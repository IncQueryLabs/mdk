/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.TaggedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
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
 * A pattern-specific query specification that can instantiate TaggedBlocksMatcher in a type-safe way.
 * 
 * @see TaggedBlocksMatcher
 * @see TaggedBlocksMatch
 * 
 */
@SuppressWarnings("all")
public final class TaggedBlocksQuerySpecification extends BaseGeneratedEMFQuerySpecification<TaggedBlocksMatcher> {
  private TaggedBlocksQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TaggedBlocksQuerySpecification instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TaggedBlocksMatcher instantiate(final ViatraQueryEngine engine) {
    return TaggedBlocksMatcher.on(engine);
  }
  
  @Override
  public TaggedBlocksMatcher instantiate() {
    return TaggedBlocksMatcher.create();
  }
  
  @Override
  public TaggedBlocksMatch newEmptyMatch() {
    return TaggedBlocksMatch.newEmptyMatch();
  }
  
  @Override
  public TaggedBlocksMatch newMatch(final Object... parameters) {
    return TaggedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot) parameters[2], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[3], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification) parameters[4]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification (visibility: PUBLIC, simpleName: TaggedBlocksQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification (visibility: PUBLIC, simpleName: TaggedBlocksQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static TaggedBlocksQuerySpecification INSTANCE = new TaggedBlocksQuerySpecification();
    
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
    private final static TaggedBlocksQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pBlock = new PParameter("block", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSlot = new PParameter("slot", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pProperty = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pValue = new PParameter("value", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "LiteralSpecification")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pBlock, parameter_pStereotype, parameter_pSlot, parameter_pProperty, parameter_pValue);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.taggedBlocks";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block","stereotype","slot","property","value");
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
          PVariable var_value = body.getOrCreateVariableByName("value");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_value), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "LiteralSpecification")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_block, parameter_pBlock),
             new ExportedParameter(body, var_stereotype, parameter_pStereotype),
             new ExportedParameter(body, var_slot, parameter_pSlot),
             new ExportedParameter(body, var_property, parameter_pProperty),
             new ExportedParameter(body, var_value, parameter_pValue)
          ));
          // 	find block(block)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_block), BlockQuerySpecification.instance().getInternalQueryRepresentation());
          // 	Class.appliedStereotypeInstance.slot(block, slot)
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
          //  // Property of  Stereotype	Slot.value(slot, value)
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_slot, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "ValueSpecification")));
          new Equality(body, var__virtual_3_, var_value);
          //  // Slot value	Stereotype.ownedAttribute(stereotype, property)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new Equality(body, var__virtual_4_, var_property);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
