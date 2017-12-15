/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import gov.nasa.jpl.mbee.mdk.queries.PropertyAttributesMatch;
import gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification;
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
 * Generated pattern matcher API of the gov.nasa.jpl.mbee.mdk.queries.propertyAttributes pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link PropertyAttributesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Queries Properties with a given name and type
 *   
 *  
 * pattern propertyAttributes(property : Property, name : java String, type : Type) {
 * 	Property.name(property, name);
 * 	Property.type(property, type);
 * }
 * </pre></code>
 * 
 * @see PropertyAttributesMatch
 *  @see PropertyAttributesProcessor
 * @see PropertyAttributesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class PropertyAttributesMatcher extends BaseMatcher<PropertyAttributesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public static PropertyAttributesMatcher on(final ViatraQueryEngine engine) {
    // check if matcher already exists
    PropertyAttributesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
        matcher = (PropertyAttributesMatcher)engine.getMatcher(querySpecification());
    }
    return matcher;
  }
  
  /**
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * @return an initialized matcher
   * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
   * 
   */
  public static PropertyAttributesMatcher create() {
    return new PropertyAttributesMatcher();
  }
  
  private final static int POSITION_PROPERTY = 0;
  
  private final static int POSITION_NAME = 1;
  
  private final static int POSITION_TYPE = 2;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PropertyAttributesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  private PropertyAttributesMatcher() {
    super(querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return matches represented as a PropertyAttributesMatch object.
   * 
   */
  public Collection<PropertyAttributesMatch> getAllMatches(final Property pProperty, final String pName, final Type pType) {
    return rawGetAllMatches(new Object[]{pProperty, pName, pType});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return a match represented as a PropertyAttributesMatch object, or null if no match is found.
   * 
   */
  public PropertyAttributesMatch getOneArbitraryMatch(final Property pProperty, final String pName, final Type pType) {
    return rawGetOneArbitraryMatch(new Object[]{pProperty, pName, pType});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Property pProperty, final String pName, final Type pType) {
    return rawHasMatch(new Object[]{pProperty, pName, pType});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Property pProperty, final String pName, final Type pType) {
    return rawCountMatches(new Object[]{pProperty, pName, pType});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Property pProperty, final String pName, final Type pType, final IMatchProcessor<? super PropertyAttributesMatch> processor) {
    rawForEachMatch(new Object[]{pProperty, pName, pType}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Property pProperty, final String pName, final Type pType, final IMatchProcessor<? super PropertyAttributesMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pProperty, pName, pType}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public PropertyAttributesMatch newMatch(final Property pProperty, final String pName, final Type pType) {
    return PropertyAttributesMatch.newMatch(pProperty, pName, pType);
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
  public Set<Property> getAllValuesOfproperty(final PropertyAttributesMatch partialMatch) {
    return rawAccumulateAllValuesOfproperty(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for property.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Property> getAllValuesOfproperty(final String pName, final Type pType) {
    return rawAccumulateAllValuesOfproperty(new Object[]{
    null, 
    pName, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfname(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_NAME, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname() {
    return rawAccumulateAllValuesOfname(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final PropertyAttributesMatch partialMatch) {
    return rawAccumulateAllValuesOfname(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for name.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfname(final Property pProperty, final Type pType) {
    return rawAccumulateAllValuesOfname(new Object[]{
    pProperty, 
    null, 
    pType
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  protected Set<Type> rawAccumulateAllValuesOftype(final Object[] parameters) {
    Set<Type> results = new HashSet<Type>();
    rawAccumulateAllValues(POSITION_TYPE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype() {
    return rawAccumulateAllValuesOftype(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final PropertyAttributesMatch partialMatch) {
    return rawAccumulateAllValuesOftype(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for type.
   * @return the Set of all values or empty set if there are no matches
   * 
   */
  public Set<Type> getAllValuesOftype(final Property pProperty, final String pName) {
    return rawAccumulateAllValuesOftype(new Object[]{
    pProperty, 
    pName, 
    null
    });
  }
  
  @Override
  protected PropertyAttributesMatch tupleToMatch(final Tuple t) {
    try {
        return PropertyAttributesMatch.newMatch((Property) t.get(POSITION_PROPERTY), (String) t.get(POSITION_NAME), (Type) t.get(POSITION_TYPE));
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in tuple not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected PropertyAttributesMatch arrayToMatch(final Object[] match) {
    try {
        return PropertyAttributesMatch.newMatch((Property) match[POSITION_PROPERTY], (String) match[POSITION_NAME], (Type) match[POSITION_TYPE]);
    } catch(ClassCastException e) {
        LOGGER.error("Element(s) in array not properly typed!",e);
        return null;
    }
  }
  
  @Override
  protected PropertyAttributesMatch arrayToMatchMutable(final Object[] match) {
    try {
        return PropertyAttributesMatch.newMutableMatch((Property) match[POSITION_PROPERTY], (String) match[POSITION_NAME], (Type) match[POSITION_TYPE]);
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
  public static IQuerySpecification<PropertyAttributesMatcher> querySpecification() {
    return PropertyAttributesQuerySpecification.instance();
  }
}
