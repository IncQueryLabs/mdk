/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlockPairs pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizedTaggedBlockPairsProcessor implements IMatchProcessor<GeneralizedTaggedBlockPairsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParentBlock the value of pattern parameter parentBlock in the currently processed match
   * @param pChildBlock the value of pattern parameter childBlock in the currently processed match
   * @param pStereotype the value of pattern parameter stereotype in the currently processed match
   * @param pParentAttribute the value of pattern parameter parentAttribute in the currently processed match
   * @param pChildAttribute the value of pattern parameter childAttribute in the currently processed match
   * 
   */
  public abstract void process(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute);
  
  @Override
  public void process(final GeneralizedTaggedBlockPairsMatch match) {
    process(match.getParentBlock(), match.getChildBlock(), match.getStereotype(), match.getParentAttribute(), match.getChildAttribute());
  }
}
