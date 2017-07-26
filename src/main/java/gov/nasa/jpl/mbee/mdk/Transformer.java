package gov.nasa.jpl.mbee.mdk;

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

public class Transformer {	
	
	private AdvancedViatraQueryEngine engine;
	private BatchTransformation transformation;
	private BatchTransformationStatements statements;
	private BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory();

	private List<Stereotype> stereotypes;
	
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> attributeCreation;
	private BatchTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> attributeRedefinition;
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> stereotypeRemoval;
	private BatchTransformationRule<UnreferredStereotypesMatch, UnreferredStereotypesMatcher> stereotypeDeletion;
	
	public Transformer(List<Stereotype> stereotypes, AdvancedViatraQueryEngine engine) throws ViatraQueryException, InconsistentEventSemanticsException {
		this.engine = engine;
		this.stereotypes = stereotypes;
		createTransformations();
	}
	
	private void createTransformations() throws ViatraQueryException {
		//Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		//Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
	}
	
	public void execute() throws ViatraQueryException, InconsistentEventSemanticsException {
		statements.fireAllCurrent(getAttributeCreationRule(), match -> stereotypes.contains(match.getStereotype()));
		statements.fireAllCurrent(getAttributeRedefinitionRule(), match -> stereotypes.contains(match.getStereotype()));
		statements.fireAllCurrent(getStereotypeRemovalRule(), match -> stereotypes.contains(match.getStereotype()));
		statements.fireAllCurrent(getStereotypeDeletionRule(), match -> stereotypes.contains(match.getStereotype()));
	}
	
	/**
	 * The returned rule creates attributes (value properties) based on the tag values of blocks labeled with the selected stereotypes (sterotypes list).
	 * This rule should be fired first as it does not depend on any other rule.
	 */
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getAttributeCreationRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeCreation == null) {
			attributeCreation = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule().name("AttributesFromTagsRule").precondition(TaggedBlocksQuerySpecification.instance()).action(
			new IMatchProcessor<TaggedBlocksMatch>() {
				public void process(TaggedBlocksMatch match) {
					SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Create attribute");
					// The stereotype property to be transformed to attribute
					Property stereotypeAttribute = match.getProperty();
					// Copying the property and putting it into the attribute list of the block (the attribute list is selected implicitly by CopyPasting)
					Property newAttribute = (Property) CopyPasting.copyPasteElement(stereotypeAttribute, match.getBlock());
					// Setting the deafult value
					LiteralSpecification defaultValue = (LiteralSpecification) CopyPasting.copyPasteElement(match.getValue(), newAttribute);
					newAttribute.setDefaultValue(defaultValue); // Without this line, the value would set the multiplicity of the attribute
					SessionManager.getInstance().closeSession(Application.getInstance().getProject());					
				}
			}).build();
		}
		return attributeCreation;
	}
	
	/**
	 * The returned rule redefines attributes that are created by attributeCreation. The attribute of a block redefines the same attribute (same name and type) of the parent block (generalization between the blocks).
	 * This rule should be fired after the attributeCreationRule.
	 */
	private BatchTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> getAttributeRedefinitionRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeRedefinition == null) {
			attributeRedefinition = ruleFactory.<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher>createRule().name("AttributeRedefinitionRule").precondition(GeneralizedTaggedBlockPairsQuerySpecification.instance()).action(
			new IMatchProcessor<GeneralizedTaggedBlockPairsMatch>() {
				public void process(GeneralizedTaggedBlockPairsMatch match) {
					SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Redefine attribute");
					match.getChildAttribute().getRedefinedProperty().add(match.getParentAttribute());
					SessionManager.getInstance().closeSession(Application.getInstance().getProject());					
				}
			}).build();
		}
		return attributeRedefinition;
	}
	
	/**
	 * The returned rule removes the labels of the selected stereotypes (sterotypes list) and the inherent tagged values from blocks.
	 * This rule should be fired after the attributeRedefinitionRule.
	 */
	private BatchTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getStereotypeRemovalRule() throws InconsistentEventSemanticsException, ViatraQueryException {
		if (stereotypeRemoval == null) {
			stereotypeRemoval = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule().name("StereotypeRemovalRule").precondition(TaggedBlocksQuerySpecification.instance()).action(
			new IMatchProcessor<TaggedBlocksMatch>() {
				public void process(TaggedBlocksMatch match) {
					SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Remove tag");
					// Removing the tag value from the block
					InstanceSpecification instanceSpecification = match.getSlot().getOwningInstance();
					instanceSpecification.getSlot().remove(match.getSlot());
					// Removing the stereotype from the block
					instanceSpecification.getClassifier().remove(match.getStereotype());				
					SessionManager.getInstance().closeSession(Application.getInstance().getProject());					
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
					SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Delete stereotype");
					match.getStereotype().refDelete();
					SessionManager.getInstance().closeSession(Application.getInstance().getProject());					
				}
			}).build();
		}
		return stereotypeDeletion;
	}
	
	public void dispose() {
		if (transformation != null) {
			transformation.getRuleEngine().dispose();
			transformation.dispose();
		}
		transformation = null;
	}
	
}
