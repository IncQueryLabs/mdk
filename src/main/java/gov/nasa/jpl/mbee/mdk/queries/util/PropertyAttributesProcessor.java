/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import gov.nasa.jpl.mbee.mdk.queries.PropertyAttributesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.propertyAttributes pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyAttributesProcessor implements IMatchProcessor<PropertyAttributesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pProperty the value of pattern parameter property in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * 
   */
  public abstract void process(final Property pProperty, final String pName, final Type pType);
  
  @Override
  public void process(final PropertyAttributesMatch match) {
    process(match.getProperty(), match.getName(), match.getType());
  }
}
