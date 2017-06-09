/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.CircularDependencyErrorMatch;
import gov.nasa.jpl.mbee.mdk.queries.CircularDependencyErrorMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.DependencyChainQuerySpecification;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate CircularDependencyErrorMatcher in a type-safe way.
 * 
 * @see CircularDependencyErrorMatcher
 * @see CircularDependencyErrorMatch
 * 
 */
@SuppressWarnings("all")
public final class CircularDependencyErrorQuerySpecification extends BaseGeneratedEMFQuerySpecification<CircularDependencyErrorMatcher> {
  private CircularDependencyErrorQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static CircularDependencyErrorQuerySpecification instance() throws ViatraQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected CircularDependencyErrorMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CircularDependencyErrorMatcher.on(engine);
  }
  
  @Override
  public CircularDependencyErrorMatcher instantiate() throws ViatraQueryException {
    return CircularDependencyErrorMatcher.create();
  }
  
  @Override
  public CircularDependencyErrorMatch newEmptyMatch() {
    return CircularDependencyErrorMatch.newEmptyMatch();
  }
  
  @Override
  public CircularDependencyErrorMatch newMatch(final Object... parameters) {
    return CircularDependencyErrorMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link CircularDependencyErrorQuerySpecification} to be created 
   * 	<b>not</b> at the class load time of the outer class, 
   * 	but rather at the first call to {@link CircularDependencyErrorQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static CircularDependencyErrorQuerySpecification INSTANCE = new CircularDependencyErrorQuerySpecification();
    
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
    private final static CircularDependencyErrorQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pDep = new PParameter("dep", "com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pDep);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.CircularDependencyError";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("dep");
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
      		PVariable var_dep = body.getOrCreateVariableByName("dep");
      		new TypeConstraint(body, new FlatTuple(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Dependency")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_dep, parameter_pDep)
      		));
      		//     //Call transitive closure of sub-pattern 'DependencyChain'    find DependencyChain+(dep, dep)
      		new BinaryTransitiveClosure(body, new FlatTuple(var_dep, var_dep), DependencyChainQuerySpecification.instance().getInternalQueryRepresentation());
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
