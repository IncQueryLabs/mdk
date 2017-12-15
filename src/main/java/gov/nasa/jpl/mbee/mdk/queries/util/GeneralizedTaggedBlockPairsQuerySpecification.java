/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.internal.GeneralizedTaggedBlocksQuerySpecification;
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
 * A pattern-specific query specification that can instantiate GeneralizedTaggedBlockPairsMatcher in a type-safe way.
 * 
 * @see GeneralizedTaggedBlockPairsMatcher
 * @see GeneralizedTaggedBlockPairsMatch
 * 
 */
@SuppressWarnings("all")
public final class GeneralizedTaggedBlockPairsQuerySpecification extends BaseGeneratedEMFQuerySpecification<GeneralizedTaggedBlockPairsMatcher> {
  private GeneralizedTaggedBlockPairsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static GeneralizedTaggedBlockPairsQuerySpecification instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected GeneralizedTaggedBlockPairsMatcher instantiate(final ViatraQueryEngine engine) {
    return GeneralizedTaggedBlockPairsMatcher.on(engine);
  }
  
  @Override
  public GeneralizedTaggedBlockPairsMatcher instantiate() {
    return GeneralizedTaggedBlockPairsMatcher.create();
  }
  
  @Override
  public GeneralizedTaggedBlockPairsMatch newEmptyMatch() {
    return GeneralizedTaggedBlockPairsMatch.newEmptyMatch();
  }
  
  @Override
  public GeneralizedTaggedBlockPairsMatch newMatch(final Object... parameters) {
    return GeneralizedTaggedBlockPairsMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[1], (com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype) parameters[2], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[3], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[4]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification (visibility: PUBLIC, simpleName: GeneralizedTaggedBlockPairsQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification (visibility: PUBLIC, simpleName: GeneralizedTaggedBlockPairsQuerySpecification, identifier: gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: gov.nasa.jpl.mbee.mdk.queries.util) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static GeneralizedTaggedBlockPairsQuerySpecification INSTANCE = new GeneralizedTaggedBlockPairsQuerySpecification();
    
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
    private final static GeneralizedTaggedBlockPairsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pParentBlock = new PParameter("parentBlock", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pChildBlock = new PParameter("childBlock", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pParentAttribute = new PParameter("parentAttribute", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pChildAttribute = new PParameter("childAttribute", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pParentBlock, parameter_pChildBlock, parameter_pStereotype, parameter_pParentAttribute, parameter_pChildAttribute);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlockPairs";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("parentBlock","childBlock","stereotype","parentAttribute","childAttribute");
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
          PVariable var_parentBlock = body.getOrCreateVariableByName("parentBlock");
          PVariable var_childBlock = body.getOrCreateVariableByName("childBlock");
          PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
          PVariable var_parentAttribute = body.getOrCreateVariableByName("parentAttribute");
          PVariable var_childAttribute = body.getOrCreateVariableByName("childAttribute");
          PVariable var_property = body.getOrCreateVariableByName("property");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_childBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentAttribute), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_childAttribute), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_parentBlock, parameter_pParentBlock),
             new ExportedParameter(body, var_childBlock, parameter_pChildBlock),
             new ExportedParameter(body, var_stereotype, parameter_pStereotype),
             new ExportedParameter(body, var_parentAttribute, parameter_pParentAttribute),
             new ExportedParameter(body, var_childAttribute, parameter_pChildAttribute)
          ));
          // 	find generalizedTaggedBlocks(parentBlock, childBlock, stereotype, property)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_parentBlock, var_childBlock, var_stereotype, var_property), GeneralizedTaggedBlocksQuerySpecification.instance().getInternalQueryRepresentation());
          // 	Class.ownedAttribute(parentBlock, parentAttribute)
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentBlock, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new Equality(body, var__virtual_0_, var_parentAttribute);
          // 	Class.ownedAttribute(childBlock, childAttribute)
          new TypeConstraint(body, Tuples.flatTupleOf(var_childBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_childBlock, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
          new Equality(body, var__virtual_1_, var_childAttribute);
          // 	find propertyAttributes(property, name, type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_property, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
          // 	find propertyAttributes(parentAttribute, name, type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_parentAttribute, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
          // 	find propertyAttributes(childAttribute, name, type)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_childAttribute, var_name, var_type), PropertyAttributesQuerySpecification.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
