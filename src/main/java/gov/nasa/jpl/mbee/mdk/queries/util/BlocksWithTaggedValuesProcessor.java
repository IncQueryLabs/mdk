/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import gov.nasa.jpl.mbee.mdk.queries.BlocksWithTaggedValuesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.blocksWithTaggedValues pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlocksWithTaggedValuesProcessor implements IMatchProcessor<BlocksWithTaggedValuesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter block in the currently processed match
   * @param pLower the value of pattern parameter lower in the currently processed match
   * @param pHigher the value of pattern parameter higher in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher);
  
  @Override
  public void process(final BlocksWithTaggedValuesMatch match) {
    process(match.getBlock(), match.getLower(), match.getHigher());
  }
}
