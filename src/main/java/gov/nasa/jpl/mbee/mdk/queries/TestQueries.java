/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.CircularDependencyErrorMatcher;
import gov.nasa.jpl.mbee.mdk.queries.DependencyChainMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.CircularDependencyErrorQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.DependencyChainQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all public patterns defined in TestQueries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file TestQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>CircularDependencyError</li>
 * <li>DependencyChain</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class TestQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TestQueries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new TestQueries();
    }
    return INSTANCE;
  }
  
  private static TestQueries INSTANCE;
  
  private TestQueries() throws ViatraQueryException {
    querySpecifications.add(CircularDependencyErrorQuerySpecification.instance());
    querySpecifications.add(DependencyChainQuerySpecification.instance());
  }
  
  public CircularDependencyErrorQuerySpecification getCircularDependencyError() throws ViatraQueryException {
    return CircularDependencyErrorQuerySpecification.instance();
  }
  
  public CircularDependencyErrorMatcher getCircularDependencyError(final ViatraQueryEngine engine) throws ViatraQueryException {
    return CircularDependencyErrorMatcher.on(engine);
  }
  
  public DependencyChainQuerySpecification getDependencyChain() throws ViatraQueryException {
    return DependencyChainQuerySpecification.instance();
  }
  
  public DependencyChainMatcher getDependencyChain(final ViatraQueryEngine engine) throws ViatraQueryException {
    return DependencyChainMatcher.on(engine);
  }
}
