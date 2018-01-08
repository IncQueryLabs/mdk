/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import gov.nasa.jpl.mbee.mdk.queries.util.PropertyAttributesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.propertyAttributes pattern,
 * to be used in conjunction with {@link PropertyAttributesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PropertyAttributesMatcher
 *  @see PropertyAttributesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PropertyAttributesMatch extends BasePatternMatch {
  private Property fProperty;
  
  private String fName;
  
  private Type fType;
  
  private static List<String> parameterNames = makeImmutableList("property", "name", "type");
  
  private PropertyAttributesMatch(final Property pProperty, final String pName, final Type pType) {
    this.fProperty = pProperty;
    this.fName = pName;
    this.fType = pType;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("property".equals(parameterName)) return this.fProperty;
    if ("name".equals(parameterName)) return this.fName;
    if ("type".equals(parameterName)) return this.fType;
    return null;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  public String getName() {
    return this.fName;
  }
  
  public Type getType() {
    return this.fType;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("property".equals(parameterName) ) {
        this.fProperty = (Property) newValue;
        return true;
    }
    if ("name".equals(parameterName) ) {
        this.fName = (String) newValue;
        return true;
    }
    if ("type".equals(parameterName) ) {
        this.fType = (Type) newValue;
        return true;
    }
    return false;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  public void setName(final String pName) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fName = pName;
  }
  
  public void setType(final Type pType) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fType = pType;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.propertyAttributes";
  }
  
  @Override
  public List<String> parameterNames() {
    return PropertyAttributesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fProperty, fName, fType};
  }
  
  @Override
  public PropertyAttributesMatch toImmutable() {
    return isMutable() ? newMatch(fProperty, fName, fType) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"property\"=" + prettyPrintValue(fProperty) + ", ");
    result.append("\"name\"=" + prettyPrintValue(fName) + ", ");
    result.append("\"type\"=" + prettyPrintValue(fType));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fProperty, fName, fType);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof PropertyAttributesMatch)) {
        PropertyAttributesMatch other = (PropertyAttributesMatch) obj;
        return Objects.equals(fProperty, other.fProperty) && Objects.equals(fName, other.fName) && Objects.equals(fType, other.fType);
    } else {
        // this should be infrequent
        if (!(obj instanceof IPatternMatch)) {
            return false;
        }
        IPatternMatch otherSig  = (IPatternMatch) obj;
        return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
    }
  }
  
  @Override
  public PropertyAttributesQuerySpecification specification() {
    return PropertyAttributesQuerySpecification.instance();
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static PropertyAttributesMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pName the fixed value of pattern parameter name, or null if not bound.
   * @param pType the fixed value of pattern parameter type, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PropertyAttributesMatch newMutableMatch(final Property pProperty, final String pName, final Type pType) {
    return new Mutable(pProperty, pName, pType);
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
  public static PropertyAttributesMatch newMatch(final Property pProperty, final String pName, final Type pType) {
    return new Immutable(pProperty, pName, pType);
  }
  
  private static final class Mutable extends PropertyAttributesMatch {
    Mutable(final Property pProperty, final String pName, final Type pType) {
      super(pProperty, pName, pType);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PropertyAttributesMatch {
    Immutable(final Property pProperty, final String pName, final Type pType) {
      super(pProperty, pName, pType);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
