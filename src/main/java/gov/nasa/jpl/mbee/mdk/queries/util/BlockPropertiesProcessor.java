/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.blockProperties pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class BlockPropertiesProcessor implements IMatchProcessor<BlockPropertiesMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBlock the value of pattern parameter block in the currently processed match
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * @param pProperty the value of pattern parameter property in the currently processed match
   * @param pLiteral the value of pattern parameter literal in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Property pProperty, final LiteralSpecification pLiteral);
  
  @Override
  public void process(final BlockPropertiesMatch match) {
    process(match.getBlock(), match.getStereotype(), match.getProperty(), match.getLiteral());
  }
}
