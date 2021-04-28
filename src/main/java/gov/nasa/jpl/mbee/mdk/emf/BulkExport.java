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
package gov.nasa.jpl.mbee.mdk.emf;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import gov.nasa.jpl.mbee.mdk.api.incubating.convert.Converters;
import com.nomagic.magicdraw.core.Project;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import gov.nasa.jpl.mbee.mdk.util.Pair;

/**
 * @author Gabor Bergmann
 * 
 * Original implementation lifted from ManualSyncRunner::collectClientElementsRecursively() by igomes
 *
 */
public class BulkExport {
	
    public static final int DEPTH_INFINITE = -1;
    public static final int DEPTH_NO_DESCENT = 0;
	
	public static Stream<Pair<Element, ObjectNode>> exportElementsRecursively(Project project, Element element, int depth) {
        ObjectNode jsonObject = Converters.getElementToJsonConverter().apply(element, project);
        if (jsonObject == null) {
            return Stream.empty();
        }
        Stream<Pair<Element, ObjectNode>> result = Stream.of(
            new Pair<>(element, jsonObject)
        );
        if (depth != DEPTH_NO_DESCENT) {
            int childDepth = depth - 1;
            result = Stream.concat(result, element.getOwnedElement().stream()
                        .flatMap(elementChild -> exportElementsRecursively(project, elementChild, childDepth))
            );
        }
        if (element.equals(project.getPrimaryModel())) {

            final Package primaryModel = project.getPrimaryModel();

            result = Stream.concat(result, project.getModels().stream()
                        .filter(attachedModel -> attachedModel != primaryModel)
                        .flatMap(attachedModel -> exportElementsRecursively(project, attachedModel, DEPTH_NO_DESCENT))
            );
        }
        return result;
    }

}
