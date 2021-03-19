/*******************************************************************************
 * Copyright (c) 2010-2021, Gabor Bergmann, IncQuery Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * Contributors:
 *   Gabor Bergmann - initial API and implementation
 *******************************************************************************/
package gov.nasa.jpl.mbee.mdk.actions;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.function.Function;

import javax.swing.JFileChooser;

import com.jidesoft.swing.FolderChooser;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import com.nomagic.ui.ProgressStatusRunner;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

import gov.nasa.jpl.mbee.mdk.fileexport.FileExportRunner;
import gov.nasa.jpl.mbee.mdk.mms.sync.manual.ManualSyncRunner;
import gov.nasa.jpl.mbee.mdk.util.Utils;

import gov.nasa.jpl.mbee.mdk.emf.BulkExport;

/**
 * @author Gabor Bergmann
 *
 */
public class ExportToJsonRecursivelyAction extends MDAction {
	
    public static ExportToJsonRecursivelyAction exportEntirePrimaryModel() {
		return new ExportToJsonRecursivelyAction(p -> Collections.singleton(p.getPrimaryModel()), BulkExport.DEPTH_INFINITE, "Export entire (primary) model to JSON");
	}

    public static ExportToJsonRecursivelyAction exportElementOnly(Element e) {
		return new ExportToJsonRecursivelyAction(p -> Collections.singleton(e), BulkExport.DEPTH_NO_DESCENT, "Export element (without contained elements) to JSON");
	}
    public static ExportToJsonRecursivelyAction exportElementHierarchy(Element e) {
		return new ExportToJsonRecursivelyAction(p -> Collections.singleton(e), BulkExport.DEPTH_INFINITE, "Export containment subtree to JSON");
	}
	
    public static ExportToJsonRecursivelyAction exportElementOnly(Collection<Element> es) {
		return new ExportToJsonRecursivelyAction(p -> es, BulkExport.DEPTH_NO_DESCENT, "Export selected elements (without contained elements) to JSON");
	}
    public static ExportToJsonRecursivelyAction exportElementHierarchy(Collection<Element> es) {
		return new ExportToJsonRecursivelyAction(p -> es, BulkExport.DEPTH_INFINITE, "Export selected containment subtrees to JSON");
	}
	
    public static final String DEFAULT_ID = "ExportToJsonRecursively";

	final Function<Project, Collection<Element>> rootsProvider;
	final int depth;
	final String title;
	
	/**
	 * @param selectedRootElements null if entire primary model is to be exported
	 */
    public ExportToJsonRecursivelyAction(Function<Project, Collection<Element>> rootsProvider, int depth, String title) {
        super(
//			DEFAULT_ID,
			String.format("%s_depth%d",
				DEFAULT_ID,
				// selectedRootElements.stream()
				 // .map(Element::getID)
				 // .map(Object::toString)
				 // .collect(Collectors.joining("_")),
				depth
			), 
			title, null, null
		);
        this.rootsProvider = rootsProvider;
		this.depth = depth;
		this.title = title;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
		Project project = Application.getInstance().getProject();
		if (project != null) {
			Collection<Element> rootElements = rootsProvider.apply(project);
			
			File folderSelection = chooseFolder();
			if (folderSelection != null) exportIntoFolder(folderSelection, project, rootElements);		
		}
    }

	/**
	 * @param folderSelection
	 */
	private void exportIntoFolder(File folderSelection, Project project, Collection<Element> rootElements) {
    	FileExportRunner exportRunner = new FileExportRunner(rootElements, project, depth, folderSelection);
        ProgressStatusRunner.runWithProgressStatus(exportRunner, title, true, 0);
	}

	/**
	 * @return selected folder, or null if cancelled
	 */
	private File chooseFolder() {
		Window dialogParent = MDDialogParentProvider.getProvider().getDialogOwner();
		FolderChooser folderChooser = new com.jidesoft.swing.FolderChooser();
		folderChooser.setRecentListVisible(false);
		folderChooser.setDialogTitle("Select folder to export into");
		int result = folderChooser.showDialog(dialogParent, "Select");
		File selectedFolder = folderChooser.getSelectedFolder();
		File folderSelection = (result == JFileChooser.APPROVE_OPTION ) ? selectedFolder : null;
		return folderSelection;
	}

}
