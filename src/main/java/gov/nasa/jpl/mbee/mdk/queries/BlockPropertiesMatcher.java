/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.BlockPropertiesMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockPropertiesQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.blockProperties pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BlockPropertiesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Returns blocks with tags (properties). These tags are attributes of a Stereotypes and have a type (literal) and value.
 *  
 * pattern blockProperties(block : Class, stereotype : Stereotype, slot : Slot, property : Property, literal : LiteralSpecification) {
 * 	find blocks(block);
 * 	Class.appliedStereotypeInstance.slot(block, slot);
 * 	Slot.definingFeature(slot, property); // Property of  Stereotype
 * 	find stereotypes(stereotype, property);
 * 	// Slot value
 * 	Slot.value(slot, literal);
 * }
 * </pre></code>
 * 
 * @see BlockPropertiesMatch
 * @see BlockPropertiesProcessor
 * @see BlockPropertiesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BlockPropertiesMatcher extends BaseMatcher<BlockPropertiesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BlockPropertiesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    BlockPropertiesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (BlockPropertiesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static BlockPropertiesMatcher create() throws ViatraQueryException {
    return new BlockPropertiesMatcher();
  }
  
  private final static int POSITION_BLOCK = 0;
  
  private final static int POSITION_STEREOTYPE = 1;
  
  private final static int POSITION_SLOT = 2;
  
  private final static int POSITION_PROPERTY = 3;
  
  private final static int POSITION_LITERAL = 4;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BlockPropertiesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private BlockPropertiesMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return matches represented as a BlockPropertiesMatch object.
   * 
   */
  public Collection<BlockPropertiesMatch> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawGetAllMatches(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return a match represented as a BlockPropertiesMatch object, or null if no match is found.
   * 
   */
  public BlockPropertiesMatch getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawGetOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawHasMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawCountMatches(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral, final IMatchProcessor<? super BlockPropertiesMatch> processor) {
    rawForEachMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral, final IMatchProcessor<? super BlockPropertiesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pBlock, pStereotype, pSlot, pProperty, pLiteral}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public BlockPropertiesMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return BlockPropertiesMatch.newMatch(pBlock, pStereotype, pSlot, pProperty, pLiteral);
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
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final BlockPropertiesMatch partialMatch) {
    return rawAccumulateAllValuesOfblock(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for block.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawAccumulateAllValuesOfblock(new Object[]{
    null, 
    pStereotype, 
    pSlot, 
    pProperty, 
    pLiteral
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
  public Set<Stereotype> getAllValuesOfstereotype(final BlockPropertiesMatch partialMatch) {
    return rawAccumulateAllValuesOfstereotype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for stereotype.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Stereotype> getAllValuesOfstereotype(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawAccumulateAllValuesOfstereotype(new Object[]{
    pBlock, 
    null, 
    pSlot, 
    pProperty, 
    pLiteral
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
  public Set<Slot> getAllValuesOfslot(final BlockPropertiesMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Property pProperty, final LiteralSpecification pLiteral) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    pBlock, 
    pStereotype, 
    null, 
    pProperty, 
    pLiteral
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
  public Set<Property> getAllValuesOfproperty(final BlockPropertiesMatch partialMatch) {
    return rawAccumulateAllValuesOfproperty(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final LiteralSpecification pLiteral) {
    return rawAccumulateAllValuesOfproperty(new Object[]{
    pBlock, 
    pStereotype, 
    pSlot, 
    null, 
    pLiteral
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for literal.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<LiteralSpecification> rawAccumulateAllValuesOfliteral(final Object[] parameters) {
    Set<LiteralSpecification> results = new HashSet<LiteralSpecification>();
    rawAccumulateAllValues(POSITION_LITERAL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for literal.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfliteral() {
    return rawAccumulateAllValuesOfliteral(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for literal.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfliteral(final BlockPropertiesMatch partialMatch) {
    return rawAccumulateAllValuesOfliteral(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for literal.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<LiteralSpecification> getAllValuesOfliteral(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty) {
    return rawAccumulateAllValuesOfliteral(new Object[]{
    pBlock, 
    pStereotype, 
    pSlot, 
    pProperty, 
    null
    });
  }
  
  @Override
  protected BlockPropertiesMatch tupleToMatch(final Tuple t) {
    try {
        return BlockPropertiesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (Stereotype) t.get(POSITION_STEREOTYPE), (Slot) t.get(POSITION_SLOT), (Property) t.get(POSITION_PROPERTY), (LiteralSpecification) t.get(POSITION_LITERAL));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlockPropertiesMatch arrayToMatch(final Object[] match) {
    try {
        return BlockPropertiesMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT], (Property) match[POSITION_PROPERTY], (LiteralSpecification) match[POSITION_LITERAL]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected BlockPropertiesMatch arrayToMatchMutable(final Object[] match) {
    try {
        return BlockPropertiesMatch.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (Stereotype) match[POSITION_STEREOTYPE], (Slot) match[POSITION_SLOT], (Property) match[POSITION_PROPERTY], (LiteralSpecification) match[POSITION_LITERAL]);
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
  public static IQuerySpecification<BlockPropertiesMatcher> querySpecification() throws ViatraQueryException {
    return BlockPropertiesQuerySpecification.instance();
  }
}
