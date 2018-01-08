/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocks pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransformedStereotypedBlocksProcessor implements IMatchProcessor<TransformedStereotypedBlocksMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter block in the currently processed match
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * @param pSlot the value of pattern parameter slot in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot);
  
  @Override
  public void process(final TransformedStereotypedBlocksMatch match) {
    process(match.getBlock(), match.getStereotype(), match.getSlot());
  }
}
