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
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.task.ProgressStatus;
import com.nomagic.task.RunnableWithProgress;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

import gov.nasa.jpl.mbee.mdk.emf.BulkExport;
import gov.nasa.jpl.mbee.mdk.json.JacksonUtils;
import gov.nasa.jpl.mbee.mdk.util.Pair;

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
	private final ElementSerializationMode serializationMode;
	
	public enum ElementSerializationMode {
		AS_DISCRETE_JSON_OBJECTS,
		AS_SINGLE_ARRAY,
		AS_CHILDREN_OF_ROOT_ELEMENT
	}

	public FileExportRunner(Collection<Element> rootElements, Project project, int depth, ElementSerializationMode serializationMode, File outputFolder) {
        this.rootElements = rootElements;
        this.project = project;
        this.depth = depth;
		this.serializationMode = serializationMode;
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

        Instant startInstant = Instant.now();
		
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
				
				try (PrintWriter filePrinter = new PrintWriter(outputFile, "UTF-8")) {
					int writtenCount = writeElementsToFile(progressStatus, filePrinter, 
							BulkExport.exportElementsRecursively(project, rootElement, depth));
					
					Application.getInstance().getGUILog().log(String.format("[INFO] Written %d element(s) to file.", writtenCount));
				}
				
			
				progressStatus.increase();
				if (progressStatus.isCancel()) {
					Application.getInstance().getGUILog().log("[INFO] JSON export cancelled by user.");
					return;
				}
					
				
			}

			Instant endInstant = Instant.now();
			final Duration elapsed = Duration.between(startInstant, endInstant);
			Application.getInstance().getGUILog().log(
					String.format("[INFO] JSON export finished successfully in %d seconds.",
							elapsed.getSeconds()));
			
		} catch (IOException ioEx) {
			handleIOException(ioEx);
		}
        
        
    }

	private int writeElementsToFile(ProgressStatus progressStatus, PrintWriter targetFileWriter,
			Stream<Pair<Element, ObjectNode>> exportedElementsStream) throws IOException 
	{
		prefixSequence(targetFileWriter);
					
		Iterator<Pair<Element, ObjectNode>> exportedElementsIterator = 
				exportedElementsStream.iterator();
		
		int count = 0;
		while(!progressStatus.isCancel() && exportedElementsIterator.hasNext()) {
			if (count++ != 0) { midfixSequence(targetFileWriter); }
			
			final ObjectNode jsonNode = exportedElementsIterator.next().getValue();
			String jsonString = jsonWriter.writeValueAsString(jsonNode); 
			targetFileWriter.print(jsonString);
		}
		
		postfixSequence(targetFileWriter);
		
		return count;
	}
	
	private void prefixSequence(PrintWriter filePrinter) {
		switch (serializationMode) {
			case AS_DISCRETE_JSON_OBJECTS:
				return;
			case AS_CHILDREN_OF_ROOT_ELEMENT:
				filePrinter.println("{ \"elements\" : [");
				return;
			case AS_SINGLE_ARRAY:
				filePrinter.println("[");
				return;
			default:
				throw new IllegalStateException(serializationMode.toString());
		}
	}

	private void postfixSequence(PrintWriter filePrinter) {
		switch (serializationMode) {
			case AS_DISCRETE_JSON_OBJECTS:
				return;
			case AS_CHILDREN_OF_ROOT_ELEMENT:
				filePrinter.println("\n]}");
				return;
			case AS_SINGLE_ARRAY:
				filePrinter.println("\n]");
				return;
			default:
				throw new IllegalStateException(serializationMode.toString());
		}
	}
	private void midfixSequence(PrintWriter filePrinter) {
		switch (serializationMode) {
			case AS_DISCRETE_JSON_OBJECTS:
				return;
			case AS_CHILDREN_OF_ROOT_ELEMENT:
			case AS_SINGLE_ARRAY:
				filePrinter.println(",");
				return;
			default:
				throw new IllegalStateException(serializationMode.toString());
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

	
	private void handleIOException(Throwable ioEx) {
		Application.getInstance().getGUILog().log("[ERROR] An error occurred while exporting model as JSON, aborting. Reason: " + ioEx.getMessage());
		ioEx.printStackTrace();
	}
	
}
