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
 *   Ivan Gomes, Gabor Bergmann
 *******************************************************************************/
package gov.nasa.jpl.mbee.mdk.fileexport;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import gov.nasa.jpl.mbee.mdk.emf.BulkExport;
import gov.nasa.jpl.mbee.mdk.json.JacksonUtils;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.task.ProgressStatus;
import com.nomagic.task.RunnableWithProgress;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;

import java.io.IOException;

/**
 * @author Gabor Bergmann
 * 
 * Based on code from ManualSyncRunner by igomes
 *
 */
public class FileExportRunner implements RunnableWithProgress {
	
    private final Collection<Element> rootElements;
    private final Project project;
    private final int depth;
    private final File outputFolder;
	
	private final ObjectWriter jsonWriter = JacksonUtils.getObjectMapper().writerWithDefaultPrettyPrinter();

	public FileExportRunner(Collection<Element> rootElements, Project project, int depth, File outputFolder) {
        this.rootElements = rootElements;
        this.project = project;
        this.depth = depth;
        this.outputFolder = outputFolder;
	}

    @Override
    public void run(ProgressStatus progressStatus) {
		String depthDescriptionText = depth == 0 ? "without contents" : (depth > 0 ? ("up to depth " + depth) : "and all contents");
		String exportDescriptionText = "Exporting to JSON " 
			+ rootElements.size() + " " + ((depth != 0) ? "root " : "") 
			+ "element" + (rootElements.size() != 1 ? "s " : " ") 
			+ depthDescriptionText;
        Application.getInstance().getGUILog().log("[INFO] " + exportDescriptionText);
		
        progressStatus.setDescription(exportDescriptionText);
        progressStatus.setIndeterminate(false);
        progressStatus.setMax(rootElements.size());
        progressStatus.setCurrent(0);
        
		Set<String> usedNames = new HashSet<>();
		try {
			
			for (Element rootElement : rootElements) {
				String name = rootElement.getHumanName();
				File outputFile = getOutputFile(name, usedNames);
				Application.getInstance().getGUILog().log(String.format("[INFO] Exporting element '%s' %s to file %s", 
					name, depthDescriptionText, outputFile.getPath().toString()));
				
				try (SequenceWriter targetFileWriter = openFile(outputFile)) {
					
					BulkExport.exportElementsRecursively(project, rootElement, depth, (element, jsonNode) -> {
						if (progressStatus.isCancel()) {
							throw new CancelledException();
						}
						
						try {
							targetFileWriter.write(jsonNode);
						} catch (IOException ioEx) {
							throw new WrappedIOException(ioEx);
						}
					});
					
					progressStatus.increase();
					if (progressStatus.isCancel()) {
						return;
					}
					
				}
			
				
			}
			
            Application.getInstance().getGUILog().log("[INFO] JSON export finished successfully.");
			
		} catch (CancelledException cancEx) {
            Application.getInstance().getGUILog().log("[INFO] JSON export cancelled by user.");
		} catch (IOException ioEx) {
			handleIOException(ioEx);
		} catch (WrappedIOException wioEx) {
			handleIOException(wioEx.getCause());
		}
        
        
    }
	
	private File getOutputFile(String originalName, Set<String> usedNames) {
		String rootName = originalName.replaceAll("[^\\p{IsAlphabetic}\\p{Digit}-_]", "_");
		if (rootName.isEmpty()) rootName = "export";
		String name = rootName; 
		int postFix = 0; 
		while (!usedNames.add(name)) {
			name = String.format("%s_%04d", rootName, postFix++);
		}
		
		return new File(outputFolder, name + ".json");
	}

	private SequenceWriter openFile(File outputFile) throws IOException {
		return jsonWriter.writeValues(outputFile);
	}
	
	private void handleIOException(Throwable ioEx) {
		Application.getInstance().getGUILog().log("[ERROR] An error occurred while exporting model as JSON, aborting. Reason: " + ioEx.getMessage());
		ioEx.printStackTrace();
	}
	
	static class CancelledException extends RuntimeException {
		public CancelledException() {}
	}
	static class WrappedIOException extends RuntimeException {
		public WrappedIOException(IOException cause) {super(cause);}
	}

}
