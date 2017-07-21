package gov.nasa.jpl.mbee.mdk;

import java.util.List;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.impl.ElementsFactory;

import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatch;
import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.StereotypesMatch;
import gov.nasa.jpl.mbee.mdk.queries.StereotypesMatcher;

public class Transformer {	
	
	private AdvancedViatraQueryEngine engine;
	private SimpleModelManipulations manipulation;
	private BatchTransformation transformation;
	private BatchTransformationStatements statements;
	private BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory();

	private Project project;
	private ElementsFactory elementsFactory;
	private List<Stereotype> stereotypes;
	
	private BatchTransformationRule<StereotypesMatch, StereotypesMatcher> stereotypesRule = null;
	
	public Transformer(Project project, List<Stereotype> stereotypes, AdvancedViatraQueryEngine engine) throws ViatraQueryException, InconsistentEventSemanticsException {
		this.project = project;
		this.elementsFactory = this.project.getElementsFactory();
		this.engine = engine;
		this.stereotypes = stereotypes;
		createTransformations();
		createRules();
		execute();
	}
	
	private void createTransformations() throws ViatraQueryException {
		//Create VIATRA model manipulations
		this.manipulation = new SimpleModelManipulations(engine);
		//Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		//Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
	}
	
	private void createRules() throws InconsistentEventSemanticsException, ViatraQueryException {
//		stereotypesRule = createStereotypesRule();
	}
	
	private void execute() throws ViatraQueryException {
//		statements.fireAllCurrent(stereotypesRule);
		createAttributesFromTags();
	}

//	private BatchTransformationRule<StereotypesMatch, StereotypesMatcher> createStereotypesRule() throws InconsistentEventSemanticsException, ViatraQueryException {
//		return ruleFactory.<StereotypesMatch, StereotypesMatcher>createRule().name("StereotypesRule").precondition(StereotypesQuerySpecification.instance()).action(new IMatchProcessor<StereotypesMatch>() {
//			public void process(StereotypesMatch match) {
//				SessionManager.getInstance().createSession(Application.getInstance().getProject(), "NameSet");
//				System.out.println("Helloooo");
//				System.out.println(match.prettyPrint());
//				SessionManager.getInstance().closeSession(Application.getInstance().getProject());						
//			}
//		}).build();
//	}
	
	private void createAttributesFromTags() throws ViatraQueryException {
		for (Stereotype stereotype : stereotypes) {
			for (BlockPropertiesMatch blockPropertiesMatch : BlockPropertiesMatcher.on(engine).getAllMatches(null, stereotype, null, null)) {
				SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Create attribute");
				Property attribute = elementsFactory.createPropertyInstance();
				attribute.setName(blockPropertiesMatch.getProperty().getName());
				blockPropertiesMatch.getBlock().getOwnedAttribute().add(attribute);
				SessionManager.getInstance().closeSession(Application.getInstance().getProject());
			}
		}
	}
	
}
