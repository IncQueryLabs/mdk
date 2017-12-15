/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatcher;
import gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TransformedGeneralizedBlockPairsMatcher;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatcher;
import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedGeneralizedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in EventDrivenTransformationQueries.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file EventDrivenTransformationQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>StereotypedBlocks</li>
 * <li>TransformedGeneralizedBlockPairs</li>
 * <li>TransformedStereotypedBlocks</li>
 * <li>FindCommonParentClass</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class EventDrivenTransformationQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static EventDrivenTransformationQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new EventDrivenTransformationQueries();
    }
    return INSTANCE;
  }
  
  private static EventDrivenTransformationQueries INSTANCE;
  
  private EventDrivenTransformationQueries() {
    querySpecifications.add(StereotypedBlocksQuerySpecification.instance());
    querySpecifications.add(TransformedGeneralizedBlockPairsQuerySpecification.instance());
    querySpecifications.add(TransformedStereotypedBlocksQuerySpecification.instance());
    querySpecifications.add(FindCommonParentClassQuerySpecification.instance());
  }
  
  public StereotypedBlocksQuerySpecification getStereotypedBlocks() {
    return StereotypedBlocksQuerySpecification.instance();
  }
  
  public StereotypedBlocksMatcher getStereotypedBlocks(final ViatraQueryEngine engine) {
    return StereotypedBlocksMatcher.on(engine);
  }
  
  public TransformedGeneralizedBlockPairsQuerySpecification getTransformedGeneralizedBlockPairs() {
    return TransformedGeneralizedBlockPairsQuerySpecification.instance();
  }
  
  public TransformedGeneralizedBlockPairsMatcher getTransformedGeneralizedBlockPairs(final ViatraQueryEngine engine) {
    return TransformedGeneralizedBlockPairsMatcher.on(engine);
  }
  
  public TransformedStereotypedBlocksQuerySpecification getTransformedStereotypedBlocks() {
    return TransformedStereotypedBlocksQuerySpecification.instance();
  }
  
  public TransformedStereotypedBlocksMatcher getTransformedStereotypedBlocks(final ViatraQueryEngine engine) {
    return TransformedStereotypedBlocksMatcher.on(engine);
  }
  
  public FindCommonParentClassQuerySpecification getFindCommonParentClass() {
    return FindCommonParentClassQuerySpecification.instance();
  }
  
  public FindCommonParentClassMatcher getFindCommonParentClass(final ViatraQueryEngine engine) {
    return FindCommonParentClassMatcher.on(engine);
  }
}
