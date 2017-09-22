/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import gov.nasa.jpl.mbee.mdk.queries.BlockMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.block pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlockProcessor implements IMatchProcessor<BlockMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pClass the value of pattern parameter class in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass);
  
  @Override
  public void process(final BlockMatch match) {
    process(match.getValueOfClass());
  }
}
