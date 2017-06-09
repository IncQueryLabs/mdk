/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import gov.nasa.jpl.mbee.mdk.queries.CircularDependencyErrorMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.CircularDependencyError pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CircularDependencyErrorProcessor implements IMatchProcessor<CircularDependencyErrorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pDep the value of pattern parameter dep in the currently processed match
   * 
   */
  public abstract void process(final Dependency pDep);
  
  @Override
  public void process(final CircularDependencyErrorMatch match) {
    process(match.getDep());
  }
}
