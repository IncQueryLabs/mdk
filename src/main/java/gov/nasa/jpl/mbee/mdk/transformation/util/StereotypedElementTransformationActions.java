package gov.nasa.jpl.mbee.mdk.transformation.util;

import com.nomagic.magicdraw.copypaste.CopyPasting;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.uml2.ext.jmi.helpers.StereotypesHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Generalization;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import com.nomagic.uml2.impl.ElementsFactory;

import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatch;

public class StereotypedElementTransformationActions {
	
	public static void createBlockAttributes(Property property, Class block, LiteralSpecification value) {
		
		// The stereotype property to be transformed to attribute
		Property stereotypeAttribute = property;
		
		// Copying the property and putting it into the attribute list of the block
		// CloneNotSupportedException is thrown if BasedElement.clone() is used
		Property newAttribute = (Property) CopyPasting.copyPasteElement(stereotypeAttribute, block);
		block.getOwnedAttribute().add(newAttribute);
		
		// Setting the default value
		LiteralSpecification defaultValue = (LiteralSpecification) CopyPasting.copyPasteElement(value, newAttribute);
		newAttribute.setDefaultValue(defaultValue); // Without this line, the value would set the multiplicity of the attribute
	}
	
	
	public static void createAttributeredefinition(Property childAttribute, Property parentAttribute) {
		childAttribute.getRedefinedProperty().add(parentAttribute);
	}
	
	public static void createRemoveStereotypeInstance(Slot slot, Stereotype stereotype) {
		// Removing the tag value from the block
		InstanceSpecification instanceSpecification = slot.getOwningInstance();
		instanceSpecification.getSlot().remove(slot);
		// Removing the stereotype from the block
		instanceSpecification.getClassifier().remove(stereotype);	
	}
	
	public static void createImpliedParentBlock(FindCommonParentClassMatch match) throws ReadOnlyElementException {
		ElementsFactory f = Application.getInstance().getProject().getElementsFactory();
		ModelElementsManager mem = ModelElementsManager.getInstance();
		
		Package package1 = match.getBlock1().getOwningPackage();
		com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class parentBlock = f.createClassInstance();
		
		mem.addElement(parentBlock, package1);
		parentBlock.setName("Parent_"+match.getStereotype().getName()+"_"+match.getBlock1().getName()+match.getBlock2().getName());
		
		StereotypesHelper.addStereotypeByString(parentBlock, "Block");
		
		Property newAttribute = (Property) CopyPasting.copyPasteElement(match.getAttribute1(), parentBlock);
		
		
		Generalization generalization1 = f.createGeneralizationInstance();
		mem.addElement(generalization1, match.getBlock1());
		
		generalization1.setGeneral(parentBlock);
		generalization1.setSpecific(match.getBlock1());
		
		Generalization generalization2 = f.createGeneralizationInstance();
		mem.addElement(generalization2, match.getBlock2());
		
		generalization2.setGeneral(parentBlock);
		generalization2.setSpecific(match.getBlock2());
		
		
		
		match.getAttribute1().getRedefinedProperty().add(newAttribute);
		match.getAttribute2().getRedefinedProperty().add(newAttribute);
			
	}
	
}
