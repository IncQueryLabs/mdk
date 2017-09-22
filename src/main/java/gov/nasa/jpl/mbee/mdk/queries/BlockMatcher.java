/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.BlockMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.block pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BlockMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Queries instances of block objects 
 *  
 * pattern block(class : Class) {
 * 	Classifier.name(block, "Block");
 * 	InstanceSpecification.classifier(instance, block);
 * 	Class.appliedStereotypeInstance(class, instance);
 * }
 * </pre></code>
 * 
 * @see BlockMatch
 *  @see BlockProcessor
 * @see BlockQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BlockMatcher extends BaseMatcher<BlockMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BlockMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    BlockMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (BlockMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static BlockMatcher create() throws ViatraQueryException {
    return new BlockMatcher();
  }
  
  private final static int POSITION_CLASS = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BlockMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private BlockMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return matches represented as a BlockMatch object.
   * 
   */
  public Collection<BlockMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return rawGetAllMatches(new Object[]{pClass});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return a match represented as a BlockMatch object, or null if no match is found.
   * 
   */
  public BlockMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return rawGetOneArbitraryMatch(new Object[]{pClass});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return rawHasMatch(new Object[]{pClass});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return rawCountMatches(new Object[]{pClass});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final IMatchProcessor<? super BlockMatch> processor) {
    rawForEachMatch(new Object[]{pClass}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final IMatchProcessor<? super BlockMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pClass}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BlockMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return BlockMatch.newMatch(pClass);
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfclass(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_CLASS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for class.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass() {
    return rawAccumulateAllValuesOfclass(emptyArray());
  }
  
  @Override
  protected BlockMatch tupleToMatch(final Tuple t) {
    try {
        return BlockMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_CLASS));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlockMatch arrayToMatch(final Object[] match) {
    try {
        return BlockMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlockMatch arrayToMatchMutable(final Object[] match) {
    try {
        return BlockMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS]);
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
  public static IQuerySpecification<BlockMatcher> querySpecification() throws ViatraQueryException {
    return BlockQuerySpecification.instance();
  }
}
