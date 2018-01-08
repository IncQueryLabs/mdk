/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate TransformedStereotypedBlocksMatcher in a type-safe way.
 * 
 * @see TransformedStereotypedBlocksMatcher
 * @see TransformedStereotypedBlocksMatch
 * 
 */
@SuppressWarnings("all")
public final class TransformedStereotypedBlocksQuerySpecification extends BaseGeneratedEMFQuerySpecification<TransformedStereotypedBlocksMatcher> {
  private TransformedStereotypedBlocksQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TransformedStereotypedBlocksQuerySpecification instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TransformedStereotypedBlocksMatcher instantiate(final ViatraQueryEngine engine) {
    return TransformedStereotypedBlocksMatcher.on(engine);
  }
  
  @Override
  public TransformedStereotypedBlocksMatcher instantiate() {
    return TransformedStereotypedBlocksMatcher.create();
  }
  
  @Override
  public TransformedStereotypedBlocksMatch newEmptyMatch() {
    return TransformedStereotypedBlocksMatch.newEmptyMatch();
  }
  
  @Override
  public TransformedStereotypedBlocksMatch newMatch(final Object... parameters) {
    return TransformedStereotypedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification (visibility: PUBLIC, simpleName: TransformedStereotypedBlocksQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification (visibility: PUBLIC, simpleName: TransformedStereotypedBlocksQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static TransformedStereotypedBlocksQuerySpecification INSTANCE = new TransformedStereotypedBlocksQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static TransformedStereotypedBlocksQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pBlock = new PParameter("block", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSlot = new PParameter("slot", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pBlock, parameter_pStereotype, parameter_pSlot);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocks";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block","stereotype","slot");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      {
          PBody body = new PBody(this);
          PVariable var_block = body.getOrCreateVariableByName("block");
          PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
          PVariable var_slot = body.getOrCreateVariableByName("slot");
          PVariable var_property = body.getOrCreateVariableByName("property");
          PVariable var_createdProperty = body.getOrCreateVariableByName("createdProperty");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_block, parameter_pBlock),
             new ExportedParameter(body, var_stereotype, parameter_pStereotype),
             new ExportedParameter(body, var_slot, parameter_pSlot)
          ));
          // //variable 'block' is a block	find block(block)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_block), BlockQuerySpecification.instance().getInternalQueryRepresentation());
          // 	//properties of applied stereotype	Class.appliedStereotypeInstance.slot(block, slot)
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "InstanceSpecification")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "InstanceSpecification", "slot")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
          new Equality(body, var__virtual_1_, var_slot);
          // 	Slot.definingFeature(slot, property)
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot", "definingFeature")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuralFeature")));
          new Equality(body, var__virtual_2_, var_property);
          //  // Property of  Stereotype	Stereotype.ownedAttribute(stereotype, property)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new Equality(body, var__virtual_3_, var_property);
          // 	//Query the block's attributes	Class.ownedAttribute(block, createdProperty)
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new Equality(body, var__virtual_4_, var_createdProperty);
          // 	//Check if properties are considered equal	Property.name(createdProperty, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_createdProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_createdProperty, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_5_, var_name);
          // 	Property.name(property, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_6_, var_name);
          // 	Property.type(createdProperty, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_createdProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_createdProperty, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "TypedElement", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_7_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Type")));
          new Equality(body, var__virtual_7_, var_type);
          // 	Property.type(property, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property, var__virtual_8_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "TypedElement", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_8_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Type")));
          new Equality(body, var__virtual_8_, var_type);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
