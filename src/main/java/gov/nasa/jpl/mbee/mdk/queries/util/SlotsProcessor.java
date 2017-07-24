/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.StructuralFeature;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification;
import gov.nasa.jpl.mbee.mdk.queries.SlotsMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.slots pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SlotsProcessor implements IMatchProcessor<SlotsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSlot the value of pattern parameter slot in the currently processed match
   * @param pOwningInstance the value of pattern parameter owningInstance in the currently processed match
   * @param pFeature the value of pattern parameter feature in the currently processed match
   * @param pValue the value of pattern parameter value in the currently processed match
   * 
   */
  public abstract void process(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue);
  
  @Override
  public void process(final SlotsMatch match) {
    process(match.getSlot(), match.getOwningInstance(), match.getFeature(), match.getValue());
  }
}
