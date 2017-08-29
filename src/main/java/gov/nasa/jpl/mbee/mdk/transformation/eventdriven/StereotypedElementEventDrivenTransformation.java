package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.evm.api.resolver.ConflictResolver;
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Profile;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.transformation.util.StereotypedElementTransformationActions;

public class StereotypedElementEventDrivenTransformation extends AdapterImpl{	
	
	private AdvancedViatraQueryEngine engine;
	private EventDrivenTransformation transformation;
	private EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory();

	private Collection<Stereotype> stereotypes;
	
	//Transformation rule responsible for creating attributes in elements in accordance to the stereotype tagged values
	private EventDrivenTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> attributeCreation;
	//Transformation rule responsible for setting redefinition relations between parent and child attributes
	private EventDrivenTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> attributeRedefinition;
	//Rule responsible for removing stereotype instances from classes
	private EventDrivenTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> stereotypeRemoval;

	
	public StereotypedElementEventDrivenTransformation(Collection<Stereotype> stereotypes, AdvancedViatraQueryEngine engine) throws ViatraQueryException, InconsistentEventSemanticsException {
		this.engine = engine;
		this.stereotypes = stereotypes;
		initTransformation();
	}
	
	private void initTransformation() throws ViatraQueryException, InconsistentEventSemanticsException {
		//Create VIATRA Batch transformation
		transformation = EventDrivenTransformation.forEngine(engine)
				.addRule(getAttributeCreationRule())
				.addRule(getAttributeRedefinitionRule())
				.addRule(getStereotypeRemovalRule())
				.setConflictResolver(createConflictResolver()).build();
	}
	
	public void forceExecution() throws ViatraQueryException, InconsistentEventSemanticsException {
		transformation.getExecutionSchema().startUnscheduledExecution();
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
	private EventDrivenTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getAttributeCreationRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeCreation == null) {
			attributeCreation = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule()
					.name("AttributesFromTagsRule").precondition(TaggedBlocksQuerySpecification.instance())
					.action(new IMatchProcessor<TaggedBlocksMatch>() {
						public void process(TaggedBlocksMatch match) {
							SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Creating block attributes"+System.nanoTime());
							StereotypedElementTransformationActions.createBlockAttributes(match);
							SessionManager.getInstance().closeSession(Application.getInstance().getProject());
						}
					}).filter(match -> stereotypes.contains(match.getStereotype())).build();
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
	private EventDrivenTransformationRule<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher> getAttributeRedefinitionRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeRedefinition == null) {
			attributeRedefinition = ruleFactory
					.<GeneralizedTaggedBlockPairsMatch, GeneralizedTaggedBlockPairsMatcher>createRule()
					.name("AttributeRedefinitionRule")
					.precondition(GeneralizedTaggedBlockPairsQuerySpecification.instance())
					.action(new IMatchProcessor<GeneralizedTaggedBlockPairsMatch>() {
						public void process(GeneralizedTaggedBlockPairsMatch match) {
							SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Setting redefinition relation"+System.nanoTime());
							StereotypedElementTransformationActions.createAttributeredefinition(match);
							SessionManager.getInstance().closeSession(Application.getInstance().getProject());
							
						}
					}).filter(match -> stereotypes.contains(match.getStereotype())).build();
		}
		return attributeRedefinition;
	}
	
	/**
	 * The returned rule removes the labels of the selected stereotypes (sterotypes list) and the inherent tagged values from blocks.
	 * This rule should be fired after the attributeRedefinitionRule.
	 *  
	 */
	private EventDrivenTransformationRule<TaggedBlocksMatch, TaggedBlocksMatcher> getStereotypeRemovalRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (stereotypeRemoval == null) {
			stereotypeRemoval = ruleFactory.<TaggedBlocksMatch, TaggedBlocksMatcher>createRule()
					.name("StereotypeRemovalRule").precondition(TaggedBlocksQuerySpecification.instance())
					.action(new IMatchProcessor<TaggedBlocksMatch>() {
						public void process(TaggedBlocksMatch match) {
							SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Removing stereotype instance"+System.nanoTime());
							StereotypedElementTransformationActions.createRemoveStereotypeInstance(match);
							SessionManager.getInstance().closeSession(Application.getInstance().getProject());
						}
					}).filter(match -> stereotypes.contains(match.getStereotype())).build();
		}
		return stereotypeRemoval;
	}
		
	public void dispose() {
		if (transformation != null) {
			transformation.dispose();
		}
		transformation = null;
		//temporary
		//TODO acquire engine from project adapter
		engine.dispose();
	}
	
	private ConflictResolver createConflictResolver() throws InconsistentEventSemanticsException, ViatraQueryException{
		FixedPriorityConflictResolver  fixedPriorityResolver = new FixedPriorityConflictResolver();
        fixedPriorityResolver.setPriority(getAttributeCreationRule().getRuleSpecification(), 1);
        fixedPriorityResolver.setPriority(getAttributeRedefinitionRule().getRuleSpecification(), 2);
        fixedPriorityResolver.setPriority(getStereotypeRemovalRule().getRuleSpecification(), 3);
        return fixedPriorityResolver;
	}
	
	public static Optional<Adapter> findAdapter(Profile profile) {
		Optional<Adapter> foundAdapter = profile.eAdapters().stream().filter(ad -> ad instanceof StereotypedElementEventDrivenTransformation).findAny();
		return foundAdapter;
	}
}
