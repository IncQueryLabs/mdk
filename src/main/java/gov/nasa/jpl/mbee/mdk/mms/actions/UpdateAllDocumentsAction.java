package gov.nasa.jpl.mbee.mdk.mms.actions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.ProjectUtilities;
import com.nomagic.ui.ProgressStatusRunner;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.*;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.generator.PresentationElementUtils;
import gov.nasa.jpl.mbee.mdk.generator.ViewPresentationGenerator;
import gov.nasa.jpl.mbee.mdk.util.Utils;
import gov.nasa.jpl.mbee.mdk.validation.ValidationSuite;

import java.awt.event.ActionEvent;
import java.util.*;

public class UpdateAllDocumentsAction extends MMSAction {
    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_ID = "GenerateAllDocs";

    private List<ValidationSuite> vss = new ArrayList<ValidationSuite>();

    public UpdateAllDocumentsAction() {
        super(DEFAULT_ID, "Generate All Documents", null, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent ae) {
        Project project = Application.getInstance().getProject();
        Utils.recommendUpdateFromRemote(project);
        updateAction(project);
    }

    public List<ValidationSuite> updateAction(Project project) {
        /*DeltaSyncRunner msr = new DeltaSyncRunner(false, false);
        ProgressStatusRunner.runWithProgressStatus(msr, "Updating project from MMS", true, 0);
        vss.addAll(msr.getValidations());
        if (msr.isFailure()) {
            Utils.guilog("[ERROR] Update from MMS was not completed");
            return vss;
        }*/

        Set<Element> docs = getProjectDocuments(project);
        PresentationElementUtils viu = new PresentationElementUtils();
        Map<String, ObjectNode> images = new HashMap<>();
        for (Element doc : docs) {
            ViewPresentationGenerator vg = new ViewPresentationGenerator(doc, true, false, viu, images, null);
            ProgressStatusRunner.runWithProgressStatus(vg, "Generating Document " + ((NamedElement) doc).getName() + "...", true, 0);
            vss.addAll(vg.getValidations());
            if (vg.isFailure()) {
                Utils.guilog("[ERROR] Document generation was not completed");
                Utils.displayValidationWindow(project, vss, "View Generation and Images Validation");
                return vss;
            }
        }
        Utils.displayValidationWindow(project, vss, "View Generation and Images Validation");
        return vss;
    }

    private Set<Element> getProjectDocuments(Project project) {
        Stereotype documentView = Utils.getProductStereotype(project);
        List<Stereotype> products = new ArrayList<>();
        for (Element el : Utils.collectDirectedRelatedElementsByRelationshipJavaClass(documentView, Generalization.class, 2, 0)) {
            if (el instanceof Stereotype) {
                products.add((Stereotype) el);
            }
        }
        products.add(documentView);
        Set<Element> projDocs = new HashSet<>();
        for (Stereotype product : products) {
            for (InstanceSpecification is : product.get_instanceSpecificationOfClassifier()) {
                Element owner = is.getOwner();
                if (!ProjectUtilities.isElementInAttachedProject(owner) && StereotypesHelper.hasStereotypeOrDerived(owner, documentView) && owner instanceof Class) {
                    projDocs.add(owner);
                }
            }
        }
        
        /*
        List<Element> elements = Utils.collectOwnedElements(Application.getInstance().getProject().getModel(), 0);
        List<Element> docs = Utils.filterElementsByStereotype(elements, documentView, true, true);
        for (Element doc: docs) {
            if (!ProjectUtilities.isElementInAttachedProject(doc) && doc instanceof Class)
                projDocs.add(doc);
        }
        */
        if (projDocs.isEmpty()) {
            Application.getInstance().getGUILog().log("No Documents Found in this project");
        }
        return projDocs;
    }

    public List<ValidationSuite> getValidations() {
        return vss;
    }

}