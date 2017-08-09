package gov.nasa.jpl.mbee.mdk.transformation;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.KeyStroke;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexFeatureFilter;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.task.BackgroundTaskRunner;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.task.ProgressStatus;
import com.nomagic.task.RunnableWithProgress;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Profile;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;

public class StereotypeTransformationConfigurator implements BrowserContextAMConfigurator {
	
	private final class RunTransformationAction extends NMAction {
		private static final long serialVersionUID = 1L;
		private List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		
		
		private RunTransformationAction(String arg0, String arg1, KeyStroke arg2, String arg3, List<Stereotype> stereotypes) {
			super(arg0, arg1, arg2, arg3);
			this.stereotypes = stereotypes;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			//Transforamtion is run in a background task
			BackgroundTaskRunner.runWithProgressStatus(new RunnableWithProgress()
			{
				@Override
				public void run(ProgressStatus progressStatus)
				{
					progressStatus.init("Transforming Elements...", 0, 6);
					// Creating a transformer and executing it
					try {
						//Transformer is initialized with a VIATRA query engine and a set of stereotypes to be transformed
						StereotypedElementTransformation transformer = new StereotypedElementTransformation(stereotypes, createEngine(), progressStatus);
						transformer.execute();
						transformer.dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "Stereotyped Element Transformation", false);
			
			
			
								
		}
	}

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		MDActionsCategory category = new MDActionsCategory("Transform Stereotyped Elements", "Transform Stereotyped Elements");
		List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		// Collecting the stereotypes selected by the user 
		for (final Node node : tree.getSelectedNodes()) { 
			if (node.getUserObject() instanceof Profile) {
				//If a profile is selected transform every stereotype of the profile
				Profile selectedProfile = (Profile) node.getUserObject();
				for (Stereotype stereotype : selectedProfile.getOwnedStereotype()) {
					stereotypes.add(stereotype);
				}
			}
			else if (node.getUserObject() instanceof Stereotype) {
	            stereotypes.add((Stereotype) node.getUserObject());
	        }
			else {
				// If different element is selected, the menu item should not appear
				category.setEnabled(false);
				return;
			}
	    }
		// Menu is enabled only when profiles or stereotypes are selected
		category.setEnabled(true);
		
		category.addAction(new RunTransformationAction("Transform Stereotyped Elements", "Transform Stereotyped Elements", null, null, stereotypes));
		manager.addCategory(category);
	}
	
	/**
	 * Creates a VIATRA query engine for the currently opened model.
	 * 
	 * @return
	 * @throws ViatraQueryException
	 */
	@SuppressWarnings("deprecation")
	private AdvancedViatraQueryEngine createEngine() throws ViatraQueryException {
		BaseIndexOptions baseIndexOptions = new BaseIndexOptions().withFeatureFilterConfiguration(new IBaseIndexFeatureFilter() {
			@Override
			public boolean isFiltered(EStructuralFeature arg0) {
				if (arg0 instanceof EReference && ((EReference)arg0).isContainment()) {
					return arg0.getName().contains("_from_");
				}
				return false;
			}
		}).withStrictNotificationMode(false);
		return AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(Application.getInstance().getProject().getModel(), baseIndexOptions));
	}
}
