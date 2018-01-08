/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocksMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.TransformedStereotypedBlocksQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.TransformedStereotypedBlocks pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link TransformedStereotypedBlocksMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Event-Driven rule precondition number 3
 *   
 *   
 *   Queries blocks that have been transformed by rule 1, in order to remove now obsolete stereotype instances.
 *   These blocks have a stereotype of the selected profile, and a property that has the same name and is of the same type
 *   
 *  
 * pattern TransformedStereotypedBlocks(block : Class, stereotype : Stereotype, slot : Slot) {
 * //variable 'block' is a block
 * 	find block(block);
 * 
 * 	//properties of applied stereotype
 * 	Class.appliedStereotypeInstance.slot(block, slot);
 * 	Slot.definingFeature(slot, property); // Property of  Stereotype
 * 	Stereotype.ownedAttribute(stereotype, property);
 * 
 * 	//Query the block's attributes
 * 	Class.ownedAttribute(block, createdProperty);
 * 
 * 	//Check if properties are considered equal
 * 	Property.name(createdProperty, name);
 * 	Property.name(property, name);
 * 
 * 	Property.type(createdProperty, type);
 * 	Property.type(property, type);
 * }
 * </pre></code>
 * 
 * @see TransformedStereotypedBlocksMatch
 *  @see TransformedStereotypedBlocksProcessor
 * @see TransformedStereotypedBlocksQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class TransformedStereotypedBlocksMatcher extends BaseMatcher<TransformedStereotypedBlocksMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public static TransformedStereotypedBlocksMatcher on(final ViatraQueryEngine engine) {
    // check if matcher already exists
    TransformedStereotypedBlocksMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (TransformedStereotypedBlocksMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static TransformedStereotypedBlocksMatcher create() {
    return new TransformedStereotypedBlocksMatcher();
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_STEREOTYPE = 1;
  
  private final static int POSITION_SLOT = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TransformedStereotypedBlocksMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  private TransformedStereotypedBlocksMatcher() {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return matches represented as a TransformedStereotypedBlocksMatch object.
   * 
   */
  public Collection<TransformedStereotypedBlocksMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot) {
    return rawGetAllMatches(new Object[]{pBlock, pStereotype, pSlot});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return a match represented as a TransformedStereotypedBlocksMatch object, or null if no match is found.
   * 
   */
  public TransformedStereotypedBlocksMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot) {
    return rawHasMatch(new Object[]{pBlock, pStereotype, pSlot});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot) {
    return rawCountMatches(new Object[]{pBlock, pStereotype, pSlot});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final IMatchProcessor<? super TransformedStereotypedBlocksMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pStereotype, pSlot}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final IMatchProcessor<? super TransformedStereotypedBlocksMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public TransformedStereotypedBlocksMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot) {
    return TransformedStereotypedBlocksMatch.newMatch(pBlock, pStereotype, pSlot);
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
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final TransformedStereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final Stereotype pStereotype, final Slot pSlot) {
    return rawAccumulateAllValuesOfblock(new Object[]{
    null, 
    pStereotype, 
    pSlot
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
  public Set<Stereotype> getAllValuesOfstereotype(final TransformedStereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfstereotype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Slot pSlot) {
    return rawAccumulateAllValuesOfstereotype(new Object[]{
    pBlock, 
    null, 
    pSlot
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
  public Set<Slot> getAllValuesOfslot(final TransformedStereotypedBlocksMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    pBlock, 
    pStereotype, 
    null
    });
  }
  
  @Override
  protected TransformedStereotypedBlocksMatch tupleToMatch(final Tuple t) {
    try {
        return TransformedStereotypedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (Stereotype) t.get(POSITION_STEREOTYPE), (Slot) t.get(POSITION_SLOT));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected TransformedStereotypedBlocksMatch arrayToMatch(final Object[] match) {
    try {
        return TransformedStereotypedBlocksMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected TransformedStereotypedBlocksMatch arrayToMatchMutable(final Object[] match) {
    try {
        return TransformedStereotypedBlocksMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT]);
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
  public static IQuerySpecification<TransformedStereotypedBlocksMatcher> querySpecification() {
    return TransformedStereotypedBlocksQuerySpecification.instance();
  }
}
