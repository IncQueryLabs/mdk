/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.StructuralFeature;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification;
import gov.nasa.jpl.mbee.mdk.queries.SlotsMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.SlotsQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.slots pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SlotsMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern slots(slot, owningInstance, feature, value) {
 * 	Slot(slot);
 * 	Slot.owningInstance(slot, owningInstance);
 * 	Slot.definingFeature(slot, feature);
 * 	Slot.value(slot, value);
 * }
 * </pre></code>
 * 
 * @see SlotsMatch
 * @see SlotsProcessor
 * @see SlotsQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SlotsMatcher extends BaseMatcher<SlotsMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SlotsMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    SlotsMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (SlotsMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static SlotsMatcher create() throws ViatraQueryException {
    return new SlotsMatcher();
  }
  
  private final static int POSITION_SLOT = 0;
  
  private final static int POSITION_OWNINGINSTANCE = 1;
  
  private final static int POSITION_FEATURE = 2;
  
  private final static int POSITION_VALUE = 3;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SlotsMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private SlotsMatcher() throws ViatraQueryException {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return matches represented as a SlotsMatch object.
   * 
   */
  public Collection<SlotsMatch> getAllMatches(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawGetAllMatches(new Object[]{pSlot, pOwningInstance, pFeature, pValue});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return a match represented as a SlotsMatch object, or null if no match is found.
   * 
   */
  public SlotsMatch getOneArbitraryMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawGetOneArbitraryMatch(new Object[]{pSlot, pOwningInstance, pFeature, pValue});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawHasMatch(new Object[]{pSlot, pOwningInstance, pFeature, pValue});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawCountMatches(new Object[]{pSlot, pOwningInstance, pFeature, pValue});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue, final IMatchProcessor<? super SlotsMatch> processor) {
    rawForEachMatch(new Object[]{pSlot, pOwningInstance, pFeature, pValue}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue, final IMatchProcessor<? super SlotsMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSlot, pOwningInstance, pFeature, pValue}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public SlotsMatch newMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return SlotsMatch.newMatch(pSlot, pOwningInstance, pFeature, pValue);
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
  public Set<Slot> getAllValuesOfslot(final SlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfslot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for slot.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Slot> getAllValuesOfslot(final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawAccumulateAllValuesOfslot(new Object[]{
    null, 
    pOwningInstance, 
    pFeature, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for owningInstance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<InstanceSpecification> rawAccumulateAllValuesOfowningInstance(final Object[] parameters) {
    Set<InstanceSpecification> results = new HashSet<InstanceSpecification>();
    rawAccumulateAllValues(POSITION_OWNINGINSTANCE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for owningInstance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfowningInstance() {
    return rawAccumulateAllValuesOfowningInstance(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for owningInstance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfowningInstance(final SlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfowningInstance(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for owningInstance.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<InstanceSpecification> getAllValuesOfowningInstance(final Slot pSlot, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return rawAccumulateAllValuesOfowningInstance(new Object[]{
    pSlot, 
    null, 
    pFeature, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for feature.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<StructuralFeature> rawAccumulateAllValuesOffeature(final Object[] parameters) {
    Set<StructuralFeature> results = new HashSet<StructuralFeature>();
    rawAccumulateAllValues(POSITION_FEATURE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for feature.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<StructuralFeature> getAllValuesOffeature() {
    return rawAccumulateAllValuesOffeature(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for feature.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<StructuralFeature> getAllValuesOffeature(final SlotsMatch partialMatch) {
    return rawAccumulateAllValuesOffeature(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for feature.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<StructuralFeature> getAllValuesOffeature(final Slot pSlot, final InstanceSpecification pOwningInstance, final ValueSpecification pValue) {
    return rawAccumulateAllValuesOffeature(new Object[]{
    pSlot, 
    pOwningInstance, 
    null, 
    pValue
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<ValueSpecification> rawAccumulateAllValuesOfvalue(final Object[] parameters) {
    Set<ValueSpecification> results = new HashSet<ValueSpecification>();
    rawAccumulateAllValues(POSITION_VALUE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfvalue() {
    return rawAccumulateAllValuesOfvalue(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfvalue(final SlotsMatch partialMatch) {
    return rawAccumulateAllValuesOfvalue(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for value.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<ValueSpecification> getAllValuesOfvalue(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature) {
    return rawAccumulateAllValuesOfvalue(new Object[]{
    pSlot, 
    pOwningInstance, 
    pFeature, 
    null
    });
  }
  
  @Override
  protected SlotsMatch tupleToMatch(final Tuple t) {
    try {
        return SlotsMatch.newMatch((Slot) t.get(POSITION_SLOT), (InstanceSpecification) t.get(POSITION_OWNINGINSTANCE), (StructuralFeature) t.get(POSITION_FEATURE), (ValueSpecification) t.get(POSITION_VALUE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SlotsMatch arrayToMatch(final Object[] match) {
    try {
        return SlotsMatch.newMatch((Slot) match[POSITION_SLOT], (InstanceSpecification) match[POSITION_OWNINGINSTANCE], (StructuralFeature) match[POSITION_FEATURE], (ValueSpecification) match[POSITION_VALUE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected SlotsMatch arrayToMatchMutable(final Object[] match) {
    try {
        return SlotsMatch.newMutableMatch((Slot) match[POSITION_SLOT], (InstanceSpecification) match[POSITION_OWNINGINSTANCE], (StructuralFeature) match[POSITION_FEATURE], (ValueSpecification) match[POSITION_VALUE]);
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
  public static IQuerySpecification<SlotsMatcher> querySpecification() throws ViatraQueryException {
    return SlotsQuerySpecification.instance();
  }
}
