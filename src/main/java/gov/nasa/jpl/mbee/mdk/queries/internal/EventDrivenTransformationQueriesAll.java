/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.internal;

import gov.nasa.jpl.mbee.mdk.queries.internal.RedefiningPropertyQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedGeneralizedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all patterns defined in EventDrivenTransformationQueries.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>StereotypedBlocks</li>
 * <li>TransformedGeneralizedBlockPairs</li>
 * <li>TransformedStereotypedBlocks</li>
 * <li>FindCommonParentClass</li>
 * <li>redefiningProperty</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class EventDrivenTransformationQueriesAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static EventDrivenTransformationQueriesAll instance() {
    if (INSTANCE == null) {
        INSTANCE = new EventDrivenTransformationQueriesAll();
    }
    return INSTANCE;
  }
  
  private static EventDrivenTransformationQueriesAll INSTANCE;
  
  private EventDrivenTransformationQueriesAll() {
    querySpecifications.add(StereotypedBlocksQuerySpecification.instance());
    querySpecifications.add(TransformedGeneralizedBlockPairsQuerySpecification.instance());
    querySpecifications.add(TransformedStereotypedBlocksQuerySpecification.instance());
    querySpecifications.add(FindCommonParentClassQuerySpecification.instance());
    querySpecifications.add(RedefiningPropertyQuerySpecification.instance());
  }
}
