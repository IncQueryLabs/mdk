/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.UsedStereotypesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.usedStereotypes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UsedStereotypesProcessor implements IMatchProcessor<UsedStereotypesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * 
   */
  public abstract void process(final Stereotype pStereotype);
  
  @Override
  public void process(final UsedStereotypesMatch match) {
    process(match.getStereotype());
  }
}
