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
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.task.ProgressStatus;
import com.nomagic.task.RunnableWithProgress;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

import gov.nasa.jpl.mbee.mdk.api.incubating.convert.Converters;
import gov.nasa.jpl.mbee.mdk.json.JacksonUtils;
import gov.nasa.jpl.mbee.mdk.mms.actions.UpdateClientElementAction;
import gov.nasa.jpl.mbee.mdk.util.Changelog;

/**
 * @author Gabor Bergmann
 *
 */
public class FilePatchRunner implements RunnableWithProgress {
	
	
	private static final String PATCH_FIELD_DELETE_IDS = "deleteElementIds";
	private static final String PATCH_FIELD_CREATE_UPDATE = "createOrUpdateElements";
	
	private Project project;
	private File patchFile;


	public FilePatchRunner(Project project, File patchFile) {
		this.project = project;
		this.patchFile = patchFile;
	}

    @Override
    public void run(ProgressStatus progressStatus) {
		String patchDescriptionText = "Patching model with file " + patchFile.getAbsolutePath();
        Application.getInstance().getGUILog().log("[INFO] " + patchDescriptionText);

        Instant startInstant = Instant.now();
		
        progressStatus.setDescription(patchDescriptionText);
        progressStatus.setIndeterminate(false);
        progressStatus.setMax(2);
        progressStatus.setCurrent(0);
        
		try {
			
			// STEP 1 - parse .mdkpatch JSON file
			
			JsonNode patch = JacksonUtils.getObjectMapper().readTree(patchFile);
			
			if (! (patch.hasNonNull(PATCH_FIELD_DELETE_IDS) && patch.get(PATCH_FIELD_DELETE_IDS).isArray()  &&
					patch.hasNonNull(PATCH_FIELD_CREATE_UPDATE) && patch.get(PATCH_FIELD_CREATE_UPDATE).isArray()) ) 
			{
				Application.getInstance().getGUILog().log("[ERROR] Malformed JSON structure, not a valid .mdkpatch file.");
				return;
			}
			
			List<String> deleteElementIds = 
					StreamSupport.stream(patch.get(PATCH_FIELD_DELETE_IDS).spliterator(), false)
						.filter(JsonNode::isTextual).map(JsonNode::asText).collect(Collectors.toList());
			List<ObjectNode> createOrUpdateElements = 
					StreamSupport.stream(patch.get(PATCH_FIELD_CREATE_UPDATE).spliterator(), false)
						.filter(JsonNode::isObject).map(ObjectNode.class::cast).collect(Collectors.toList());
						
	        Application.getInstance().getGUILog().log(String.format(
	        		"[INFO] Parsed patch: %d elements to delete, %d elements to create or update.",
	        		deleteElementIds.size(), createOrUpdateElements.size()));
	        
	        progressStatus.setCurrent(1);
	        
	        
			
			// STEP 2 - check if patch is valid, i.e. all elements to delete are in fact present
			
        
	        BiFunction<String, Project, Element> idToElement = Converters.getIdToElementConverter();
	        for (String elementToDelete : deleteElementIds) {
				if (null == idToElement.apply(elementToDelete, project)) 
				{
		            Application.getInstance().getGUILog().log("[ERROR] Invalid patch: cannot delete non-existing element " + elementToDelete);
	        		return;
	        	}
	        }
	        
	        progressStatus.setCurrent(2);
	        
			
			// STEP 3 - apply patch
			
            UpdateClientElementAction updateClientElementAction = new UpdateClientElementAction(project);
            updateClientElementAction.setElementsToUpdate(createOrUpdateElements);
            updateClientElementAction.setElementsToDelete(deleteElementIds);
            updateClientElementAction.run(progressStatus);
        	
            
			
			// FINALLY - evaluate success of patch application
			
            Changelog<String, ObjectNode> failedChangelog = updateClientElementAction.getFailedChangelog();
            if (failedChangelog.isEmpty()) {
    			Instant endInstant = Instant.now();
    			final Duration elapsed = Duration.between(startInstant, endInstant);
    			Application.getInstance().getGUILog().log(
    					String.format("[INFO] Patch applied successfully in %d seconds.",
    							elapsed.getSeconds()));	            
            } else {
	            Application.getInstance().getGUILog().log("[ERROR] Patch failed: " + failedChangelog);
            }

            
		} catch (IOException ioEx) {
			handleIOException(ioEx);
		}
        
        
    }

	
	private void handleIOException(Throwable ioEx) {
		Application.getInstance().getGUILog().log("[ERROR] An error occurred while patching model from JSON file, aborting. Reason: " + ioEx.getMessage());
		ioEx.printStackTrace();
	}
	
}
