/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.BlockMatcher;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizationMatcher;
import gov.nasa.jpl.mbee.mdk.queries.PropertyAttributesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.UsedStereotypesMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizationQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.UsedStereotypesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all public patterns defined in UtilityQueries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file UtilityQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>block</li>
 * <li>propertyAttributes</li>
 * <li>generalization</li>
 * <li>usedStereotypes</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class UtilityQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static UtilityQueries instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new UtilityQueries();
    }
    return INSTANCE;
  }
  
  private static UtilityQueries INSTANCE;
  
  private UtilityQueries() throws ViatraQueryException {
    querySpecifications.add(BlockQuerySpecification.instance());
    querySpecifications.add(PropertyAttributesQuerySpecification.instance());
    querySpecifications.add(GeneralizationQuerySpecification.instance());
    querySpecifications.add(UsedStereotypesQuerySpecification.instance());
  }
  
  public BlockQuerySpecification getBlock() throws ViatraQueryException {
    return BlockQuerySpecification.instance();
  }
  
  public BlockMatcher getBlock(final ViatraQueryEngine engine) throws ViatraQueryException {
    return BlockMatcher.on(engine);
  }
  
  public PropertyAttributesQuerySpecification getPropertyAttributes() throws ViatraQueryException {
    return PropertyAttributesQuerySpecification.instance();
  }
  
  public PropertyAttributesMatcher getPropertyAttributes(final ViatraQueryEngine engine) throws ViatraQueryException {
    return PropertyAttributesMatcher.on(engine);
  }
  
  public GeneralizationQuerySpecification getGeneralization() throws ViatraQueryException {
    return GeneralizationQuerySpecification.instance();
  }
  
  public GeneralizationMatcher getGeneralization(final ViatraQueryEngine engine) throws ViatraQueryException {
    return GeneralizationMatcher.on(engine);
  }
  
  public UsedStereotypesQuerySpecification getUsedStereotypes() throws ViatraQueryException {
    return UsedStereotypesQuerySpecification.instance();
  }
  
  public UsedStereotypesMatcher getUsedStereotypes(final ViatraQueryEngine engine) throws ViatraQueryException {
    return UsedStereotypesMatcher.on(engine);
  }
}
