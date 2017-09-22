/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocks pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link StereotypedBlocksMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Event-Driven rule precondition number 1
 *   
 *   Queries blocks that have instances of the selected profile's stereotypes, and define tagged values for its properties. 
 *   during the rule action, for these tagged values new block ValueProperties are introduced. the value of the tag is 
 *   represented as the default value of the property.
 *   
 *  
 * pattern StereotypedBlocks(block : Class, stereotype : Stereotype, slot : Slot, property : Property, value : LiteralSpecification) {
 * 	find block(block);
 * 	Class.appliedStereotypeInstance.slot(block, slot);
 * 	Slot.definingFeature(slot, property); 
 * 	Slot.value(slot, value);
 * 	Stereotype.ownedAttribute(stereotype, property);
 * }
 * </pre></code>
 * 
 * @see StereotypedBlocksMatch
 *  @see StereotypedBlocksProcessor
 * @see StereotypedBlocksQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class StereotypedBlocksMatcher extends BaseMatcher<StereotypedBlocksMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static StereotypedBlocksMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    StereotypedBlocksMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (StereotypedBlocksMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static StereotypedBlocksMatcher create() throws ViatraQueryException {
    return new StereotypedBlocksMatcher();
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_STEREOTYPE = 1;
  
  private final static int POSITION_SLOT = 2;
  
  private final static int POSITION_PROPERTY = 3;
  
  private final static int POSITION_VALUE = 4;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(StereotypedBlocksMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private StereotypedBlocksMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return matches represented as a StereotypedBlocksMatch object.
   * 
   */
  public Collection<StereotypedBlocksMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawGetAllMatches(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return a match represented as a StereotypedBlocksMatch object, or null if no match is found.
   * 
   */
  public StereotypedBlocksMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawHasMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawCountMatches(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue, final IMatchProcessor<? super StereotypedBlocksMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue, final IMatchProcessor<? super StereotypedBlocksMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pValue}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public StereotypedBlocksMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return StereotypedBlocksMatch.newMatch(pBlock, pStereotype, pSlot, pProperty, pValue);
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
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final StereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawAccumulateAllValuesOfblock(new Object[]{
    null, 
    pStereotype, 
    pSlot, 
    pProperty, 
    pValue
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
  public Set<Stereotype> getAllValuesOfstereotype(final StereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfstereotype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return rawAccumulateAllValuesOfstereotype(new Object[]{
    pBlock, 
    null, 
    pSlot, 
    pProperty, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Slot> rawAccumulateAllValuesOfslot(final Object[] parameters) {
    Set<Slot> results = new HashSet<Slot>();
    rawAccumulateAllValues(POSITION_SLOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot() {
    return rawAccumulateAllValuesOfslot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final StereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Property pProperty, final LiteralSpecification pValue) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    pBlock, 
    pStereotype, 
    null, 
    pProperty, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Property> rawAccumulateAllValuesOfproperty(final Object[] parameters) {
    Set<Property> results = new HashSet<Property>();
    rawAccumulateAllValues(POSITION_PROPERTY, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty() {
    return rawAccumulateAllValuesOfproperty(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final StereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfproperty(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final LiteralSpecification pValue) {
    return rawAccumulateAllValuesOfproperty(new Object[]{
    pBlock, 
    pStereotype, 
    pSlot, 
    null, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<LiteralSpecification> rawAccumulateAllValuesOfvalue(final Object[] parameters) {
    Set<LiteralSpecification> results = new HashSet<LiteralSpecification>();
    rawAccumulateAllValues(POSITION_VALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfvalue() {
    return rawAccumulateAllValuesOfvalue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfvalue(final StereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfvalue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfvalue(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty) {
    return rawAccumulateAllValuesOfvalue(new Object[]{
    pBlock, 
    pStereotype, 
    pSlot, 
    pProperty, 
    null
    });
  }
  
  @Override
  protected StereotypedBlocksMatch tupleToMatch(final Tuple t) {
    try {
        return StereotypedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (Stereotype) t.get(POSITION_STEREOTYPE), (Slot) t.get(POSITION_SLOT), (Property) t.get(POSITION_PROPERTY), (LiteralSpecification) t.get(POSITION_VALUE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected StereotypedBlocksMatch arrayToMatch(final Object[] match) {
    try {
        return StereotypedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT], (Property) match[POSITION_PROPERTY], (LiteralSpecification) match[POSITION_VALUE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected StereotypedBlocksMatch arrayToMatchMutable(final Object[] match) {
    try {
        return StereotypedBlocksMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT], (Property) match[POSITION_PROPERTY], (LiteralSpecification) match[POSITION_VALUE]);
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
  public static IQuerySpecification<StereotypedBlocksMatcher> querySpecification() throws ViatraQueryException {
    return StereotypedBlocksQuerySpecification.instance();
  }
}
