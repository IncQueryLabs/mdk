package gov.nasa.jpl.mbee.mdk.transformation;

import java.util.List;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

import com.nomagic.magicdraw.copypaste.CopyPasting;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.task.ProgressStatus;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.UnreferredStereotypesMatch;
import gov.nasa.jpl.mbee.mdk.queries.UnreferredStereotypesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.UnreferredStereotypesQuerySpecification;

public class StereotypedElementTransformation {	
	
	private AdvancedViatraQueryEngine engine;
	private BatchTransformation transformation;
	private BatchTransformationStatements statements;
	private BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory();

	private List<Stereotype> stereotypes;
	
	//Transformation rule responsible for creating attributes in elements in accordance to the stereotype tagged values
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> attributeCreation;
	//Transformation rule responsible for setting redefinition relations between parent and child attributes
	private BatchTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> attributeRedefinition;
	//Rule responsible for removing stereotype instances from classes
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> stereotypeRemoval;
	//Rule responsible for the deletion of now unused stereotypes
	private BatchTransformationRule<UnreferredStereotypesMatch, UnreferredStereotypesMatcher> stereotypeDeletion;
	
	//Required for displaying transformation status
	private ProgressStatus status;
	
	public StereotypedElementTransformation(List<Stereotype> stereotypes, AdvancedViatraQueryEngine engine, ProgressStatus status) throws ViatraQueryException, InconsistentEventSemanticsException {
		this.engine = engine;
		this.stereotypes = stereotypes;
		this.status = status;
		initTransformation();
	}
	
	private void initTransformation() throws ViatraQueryException {
		//Set status description
		status.setDescription("Initializing Transformation");
		
		//Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		//Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
		
		//Report status change
		status.increase();
	}
	
	public void execute() throws ViatraQueryException, InconsistentEventSemanticsException {
		//Rule instances are executed here
		//Each set of elements that match the preconditions of each rule result in a set of rule activations
		//These rule activations are executed here in a predefined order
		
		//Set status description
		status.setDescription("Creating attributes");
		//Session is created for model modification
		SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Creating attributes");
		//Attribute creation and default value setting activations
		statements.fireAllCurrent(getAttributeCreationRule(), match -> stereotypes.contains(match.getStereotype()));
		//Closing session
		SessionManager.getInstance().closeSession(Application.getInstance().getProject());
		//Report status change
		status.increase();
		
		
		status.setDescription("Setting redefine attribute relations");
		SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Setting redefine attribute relations");
		//Attribute redefinition relation setting activations
		statements.fireAllCurrent(getAttributeRedefinitionRule(), match -> stereotypes.contains(match.getStereotype()));
		SessionManager.getInstance().closeSession(Application.getInstance().getProject());	
		status.increase();
		
		
		status.setDescription("Removing tagged values");
		SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Removing tagged values");
		//Stereotype instance removal activations
		statements.fireAllCurrent(getStereotypeRemovalRule(), match -> stereotypes.contains(match.getStereotype()));
		SessionManager.getInstance().closeSession(Application.getInstance().getProject());
		status.increase();
		
		status.setDescription("Deleting unused profile stereotypes");
		SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Deleting unused profile stereotypes");
		//Unused stereotype removal activations
		statements.fireAllCurrent(getStereotypeDeletionRule(), match -> stereotypes.contains(match.getStereotype()));
		SessionManager.getInstance().closeSession(Application.getInstance().getProject());	
		status.increase();
		
	}
	
	/**
	 * The returned rule creates attributes (value properties) based on the tag values of blocks labeled with the selected stereotypes (sterotypes list).
	 * This rule should be fired first as it does not depend on any other rule.
	 * 
	 * Precondition:
	 * 
	 * Returns blocks with tag values (a slot referring to a property). These properties are owned attributes of a stereotype.
	 * A slot assigns a value to the property.
	 * 
	 */
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getAttributeCreationRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeCreation == null) {
			attributeCreation = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule().name("AttributesFromTagsRule").precondition(TaggedBlocksQuerySpecification.instance()).action(
			new IMatchProcessor<TaggedBlocksMatch>() {
				public void process(TaggedBlocksMatch match) {
					// The stereotype property to be transformed to attribute
					Property stereotypeAttribute = match.getProperty();
					
					// Copying the property and putting it into the attribute list of the block
					// CloneNotSupportedException is thrown if BasedElement.clone() is used
					Property newAttribute = (Property) CopyPasting.copyPasteElement(stereotypeAttribute, match.getBlock());
					match.getBlock().getOwnedAttribute().add(newAttribute);
					
					// Setting the default value
					LiteralSpecification defaultValue = (LiteralSpecification) CopyPasting.copyPasteElement(match.getValue(), newAttribute);
					newAttribute.setDefaultValue(defaultValue); // Without this line, the value would set the multiplicity of the attribute
				}
			}).build();
		}
		return attributeCreation;
	}
	
	/**
	 * The returned rule redefines attributes that are created by attributeCreation. The attribute of a block redefines the same attribute (same name and type) of the parent block (generalization between the blocks).
	 * This rule should be fired after the attributeCreationRule.
	 * 
	 * Precondition:
	 * 
	 * Returns a pair of blocks that are in a generalization relationship (parent and child).
	 * Also, it returns the stereotype that is assigned to the blocks, as well as the attributes
	 * (parentAttribute and childAttribute) that should be in a redefinition relationship according to the desired design pattern.
	 * 
	 */
	private BatchTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> getAttributeRedefinitionRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeRedefinition == null) {
			attributeRedefinition = ruleFactory.<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher>createRule().name("AttributeRedefinitionRule").precondition(GeneralizedTaggedBlockPairsQuerySpecification.instance()).action(
			new IMatchProcessor<GeneralizedTaggedBlockPairsMatch>() {
				public void process(GeneralizedTaggedBlockPairsMatch match) {
					//Setting redefined relation between attributes that activated the rule.
					match.getChildAttribute().getRedefinedProperty().add(match.getParentAttribute());
				}
			}).build();
		}
		return attributeRedefinition;
	}
	
	/**
	 * The returned rule removes the labels of the selected stereotypes (sterotypes list) and the inherent tagged values from blocks.
	 * This rule should be fired after the attributeRedefinitionRule.
	 *  
	 */
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getStereotypeRemovalRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (stereotypeRemoval == null) {
			stereotypeRemoval = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule().name("StereotypeRemovalRule").precondition(TaggedBlocksQuerySpecification.instance()).action(
			new IMatchProcessor<TaggedBlocksMatch>() {
				public void process(TaggedBlocksMatch match) {
					// Removing the tag value from the block
					InstanceSpecification instanceSpecification = match.getSlot().getOwningInstance();
					instanceSpecification.getSlot().remove(match.getSlot());
					// Removing the stereotype from the block
					instanceSpecification.getClassifier().remove(match.getStereotype());				
				}
			}).build();
		}
		return stereotypeRemoval;
	}
	
	/**
	 * The returned rule deletes the selected stereotypes (sterotypes list) if it does not have a property that is referred by a class.
	 * This rule should be fired after the stereotypeRemovalRule.
	 */
	private BatchTransformationRule<UnreferredStereotypesMatch, UnreferredStereotypesMatcher> getStereotypeDeletionRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (stereotypeDeletion == null) {
			stereotypeDeletion = ruleFactory.<UnreferredStereotypesMatch, UnreferredStereotypesMatcher>createRule().name("StereotypeDeletionRule").precondition(UnreferredStereotypesQuerySpecification.instance()).action(
			new IMatchProcessor<UnreferredStereotypesMatch>() {
				public void process(UnreferredStereotypesMatch match) {
					//Delete unused stereotypes contained in the specified profile (selected by the user)
					match.getStereotype().refDelete();
				}
			}).build();
		}
		return stereotypeDeletion;
	}
	
	public void dispose() {
		status.setDescription("Disposing transformation");
		//Here the transformation and query engine are disposed
		if (transformation != null) {
			transformation.getRuleEngine().dispose();
			transformation.dispose();
		}
		transformation = null;
		status.increase();
	}
	
}
