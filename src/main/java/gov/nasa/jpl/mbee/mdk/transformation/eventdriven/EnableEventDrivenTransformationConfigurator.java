package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.awt.event.ActionEvent;
import java.util.Set;

import javax.swing.KeyStroke;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
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

import gov.nasa.jpl.mbee.mdk.transformation.util.ActionStringLiterals;

public class EnableEventDrivenTransformationConfigurator implements BrowserContextAMConfigurator {
	
	private final class EnableTransformationAction extends NMAction {
		private static final long serialVersionUID = 1L;
		private Profile profile;
		
		private EnableTransformationAction(String arg0, String arg1, KeyStroke arg2, String arg3, Profile profile) {
			super(arg0, arg1, arg2, arg3);
			this.profile = profile;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			BackgroundTaskRunner.runWithProgressStatus(new RunnableWithProgress()
			{
				@Override
				public void run(ProgressStatus progressStatus)
				{
					MDKTransformationRules.getInstance().addStereotypes(profile.getOwnedStereotype(), Application.getInstance().getProject());
				}
			}, "Stereotyped Element Transformation", true);
		}
	}

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		ActionsCategory category  = new MDActionsCategory(ActionStringLiterals.ED_TRAFO_ON, ActionStringLiterals.ED_TRAFO_ON);
		Profile profile = null;
		// Collecting the stereotypes selected by the user 
		for (final Node node : tree.getSelectedNodes()) { 
			Object selectedProfile = node.getUserObject();
			Set<Stereotype> stereotypes = MDKTransformationRules.getInstance().getStereotypes();
			if (selectedProfile instanceof Profile && !stereotypes.containsAll(((Profile) selectedProfile).getOwnedStereotype())) {
				//If a profile is selected transform every stereotype of the profile
				profile = (Profile) selectedProfile;
				category.setEnabled(true);
			}
			else {
				// If different element is selected, the menu item should not appear
				category.setEnabled(false);
				return;
			}
	    }
		
		category.addAction(new EnableTransformationAction(ActionStringLiterals.ED_TRAFO_ON, ActionStringLiterals.ED_TRAFO_ON, null, null, profile));
		manager.addCategory(category);
	}
	

	
}
