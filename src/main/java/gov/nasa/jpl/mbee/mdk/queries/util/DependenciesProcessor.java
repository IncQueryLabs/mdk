/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import gov.nasa.jpl.mbee.mdk.queries.DependenciesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.dependencies pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DependenciesProcessor implements IMatchProcessor<DependenciesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pDependency the value of pattern parameter dependency in the currently processed match
   * @param pSource the value of pattern parameter source in the currently processed match
   * @param pTarget the value of pattern parameter target in the currently processed match
   * 
   */
  public abstract void process(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget);
  
  @Override
  public void process(final DependenciesMatch match) {
    process(match.getDependency(), match.getSource(), match.getTarget());
  }
}
