/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatch;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatcher;
import gov.nasa.jpl.mbee.mdk.queries.internal.RedefiningPropertyQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;

/**
 * A pattern-specific query specification that can instantiate FindCommonParentClassMatcher in a type-safe way.
 * 
 * @see FindCommonParentClassMatcher
 * @see FindCommonParentClassMatch
 * 
 */
@SuppressWarnings("all")
public final class FindCommonParentClassQuerySpecification extends BaseGeneratedEMFQuerySpecification<FindCommonParentClassMatcher> {
  private FindCommonParentClassQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static FindCommonParentClassQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected FindCommonParentClassMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return FindCommonParentClassMatcher.on(engine);
  }
  
  @Override
  public FindCommonParentClassMatcher instantiate() throws ViatraQueryException {
    return FindCommonParentClassMatcher.create();
  }
  
  @Override
  public FindCommonParentClassMatch newEmptyMatch() {
    return FindCommonParentClassMatch.newEmptyMatch();
  }
  
  @Override
  public FindCommonParentClassMatch newMatch(final Object... parameters) {
    return FindCommonParentClassMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[2], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[3], (com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype) parameters[4]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification (visibility: PUBLIC, simpleName: FindCommonParentClassQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification (visibility: PUBLIC, simpleName: FindCommonParentClassQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static FindCommonParentClassQuerySpecification INSTANCE = new FindCommonParentClassQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static FindCommonParentClassQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pBlock1 = new PParameter("block1", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pBlock2 = new PParameter("block2", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pAttribute1 = new PParameter("attribute1", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pAttribute2 = new PParameter("attribute2", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pBlock1, parameter_pBlock2, parameter_pAttribute1, parameter_pAttribute2, parameter_pStereotype);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClass";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block1","block2","attribute1","attribute2","stereotype");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
          {
              PBody body = new PBody(this);
              PVariable var_block1 = body.getOrCreateVariableByName("block1");
              PVariable var_block2 = body.getOrCreateVariableByName("block2");
              PVariable var_attribute1 = body.getOrCreateVariableByName("attribute1");
              PVariable var_attribute2 = body.getOrCreateVariableByName("attribute2");
              PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
              PVariable var_property = body.getOrCreateVariableByName("property");
              PVariable var_name = body.getOrCreateVariableByName("name");
              PVariable var_type = body.getOrCreateVariableByName("type");
              new TypeConstraint(body, Tuples.flatTupleOf(var_block1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_block2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_attribute1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_attribute2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_block1, parameter_pBlock1),
                 new ExportedParameter(body, var_block2, parameter_pBlock2),
                 new ExportedParameter(body, var_attribute1, parameter_pAttribute1),
                 new ExportedParameter(body, var_attribute2, parameter_pAttribute2),
                 new ExportedParameter(body, var_stereotype, parameter_pStereotype)
              ));
              // 	find block(block1)
              new PositivePatternCall(body, new FlatTuple(var_block1), BlockQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find block(block2)
              new PositivePatternCall(body, new FlatTuple(var_block2), BlockQuerySpecification.instance().getInternalQueryRepresentation());
              // 	block1 != block2
              new Inequality(body, var_block1, var_block2);
              // 	//Query attributes of blocks 1 and 2 as well as the stereotypes of the profile	Class.ownedAttribute(block1, attribute1)
              new TypeConstraint(body, Tuples.flatTupleOf(var_block1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_block1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              new Equality(body, var__virtual_0_, var_attribute1);
              // 	Class.ownedAttribute(block2, attribute2)
              new TypeConstraint(body, Tuples.flatTupleOf(var_block2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_block2, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              new Equality(body, var__virtual_1_, var_attribute2);
              // 	//Attributes of the block do not redefine a property	neg find redefiningProperty(attribute1)
              new NegativePatternCall(body, new FlatTuple(var_attribute1), RedefiningPropertyQuerySpecification.instance().getInternalQueryRepresentation());
              // 	neg find redefiningProperty(attribute2)
              new NegativePatternCall(body, new FlatTuple(var_attribute2), RedefiningPropertyQuerySpecification.instance().getInternalQueryRepresentation());
              // 	Stereotype.ownedAttribute(stereotype, property)
              new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
              new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              new Equality(body, var__virtual_2_, var_property);
              // 	//Check if they are all equal	find propertyAttributes(attribute1, name, type)
              new PositivePatternCall(body, new FlatTuple(var_attribute1, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find propertyAttributes(attribute2, name, type)
              new PositivePatternCall(body, new FlatTuple(var_attribute2, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find propertyAttributes(property, name, type)
              new PositivePatternCall(body, new FlatTuple(var_property, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          // to silence compiler error
          if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
