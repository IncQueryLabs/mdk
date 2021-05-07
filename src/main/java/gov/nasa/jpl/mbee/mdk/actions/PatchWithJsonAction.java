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

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import com.nomagic.ui.ProgressStatusRunner;

import gov.nasa.jpl.mbee.mdk.fileexport.FilePatchRunner;

/**
 * @author Gabor Bergmann
 *
 */
public class PatchWithJsonAction extends MDAction {
	
    public static PatchWithJsonAction patchEntirePrimaryModel() {
		return new PatchWithJsonAction("Patch model with .mdkpatch file");
	}
	
    public static final String DEFAULT_ID = "PatchWithJson";

	final String title;
	
	
	
    public PatchWithJsonAction(String title) {
        super(
			DEFAULT_ID,
			title, null, null
		);
		this.title = title;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
		Project project = Application.getInstance().getProject();
		if (project != null) {			
			File fileSelection = choosePatch();
			if (fileSelection != null) patchWithFile(fileSelection, project);		
		}
    }

	/**
	 * @param folderSelection
	 */
	private void patchWithFile(File fileSelection, Project project) {
		FilePatchRunner patchRunner = new FilePatchRunner(project, fileSelection);
        ProgressStatusRunner.runWithProgressStatus(patchRunner, title, true, 0);
	}

	/**
	 * @return selected folder, or null if cancelled
	 */
	private File choosePatch() {
		Window dialogParent = MDDialogParentProvider.getProvider().getDialogOwner();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "MDK model patch files (.mdkpatch)";
			}
			
			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith(".mdkpatch");
			}
		});
		fileChooser.setDialogTitle("Select model patch file");

		int result = fileChooser.showDialog(dialogParent, "Apply patch");
		File selectedFile = fileChooser.getSelectedFile();
		return (result == JFileChooser.APPROVE_OPTION ) ? selectedFile : null;
	}

}
