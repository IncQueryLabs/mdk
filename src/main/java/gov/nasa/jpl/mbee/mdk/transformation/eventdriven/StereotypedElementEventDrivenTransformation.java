package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.util.Collection;
import java.util.Optional;

import org.apache.log4j.Level;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.evm.api.resolver.ConflictResolver;
import org.eclipse.viatra.transformation.evm.specific.resolver.FixedPriorityConflictResolver;
import org.eclipse.viatra.transformation.evm.update.QueryEngineUpdateCompleteProvider;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Profile;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import gov.nasa.jpl.mbee.mdk.queries.EventDrivenTransformationQueries;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatch;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatcher;
import gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TransformedGeneralizedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.TransformedGeneralizedBlockPairsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedGeneralizedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.transformation.util.EngineCreationUtil;
import gov.nasa.jpl.mbee.mdk.transformation.util.StereotypedElementTransformationActions;

public class StereotypedElementEventDrivenTransformation extends AdapterImpl{	
	
	private AdvancedViatraQueryEngine engine;
	private EventDrivenTransformation transformation;
	private EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory();

	private Collection<Stereotype> stereotypes;
	
	//Transformation rule responsible for creating attributes in elements in accordance to the stereotype tagged values
	private EventDrivenTransformationRule<StereotypedBlocksMatch, StereotypedBlocksMatcher> attributeCreation;
	//Transformation rule responsible for setting redefinition relations between parent and child attributes
	private EventDrivenTransformationRule<TransformedGeneralizedBlockPairsMatch, TransformedGeneralizedBlockPairsMatcher> attributeRedefinition;
	//Rule responsible for removing stereotype instances from classes
	private EventDrivenTransformationRule<TransformedStereotypedBlocksMatch, TransformedStereotypedBlocksMatcher> stereotypeRemoval;
	
	private EventDrivenTransformationRule<FindCommonParentClassMatch, FindCommonParentClassMatcher> blockRestructuring;

	
	public StereotypedElementEventDrivenTransformation(Collection<Stereotype> stereotypes) throws ViatraQueryException, InconsistentEventSemanticsException {
		
		this.engine = EngineCreationUtil.createEngine();
		this.stereotypes = stereotypes;
		initTransformation();
	}
	
	private void initTransformation() throws ViatraQueryException, InconsistentEventSemanticsException {
		//Create VIATRA Batch transformation
		
		EventDrivenTransformationQueries.instance().prepare(engine);
		
		transformation = EventDrivenTransformation.forEngine(engine)
//				.addAdapterConfiguration(new TransformationDebuggerConfiguration("MDK_TRAFO"))
				.addRule(getAttributeCreationRule())
				.addRule(getAttributeRedefinitionRule())
				.addRule(getStereotypeRemovalRule())
				.addRule(getBlockRestructuringRule())
				.setConflictResolver(createConflictResolver())
				.setSchedulerFactory(getQueryEngineSchedulerFactory(engine))
				.build();
		transformation.getExecutionSchema().getLogger().setLevel(Level.DEBUG);
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
	private EventDrivenTransformationRule<StereotypedBlocksMatch, StereotypedBlocksMatcher> getAttributeCreationRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeCreation == null) {
			attributeCreation = ruleFactory.<StereotypedBlocksMatch, StereotypedBlocksMatcher>createRule()
					.name("AttributesFromTagsRule").precondition(StereotypedBlocksQuerySpecification.instance())
					.action(new IMatchProcessor<StereotypedBlocksMatch>() {
						public void process(StereotypedBlocksMatch match) {
							//TODO Workaround for VIATRA ED Transformation filtering bug
							if(stereotypes.contains(match.getStereotype())) {
								openSession("Creating block attributes");
								StereotypedElementTransformationActions.createBlockAttributes(match.getProperty(), match.getBlock(), match.getValue());
								closeSession();
							}
							
						}

						
					}).filter(match -> {
						System.out.println(match.getStereotype() + " : " + stereotypes.contains(match.getStereotype()));
						return stereotypes.contains(match.getStereotype());}).build();
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
	private EventDrivenTransformationRule<TransformedGeneralizedBlockPairsMatch, TransformedGeneralizedBlockPairsMatcher> getAttributeRedefinitionRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (attributeRedefinition == null) {
			attributeRedefinition = ruleFactory
					.<TransformedGeneralizedBlockPairsMatch, TransformedGeneralizedBlockPairsMatcher>createRule()
					.name("AttributeRedefinitionRule")
					.precondition(TransformedGeneralizedBlockPairsQuerySpecification.instance())
					.action(new IMatchProcessor<TransformedGeneralizedBlockPairsMatch>() {
						public void process(TransformedGeneralizedBlockPairsMatch match) {
							//TODO Workaround for VIATRA ED Transformation filtering bug
							if(stereotypes.contains(match.getStereotype())) {
								
								openSession("Setting redefinition relation");
								StereotypedElementTransformationActions.createAttributeredefinition(match.getChildAttribute(), match.getParentAttribute());
								closeSession();
							}
							
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
	private EventDrivenTransformationRule<TransformedStereotypedBlocksMatch, TransformedStereotypedBlocksMatcher> getStereotypeRemovalRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (stereotypeRemoval == null) {
			stereotypeRemoval = ruleFactory.<TransformedStereotypedBlocksMatch, TransformedStereotypedBlocksMatcher>createRule()
					.name("StereotypeRemovalRule").precondition(TransformedStereotypedBlocksQuerySpecification.instance())
					.action(new IMatchProcessor<TransformedStereotypedBlocksMatch>() {
						public void process(TransformedStereotypedBlocksMatch match) {
							//TODO Workaround for VIATRA ED Transformation filtering bug
							if(stereotypes.contains(match.getStereotype())) {
								openSession("Removing stereotype instance");
								StereotypedElementTransformationActions.createRemoveStereotypeInstance(match.getSlot(), match.getStereotype());
								closeSession();
							}
						}
					}).filter(match -> stereotypes.contains(match.getStereotype())).build();
		}
		return stereotypeRemoval;
	}
	
	private EventDrivenTransformationRule<FindCommonParentClassMatch, FindCommonParentClassMatcher> getBlockRestructuringRule()
			throws InconsistentEventSemanticsException, ViatraQueryException {
		if (blockRestructuring == null) {
			blockRestructuring = ruleFactory.<FindCommonParentClassMatch, FindCommonParentClassMatcher>createRule()
					.name("BlockRestructuringRule").precondition(FindCommonParentClassQuerySpecification.instance())
					.action(new IMatchProcessor<FindCommonParentClassMatch>() {
						public void process(FindCommonParentClassMatch match) {
							//TODO Workaround for VIATRA ED Transformation filtering bug
							if(stereotypes.contains(match.getStereotype())) {
								openSession("Restructuring block hierarchy");
								try {
									StereotypedElementTransformationActions.createImpliedParentBlock(match);
								} catch (ReadOnlyElementException e) {
									e.printStackTrace();
								}
								closeSession();
							}
						}
					}).filter(match -> stereotypes.contains(match.getStereotype())).build();
		}
		return blockRestructuring;
	}
	
	private void openSession(String message) {
		if(!SessionManager.getInstance().isSessionCreated(Application.getInstance().getProject())) {
			SessionManager.getInstance().createSession(Application.getInstance().getProject(), message+System.nanoTime());
		}
	}
	
	private void closeSession() {
		if(SessionManager.getInstance().isSessionCreated(Application.getInstance().getProject())) {
			SessionManager.getInstance().closeSession(Application.getInstance().getProject());
		}
	}
		
	public void dispose() {
		if (transformation != null) {
			transformation.dispose();
		}
		transformation = null;
		engine.dispose();
	}
	
	private ConflictResolver createConflictResolver() throws InconsistentEventSemanticsException, ViatraQueryException{
		FixedPriorityConflictResolver  fixedPriorityResolver = new FixedPriorityConflictResolver();
        fixedPriorityResolver.setPriority(getAttributeCreationRule().getRuleSpecification(), 1);
        fixedPriorityResolver.setPriority(getAttributeRedefinitionRule().getRuleSpecification(), 2);
        fixedPriorityResolver.setPriority(getStereotypeRemovalRule().getRuleSpecification(), 3);
        fixedPriorityResolver.setPriority(getBlockRestructuringRule().getRuleSpecification(), 4);
        return fixedPriorityResolver;
	}
	
	public static Optional<Adapter> findAdapter(Profile profile) {
		Optional<Adapter> foundAdapter = profile.eAdapters().stream().filter(ad -> ad instanceof StereotypedElementEventDrivenTransformation).findAny();
		return foundAdapter;
	}
	
	public static StereotypedTransformationSchedulerFactory getQueryEngineSchedulerFactory(final ViatraQueryEngine engine) {
        QueryEngineUpdateCompleteProvider provider;
        provider = new QueryEngineUpdateCompleteProvider(engine);
        return new StereotypedTransformationSchedulerFactory(provider);
    }
}
