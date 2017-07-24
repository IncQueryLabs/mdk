/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.DependenciesMatch;
import gov.nasa.jpl.mbee.mdk.queries.DependenciesMatcher;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate DependenciesMatcher in a type-safe way.
 * 
 * @see DependenciesMatcher
 * @see DependenciesMatch
 * 
 */
@SuppressWarnings("all")
public final class DependenciesQuerySpecification extends BaseGeneratedEMFQuerySpecification<DependenciesMatcher> {
  private DependenciesQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static DependenciesQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected DependenciesMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return DependenciesMatcher.on(engine);
  }
  
  @Override
  public DependenciesMatcher instantiate() throws ViatraQueryException {
    return DependenciesMatcher.create();
  }
  
  @Override
  public DependenciesMatch newEmptyMatch() {
    return DependenciesMatch.newEmptyMatch();
  }
  
  @Override
  public DependenciesMatch newMatch(final Object... parameters) {
    return DependenciesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link DependenciesQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DependenciesQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static DependenciesQuerySpecification INSTANCE = new DependenciesQuerySpecification();
    
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
    private final static DependenciesQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pDependency = new PParameter("dependency", "com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSource = new PParameter("source", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pTarget = new PParameter("target", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pDependency, parameter_pSource, parameter_pTarget);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.dependencies";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("dependency","source","target");
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
              PVariable var_dependency = body.getOrCreateVariableByName("dependency");
              PVariable var_source = body.getOrCreateVariableByName("source");
              PVariable var_target = body.getOrCreateVariableByName("target");
              new TypeConstraint(body, new FlatTuple(var_dependency), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")));
              new TypeConstraint(body, new FlatTuple(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")));
              new TypeConstraint(body, new FlatTuple(var_target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")));
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_dependency, parameter_pDependency),
                 new ExportedParameter(body, var_source, parameter_pSource),
                 new ExportedParameter(body, var_target, parameter_pTarget)
              ));
              // 	Dependency.supplier(dependency, target)
              new TypeConstraint(body, new FlatTuple(var_dependency), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, new FlatTuple(var_dependency, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency", "supplier")));
              new TypeConstraint(body, new FlatTuple(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")));
              new Equality(body, var__virtual_0_, var_target);
              // 	Dependency.client(dependency, source)
              new TypeConstraint(body, new FlatTuple(var_dependency), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, new FlatTuple(var_dependency, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency", "client")));
              new TypeConstraint(body, new FlatTuple(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement")));
              new Equality(body, var__virtual_1_, var_source);
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
