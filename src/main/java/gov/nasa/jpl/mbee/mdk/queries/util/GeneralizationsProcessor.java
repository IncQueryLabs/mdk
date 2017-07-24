/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import gov.nasa.jpl.mbee.mdk.queries.GeneralizationsMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.generalizations pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationsProcessor implements IMatchProcessor<GeneralizationsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pGeneral the value of pattern parameter general in the currently processed match
   * @param pSpecific the value of pattern parameter specific in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific);
  
  @Override
  public void process(final GeneralizationsMatch match) {
    process(match.getGeneral(), match.getSpecific());
  }
}
