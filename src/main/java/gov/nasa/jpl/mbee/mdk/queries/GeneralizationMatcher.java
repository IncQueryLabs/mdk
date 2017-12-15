/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.GeneralizationMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizationQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.generalization pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GeneralizationMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Defines parent-child relation between classes
 *  
 * pattern generalization(general : Class, specific : Class) {
 * 	Generalization.general(generalization, general);
 * 	Generalization.specific(generalization, specific);
 * }
 * </pre></code>
 * 
 * @see GeneralizationMatch
 *  @see GeneralizationProcessor
 * @see GeneralizationQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GeneralizationMatcher extends BaseMatcher<GeneralizationMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public static GeneralizationMatcher on(final ViatraQueryEngine engine) {
    // check if matcher already exists
    GeneralizationMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (GeneralizationMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static GeneralizationMatcher create() {
    return new GeneralizationMatcher();
  }
  
  private final static int POSITION_GENERAL = 0;
  
  private final static int POSITION_SPECIFIC = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GeneralizationMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  private GeneralizationMatcher() {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return matches represented as a GeneralizationMatch object.
   * 
   */
  public Collection<GeneralizationMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return rawGetAllMatches(new Object[]{pGeneral, pSpecific});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return a match represented as a GeneralizationMatch object, or null if no match is found.
   * 
   */
  public GeneralizationMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return rawGetOneArbitraryMatch(new Object[]{pGeneral, pSpecific});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return rawHasMatch(new Object[]{pGeneral, pSpecific});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return rawCountMatches(new Object[]{pGeneral, pSpecific});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific, final IMatchProcessor<? super GeneralizationMatch> processor) {
    rawForEachMatch(new Object[]{pGeneral, pSpecific}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific, final IMatchProcessor<? super GeneralizationMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pGeneral, pSpecific}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GeneralizationMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return GeneralizationMatch.newMatch(pGeneral, pSpecific);
  }
  
  /**
   * Retrieve the set of values that occur in matches for general.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfgeneral(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_GENERAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for general.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfgeneral() {
    return rawAccumulateAllValuesOfgeneral(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for general.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfgeneral(final GeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfgeneral(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for general.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfgeneral(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return rawAccumulateAllValuesOfgeneral(new Object[]{
    null, 
    pSpecific
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for specific.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfspecific(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_SPECIFIC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for specific.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfspecific() {
    return rawAccumulateAllValuesOfspecific(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for specific.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfspecific(final GeneralizationMatch partialMatch) {
    return rawAccumulateAllValuesOfspecific(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for specific.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfspecific(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral) {
    return rawAccumulateAllValuesOfspecific(new Object[]{
    pGeneral, 
    null
    });
  }
  
  @Override
  protected GeneralizationMatch tupleToMatch(final Tuple t) {
    try {
        return GeneralizationMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_GENERAL), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_SPECIFIC));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GeneralizationMatch arrayToMatch(final Object[] match) {
    try {
        return GeneralizationMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_GENERAL], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_SPECIFIC]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GeneralizationMatch arrayToMatchMutable(final Object[] match) {
    try {
        return GeneralizationMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_GENERAL], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_SPECIFIC]);
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
  public static IQuerySpecification<GeneralizationMatcher> querySpecification() {
    return GeneralizationQuerySpecification.instance();
  }
}
