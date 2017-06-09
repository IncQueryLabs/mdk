/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import gov.nasa.jpl.mbee.mdk.queries.DependencyChainMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.DependencyChain pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DependencyChainProcessor implements IMatchProcessor<DependencyChainMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSource the value of pattern parameter source in the currently processed match
   * @param pTarget the value of pattern parameter target in the currently processed match
   * 
   */
  public abstract void process(final Dependency pSource, final Dependency pTarget);
  
  @Override
  public void process(final DependencyChainMatch match) {
    process(match.getSource(), match.getTarget());
  }
}
