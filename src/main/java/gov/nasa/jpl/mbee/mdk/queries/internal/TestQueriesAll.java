/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.internal;

import gov.nasa.jpl.mbee.mdk.queries.internal.BlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.internal.GeneralizationsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.internal.GeneralizedTaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.internal.PropertiesQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.internal.ReferredStereotypesQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.internal.StereotypesQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.TaggedBlocksQuerySpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.UnreferredStereotypesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in TestQueries.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package gov.nasa.jpl.mbee.mdk.queries, the group contains the definition of the following patterns: <ul>
 * <li>blocks</li>
 * <li>properties</li>
 * <li>stereotypes</li>
 * <li>generalizations</li>
 * <li>taggedBlocks</li>
 * <li>generalizedTaggedBlocks</li>
 * <li>generalizedTaggedBlockPairs</li>
 * <li>referredStereotypes</li>
 * <li>unreferredStereotypes</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class TestQueriesAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static TestQueriesAll instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new TestQueriesAll();
    }
    return INSTANCE;
  }
  
  private static TestQueriesAll INSTANCE;
  
  private TestQueriesAll() throws ViatraQueryException {
    querySpecifications.add(BlocksQuerySpecification.instance());
    querySpecifications.add(PropertiesQuerySpecification.instance());
    querySpecifications.add(StereotypesQuerySpecification.instance());
    querySpecifications.add(GeneralizationsQuerySpecification.instance());
    querySpecifications.add(TaggedBlocksQuerySpecification.instance());
    querySpecifications.add(GeneralizedTaggedBlocksQuerySpecification.instance());
    querySpecifications.add(GeneralizedTaggedBlockPairsQuerySpecification.instance());
    querySpecifications.add(ReferredStereotypesQuerySpecification.instance());
    querySpecifications.add(UnreferredStereotypesQuerySpecification.instance());
  }
}
