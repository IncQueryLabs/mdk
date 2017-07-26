/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.GeneralizedTaggedBlockPairsMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlockPairs pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link GeneralizedTaggedBlockPairsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern generalizedTaggedBlockPairs(parentBlock : Class, childBlock : Class, stereotype : Stereotype, parentAttribute : Property, childAttribute : Property) {
 * 	find descendantTaggedBlocks(parentBlock, childBlock, stereotype, property);
 * 	Class.ownedAttribute(parentBlock, parentAttribute);
 * 	Class.ownedAttribute(childBlock, childAttribute);
 * 	find properties(property, name, type);
 * 	find properties(parentAttribute, name, type);
 * 	find properties(childAttribute, name, type);	
 * }
 * </pre></code>
 * 
 * @see GeneralizedTaggedBlockPairsMatch
 * @see GeneralizedTaggedBlockPairsProcessor
 * @see GeneralizedTaggedBlockPairsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class GeneralizedTaggedBlockPairsMatcher extends BaseMatcher<GeneralizedTaggedBlockPairsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static GeneralizedTaggedBlockPairsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    GeneralizedTaggedBlockPairsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (GeneralizedTaggedBlockPairsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static GeneralizedTaggedBlockPairsMatcher create() throws ViatraQueryException {
    return new GeneralizedTaggedBlockPairsMatcher();
  }
  
  private final static int POSITION_PARENTBLOCK = 0;
  
  private final static int POSITION_CHILDBLOCK = 1;
  
  private final static int POSITION_STEREOTYPE = 2;
  
  private final static int POSITION_PARENTATTRIBUTE = 3;
  
  private final static int POSITION_CHILDATTRIBUTE = 4;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GeneralizedTaggedBlockPairsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private GeneralizedTaggedBlockPairsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return matches represented as a GeneralizedTaggedBlockPairsMatch object.
   * 
   */
  public Collection<GeneralizedTaggedBlockPairsMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawGetAllMatches(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return a match represented as a GeneralizedTaggedBlockPairsMatch object, or null if no match is found.
   * 
   */
  public GeneralizedTaggedBlockPairsMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawGetOneArbitraryMatch(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawHasMatch(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawCountMatches(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute, final IMatchProcessor<? super GeneralizedTaggedBlockPairsMatch> processor) {
    rawForEachMatch(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute, final IMatchProcessor<? super GeneralizedTaggedBlockPairsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public GeneralizedTaggedBlockPairsMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return GeneralizedTaggedBlockPairsMatch.newMatch(pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute);
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfparentBlock(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_PARENTBLOCK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparentBlock() {
    return rawAccumulateAllValuesOfparentBlock(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparentBlock(final GeneralizedTaggedBlockPairsMatch partialMatch) {
    return rawAccumulateAllValuesOfparentBlock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparentBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawAccumulateAllValuesOfparentBlock(new Object[]{
    null, 
    pChildBlock, 
    pStereotype, 
    pParentAttribute, 
    pChildAttribute
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for childBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawAccumulateAllValuesOfchildBlock(final Object[] parameters) {
    Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> results = new HashSet<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class>();
    rawAccumulateAllValues(POSITION_CHILDBLOCK, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for childBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfchildBlock() {
    return rawAccumulateAllValuesOfchildBlock(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for childBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfchildBlock(final GeneralizedTaggedBlockPairsMatch partialMatch) {
    return rawAccumulateAllValuesOfchildBlock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for childBlock.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfchildBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return rawAccumulateAllValuesOfchildBlock(new Object[]{
    pParentBlock, 
    null, 
    pStereotype, 
    pParentAttribute, 
    pChildAttribute
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
  public Set<Stereotype> getAllValuesOfstereotype(final GeneralizedTaggedBlockPairsMatch partialMatch) {
    return rawAccumulateAllValuesOfstereotype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Property pParentAttribute, final Property pChildAttribute) {
    return rawAccumulateAllValuesOfstereotype(new Object[]{
    pParentBlock, 
    pChildBlock, 
    null, 
    pParentAttribute, 
    pChildAttribute
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfparentAttribute(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_PARENTATTRIBUTE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfparentAttribute() {
    return rawAccumulateAllValuesOfparentAttribute(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfparentAttribute(final GeneralizedTaggedBlockPairsMatch partialMatch) {
    return rawAccumulateAllValuesOfparentAttribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for parentAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfparentAttribute(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pChildAttribute) {
    return rawAccumulateAllValuesOfparentAttribute(new Object[]{
    pParentBlock, 
    pChildBlock, 
    pStereotype, 
    null, 
    pChildAttribute
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for childAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfchildAttribute(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_CHILDATTRIBUTE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for childAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfchildAttribute() {
    return rawAccumulateAllValuesOfchildAttribute(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for childAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfchildAttribute(final GeneralizedTaggedBlockPairsMatch partialMatch) {
    return rawAccumulateAllValuesOfchildAttribute(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for childAttribute.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfchildAttribute(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute) {
    return rawAccumulateAllValuesOfchildAttribute(new Object[]{
    pParentBlock, 
    pChildBlock, 
    pStereotype, 
    pParentAttribute, 
    null
    });
  }
  
  @Override
  protected GeneralizedTaggedBlockPairsMatch tupleToMatch(final Tuple t) {
    try {
        return GeneralizedTaggedBlockPairsMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_PARENTBLOCK), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_CHILDBLOCK), (Stereotype) t.get(POSITION_STEREOTYPE), (Property) t.get(POSITION_PARENTATTRIBUTE), (Property) t.get(POSITION_CHILDATTRIBUTE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GeneralizedTaggedBlockPairsMatch arrayToMatch(final Object[] match) {
    try {
        return GeneralizedTaggedBlockPairsMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PARENTBLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CHILDBLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Property) match[POSITION_PARENTATTRIBUTE], (Property) match[POSITION_CHILDATTRIBUTE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected GeneralizedTaggedBlockPairsMatch arrayToMatchMutable(final Object[] match) {
    try {
        return GeneralizedTaggedBlockPairsMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PARENTBLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CHILDBLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Property) match[POSITION_PARENTATTRIBUTE], (Property) match[POSITION_CHILDATTRIBUTE]);
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
  public static IQuerySpecification<GeneralizedTaggedBlockPairsMatcher> querySpecification() throws ViatraQueryException {
    return GeneralizedTaggedBlockPairsQuerySpecification.instance();
  }
}
