/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.BlocksWithTaggedValuesMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.BlocksWithTaggedValuesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.blocksWithTaggedValues pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BlocksWithTaggedValuesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern blocksWithTaggedValues(block : Class, lower : java ^java.lang.String, higher : java ^java.lang.String) {
 * 	find blocks(block);
 * 	Class.ownedAttribute(block, property);
 * 	Property.lowerValue._representationText(property, lower);
 * 	Property.upperValue._representationText(property, higher);
 * }
 * </pre></code>
 * 
 * @see BlocksWithTaggedValuesMatch
 * @see BlocksWithTaggedValuesProcessor
 * @see BlocksWithTaggedValuesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BlocksWithTaggedValuesMatcher extends BaseMatcher<BlocksWithTaggedValuesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BlocksWithTaggedValuesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    BlocksWithTaggedValuesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (BlocksWithTaggedValuesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static BlocksWithTaggedValuesMatcher create() throws ViatraQueryException {
    return new BlocksWithTaggedValuesMatcher();
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_LOWER = 1;
  
  private final static int POSITION_HIGHER = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BlocksWithTaggedValuesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private BlocksWithTaggedValuesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return matches represented as a BlocksWithTaggedValuesMatch object.
   * 
   */
  public Collection<BlocksWithTaggedValuesMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return rawGetAllMatches(new Object[]{pBlock, pLower, pHigher});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return a match represented as a BlocksWithTaggedValuesMatch object, or null if no match is found.
   * 
   */
  public BlocksWithTaggedValuesMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pLower, pHigher});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return rawHasMatch(new Object[]{pBlock, pLower, pHigher});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return rawCountMatches(new Object[]{pBlock, pLower, pHigher});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher, final IMatchProcessor<? super BlocksWithTaggedValuesMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pLower, pHigher}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher, final IMatchProcessor<? super BlocksWithTaggedValuesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pLower, pHigher}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BlocksWithTaggedValuesMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return BlocksWithTaggedValuesMatch.newMatch(pBlock, pLower, pHigher);
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfblock(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_BLOCK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock() {
    return rawAccumulateAllValuesOfblock(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final BlocksWithTaggedValuesMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final String pLower, final String pHigher) {
    return rawAccumulateAllValuesOfblock(new Object[]{
    null, 
    pLower, 
    pHigher
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOflower(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_LOWER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOflower() {
    return rawAccumulateAllValuesOflower(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOflower(final BlocksWithTaggedValuesMatch partialMatch) {
    return rawAccumulateAllValuesOflower(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for lower.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOflower(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pHigher) {
    return rawAccumulateAllValuesOflower(new Object[]{
    pBlock, 
    null, 
    pHigher
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for higher.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfhigher(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_HIGHER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for higher.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfhigher() {
    return rawAccumulateAllValuesOfhigher(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for higher.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfhigher(final BlocksWithTaggedValuesMatch partialMatch) {
    return rawAccumulateAllValuesOfhigher(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for higher.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfhigher(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower) {
    return rawAccumulateAllValuesOfhigher(new Object[]{
    pBlock, 
    pLower, 
    null
    });
  }
  
  @Override
  protected BlocksWithTaggedValuesMatch tupleToMatch(final Tuple t) {
    try {
        return BlocksWithTaggedValuesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (String) t.get(POSITION_LOWER), (String) t.get(POSITION_HIGHER));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlocksWithTaggedValuesMatch arrayToMatch(final Object[] match) {
    try {
        return BlocksWithTaggedValuesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (String) match[POSITION_LOWER], (String) match[POSITION_HIGHER]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlocksWithTaggedValuesMatch arrayToMatchMutable(final Object[] match) {
    try {
        return BlocksWithTaggedValuesMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (String) match[POSITION_LOWER], (String) match[POSITION_HIGHER]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BlocksWithTaggedValuesMatcher> querySpecification() throws ViatraQueryException {
    return BlocksWithTaggedValuesQuerySpecification.instance();
  }
}
