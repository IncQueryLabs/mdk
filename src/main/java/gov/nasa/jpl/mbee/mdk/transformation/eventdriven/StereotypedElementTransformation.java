package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.collect.Sets;
import com.incquerylabs.incquery.magicdraw.autoquickfix.AutoQuickFixRule;
import com.incquerylabs.incquery.magicdraw.autoquickfix.AutoQuickFixRuleRegistry;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedGeneralizedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.transformation.util.StereotypedElementTransformationActions;

public class StereotypedElementTransformation {
	private static Set<AutoQuickFixRule> rules;
	private Set<Stereotype> stereotypes;
	
	private static StereotypedElementTransformation instance;
	
	protected StereotypedElementTransformation() {
		rules = Sets.newHashSet();
		stereotypes = Sets.newHashSet();
	}
	
	public static StereotypedElementTransformation getInstance() {
		if(instance == null) {
			instance = new StereotypedElementTransformation();
		}
		return instance;
	}
	
	
	public void addStereotypes(Collection<Stereotype> stereotypes, Project project) {
		this.stereotypes.addAll(stereotypes);
		reInitRules(project);
	}
	
	public void removeStereotypes(Collection<Stereotype> stereotypes, Project project) {
		this.stereotypes.removeAll(stereotypes);
		if(this.stereotypes.isEmpty()) {
			removeAllRules(project);
		}else {
			reInitRules(project);
		}
	}
	
	
	public void removeAllRules(Project project) {
		AutoQuickFixRuleRegistry registry = AutoQuickFixRuleRegistry.forProject(project);
		
		for (AutoQuickFixRule autoQuickFixRule : rules) {
			registry.removeRule(autoQuickFixRule);
		}
		
	}
	
	private void reInitRules(Project project) {
		AutoQuickFixRuleRegistry registry = AutoQuickFixRuleRegistry.forProject(project);
		try {
			
			rules.add(registry.createRuleForPattern(StereotypedBlocksQuerySpecification.instance()).action(match -> {
				openSession("Creating block attributes");
				StereotypedElementTransformationActions.createBlockAttributes(match.getProperty(),
						match.getBlock(), match.getValue());
				closeSession();
				
				
			}).priority(1).filter(match -> {
				System.out.println(match.getStereotype() + " : " + stereotypes.contains(match.getStereotype()));
				return stereotypes.contains(match.getStereotype());
			})
			.buildAndRegister());
			
			
			rules.add(registry.createRuleForPattern(TransformedGeneralizedBlockPairsQuerySpecification.instance()).action(match -> {
				openSession("Setting redefinition relation");
				StereotypedElementTransformationActions
						.createAttributeredefinition(match.getChildAttribute(), match.getParentAttribute());
				closeSession();
				
				
			}).priority(2).filter(match -> {
				System.out.println(match.getStereotype() + " : " + stereotypes.contains(match.getStereotype()));
				return stereotypes.contains(match.getStereotype());
			})
			.buildAndRegister());
			
			
			rules.add(registry.createRuleForPattern(TransformedStereotypedBlocksQuerySpecification.instance()).action(match -> {
				openSession("Removing stereotype instance");
				StereotypedElementTransformationActions.createRemoveStereotypeInstance(match.getSlot(),
						match.getStereotype());
				closeSession();
				
				
			}).priority(3).filter(match -> {
				System.out.println(match.getStereotype() + " : " + stereotypes.contains(match.getStereotype()));
				return stereotypes.contains(match.getStereotype());
			})
			.buildAndRegister());
			
			rules.add(registry.createRuleForPattern(FindCommonParentClassQuerySpecification.instance()).action(match -> {
				openSession("Restructuring block hierarchy");
				try {
					StereotypedElementTransformationActions.createImpliedParentBlock(match);
				} catch (ReadOnlyElementException e) {
					e.printStackTrace();
				}
				closeSession();
				
				
			}).priority(4).filter(match -> {
				System.out.println(match.getStereotype() + " : " + stereotypes.contains(match.getStereotype()));
				return stereotypes.contains(match.getStereotype());
			})
			.buildAndRegister());
			
			
			
		} catch (ViatraQueryException e) {
			e.printStackTrace();
		}
		registry.updateRegisteredRules();
		
	}
	
	/*
	 * Utility methods for creating and closing MD sessions on demand
	 */
	private void openSession(String message) {
		if (!SessionManager.getInstance().isSessionCreated(Application.getInstance().getProject())) {
			SessionManager.getInstance().createSession(Application.getInstance().getProject(),
					message + System.nanoTime());
		}
	}

	private void closeSession() {
		if (SessionManager.getInstance().isSessionCreated(Application.getInstance().getProject())) {
			SessionManager.getInstance().closeSession(Application.getInstance().getProject());
		}
	}

	public Set<Stereotype> getStereotypes() {
		return Collections.unmodifiableSet(stereotypes);
	}


}
