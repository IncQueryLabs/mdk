/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.internal;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.internal.GeneralizationsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPrivateEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate GeneralizedTaggedBlocksMatcher in a type-safe way.
 * 
 * @see GeneralizedTaggedBlocksMatcher
 * @see GeneralizedTaggedBlocksMatch
 * 
 */
@SuppressWarnings("all")
public final class GeneralizedTaggedBlocksQuerySpecification extends BaseGeneratedPrivateEMFQuerySpecification {
  private GeneralizedTaggedBlocksQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static GeneralizedTaggedBlocksQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  /**
   * Inner class allowing the singleton instance of {@link GeneralizedTaggedBlocksQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link GeneralizedTaggedBlocksQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static GeneralizedTaggedBlocksQuerySpecification INSTANCE = new GeneralizedTaggedBlocksQuerySpecification();
    
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
    private final static GeneralizedTaggedBlocksQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pParentBlock = new PParameter("parentBlock", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pChildBlock = new PParameter("childBlock", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pStereotype = new PParameter("stereotype", "com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pProperty = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pParentBlock, parameter_pChildBlock, parameter_pStereotype, parameter_pProperty);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlocks";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("parentBlock","childBlock","stereotype","property");
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
              PVariable var_parentBlock = body.getOrCreateVariableByName("parentBlock");
              PVariable var_childBlock = body.getOrCreateVariableByName("childBlock");
              PVariable var_stereotype = body.getOrCreateVariableByName("stereotype");
              PVariable var_property = body.getOrCreateVariableByName("property");
              PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
              PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
              PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
              PVariable var___3_ = body.getOrCreateVariableByName("_<3>");
              new TypeConstraint(body, new FlatTuple(var_parentBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, new FlatTuple(var_childBlock), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Class")));
              new TypeConstraint(body, new FlatTuple(var_stereotype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Stereotype")));
              new TypeConstraint(body, new FlatTuple(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Property")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_parentBlock, parameter_pParentBlock),
                 new ExportedParameter(body, var_childBlock, parameter_pChildBlock),
                 new ExportedParameter(body, var_stereotype, parameter_pStereotype),
                 new ExportedParameter(body, var_property, parameter_pProperty)
              ));
              // 	find taggedBlocks(parentBlock, stereotype, _, property, _)
              new PositivePatternCall(body, new FlatTuple(var_parentBlock, var_stereotype, var___0_, var_property, var___1_), TaggedBlocksQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find generalizations(parentBlock, childBlock)
              new PositivePatternCall(body, new FlatTuple(var_parentBlock, var_childBlock), GeneralizationsQuerySpecification.instance().getInternalQueryRepresentation());
              // 	find taggedBlocks(childBlock, stereotype, _, property, _)
              new PositivePatternCall(body, new FlatTuple(var_childBlock, var_stereotype, var___2_, var_property, var___3_), TaggedBlocksQuerySpecification.instance().getInternalQueryRepresentation());
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
