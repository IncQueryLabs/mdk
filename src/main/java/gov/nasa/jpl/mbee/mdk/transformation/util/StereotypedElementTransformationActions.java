package gov.nasa.jpl.mbee.mdk.transformation.util;

import com.nomagic.magicdraw.copypaste.CopyPasting;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;

import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatch;

public class StereotypedElementTransformationActions {
	
	public static void createBlockAttributes(TaggedBlocksMatch match) {
		
		// The stereotype property to be transformed to attribute
		Property stereotypeAttribute = match.getProperty();
		
		// Copying the property and putting it into the attribute list of the block
		// CloneNotSupportedException is thrown if BasedElement.clone() is used
		Property newAttribute = (Property) CopyPasting.copyPasteElement(stereotypeAttribute, match.getBlock());
		match.getBlock().getOwnedAttribute().add(newAttribute);
		
		// Setting the default value
		LiteralSpecification defaultValue = (LiteralSpecification) CopyPasting.copyPasteElement(match.getValue(), newAttribute);
		newAttribute.setDefaultValue(defaultValue); // Without this line, the value would set the multiplicity of the attribute
	}
	
	
	public static void createAttributeredefinition(GeneralizedTaggedBlockPairsMatch match) {
		match.getChildAttribute().getRedefinedProperty().add(match.getParentAttribute());
	}
	
	public static void createRemoveStereotypeInstance(TaggedBlocksMatch match) {
		// Removing the tag value from the block
		InstanceSpecification instanceSpecification = match.getSlot().getOwningInstance();
		instanceSpecification.getSlot().remove(match.getSlot());
		// Removing the stereotype from the block
		instanceSpecification.getClassifier().remove(match.getStereotype());	
	}
	
}
