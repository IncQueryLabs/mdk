/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.UsedStereotypesMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.UsedStereotypesQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.usedStereotypes pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UsedStereotypesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Returns stereotypes that are used as applied instances.
 *  
 * pattern usedStereotypes(stereotype : Stereotype) {
 * 	Class.appliedStereotypeInstance.classifier(_class, stereotype);
 * } or {
 * 	Stereotype.ownedAttribute(stereotype, property);
 * 	Class.appliedStereotypeInstance.slot.definingFeature(_class, property);
 * }
 * </pre></code>
 * 
 * @see UsedStereotypesMatch
 *  @see UsedStereotypesProcessor
 * @see UsedStereotypesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UsedStereotypesMatcher extends BaseMatcher<UsedStereotypesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public static UsedStereotypesMatcher on(final ViatraQueryEngine engine) {
    // check if matcher already exists
    UsedStereotypesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (UsedStereotypesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static UsedStereotypesMatcher create() {
    return new UsedStereotypesMatcher();
  }
  
  private final static int POSITION_STEREOTYPE = 0;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(UsedStereotypesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  private UsedStereotypesMatcher() {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return matches represented as a UsedStereotypesMatch object.
   * 
   */
  public Collection<UsedStereotypesMatch> getAllMatches(final Stereotype pStereotype) {
    return rawGetAllMatches(new Object[]{pStereotype});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return a match represented as a UsedStereotypesMatch object, or null if no match is found.
   * 
   */
  public UsedStereotypesMatch getOneArbitraryMatch(final Stereotype pStereotype) {
    return rawGetOneArbitraryMatch(new Object[]{pStereotype});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Stereotype pStereotype) {
    return rawHasMatch(new Object[]{pStereotype});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Stereotype pStereotype) {
    return rawCountMatches(new Object[]{pStereotype});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Stereotype pStereotype, final IMatchProcessor<? super UsedStereotypesMatch> processor) {
    rawForEachMatch(new Object[]{pStereotype}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Stereotype pStereotype, final IMatchProcessor<? super UsedStereotypesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pStereotype}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public UsedStereotypesMatch newMatch(final Stereotype pStereotype) {
    return UsedStereotypesMatch.newMatch(pStereotype);
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Stereotype> rawAccumulateAllValuesOfstereotype(final Object[] parameters) {
    Set<Stereotype> results = new HashSet<Stereotype>();
    rawAccumulateAllValues(POSITION_STEREOTYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype() {
    return rawAccumulateAllValuesOfstereotype(emptyArray());
  }
  
  @Override
  protected UsedStereotypesMatch tupleToMatch(final Tuple t) {
    try {
        return UsedStereotypesMatch.newMatch((Stereotype) t.get(POSITION_STEREOTYPE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected UsedStereotypesMatch arrayToMatch(final Object[] match) {
    try {
        return UsedStereotypesMatch.newMatch((Stereotype) match[POSITION_STEREOTYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected UsedStereotypesMatch arrayToMatchMutable(final Object[] match) {
    try {
        return UsedStereotypesMatch.newMutableMatch((Stereotype) match[POSITION_STEREOTYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<UsedStereotypesMatcher> querySpecification() {
    return UsedStereotypesQuerySpecification.instance();
  }
}
