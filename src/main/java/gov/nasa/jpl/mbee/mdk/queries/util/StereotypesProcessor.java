/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.StereotypesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.stereotypes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StereotypesProcessor implements IMatchProcessor<StereotypesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * 
   */
  public abstract void process(final Stereotype pStereotype, final Property pAttribute);
  
  @Override
  public void process(final StereotypesMatch match) {
    process(match.getStereotype(), match.getAttribute());
  }
}
