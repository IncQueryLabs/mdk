package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.awt.event.ActionEvent;
import java.util.Optional;

import javax.swing.KeyStroke;

import org.eclipse.emf.common.notify.Adapter;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Profile;

import gov.nasa.jpl.mbee.mdk.transformation.util.ActionStringLiterals;

public class DisableEventDrivenTransformationConfigurator implements BrowserContextAMConfigurator {
	
	private final class DisableTransformationAction extends NMAction {
		private static final long serialVersionUID = 1L;
		private Profile profile;
		
		
		private DisableTransformationAction(String arg0, String arg1, KeyStroke arg2, String arg3, Profile profile) {
			super(arg0, arg1, arg2, arg3);
			this.profile = profile;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			Optional<Adapter> findAdapter = StereotypedElementEventDrivenTransformation.findAdapter(profile);
			if(findAdapter.isPresent()){
				Adapter adapter = findAdapter.get();
				if(adapter instanceof StereotypedElementEventDrivenTransformation){
					profile.eAdapters().remove(adapter);
					((StereotypedElementEventDrivenTransformation) adapter).dispose();
				}
			}					
		}
	}

	@Override
	public int getPriority() {
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		ActionsCategory category = new MDActionsCategory(ActionStringLiterals.ED_TRAFO_OFF, ActionStringLiterals.ED_TRAFO_OFF);
		Profile profile = null;
		// Collecting the stereotypes selected by the user 
		for (final Node node : tree.getSelectedNodes()) { 
			Object selectedProfile = node.getUserObject();
			if (selectedProfile instanceof Profile && StereotypedElementEventDrivenTransformation.findAdapter((Profile) selectedProfile).isPresent()) {
				profile = (Profile) selectedProfile;
				category.setEnabled(true);
			}else {
				// If different element is selected, the menu item should not appear
				category.setEnabled(false);
				return;
			}
	    }

		
		category.addAction(new DisableTransformationAction(ActionStringLiterals.ED_TRAFO_OFF, ActionStringLiterals.ED_TRAFO_OFF, null, null, profile));
		manager.addCategory(category);
	}
}
