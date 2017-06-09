/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import gov.nasa.jpl.mbee.mdk.queries.CircularDependencyErrorMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.CircularDependencyErrorQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.CircularDependencyError pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CircularDependencyErrorMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Pattern responsible for detecting circular dependency chains in UML models
 *  
 * pattern CircularDependencyError(dep : Dependency) {
 *     //Call transitive closure of sub-pattern 'DependencyChain'
 *     find DependencyChain+(dep, dep);
 * }
 * </pre></code>
 * 
 * @see CircularDependencyErrorMatch
 * @see CircularDependencyErrorProcessor
 * @see CircularDependencyErrorQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CircularDependencyErrorMatcher extends BaseMatcher<CircularDependencyErrorMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CircularDependencyErrorMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    CircularDependencyErrorMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = (CircularDependencyErrorMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static CircularDependencyErrorMatcher create() throws ViatraQueryException {
    return new CircularDependencyErrorMatcher();
  }
  
  private final static int POSITION_DEP = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CircularDependencyErrorMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private CircularDependencyErrorMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return matches represented as a CircularDependencyErrorMatch object.
   * 
   */
  public Collection<CircularDependencyErrorMatch> getAllMatches(final Dependency pDep) {
    return rawGetAllMatches(new Object[]{pDep});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return a match represented as a CircularDependencyErrorMatch object, or null if no match is found.
   * 
   */
  public CircularDependencyErrorMatch getOneArbitraryMatch(final Dependency pDep) {
    return rawGetOneArbitraryMatch(new Object[]{pDep});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Dependency pDep) {
    return rawHasMatch(new Object[]{pDep});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Dependency pDep) {
    return rawCountMatches(new Object[]{pDep});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Dependency pDep, final IMatchProcessor<? super CircularDependencyErrorMatch> processor) {
    rawForEachMatch(new Object[]{pDep}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Dependency pDep, final IMatchProcessor<? super CircularDependencyErrorMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pDep}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CircularDependencyErrorMatch newMatch(final Dependency pDep) {
    return CircularDependencyErrorMatch.newMatch(pDep);
  }
  
  /**
   * Retrieve the set of values that occur in matches for dep.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Dependency> rawAccumulateAllValuesOfdep(final Object[] parameters) {
    Set<Dependency> results = new HashSet<Dependency>();
    rawAccumulateAllValues(POSITION_DEP, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for dep.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Dependency> getAllValuesOfdep() {
    return rawAccumulateAllValuesOfdep(emptyArray());
  }
  
  @Override
  protected CircularDependencyErrorMatch tupleToMatch(final Tuple t) {
    try {
    	return CircularDependencyErrorMatch.newMatch((Dependency) t.get(POSITION_DEP));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CircularDependencyErrorMatch arrayToMatch(final Object[] match) {
    try {
    	return CircularDependencyErrorMatch.newMatch((Dependency) match[POSITION_DEP]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CircularDependencyErrorMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return CircularDependencyErrorMatch.newMutableMatch((Dependency) match[POSITION_DEP]);
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
  public static IQuerySpecification<CircularDependencyErrorMatcher> querySpecification() throws ViatraQueryException {
    return CircularDependencyErrorQuerySpecification.instance();
  }
}
