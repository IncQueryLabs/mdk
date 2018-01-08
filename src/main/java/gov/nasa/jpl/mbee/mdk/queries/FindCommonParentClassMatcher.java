/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClassMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link FindCommonParentClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Event-Driven rule precondition number 4
 *   
 *   Queries structures that require the introduction of a new, common super-class. These structure involve two or 
 *   more blocks that introduce properties (meaning that they do not redefine an other property), that are considered 
 *   equal (have the same type and name), and are defined by a stereotype of the selected profile.
 *   
 *  
 * pattern FindCommonParentClass(block1 : Class, block2 : Class, attribute1 : Property, attribute2 : Property, stereotype : Stereotype) {
 * 	find block(block1);
 * 	find block(block2);
 * 
 * 	block1 != block2;
 * 
 * 	//Query attributes of blocks 1 and 2 as well as the stereotypes of the profile
 * 	Class.ownedAttribute(block1, attribute1);
 * 	Class.ownedAttribute(block2, attribute2);
 * 	//Attributes of the block do not redefine a property
 * 	neg find redefiningProperty(attribute1);
 * 	neg find redefiningProperty(attribute2);
 * 	Stereotype.ownedAttribute(stereotype, property);
 * 
 * 	//Check if they are all equal
 * 	find propertyAttributes(attribute1, name, type);
 * 	find propertyAttributes(attribute2, name, type);
 * 	find propertyAttributes(property, name, type);
 * 
 * }
 * </pre></code>
 * 
 * @see FindCommonParentClassMatch
 *  @see FindCommonParentClassProcessor
 * @see FindCommonParentClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class FindCommonParentClassMatcher extends BaseMatcher<FindCommonParentClassMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public static FindCommonParentClassMatcher on(final ViatraQueryEngine engine) {
    // check if matcher already exists
    FindCommonParentClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (FindCommonParentClassMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static FindCommonParentClassMatcher create() {
    return new FindCommonParentClassMatcher();
  }
  
  private final static int POSITION_BLOCK1 = 0;
  
  private final static int POSITION_BLOCK2 = 1;
  
  private final static int POSITION_ATTRIBUTE1 = 2;
  
  private final static int POSITION_ATTRIBUTE2 = 3;
  
  private final static int POSITION_STEREOTYPE = 4;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FindCommonParentClassMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  private FindCommonParentClassMatcher() {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return matches represented as a FindCommonParentClassMatch object.
   * 
   */
  public Collection<FindCommonParentClassMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawGetAllMatches(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return a match represented as a FindCommonParentClassMatch object, or null if no match is found.
   * 
   */
  public FindCommonParentClassMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawHasMatch(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawCountMatches(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype, final IMatchProcessor<? super FindCommonParentClassMatch> processor) {
    rawForEachMatch(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype, final IMatchProcessor<? super FindCommonParentClassMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public FindCommonParentClassMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return FindCommonParentClassMatch.newMatch(pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype);
  }
  
  /**
   * Retrieve the set of values that occur in matches for block1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfblock1(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_BLOCK1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for block1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock1() {
    return rawAccumulateAllValuesOfblock1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock1(final FindCommonParentClassMatch partialMatch) {
    return rawAccumulateAllValuesOfblock1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawAccumulateAllValuesOfblock1(new Object[]{
    null, 
    pBlock2, 
    pAttribute1, 
    pAttribute2, 
    pStereotype
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for block2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfblock2(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_BLOCK2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for block2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock2() {
    return rawAccumulateAllValuesOfblock2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock2(final FindCommonParentClassMatch partialMatch) {
    return rawAccumulateAllValuesOfblock2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return rawAccumulateAllValuesOfblock2(new Object[]{
    pBlock1, 
    null, 
    pAttribute1, 
    pAttribute2, 
    pStereotype
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfattribute1(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_ATTRIBUTE1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute1() {
    return rawAccumulateAllValuesOfattribute1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute1(final FindCommonParentClassMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute1.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute2, final Stereotype pStereotype) {
    return rawAccumulateAllValuesOfattribute1(new Object[]{
    pBlock1, 
    pBlock2, 
    null, 
    pAttribute2, 
    pStereotype
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfattribute2(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_ATTRIBUTE2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute2() {
    return rawAccumulateAllValuesOfattribute2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute2(final FindCommonParentClassMatch partialMatch) {
    return rawAccumulateAllValuesOfattribute2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for attribute2.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfattribute2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Stereotype pStereotype) {
    return rawAccumulateAllValuesOfattribute2(new Object[]{
    pBlock1, 
    pBlock2, 
    pAttribute1, 
    null, 
    pStereotype
    });
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
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final FindCommonParentClassMatch partialMatch) {
    return rawAccumulateAllValuesOfstereotype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2) {
    return rawAccumulateAllValuesOfstereotype(new Object[]{
    pBlock1, 
    pBlock2, 
    pAttribute1, 
    pAttribute2, 
    null
    });
  }
  
  @Override
  protected FindCommonParentClassMatch tupleToMatch(final Tuple t) {
    try {
        return FindCommonParentClassMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK1), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK2), (Property) t.get(POSITION_ATTRIBUTE1), (Property) t.get(POSITION_ATTRIBUTE2), (Stereotype) t.get(POSITION_STEREOTYPE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected FindCommonParentClassMatch arrayToMatch(final Object[] match) {
    try {
        return FindCommonParentClassMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK2], (Property) match[POSITION_ATTRIBUTE1], (Property) match[POSITION_ATTRIBUTE2], (Stereotype) match[POSITION_STEREOTYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected FindCommonParentClassMatch arrayToMatchMutable(final Object[] match) {
    try {
        return FindCommonParentClassMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK2], (Property) match[POSITION_ATTRIBUTE1], (Property) match[POSITION_ATTRIBUTE2], (Stereotype) match[POSITION_STEREOTYPE]);
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
  public static IQuerySpecification<FindCommonParentClassMatcher> querySpecification() {
    return FindCommonParentClassQuerySpecification.instance();
  }
}
