/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FindCommonParentClassProcessor implements IMatchProcessor<FindCommonParentClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock1 the value of pattern parameter block1 in the currently processed match
   * @param pBlock2 the value of pattern parameter block2 in the currently processed match
   * @param pAttribute1 the value of pattern parameter attribute1 in the currently processed match
   * @param pAttribute2 the value of pattern parameter attribute2 in the currently processed match
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype);
  
  @Override
  public void process(final FindCommonParentClassMatch match) {
    process(match.getBlock1(), match.getBlock2(), match.getAttribute1(), match.getAttribute2(), match.getStereotype());
  }
}
