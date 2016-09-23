/*******************************************************************************
 * Copyright (c) <2013>, California Institute of Technology ("Caltech").  
 * U.S. Government sponsorship acknowledged.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are 
 * permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice, this list of 
 *    conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice, this list 
 *    of conditions and the following disclaimer in the documentation and/or other materials 
 *    provided with the distribution.
 *  - Neither the name of Caltech nor its operating division, the Jet Propulsion Laboratory, 
 *    nor the names of its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS 
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER  
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON 
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package gov.nasa.jpl.mbee.mdk.ems.validation;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.GUILog;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.ProjectUtilities;
import com.nomagic.magicdraw.uml.RepresentationTextCreator;
import com.nomagic.task.ProgressStatus;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdmodels.Model;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.*;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;
import gov.nasa.jpl.mbee.mdk.api.docgen.presentation_elements.PresentationElementEnum;
import gov.nasa.jpl.mbee.mdk.api.docgen.presentation_elements.properties.PresentationElementPropertyEnum;
import gov.nasa.jpl.mbee.mdk.ems.ExportUtility;
import gov.nasa.jpl.mbee.mdk.ems.ImportUtility;
import gov.nasa.jpl.mbee.mdk.ems.ServerException;
import gov.nasa.jpl.mbee.mdk.ems.validation.actions.*;
import gov.nasa.jpl.mbee.mdk.lib.Debug;
import gov.nasa.jpl.mbee.mdk.lib.JSONUtils;
import gov.nasa.jpl.mbee.mdk.lib.Utils;
import gov.nasa.jpl.mbee.mdk.docgen.validation.ValidationRule;
import gov.nasa.jpl.mbee.mdk.docgen.validation.ValidationRuleViolation;
import gov.nasa.jpl.mbee.mdk.docgen.validation.ValidationSuite;
import gov.nasa.jpl.mbee.mdk.docgen.validation.ViolationSeverity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
//TODO rewrite the entire thing for @donbot
public class ModelValidator {
    public static final String HIDDEN_ID_PREFIX = "_hidden_",
            HOLDING_BIN_PACKAGE_ID_REGEX = "^(holding_bin|(Y|M|D|H){2}_[0-9]+)_.+$";

    private ValidationSuite suite = new ValidationSuite("Model Sync");
    private ValidationRule nameDiff = new ValidationRule("Mismatched Name", "name is different", ViolationSeverity.ERROR);
    private ValidationRule docDiff = new ValidationRule("Mismatched Doc", "documentation is different", ViolationSeverity.ERROR);
    private ValidationRule valueDiff = new ValidationRule("Mismatched Value", "property/slot value is different", ViolationSeverity.ERROR);
    private ValidationRule propertyTypeDiff = new ValidationRule("Mismatched Property Type", "property type is different", ViolationSeverity.ERROR);
    private ValidationRule ownership = new ValidationRule("Moved", "Wrong containment", ViolationSeverity.ERROR);
    private ValidationRule exist = new ValidationRule("Exist", "Doesn't Exist or Moved", ViolationSeverity.ERROR);
    private ValidationRule relDiff = new ValidationRule("Relationship", "Relationship source or target", ViolationSeverity.ERROR);
    private ValidationRule commentDiff = new ValidationRule("Comment", "Comment different", ViolationSeverity.ERROR);
    private ValidationRule projectExist = new ValidationRule("Project Exist", "Project doesn't exist", ViolationSeverity.ERROR);
    private ValidationRule baselineTag = new ValidationRule("Baseline Tag Set", "Baseline Tag isn't set", ViolationSeverity.WARNING);
    private ValidationRule metaclassDiff = new ValidationRule("No longer a document", "no longer a document", ViolationSeverity.WARNING);
    private ValidationRule connectorDiff = new ValidationRule("Connector", "role/property paths are different", ViolationSeverity.ERROR);
    private ValidationRule constraintDiff = new ValidationRule("Constraint", "constraint spec is different", ViolationSeverity.ERROR);
    private ValidationRule operationDiff = new ValidationRule("Operation", "operation spec is different", ViolationSeverity.ERROR);
    private ValidationRule parameterDiff = new ValidationRule("Parameter", "parameter spec is different", ViolationSeverity.ERROR);
    private ValidationRule associationDiff = new ValidationRule("Association", "association roles are different", ViolationSeverity.ERROR);
    private ValidationRule siteDiff = new ValidationRule("Site", "site existence", ViolationSeverity.ERROR);
    private ValidationRule productView = new ValidationRule("No longer a document", "no longer a document", ViolationSeverity.WARNING);
    private ValidationRule instanceSpec = new ValidationRule("InstanceSpec", "InstanceSpec", ViolationSeverity.ERROR);
    private ValidationRule viewConstraint = new ValidationRule("view constraint", "View constraint", ViolationSeverity.ERROR);
    private ValidationRule metatypes = new ValidationRule("metatypes", "Metatypes", ViolationSeverity.ERROR);
    private ValidationRule ownedAttribute = new ValidationRule("ownedAttribute", "Owned Attribute", ViolationSeverity.ERROR);

    private Set<String> differentElements = new HashSet<>();
    private Project prj;
    private Collection<Element> starts;
    private JSONObject result;
    private boolean checkExist;
    private Set<Element> elementSet;
    private boolean crippled;
    private boolean recurse;
    private int depth = -2;

    private Map<String, JSONObject> keyedElements;

    public ModelValidator(Collection<Element> starts, JSONObject result, boolean checkExist, Set<Element> elementSet, boolean crippled, boolean recurse, int depth) {
        //result is from web, elementSet is from model
        this.starts = starts;
        suite.addValidationRule(nameDiff);
        suite.addValidationRule(docDiff);
        suite.addValidationRule(valueDiff);
        suite.addValidationRule(ownership);
        suite.addValidationRule(exist);
        suite.addValidationRule(relDiff);
        suite.addValidationRule(commentDiff);
        suite.addValidationRule(projectExist);
        suite.addValidationRule(baselineTag);
        suite.addValidationRule(metaclassDiff);
        suite.addValidationRule(propertyTypeDiff);
        suite.addValidationRule(connectorDiff);
        suite.addValidationRule(constraintDiff);
        suite.addValidationRule(operationDiff);
        suite.addValidationRule(parameterDiff);
        suite.addValidationRule(associationDiff);
        suite.addValidationRule(siteDiff);
        suite.addValidationRule(productView);
        suite.addValidationRule(instanceSpec);
        suite.addValidationRule(viewConstraint);
        suite.addValidationRule(metatypes);
        suite.addValidationRule(ownedAttribute);
        this.checkExist = checkExist;
        this.result = result;
        prj = Application.getInstance().getProject();
        this.elementSet = elementSet;
        this.crippled = crippled;
        this.recurse = recurse;
        this.depth = depth;
    }

    public ModelValidator(Collection<Element> starts, JSONObject result, boolean checkExist, Set<Element> elementSet, boolean crippled) {
        this(starts, result, checkExist, elementSet, crippled, true, 0);
    }

    public static void updateElementsKeyed(JSONObject result, Map<String, JSONObject> elementsKeyed) {
        if (result == null) {
            return;
        }
        JSONArray elements = (JSONArray) result.get("elements");
        if (elements == null) {
            return;
        }
        for (JSONObject elementInfo : (List<JSONObject>) elements) {
            String elementId = (String) elementInfo.get("sysmlid");
            if (elementId == null) {
                continue;
            }
            if (elementId.contains("-slot-")) {
                Element e = ExportUtility.getElementFromID(elementId);
                if (e != null) {
                    elementId = e.getID();
                }
                //else
                //    continue; //this is ignoring slots on the server that're not in magicdraw
            }
            elementsKeyed.put(elementId, elementInfo);
        }
    }

    public static ValidationRuleViolation siteDiff(Package e, JSONObject elementInfo) {
        JSONObject model = ExportUtility.fillPackage(e, null);
        Boolean serverSite = (Boolean) elementInfo.get("isSite");
        boolean serversite = false;
        if (serverSite != null && serverSite) {
            serversite = true;
        }
        boolean modelsite = (Boolean) model.get("isSite");
        if (!serversite && modelsite || serversite && !modelsite) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[SITE CHAR] model: " + modelsite + ", web: " + serversite);
            v.addAction(new ExportSite(e));
            return v;
        }
        return null;
    }

    private static String truncate(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() > 50) {
            return s.substring(0, 49) + "...";
        }
        return s;
    }

    public static JSONObject getManyAlfrescoElementsByID(Collection<String> ids, ProgressStatus ps) throws ServerException {
        if (ids.isEmpty()) {
            return null;
        }
        JSONArray idsJSONArray = new JSONArray();
        for (String id : ids) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("sysmlId", id);
            idsJSONArray.add(jsonObject);
        }
        final JSONObject body = new JSONObject();
        body.put("elements", idsJSONArray);
        final String url = ExportUtility.getUrlWithWorkspace() + "/elements";
        Utils.guilog("[INFO] Searching for " + ids.size() + " elements from server...");

        final AtomicReference<String> res = new AtomicReference<>();
        final AtomicReference<Integer> code = new AtomicReference<>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                String tres;
                try {
                    tres = ExportUtility.getWithBody(url, body.toJSONString());
                    res.set(tres);
                    code.set(200);
                } catch (ServerException ex) {
                    code.set(ex.getCode());
                    if (ex.getCode() != 404) {
                        res.set(ex.getResponse());
                    }
                }
            }
        });
        t.start();
        try {
            t.join(10000);
            while (t.isAlive()) {
                if (ps.isCancel()) {
                    //clean up thread?
                    Utils.guilog("[INFO] Search for elements cancelled.");
                    code.set(500);
                    break;
                }
                t.join(10000);
            }
        } catch (Exception ignored) {
        }

        String response = res.get();
        if (code.get() != 404 && code.get() != 200) {
            throw new ServerException(response, code.get());
        }
        Utils.guilog("[INFO] Finished getting elements.");
        if (response == null) {
            JSONObject reso = new JSONObject();
            reso.put("elements", new JSONArray());
            return reso;
        }
        return (JSONObject) JSONValue.parse(response);
    }

    public static JSONObject getManyAlfrescoElements(Collection<Element> elements, ProgressStatus ps) throws ServerException {
        if (elements.isEmpty()) {
            return null;
        }
        final List<String> ids = new ArrayList<>(elements.size());
        for (Element element : elements) {
            ids.add(element.getID());
        }
        return getManyAlfrescoElementsByID(ids, ps);
    }

    @Deprecated
    private static NMAction getPaddingAction() {
        return new MDAction(null, null, null, null) {
            @Override
            public boolean isEnabled() {
                return false;
            }
        };
    }

    public Set<String> getDifferentElementIDs() {
        return differentElements;
    }

    public Map<String, JSONObject> getKeyed() {
        return keyedElements;
    }

    public boolean checkProject(ProgressStatus ps) {
        //if (ExportUtility.baselineNotSet)
        //    baselineTag.addViolation(new ValidationRuleViolation(Project.getProject(start).getModel(), "The baseline tag isn't set, baseline check wasn't done."));
        String projectUrl = ExportUtility.getUrlForProject();
        if (projectUrl == null) {
            return false;
        }
        String globalUrl = ExportUtility.getUrl(Application.getInstance().getProject());
        globalUrl += "/workspaces/master/elements/" + Application.getInstance().getProject().getPrimaryProject().getProjectID();
        String globalResponse = null;
        try {
            globalResponse = ExportUtility.get(globalUrl, false);
        } catch (ServerException ex) {

        }
        String url = ExportUtility.getUrlWithWorkspace();
        if (url == null) {
            return false;
        }
        if (globalResponse == null) {
            ValidationRuleViolation v = null;
            if (url.contains("master")) {
                v = new ValidationRuleViolation(Application.getInstance().getProject().getModel(), "The project doesn't exist on the web.");
                // TODO Change me back to false @donbot
                v.addAction(new InitializeProjectModel(true));
            }
            else {
                v = new ValidationRuleViolation(Application.getInstance().getProject().getModel(), "The trunk project doesn't exist on the web. Export the trunk first.");
            }
            projectExist.addViolation(v);
            return false;
        }
        String response = null;
        try {
            response = ExportUtility.get(projectUrl, false);
        } catch (ServerException ex) {

        }
        if (response == null || response.contains("Site node is null") || response.contains("Could not find project")) {//tears

            ValidationRuleViolation v = new ValidationRuleViolation(Application.getInstance().getProject().getModel(), "The project exists on the server already under a different site.");
            //v.addAction(new InitializeProjectModel(false));
            projectExist.addViolation(v);

            return false;
        }
        for (Element start : starts) {
            if (ProjectUtilities.isElementInAttachedProject(start)) {
                Utils.showPopupMessage("You should not validate or export elements not from this project! Open the right project and do it from there");
                return false;
            }
        }
        JSONArray elements = new JSONArray();
        // TODO REVERT ME @donbot
        /*for (Element start : starts) {
            String id = start.getID();
            if (start == Application.getInstance().getProject().getModel()) {
                id = Application.getInstance().getProject().getPrimaryProject().getProjectID();
            }
            id = id.replace(".", "%2E");
            final String url2;
            if (depth > 0) {
                url2 = url + "/elements/" + id + "?depth=" + java.lang.Integer.toString(depth) + "&qualified=false";
            }
            else {
                url2 = url + "/elements/" + id + "?recurse=" + java.lang.Boolean.toString(recurse) + "&qualified=false";
            }
            GUILog log = Application.getInstance().getGUILog();
            Utils.guilog("[INFO] Getting elements from server...");

            final AtomicReference<String> res = new AtomicReference<String>();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    String tres = null;
                    try {
                        tres = ExportUtility.get(url2, false);
                    } catch (ServerException ex) {
                    }
                    res.set(tres);
                }
            });
            t.start();
            try {
                t.join(10000);
                while (t.isAlive()) {
                    if (ps.isCancel()) {
                        Utils.guilog("[INFO] Model validation canceled.");
                        //clean up thread?
                        return false;
                    }
                    t.join(10000);
                }
            } catch (Exception e) {

            }
            //response = ExportUtility.get(url2, false);

            response = res.get();
            Utils.guilog("[INFO] Finished getting elements");
            if (response == null) {
                response = "{\"elements\": []}";
            }
            JSONObject partialResult = (JSONObject) JSONValue.parse(response);
            if (partialResult != null && partialResult.containsKey("elements")) {
                elements.addAll((JSONArray) partialResult.get("elements"));
            }
        }
        result = new JSONObject();
        result.put("elements", elements);
        ResultHolder.lastResults = result;*/
        result = new JSONObject();
        result.put("elements", new JSONArray());
        return true;
    }

    @SuppressWarnings("unchecked")
    public void validate(boolean fillContainment, ProgressStatus ps) throws ServerException {
        JSONArray elements = (JSONArray) result.get("elements");
        if (elements == null) {
            return;
        }
        Map<String, JSONObject> elementsKeyed = new HashMap<String, JSONObject>();
        if (fillContainment) {
            elementSet = new HashSet<Element>();
            for (Element start : starts) {
                getAllMissing(start, elementSet, elementsKeyed, recurse, depth);
            }
            validateModel(elementsKeyed, elementSet, ps);
        }
        else {
            validateModel(elementsKeyed, elementSet, ps);
        }
        keyedElements = elementsKeyed;
        result.put("elementsKeyed", elementsKeyed);
    }

    @SuppressWarnings("unchecked")
    private void validateModel(Map<String, JSONObject> elementsKeyed, Set<Element> all, ProgressStatus ps) throws ServerException {
        //Set<Element> all = new HashSet<Element>();
        Set<String> checked = new HashSet<String>();

        //MDEV #673: update to handle specialization elements.
        //
        updateElementsKeyed(result, elementsKeyed);
        // elementsKeyed.keySet() refers to all MagicDraw element IDs on Alfresco
        // all refers to MagicDraw view element and owned elements
        // 1st loop: MagicDraw elements get compared with Alfresco elements
        Set<Element> missing = new HashSet<>();
        for (Element e : all) {
            if (ps != null && ps.isCancel()) {
                break;
            }
            if (!elementsKeyed.containsKey(e.getID())) {
                // MagicDraw element is not on Alfresco
                if (checkExist && ExportUtility.shouldAdd(e)) {
                    missing.add(e);
                }
                else {
                    continue;
                }
            }
        }
        JSONObject missingResult = getManyAlfrescoElements(missing, ps);
        updateElementsKeyed(missingResult, elementsKeyed);
        for (Element e : all) {
            if (ps != null && ps.isCancel()) {
                break;
            }
            if (!elementsKeyed.containsKey(e.getID())) {
                ValidationRuleViolation v = new ValidationRuleViolation(e, "[EXIST] This doesn't exist on MMS");
                if (!crippled) {
                    v.addAction(new ExportElement(e));
                    v.addAction(new DeleteMagicDrawElement(e));
                }
                exist.addViolation(v);
                differentElements.add(ExportUtility.getElementID(e));
                continue;
            }
            JSONObject elementInfo = elementsKeyed.get(e.getID());
            checkElement(e, elementInfo);
            checked.add(e.getID());
        }

        Set<String> elementsKeyedIds = new HashSet<>(elementsKeyed.keySet());
        elementsKeyedIds.removeAll(checked);
        for (String elementsKeyedId : elementsKeyedIds) {
            // MagicDraw element that has not been compared to Alfresco
            Element e = ExportUtility.getElementFromID(elementsKeyedId);
            if (e == null || e == prj.getModel()) {
                if (elementsKeyedId.startsWith("PROJECT")) {
                    continue;
                }
                if (elementsKeyedId.startsWith(ModelValidator.HIDDEN_ID_PREFIX)) {
                    continue;
                }
                // Alfresco sysml element is not in MagicDraw
                JSONObject jsonObject = elementsKeyed.get(elementsKeyedId);
                String type = null;
                if (jsonObject.containsKey("type")) {
                    type = (String) jsonObject.get("type");
                }
                if (type != null && type.equals("Project")) {
                    continue;
                }
                Object o;
                if ((o = jsonObject.get("classifierIds")) instanceof JSONArray) {
                    //TODO this is legacy element support. purge? @donbot (see also JMSMessageListener.java:105)
                    boolean isPresentationElement = false;
                    for (Object c : (JSONArray) o) {
                        if (c instanceof String) {
                            for (PresentationElementEnum presentationElementEnum : PresentationElementEnum.values()) {
                                if (c.equals(presentationElementEnum.get().getID())) {
                                    isPresentationElement = true;
                                    break;
                                }
                            }
                        }
                        if (isPresentationElement) {
                            break;
                        }
                    }
                    if (isPresentationElement) {
                        continue;
                    }
                }
                if ((o = jsonObject.get("definingFeatureId")) instanceof String) {
                    //TODO this is legacy element support. purge? @donbot (see also JMSMessageListener.java:125)
                    boolean isPresentationElementProperty = false;
                    for (PresentationElementPropertyEnum presentationElementPropertyEnum : PresentationElementPropertyEnum.values()) {
                        if (o.equals(presentationElementPropertyEnum.get().getID())) {
                            isPresentationElementProperty = true;
                            break;
                        }
                    }
                    if (isPresentationElementProperty) {
                        continue;
                    }
                }
                /*
                 * previous check of propertyType json array
                 * 
                    if ((o = jsonObject.get("propertyType")) instanceof JSONArray) {
                        boolean isPresentationElementProperty = false;
                        for (Object c : (JSONArray) o2) {
                            if (c instanceof String) {
                                for (PresentationElementPropertyEnum presentationElementPropertyEnum : PresentationElementPropertyEnum.values()) {
                                    if (c.equals(presentationElementPropertyEnum.get().getID())) {
                                        isPresentationElementProperty = true;
                                        break;
                                    }
                                }
                            }
                            if (isPresentationElementProperty) {
                                break;
                            }
                        }
                        if (isPresentationElementProperty) {
                            continue;
                        }
                    }
                */
                
                if (type == null) {
                    type = "Element";
                }
                if (ImportUtility.VALUESPECS.contains(type)) {
                    continue;
                }
                ValidationRuleViolation v;
                String existname = (String) jsonObject.get("name");
                if (existname == null) {
                    existname = "<>";
                }
                existname.replace('`', '\'');
                v = new ValidationRuleViolation(e, "[EXIST on MMS] " + (type.equals("Product") ? "Document" : type) + " " + existname + " `" + elementsKeyedId + "` exists on MMS but was deleted locally");
                if (!crippled) {
                    if (!elementsKeyedId.matches(HOLDING_BIN_PACKAGE_ID_REGEX)) {
                        v.addAction(new DeleteAlfrescoElement(elementsKeyedId, elementsKeyed));
                    }
                    v.addAction(new DetailDiff(new JSONObject(), jsonObject));
                    //v.addAction(new ElementDetail(jSONobject));
                    v.addAction(new CreateMagicDrawElement(jsonObject, elementsKeyed));
                }
                else {
                    v.addAction(new ElementDetail(jsonObject));
                }
                exist.addViolation(v);
                differentElements.add(elementsKeyedId);
            }
            else {
                if (!(e instanceof ValueSpecification)) {
                    checkElement(e, elementsKeyed.get(elementsKeyedId));
                }
            }
        }
    }

    private void getAllMissing(Element current, Set<Element> missing, Map<String, JSONObject> elementsKeyed, boolean recurse, int depth) {
        if (ProjectUtilities.isElementInAttachedProject(current)) {
            return;
        }
        if (!ExportUtility.shouldAdd(current)) {
            return;
        }
        if (!elementsKeyed.containsKey(current.getID())) {
            if (!(current instanceof Model && ((Model) current).getName().equals("Data"))) {
                missing.add(current);
            }
        }
        if (recurse) {
            for (Element e : current.getOwnedElement()) {
                getAllMissing(e, missing, elementsKeyed, true, 0);
            }
        }
        else if (depth > 0) {
            for (Element e : current.getOwnedElement()) {
                getAllMissing(e, missing, elementsKeyed, false, depth - 1);
            }
        }
    }

    private void checkElement(Element e, JSONObject elementInfo) {
        String elementID = ExportUtility.getElementID(e);
        String elementDoc = ModelHelper.getComment(e);
        String elementDocClean = ExportUtility.cleanHtml(elementDoc);
        String elementName = null;
        Boolean editable = (Boolean) elementInfo.get("editable");
        String webDoc = (String) elementInfo.get("documentation");

//        ValidateDiff ddiff = new ValidateDiff(e, webDoc, elementDocClean, elementInfo, editable);
        DetailDiff ddiff = new DetailDiff(e, elementInfo);

        if (webDoc != null) {
            webDoc = ExportUtility.cleanHtml(webDoc);
            elementInfo.put("documentation", webDoc);
        }
        if (e instanceof NamedElement) {
            elementName = ((NamedElement) e).getName();
        }
        String webName = ExportUtility.unescapeHtml((String) elementInfo.get("name"));

        if (elementName != null && !elementName.equals(webName)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[NAME] model: " + elementName + ", web: " + webName);
            differentElements.add(elementID);
            if (editable) {
                v.addAction(new ExportName((NamedElement) e));
            }
            v.addAction(ddiff);
            v.addAction(new ImportName((NamedElement) e, webName, result));
            nameDiff.addViolation(v);
        }
        if (elementDoc != null && !(webDoc == null && elementDoc.equals("")) && !elementDocClean.equals(webDoc)) {
            /*if (webDoc != null) {
                for (int i = 0; i < Math.max(elementDocClean.length(), webDoc.length()); i++) {
                    Character elementChar = i < elementDocClean.length() ? elementDocClean.charAt(i) : null;
                    Character webChar = i < webDoc.length() ? webDoc.charAt(i) : null;
                    System.out.println((elementChar != null ? "'" + elementChar + "' [" + (int) elementChar + "]" : "~") + "\t" + (webChar != null ? "'" + webChar + "' [" + (int) webChar + "]" : "~"));
                }
            }*/
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[DOC] model: " + truncate(elementDocClean) + ", web: " + truncate((String) elementInfo.get("documentation")));
            differentElements.add(elementID);
            if (editable) {
                v.addAction(new ExportDoc(e));
            }
            v.addAction(new CompareText(e, webDoc, elementDocClean, result));
            v.addAction(ddiff);
            v.addAction(new ImportDoc(e, webDoc, result));
            docDiff.addViolation(v);
        }

        if (e instanceof Property) {
            ValidationRuleViolation v = valueDiff((Property) e, elementInfo);
            if (v != null) {
                // Replacement to separate commit and accept that are added inside the valueDiff method
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                valueDiff.addViolation(v);
                differentElements.add(elementID);
            }
            ValidationRuleViolation v2 = propertyDiff((Property) e, elementInfo);
            if (v2 != null) {
                //v2.addAction(vdiff);
                v2.getActions().add(v2.getActions().size() > 1 ? 1 : 0, ddiff);
                propertyTypeDiff.addViolation(v2);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Slot) {
            ValidationRuleViolation v = valueDiff((Slot) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                valueDiff.addViolation(v);
                differentElements.add(elementID);
            }
            ValidationRuleViolation v2 = slotTypeDiff((Slot) e, elementInfo);
            if (v2 != null) {
                //v2.addAction(vdiff);
                v2.getActions().add(v2.getActions().size() > 1 ? 1 : 0, ddiff);
                propertyTypeDiff.addViolation(v2);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Comment) {
            //ValidationRuleViolation v = commentDiff((Comment)e, elementInfo);
            //if (v != null)
            //   valueDiff.addViolation(v);
        }
        else if (e instanceof DirectedRelationship) {
            ValidationRuleViolation v = relationshipDiff((DirectedRelationship) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                relDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Connector) {
            ValidationRuleViolation v = connectorDiff((Connector) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                connectorDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Constraint) {
            ValidationRuleViolation v = constraintDiff((Constraint) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                constraintDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Operation) {
            ValidationRuleViolation v = operationDiff((Operation) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                operationDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Parameter) {
            ValidationRuleViolation v = parameterDiff((Parameter) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                parameterDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Association) {
            ValidationRuleViolation v = associationDiff((Association) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                associationDiff.addViolation(v);
                differentElements.add(elementID);
            }
        }
        else if (e instanceof Package) {
            ValidationRuleViolation v = siteDiff((Package) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                siteDiff.addViolation(v);
            }
        }
        else if (e instanceof InstanceSpecification) {
            ValidationRuleViolation v = instanceSpecificationDiff((InstanceSpecification) e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                instanceSpec.addViolation(v);
                differentElements.add(elementID);
            }
        }

        // Server-side only PEI means no more need to validate them with the model
        /*
        Stereotype view = Utils.getViewStereotype();
        if (StereotypesHelper.hasStereotypeOrDerived(e, view)) {
            ValidationRuleViolation v = viewContentDiff(e, elementInfo);
            if (v != null) {
                //v.addAction(vdiff);
            	v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                viewConstraint.addViolation(v);
                differentElements.add(elementID); //should this be here
            }
        }
        */
        if (e instanceof Class) {
            ValidationRuleViolation v = ownedAttributeDiff((Class) e, elementInfo);
            if (v != null) {
                v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
                ownedAttribute.addViolation(v);
                differentElements.add(elementID); //should this be here
            }
        }
        ValidationRuleViolation v = ownerDiff(e, elementInfo);
        if (v != null) {
            //v.addAction(vdiff);
            v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
            ownership.addViolation(v);
            differentElements.add(elementID);
        }
        v = metatypeDiff(e, elementInfo);
        if (v != null) {
            //v.addAction(vdiff);
            v.getActions().add(v.getActions().size() > 1 ? 1 : 0, ddiff);
            metatypes.addViolation(v);
            differentElements.add(elementID);
        }
        docDiff(e, elementInfo);
    }

    public static boolean isViewSpecializationDiff(JSONObject firstSpecialization, JSONObject secondSpecialization) {
        if (firstSpecialization == null && secondSpecialization == null) {
            return false;
        }
        if (firstSpecialization == null || secondSpecialization == null) {
            return true;
        }
        Object o;

        JSONObject firstContents = null, secondContents = null;
        if ((o = firstSpecialization.get("contents")) instanceof JSONObject) {
            firstContents = (JSONObject) o;
        }
        if ((o = secondSpecialization.get("contents")) instanceof JSONObject) {
            secondContents = (JSONObject) o;
        }

        JSONArray firstDisplayedElements = null, secondDisplayedElements = null;
        if ((o = firstSpecialization.get("displayedElements")) instanceof JSONArray) {
            firstDisplayedElements = (JSONArray) o;
        }
        if ((o = secondSpecialization.get("displayedElements")) instanceof JSONArray) {
            secondDisplayedElements = (JSONArray) o;
        }

        return !JSONUtils.compare(firstContents, secondContents) || !Utils.isJSONArrayEqual(firstDisplayedElements, secondDisplayedElements);
    }

    // obsoleted by server-side only instances
    @Deprecated
    private ValidationRuleViolation viewContentDiff(Element e, JSONObject elementInfo) {
        JSONObject webViewSpec = elementInfo;
        if (isViewSpecializationDiff(webViewSpec, ExportUtility.fillViewContent(e, null))) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VIEW CONSTRAINT] View constraint or displayed elements are different");
            v.addAction(new ExportViewConstraint((NamedElement) e));
            v.addAction(new ImportViewConstraint((NamedElement) e, webViewSpec, result));
            return v;
        }
        return null;
    }

    @Deprecated
    private ValidationRuleViolation docDiff(Element e, JSONObject elementInfo) {
        JSONObject webViewSpec = elementInfo;
        if (webViewSpec == null) {
            return null;
        }
        if (webViewSpec.get("type") instanceof String && webViewSpec.get("type").equals("Product") &&
                !StereotypesHelper.hasStereotypeOrDerived(e, Utils.getProductStereotype())) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[DOCUMENT] This is no longer a product/document.");
            v.addAction(new Downgrade(e, elementInfo));
            productView.addViolation(v);
            return v;
        }
        return null;
    }

    private ValidationRuleViolation ownedAttributeDiff(Class e, JSONObject elementInfo) {
        Boolean editable = (Boolean) elementInfo.get("editable");
        JSONObject model = ExportUtility.fillOwnedAttribute(e, null);
        JSONArray modelArray = (JSONArray) model.get("ownedAttribute");
        JSONArray webArray = (JSONArray) elementInfo.get("ownedAttribute");
        if (JSONUtils.compare(modelArray, webArray)) {
            return null;
        }
        ValidationRuleViolation v = new ValidationRuleViolation(e, "[ATTRIBUTE] Owned attribute ordering is different.");
        if (editable) {
            v.addAction(new ExportOwnedAttribute(e));
        }
        v.addAction(new ImportOwnedAttribute(e, elementInfo, result));
        return v;

    }

    private ValidationRuleViolation ownerDiff(Element e, JSONObject elementInfo) {
        Boolean editable = (Boolean) elementInfo.get("editable");
        if (e.getOwner() != null) {
            String ownerID = ExportUtility.getElementID(e.getOwner());
            String webOwnerID = (String) elementInfo.get("owner");
            if (webOwnerID == null || webOwnerID.startsWith("PROJECT")) {
                if (webOwnerID == null) {
                    webOwnerID = Application.getInstance().getProject().getModel().getID();
                }
                else {
                    if (webOwnerID.equals(Application.getInstance().getProject().getPrimaryProject().getProjectID())) {
                        webOwnerID = Application.getInstance().getProject().getModel().getID();
                    }
                    else {
                        webOwnerID = null;
                    }
                }

            }
            if (!ownerID.equals(webOwnerID)) {
                Element owner = null;
                if (webOwnerID != null) {
                    owner = (Element) prj.getElementByID(webOwnerID);
                }
                if (e.getOwner() == owner) {
                    return null; //in case owner is Data
                }
                ValidationRuleViolation v = new ValidationRuleViolation(e, "[OWNER] model: " + e.getOwner().getHumanName() + ", web: " + (owner == null ? webOwnerID : owner.getHumanName()));
                if (!crippled) {
                    if (editable) {
                        v.addAction(new ExportOwner(e));
                    }
                    v.addAction(new FixModelOwner(e, owner, result));
                }
                return v;
            }
        }
        return null;
    }

    private ValidationRuleViolation propertyDiff(Property e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");

        JSONObject webcopy = (JSONObject) info.clone();
        if (webcopy.containsKey("value")) {
            webcopy.remove("value");
        }
        JSONObject model = ExportUtility.fillPropertySpecialization(e, null, false, true);
        if (!JSONUtils.compare(webcopy, model)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[PROP] Property type/aggregation/multiplicity/redefines is different");
            if (editable) {
                v.addAction(new ExportProperty(e));
            }
            v.addAction(new ImportProperty(e, result, info));
            return v;
        }
        return null;
        /*
         *   //TODO purge? @donbot specification json references not updated in old code below
         * 
        // diff the aggregation
        String modelAggr = e.getAggregation().toString().toUpperCase();
        String webAggr = null;
        if (specialization != null && specialization.containsKey("aggregation")) {
        		webAggr = (specialization.get("aggregation")).toString().toUpperCase();
        }

        // diff the prop type
        Type modelType = e.getType();
        String modelTypeId = null;
        if (modelType != null)
            modelTypeId = modelType.getID();
        String webTypeId = null;
        if (specialization != null && specialization.containsKey("propertyType"))
            webTypeId = (String)specialization.get("propertyType");
        Element webTypeElement = null;
        if (webTypeId != null)
            webTypeElement = ExportUtility.getElementFromID(webTypeId);

        // build that validation violation if it's necessary
        if ((modelTypeId != null && !modelTypeId.equals(webTypeId)) || (webTypeId != null && !webTypeId.equals(modelTypeId))
        		|| (modelAggr != null && !modelAggr.equals(webAggr)) || (webAggr != null && !webAggr.equals(modelAggr))) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[PROP] Property type/aggregation is different");
        		if (editable)
                v.addAction(new ExportProperty(e));
            v.addAction(new ImportProperty(e, (Type)webTypeElement, result));
            return v;
        }
        return null;*/
    }

    private ValidationRuleViolation slotTypeDiff(Slot e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        NamedElement modelType = e.getDefiningFeature();
        String modelTypeId = null;
        if (modelType != null) {
            modelTypeId = modelType.getID();
        }
        String webTypeId = null;
        if (info.containsKey("definingFeatureId"))
            webTypeId = (String) info.get("definingFeatureId");
        Element webTypeElement = null;
        if (webTypeId != null) {
            webTypeElement = ExportUtility.getElementFromID(webTypeId);
        }
        if ((modelTypeId != null && !modelTypeId.equals(webTypeId)) || (webTypeId != null && !webTypeId.equals(modelTypeId))) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[FEATURE] model: " + (modelType == null ? "null" : modelType.getName()) + ", web: " + (webTypeElement == null ? "null" : webTypeElement.getHumanName()));
            if (editable) {
                v.addAction(new ExportProperty(e));
            }
            //v.addAction(new ImportPropertyType(e, (Type)webTypeElement, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation relationshipDiff(DirectedRelationship e, JSONObject elementInfo) {
        Boolean editable = (Boolean) elementInfo.get("editable");
        String websourceId = (String) elementInfo.get("sourceId");
        Element websource = null;
        String webtargetId = (String) elementInfo.get("targetId");
        Element webtarget = null;
        Element localsource = ModelHelper.getClientElement(e);
        Element localtarget = ModelHelper.getSupplierElement(e);
        if (websourceId != null) {
            websource = (Element) prj.getElementByID(websourceId);
        }
        if (webtargetId != null) {
            webtarget = (Element) prj.getElementByID(webtargetId);
        }
        if (websource != null && webtarget != null && localsource != null && localtarget != null && (websource != localsource || webtarget != localtarget)) {
            String msg = "[REL] ";
            if (websource != localsource) {
                msg += "model source: " + localsource.getHumanName() + ", web source: " + websource == null ? "null" : websource.getHumanName() + " ";
            }
            if (webtarget != localtarget) {
                msg += "model target: " + localtarget.getHumanName() + ", web target: " + webtarget == null ? "null" : webtarget.getHumanName();
            }
            ValidationRuleViolation v = new ValidationRuleViolation(e, msg);
            if (editable) {
                v.addAction(new ExportRel(e));
            }
            v.addAction(new ImportRel(e, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation valueDiff(Property e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        ValueSpecification vs = e.getDefaultValue();
        JSONArray value = (JSONArray) info.get("value");

        /*JSONObject modelSpec = ExportUtility.fillPropertySpecialization(e, null, false);
        JSONArray modelValue = (JSONArray)modelSpec.get("value");
        if (!modelValue.equals(value)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: " + vs.get_representationText() + ", web: " + value == null ? "null" : value.toString());
            v.addAction(new ImportValue(e, value, result));
            if (editable)
                v.addAction(new ExportValue(e));
            return v;
        }
        return null;*/ //above is much simpler, but the return json from server can fool the json parser into using a long instead of double if it's a whole integer, so doesn't always work

        String valueTypes;
        JSONObject firstObject = null;
        if ((value == null) || (value.isEmpty())) {
            valueTypes = null;
        }
        else {
            //retrieve the type of the first element
            //in the value array.
            //
            firstObject = (JSONObject) value.get(0);
            valueTypes = (String) firstObject.get("type");
        }

        if ((vs == null || (vs instanceof ElementValue && ((ElementValue) vs).getElement() == null) ||
                (vs instanceof InstanceValue && ((InstanceValue) vs).getInstance() == null))
                && (valueTypes == null || valueTypes.equals("ElementValue") && firstObject.get("element") == null || valueTypes.equals("InstanceValue") && firstObject.get("instance") == null)) {
            return null;
        }
        if ((vs != null || (vs instanceof ElementValue && ((ElementValue) vs).getElement() != null) ||
                (vs instanceof InstanceValue && ((InstanceValue) vs).getInstance() != null))
                && (valueTypes == null || valueTypes.equals("ElementValue") && firstObject.get("element") == null || valueTypes.equals("InstanceValue") && firstObject.get("instance") == null)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: not null, web: null");
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, null, result));
            return v;
        }
        if ((vs == null || (vs instanceof ElementValue && ((ElementValue) vs).getElement() == null) ||
                (vs instanceof InstanceValue && ((InstanceValue) vs).getInstance() == null))
                && value != null && value.size() > 0 && valueTypes != null) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: null, web: " + truncate(value.toString()));
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, value, result));
            return v;
        }
        PropertyValueType valueType = PropertyValueType.valueOf((String) firstObject.get("type"));
        Map<String, Object> results = valueSpecDiff2(vs, firstObject);
        String message = (String) results.get("message");
        boolean stringMatch = (Boolean) results.get("stringMatch");
        String webString = (String) results.get("webString");
        String modelString = (String) results.get("modelString");
        if (!message.equals("")) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, message);
            if (stringMatch) {
                v.addAction(new CompareText(e, webString, modelString, result));
            }
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, value, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation valueDiff(Slot e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONArray value = (JSONArray) info.get("value");
        /*JSONObject modelSpec = ExportUtility.fillPropertySpecialization(e, null, false);
        JSONArray modelValue = (JSONArray)modelSpec.get("value");
        if (!modelValue.equals(value)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: " + modelValue.toString() + ", web: " + value == null ? "null" : value.toString());
            v.addAction(new ImportValue(e, value, result));
            if (editable)
                v.addAction(new ExportValue(e));
            return v;
        }
        return null;*/

        String valueTypes;
        JSONObject firstObject = null;

        List<ValueSpecification> vss = e.getValue();

        if ((value == null) || (value.isEmpty())) {
            valueTypes = null;
        }
        else {
            firstObject = (JSONObject) value.get(0);
            valueTypes = (String) firstObject.get("type");
        }
        Debug.outln("JSONArray value = " + value);
        boolean nullElementValues = areNullElementValues(vss);
        if ((vss == null || vss.isEmpty() || nullElementValues) && (valueTypes == null)) {
            Debug.outln("returning null: vs=" + vss + ", valueTypes=" + valueTypes + ", value=" + value);
            return null;
        }
        if (vss != null && vss.size() > 0 && !nullElementValues && (valueTypes == null)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: not null, web: null");
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, null, result));
            Debug.outln("1) returning ValidationRuleViolation: " + v);
            return v;
        }
        if ((vss == null || vss.isEmpty() || nullElementValues) && value != null && value.size() > 0 && valueTypes != null) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model: null, web: " + truncate(value.toString()));
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, value, result));
            Debug.outln("2) returning ValidationRuleViolation: " + v);
            return v;
        }
        if ((vss.size() != value.size())) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[VALUE] model and web values don't match");
            if (editable) {
                v.addAction(new ExportValue(e));
            }
            v.addAction(new ImportValue(e, value, result));
            Debug.outln("3) returning ValidationRuleViolation: " + v);
            return v;
        }

        PropertyValueType valueType = PropertyValueType.valueOf(valueTypes);
        String message = "";
        String badMessage = "[VALUE] model: " + truncate(RepresentationTextCreator.getRepresentedText(e)) + ", web: " + truncate(value.toString());
        String modelString = null;
        String webString = null;
        boolean stringMatch = false;
        Map<String, Object> results = null;
        for (int i = 0; i < vss.size(); i++) {
            results = valueSpecDiff2(vss.get(i), (JSONObject) value.get(i));
            message = (String) results.get("message");
            stringMatch = (Boolean) results.get("stringMatch");
            webString = (String) results.get("webString");
            modelString = (String) results.get("modelString");
            if (!message.equals("")) {
                ValidationRuleViolation v = new ValidationRuleViolation(e, message);
                if (stringMatch) {
                    v.addAction(new CompareText(e, webString, modelString, result));
                }
                if (editable) {
                    v.addAction(new ExportValue(e));
                }
                v.addAction(new ImportValue(e, value, result));
                return v;
            }
        }
        return null;
    }

    private ValidationRuleViolation connectorDiff(Connector e, JSONObject info) {
        JSONObject webspec = info;
        Boolean editable = (Boolean) info.get("editable");
        JSONArray webSourcePropPath = (JSONArray) webspec.get("sourcePath");
        JSONArray webTargetPropPath = (JSONArray) webspec.get("targetPath");
        String webtype = (String) webspec.get("connectorType");
        JSONObject modelspec = ExportUtility.fillConnectorSpecialization(e, null);
        JSONArray modelSourcePropPath = (JSONArray) modelspec.get("sourcePath");
        JSONArray modelTargetPropPath = (JSONArray) modelspec.get("targetPath");
        String modeltype = (String) modelspec.get("connectorType");
        if (!modelSourcePropPath.equals(webSourcePropPath) || !modelTargetPropPath.equals(webTargetPropPath) ||
                (modeltype != null && !modeltype.equals(webtype) || webtype != null && !webtype.equals(modeltype))) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[CONNECTOR] connector roles/paths/types doesn't match");
            if (editable) {
                v.addAction(new ExportConnector(e));
            }
            v.addAction(new ImportConnector(e, webspec, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation constraintDiff(Constraint e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONObject value = (JSONObject) info.get("specification");
        JSONObject modelspec = ExportUtility.fillConstraintSpecialization(e, null);
        //JSONObject modelvalue = (JSONObject)modelspec.get("specification");
        JSONObject modelvalue = ExportUtility.fillValueSpecification(e.getSpecification(), null);
        //if (jsonObjectEquals(value, modelvalue))
        //    return null;
        // if (modelvalue != null && modelvalue.equals(value))
        if (modelvalue != null && JSONUtils.compare(modelvalue, value)) {
            return null;
        }
        // if (modelvalue != null && !modelvalue.equals(value) || value != null && !value.equals(modelvalue)) {
        if (!JSONUtils.compare(modelvalue, value)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[CONSTRAINT] specifications don't match");
            //if (stringMatch)
            //  v.addAction(new CompareText(e, webString, modelString, result));
            if (editable) {
                v.addAction(new ExportConstraint(e));
            }
            //v.addAction(getPaddingAction());
            v.addAction(new ImportConstraint(e, info, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation operationDiff(Operation e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONArray postconds = (JSONArray) info.get("postconditions");
        JSONArray parameters = (JSONArray) info.get("parameters");

        JSONObject modelspec = ExportUtility.fillOperationSpecialization(e, null);
        JSONArray modelPostconds = (JSONArray) modelspec.get("postconditions");
        JSONArray modelParameters = (JSONArray) modelspec.get("parameters");

        if (!JSONUtils.compare(parameters, modelParameters) ||
                !Utils.isJSONArrayEqual(postconds, modelPostconds)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[Operation] parameters/postconditions are different");
            if (editable) {
                v.addAction(new ExportOperation(e));
            }
            v.addAction(new ImportOperation(e, info, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation parameterDiff(Parameter e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONObject modelspec = ExportUtility.fillParameterSpecialization(e, null);
        //this is now comparing the full json in info with the reduced spec json in model spec. not sure it needs altering @donbot
        if (!JSONUtils.compare(info, modelspec)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[Parameter] directions/parameterTypes are different");
            if (editable) {
                v.addAction(new ExportParameter(e));
            }
            v.addAction(new ImportParameter(e, info, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation associationDiff(Association e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONObject webspec = info;
        JSONObject modelspec = ExportUtility.fillAssociationSpecialization(e, null);
        String modelSource = (String) modelspec.get("sourceId");
        String modelTarget = (String) modelspec.get("targetId");
//        String modelSourceAggr = (String)modelspec.get("sourceAggregation");
//        String modelTargetAggr = (String)modelspec.get("targetAggregation");
        JSONArray modelOwned = (JSONArray) modelspec.get("ownedEndIds");
        String webSource = (String) webspec.get("sourceId");
        String webTarget = (String) webspec.get("targetId");
//        String webSourceAggr = (String)webspec.get("sourceAggregation");
//        String webTargetAggr = (String)webspec.get("targetAggregation");
        JSONArray webOwned = (JSONArray) webspec.get("ownedEndIds");
        if (modelSource == null || modelTarget == null || modelOwned == null || !modelSource.equals(webSource) || !modelTarget.equals(webTarget) ||
//                !modelSourceAggr.equals(webSourceAggr) || !modelTargetAggr.equals(webTargetAggr) ||
                !modelOwned.equals(webOwned)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[ASSOC] Association roles/aggregation/navigability are different");
            if (editable) {
                v.addAction(new ExportAssociation(e));
            }
            v.addAction(new ImportAssociation(e, webspec, result));
            return v;
        }
        return null;
    }

    private ValidationRuleViolation metatypeDiff(Element e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        Boolean webIsMetatype = (Boolean) info.get("isMetatype");
        JSONArray webMetatypes = (JSONArray) info.get("metatypes");
        JSONArray webAppliedMetatypes = (JSONArray) info.get("appliedMetatypes");
        JSONObject model = ExportUtility.fillMetatype(e, null);
        Boolean modelIsMetatype = (Boolean) model.get("isMetatype");
        JSONArray modelMetatypes = (JSONArray) model.get("metatypes");
        JSONArray modelAppliedMetatypes = (JSONArray) model.get("appliedMetatypes");
        if (webIsMetatype != modelIsMetatype
                || !Utils.isJSONArrayEqual(modelAppliedMetatypes, webAppliedMetatypes)
                || (modelIsMetatype && !Utils.isJSONArrayEqual(modelMetatypes, webMetatypes))) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[METATYPE] Metatype/Stereotype application are different.");
            if (editable) {
                v.addAction(new ExportMetatypes(e));
            }
            return v;
        }
        return null;
    }

    private ValidationRuleViolation instanceSpecificationDiff(InstanceSpecification e, JSONObject info) {
        Boolean editable = (Boolean) info.get("editable");
        JSONObject webspec = info;
        JSONObject modelspec = ExportUtility.fillInstanceSpecificationSpecialization(e, null);
        // if (webspec.equals(modelspec)) {
        if (!JSONUtils.compare(webspec, modelspec)) {
            ValidationRuleViolation v = new ValidationRuleViolation(e, "[INSTANCE] Instance specification or classifiers are different");
            if (editable) {
                v.addAction(new ExportInstanceSpec(e));
            }
            v.addAction(new ImportInstanceSpec(e, webspec, result));
            return v;
        }
        return null;
    }

    private Map<String, Object> valueSpecDiff2(ValueSpecification vs, JSONObject firstObject) {
        Map<String, Object> result = new HashMap<String, Object>();
        String message = "";
        String typeMismatchMessage = "[VALUE] value spec types don't match";
        String modelString = null;
        String webString = null;
        boolean stringMatch = false;
        JSONObject model = ExportUtility.fillValueSpecification(vs, null);
        if (!JSONUtils.compare(model, firstObject)) {
            if (vs instanceof LiteralString && "LiteralString".equals(firstObject.get("type"))) {
                modelString = ExportUtility.cleanHtml(((LiteralString) vs).getValue());
                webString = ExportUtility.cleanHtml((String) firstObject.get("string"));
                firstObject.put("string", webString);
                if (!modelString.equals(webString)) {
                    stringMatch = true;
                    message = "[VALUE] model: " + truncate(modelString) + ", web: " + truncate(webString);
                }
            }
            else {
                Object web = firstObject.get("double");
                if (web == null) {
                    web = firstObject.get("integer");
                }
                if (web == null) {
                    web = firstObject.get("boolean");
                }
                if (web == null) {
                    web = firstObject.get("naturalValue");
                }
                if (web == null) {
                    web = firstObject.get("instance");
                    if (web != null) {
                        Element el = ExportUtility.getElementFromID((String) web);
                        if (el != null) {
                            web = RepresentationTextCreator.getRepresentedText(el);
                        }
                    }
                }
                if (web == null) {
                    web = firstObject.get("element");
                    if (web != null) {
                        Element el = ExportUtility.getElementFromID((String) web);
                        if (el != null) {
                            web = RepresentationTextCreator.getRepresentedText(el);
                        }
                    }
                }
                if (web == null) {
                    web = firstObject.toString();
                }
                message = "[VALUE] model: " + RepresentationTextCreator.getRepresentedText(vs) + ", web: " + web;
            }
        }
        result.put("message", message);
        result.put("webString", webString);
        result.put("modelString", modelString);
        result.put("stringMatch", stringMatch);
        return result;
    }

    @Deprecated
    private Map<String, Object> valueSpecDiff(ValueSpecification vs, JSONObject firstObject) {
        Map<String, Object> result = new HashMap<String, Object>();
        PropertyValueType valueType = PropertyValueType.valueOf((String) firstObject.get("type"));
        String message = "";
        String typeMismatchMessage = "[VALUE] value spec types don't match";
        String modelString = null;
        String webString = null;
        boolean stringMatch = false;
        if (valueType == PropertyValueType.LiteralString) {
            if (vs instanceof LiteralString) {
                modelString = ExportUtility.cleanHtml(((LiteralString) vs).getValue());
                webString = ExportUtility.cleanHtml((String) firstObject.get("string"));
                firstObject.put("string", webString);
                if (!modelString.equals(webString)) {
                    stringMatch = true;
                    message = "[VALUE] model: " + truncate(modelString) + ", web: " + truncate(webString);
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.LiteralBoolean) {
            if (vs instanceof LiteralBoolean) {
                if ((Boolean) firstObject.get("boolean") != ((LiteralBoolean) vs).isValue()) {
                    message = "[VALUE] model: " + ((LiteralBoolean) vs).isValue() + ", web: " + firstObject.get("boolean");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.LiteralInteger) {
            if (vs instanceof LiteralInteger) {
                if (((LiteralInteger) vs).getValue() != (Long) firstObject.get("integer")) {
                    message = "[VALUE] model: " + ((LiteralInteger) vs).getValue() + ", web: " + firstObject.get("integer");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.LiteralUnlimitedNatural) {
            if (vs instanceof LiteralUnlimitedNatural) {
                if (((LiteralUnlimitedNatural) vs).getValue() != (Long) firstObject.get("naturalValue")) {
                    message = "[VALUE] model: " + ((LiteralUnlimitedNatural) vs).getValue() + ", web: " + firstObject.get("naturalValue");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.LiteralReal) {
            if (vs instanceof LiteralReal) {
                Double webValue = null;
                if (firstObject.get("double") instanceof Long) {
                    webValue = Double.parseDouble(firstObject.get("double").toString());
                }
                else {
                    webValue = (Double) firstObject.get("double");
                }
                if (((LiteralReal) vs).getValue() != webValue) {
                    message = "[VALUE] model: " + ((LiteralReal) vs).getValue() + ", web: " + firstObject.get("double");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.ElementValue) {
            if (vs instanceof ElementValue) {
                if (((ElementValue) vs).getElement() == null || !ExportUtility.getElementID(((ElementValue) vs).getElement()).equals(firstObject.get("element"))) {
                    message = "[VALUE] model: " + ((ElementValue) vs).getElement().getHumanName() + ", web: " + firstObject.get("element");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.InstanceValue) {
            if (vs instanceof InstanceValue) {
                if (((InstanceValue) vs).getInstance() == null || !ExportUtility.getElementID(((InstanceValue) vs).getInstance()).equals(firstObject.get("instance"))) {
                    message = "[VALUE] model: " + ((InstanceValue) vs).getInstance().getHumanName() + ", web: " + firstObject.get("instance");
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.Expression) {
            if (vs instanceof Expression) {
                JSONObject model = ExportUtility.fillValueSpecification(vs, null);
                if (!model.equals(firstObject)) {
                    message = "[VALUE] expressions don't match";
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else if (valueType == PropertyValueType.OpaqueExpression) {
            if (vs instanceof OpaqueExpression) {
                JSONObject model = ExportUtility.fillValueSpecification(vs, null);
                if (!model.equals(firstObject)) {
                    message = "[VALUE] opaque expressions don't match";
                }
            }
            else {
                message = typeMismatchMessage;
            }
        }
        else { //type of value in model and alfresco don't match or unknown type

        }
        result.put("message", message);
        result.put("webString", webString);
        result.put("modelString", modelString);
        result.put("stringMatch", stringMatch);
        return result;
    }

    @SuppressWarnings("unchecked")
    private ValidationRuleViolation commentDiff(Comment e, JSONObject elementInfo) {
        String modelBodyClean = ExportUtility.cleanHtml(e.getBody());
        String webBody = (String) elementInfo.get("body");
        if (webBody == null) {
            webBody = "";
        }
        else {
            webBody = ExportUtility.cleanHtml(webBody);
        }
        ValidationRuleViolation v = null;
        if (!modelBodyClean.equals(webBody)) {
            v = new ValidationRuleViolation(e, "[Comment] model: " + truncate(modelBodyClean) + ", web: " + truncate(webBody));
            v.addAction(new ImportComment(e, webBody, result));
            v.addAction(new ExportComment(e));
        }
        Set<String> modelAnnotated = new HashSet<String>();
        for (Element el : e.getAnnotatedElement()) {
            modelAnnotated.add(el.getID());
        }
        JSONArray web = (JSONArray) elementInfo.get("annotatedElements");
        if (web != null) {
            Set<String> webs = new HashSet<String>(web);
            if (!webs.containsAll(modelAnnotated) || !modelAnnotated.containsAll(webs)) {
                if (v == null) {
                    v = new ValidationRuleViolation(e, "[Comment] The anchored elements are different");
                    v.addAction(new ImportComment(e, webBody, result));
                    v.addAction(new ExportComment(e));
                }
            }
        }
        return v;
    }

    public void showWindow() {
        List<ValidationSuite> vss = new ArrayList<ValidationSuite>();
        vss.add(suite);
        Utils.guilog("[INFO] Showing validations...");
        Utils.displayValidationWindow(vss, "Model Web Difference Validation");
    }

    public ValidationSuite getSuite() {
        return suite;
    }

    private boolean areNullElementValues(List<ValueSpecification> vs) {
        for (ValueSpecification v : vs) {
            if (!(v instanceof ElementValue || v instanceof InstanceValue) ||
                    (v instanceof ElementValue && ((ElementValue) v).getElement() != null) ||
                    (v instanceof InstanceValue && ((InstanceValue) v).getInstance() != null)) {
                return false;
            }
        }
        return true;
    }

    public static JSONObject getAlfrescoElement(Element e) {
        String id = ExportUtility.getElementID(e);
        if (id == null) {
            return null;
        }
        return getAlfrescoElementByID(id);
    }

    public static JSONObject getAlfrescoElementByID(String id) {
        String url = ExportUtility.getUrlWithWorkspace();
        if (url == null) {
            return null;
        }
        id = id.replace(".", "%2E");
        url += "/elements/" + id;
        String response = null;
        try {
            response = ExportUtility.get(url, false);
        } catch (ServerException ex) {

        }
        if (response == null) {
            return null;
        }
        JSONObject result = (JSONObject) JSONValue.parse(response);
        JSONArray elements = (JSONArray) result.get("elements");
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        return (JSONObject) elements.get(0);
    }
}