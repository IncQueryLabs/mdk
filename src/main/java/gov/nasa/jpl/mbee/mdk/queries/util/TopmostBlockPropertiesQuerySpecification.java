/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.TopmostBlockPropertiesMatch;
import gov.nasa.jpl.mbee.mdk.queries.TopmostBlockPropertiesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockPropertiesQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate TopmostBlockPropertiesMatcher in a type-safe way.
 * 
 * @see TopmostBlockPropertiesMatcher
 * @see TopmostBlockPropertiesMatch
 * 
 */
@SuppressWarnings("all")
public final class TopmostBlockPropertiesQuerySpecification extends BaseGeneratedEMFQuerySpecification<TopmostBlockPropertiesMatcher> {
  private TopmostBlockPropertiesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static TopmostBlockPropertiesQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected TopmostBlockPropertiesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TopmostBlockPropertiesMatcher.on(engine);
  }
  
  @Override
  public TopmostBlockPropertiesMatcher instantiate() throws ViatraQueryException {
    return TopmostBlockPropertiesMatcher.create();
  }
  
  @Override
  public TopmostBlockPropertiesMatch newEmptyMatch() {
    return TopmostBlockPropertiesMatch.newEmptyMatch();
  }
  
  @Override
  public TopmostBlockPropertiesMatch newMatch(final Object... parameters) {
    return TopmostBlockPropertiesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link TopmostBlockPropertiesQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TopmostBlockPropertiesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static TopmostBlockPropertiesQuerySpecification INSTANCE = new TopmostBlockPropertiesQuerySpecification();
    
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
    private final static TopmostBlockPropertiesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pBlock = new PParameter("block", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pProperty = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pBlock, parameter_pStereotype, parameter_pProperty);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.topmostBlockProperties";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block","stereotype","property");
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
              PVariable var_block = body.getOrCreateVariableByName("block");
              PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
              PVariable var_property = body.getOrCreateVariableByName("property");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var_general = body.getOrCreateVariableByName("general");
              PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
              new TypeConstraint(body, new FlatTuple(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, new FlatTuple(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
              new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_block, parameter_pBlock),
                 new ExportedParameter(body, var_stereotype, parameter_pStereotype),
                 new ExportedParameter(body, var_property, parameter_pProperty)
              ));
              // 	find blockProperties(block, stereotype, property, _)
              new PositivePatternCall(body, new FlatTuple(var_block, var_stereotype, var_property, var___0_), BlockPropertiesQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find generalizations(general, block)
              new PositivePatternCall(body, new FlatTuple(var_general, var_block), GeneralizationsQuerySpecification.instance().getInternalQueryRepresentation());
              // 	neg find blockProperties(general, stereotype, property, _)
              new NegativePatternCall(body, new FlatTuple(var_general, var_stereotype, var_property, var___1_), BlockPropertiesQuerySpecification.instance().getInternalQueryRepresentation());
              bodies.add(body);
          }
          {
              PBody body = new PBody(this);
              PVariable var_block = body.getOrCreateVariableByName("block");
              PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
              PVariable var_property = body.getOrCreateVariableByName("property");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var__general = body.getOrCreateVariableByName("_general");
              new TypeConstraint(body, new FlatTuple(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, new FlatTuple(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
              new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_block, parameter_pBlock),
                 new ExportedParameter(body, var_stereotype, parameter_pStereotype),
                 new ExportedParameter(body, var_property, parameter_pProperty)
              ));
              // 	find blockProperties(block, stereotype, property, _)
              new PositivePatternCall(body, new FlatTuple(var_block, var_stereotype, var_property, var___0_), BlockPropertiesQuerySpecification.instance().getInternalQueryRepresentation());
              // 	neg find generalizations(_general, block)
              new NegativePatternCall(body, new FlatTuple(var__general, var_block), GeneralizationsQuerySpecification.instance().getInternalQueryRepresentation());
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
