/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.PropertyAttributesMatch;
import gov.nasa.jpl.mbee.mdk.queries.PropertyAttributesMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate PropertyAttributesMatcher in a type-safe way.
 * 
 * @see PropertyAttributesMatcher
 * @see PropertyAttributesMatch
 * 
 */
@SuppressWarnings("all")
public final class PropertyAttributesQuerySpecification extends BaseGeneratedEMFQuerySpecification<PropertyAttributesMatcher> {
  private PropertyAttributesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PropertyAttributesQuerySpecification instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertyAttributesMatcher instantiate(final ViatraQueryEngine engine) {
    return PropertyAttributesMatcher.on(engine);
  }
  
  @Override
  public PropertyAttributesMatcher instantiate() {
    return PropertyAttributesMatcher.create();
  }
  
  @Override
  public PropertyAttributesMatch newEmptyMatch() {
    return PropertyAttributesMatch.newEmptyMatch();
  }
  
  @Override
  public PropertyAttributesMatch newMatch(final Object... parameters) {
    return PropertyAttributesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[0], (java.lang.String) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification (visibility: PUBLIC, simpleName: PropertyAttributesQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification (visibility: PUBLIC, simpleName: PropertyAttributesQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static PropertyAttributesQuerySpecification INSTANCE = new PropertyAttributesQuerySpecification();
    
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
    private final static PropertyAttributesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pProperty = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pName = new PParameter("name", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_pType = new PParameter("type", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Type")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pProperty, parameter_pName, parameter_pType);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.propertyAttributes";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("property","name","type");
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
          PVariable var_property = body.getOrCreateVariableByName("property");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_property, parameter_pProperty),
             new ExportedParameter(body, var_name, parameter_pName),
             new ExportedParameter(body, var_type, parameter_pType)
          ));
          // 	Property.name(property, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_0_, var_name);
          // 	Property.type(property, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "TypedElement", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Type")));
          new Equality(body, var__virtual_1_, var_type);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
