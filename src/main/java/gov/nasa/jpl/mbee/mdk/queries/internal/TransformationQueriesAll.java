/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.internal;

import gov.nasa.jpl.mbee.mdk.queries.internal.GeneralizedTaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.UnreferredStereotypesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in TransformationQueries.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>taggedBlocks</li>
 * <li>generalizedTaggedBlockPairs</li>
 * <li>unreferredStereotypes</li>
 * <li>generalizedTaggedBlocks</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class TransformationQueriesAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TransformationQueriesAll instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new TransformationQueriesAll();
    }
    return INSTANCE;
  }
  
  private static TransformationQueriesAll INSTANCE;
  
  private TransformationQueriesAll() throws ViatraQueryException {
    querySpecifications.add(TaggedBlocksQuerySpecification.instance());
    querySpecifications.add(GeneralizedTaggedBlockPairsQuerySpecification.instance());
    querySpecifications.add(UnreferredStereotypesQuerySpecification.instance());
    querySpecifications.add(GeneralizedTaggedBlocksQuerySpecification.instance());
  }
}
