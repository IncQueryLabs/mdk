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
package gov.nasa.jpl.mbee.mdk.ems.validation.actions;

import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.annotation.AnnotationAction;
import gov.nasa.jpl.mbee.mdk.MDKPlugin;
import gov.nasa.jpl.mbee.mdk.ems.ExportUtility;
import gov.nasa.jpl.mbee.mdk.ems.sync.queue.OutputQueue;
import gov.nasa.jpl.mbee.mdk.ems.sync.queue.Request;
import gov.nasa.jpl.mbee.mdk.lib.Utils;
import gov.nasa.jpl.mbee.mdk.docgen.validation.IRuleViolationAction;
import gov.nasa.jpl.mbee.mdk.docgen.validation.RuleViolationAction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Map;

public class DeleteAlfrescoElement extends RuleViolationAction implements AnnotationAction, IRuleViolationAction {

    private static final long serialVersionUID = 1L;
    private Map<String, JSONObject> elementsKeyed;
    private String id;

    public DeleteAlfrescoElement(String id, Map<String, JSONObject> elementsKeyed) {
        super("DeleteElement", "Delete MMS element", null, null);
        this.elementsKeyed = elementsKeyed;
        this.id = id;
    }

    @Override
    public boolean canExecute(Collection<Annotation> arg0) {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(Collection<Annotation> annos) {
        String url = ExportUtility.getUrlWithWorkspace();
        //Collection<Annotation> toremove = new HashSet<Annotation>();
        JSONObject send = new JSONObject();
        JSONArray elements = new JSONArray();
        send.put("elements", elements);
        send.put("source", "magicdraw");
        send.put("mmsVersion", MDKPlugin.VERSION);
        for (Annotation anno : annos) {
            String message = anno.getText();
            String[] mes = message.split("`");
            String eid = null;
            if (mes.length > 2) {
                eid = mes[1];
            }
            if (eid != null) {
                JSONObject eo = new JSONObject();
                eo.put("sysmlId", eid);
                elements.add(eo);
                //String eurl = url + "/elements/" + eid;
                //OutputQueue.getInstance().offer(new Request(eurl, "{}", "DELETE", true));
                //String result = ExportUtility.delete(eurl);
                //if (result != null)
                //    toremove.add(anno);
            }
        }
        Utils.guilog("[INFO] Request is added to queue.");
        OutputQueue.getInstance().offer(new Request(url + "/elements", send.toJSONString(), "DELETEALL", true, annos.size(), "Element"));
        //saySuccess();
        //this.removeViolationsAndUpdateWindow(toremove);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        // perform a DELETE on https://ems-stg.jpl.nasa.gov/alfresco/service/workspaces/master/elements/elementID
        String url = ExportUtility.getUrlWithWorkspace();
        url += "/elements/" + id;
        //String result = ExportUtility.delete(url);
        Utils.guilog("[INFO] Request is added to queue.");
        OutputQueue.getInstance().offer(new Request(url, "{}", "DELETE", true));
    }
}