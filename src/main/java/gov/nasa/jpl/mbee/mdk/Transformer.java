package gov.nasa.jpl.mbee.mdk;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.InconsistentEventSemanticsException;

import com.nomagic.magicdraw.copypaste.CopyPasting;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.impl.ElementsFactory;

import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatch;
import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizationsMatch;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizationsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.StereotypesMatch;
import gov.nasa.jpl.mbee.mdk.queries.StereotypesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TopmostBlockPropertiesMatch;
import gov.nasa.jpl.mbee.mdk.queries.TopmostBlockPropertiesMatcher;

public class Transformer {	
	
	private AdvancedViatraQueryEngine engine;
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
	}
	
	private void createTransformations() throws ViatraQueryException {
		//Create VIATRA Batch transformation
		transformation = BatchTransformation.forEngine(engine).build();
		//Initialize batch transformation statements
		statements = transformation.getTransformationStatements();
	}
	
	private void createRules() throws InconsistentEventSemanticsException, ViatraQueryException {
//		stereotypesRule = createStereotypesRule();
	}
	
	public void execute() throws ViatraQueryException {
//		statements.fireAllCurrent(stereotypesRule);
		createAttributesFromTags();
		redefineAttributes();
		removeTags();
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
			for (BlockPropertiesMatch blockPropertiesMatch : BlockPropertiesMatcher.on(engine).getAllMatches(null, stereotype, null, null, null)) {
				SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Create attribute");
				// The stereotype property to be transformed to attribute
				Property stereotypeAttribute = blockPropertiesMatch.getProperty();
				// Copying the property and putting it into the attribute list of the block (the attribute list is selected implicitly by CopyPasting)
				Property newAttribute = (Property) CopyPasting.copyPasteElement(stereotypeAttribute, blockPropertiesMatch.getBlock());
				// Setting the deafult value
				LiteralSpecification defaultValue = (LiteralSpecification) CopyPasting.copyPasteElement(blockPropertiesMatch.getLiteral(), newAttribute);
				newAttribute.setDefaultValue(defaultValue); // Without this line, the value would set the multiplicity of the attribute
				SessionManager.getInstance().closeSession(Application.getInstance().getProject());
			}
		}
	}
	
	
	private void redefineAttributes() throws ViatraQueryException {
		for (Stereotype stereotype : stereotypes) {
			for (TopmostBlockPropertiesMatch topmostBlockPropertiesMatch : TopmostBlockPropertiesMatcher.on(engine).getAllMatches(null, stereotype, null)) {
				redefineAttribute(topmostBlockPropertiesMatch.getBlock(), topmostBlockPropertiesMatch.getProperty());
			}
		}
	}
	
	private void redefineAttribute(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class clazz, Property property) throws ViatraQueryException {
		String propertyName = property.getName();
		Type type = property.getType();
		// Filtering the attributes to redefine
		List<Property> equalProperties = clazz.getOwnedAttribute().stream().filter(it -> it.getName().equals(propertyName)
									&& it.getType() == type).collect(Collectors.toList());
		if (equalProperties.size() != 1) {
			System.out.println("Warning: attribute redefinition chain aborted or multiple attributes need to be redefined: " + equalProperties.size());
		}
		Property redefinableProperty = equalProperties.get(0);
		SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Redefine attribute");
		// Setting the property of the generalized class redefined
		if (!(property.getOwner() instanceof Stereotype)) {
			// For the first call, the property is the element of a Stereotype, so redefinition must not be done
			redefinableProperty.getRedefinedElement().add(property);
		}
		SessionManager.getInstance().closeSession(Application.getInstance().getProject());
		// Recursively redefining attributes in descendant classes
		for (GeneralizationsMatch generalizationsMatch : GeneralizationsMatcher.on(engine).getAllMatches(clazz, null)) {
			redefineAttribute(generalizationsMatch.getSpecific(), redefinableProperty);
		}
	}
	
	private void removeTags() throws ViatraQueryException {
		for (Stereotype stereotype : stereotypes) {
			for (BlockPropertiesMatch blockPropertiesMatch : BlockPropertiesMatcher.on(engine).getAllMatches(null, stereotype, null, null, null)) {
				SessionManager.getInstance().createSession(Application.getInstance().getProject(), "Remove tag");
				// Removing the tag value from the block
				InstanceSpecification instanceSpecification = blockPropertiesMatch.getSlot().getOwningInstance();
				instanceSpecification.getSlot().remove(blockPropertiesMatch.getSlot());
				SessionManager.getInstance().closeSession(Application.getInstance().getProject());
			}
		}
	}
	
}
