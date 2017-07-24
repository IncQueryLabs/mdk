/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.stereotypes pattern,
 * to be used in conjunction with {@link StereotypesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StereotypesMatcher
 * @see StereotypesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StereotypesMatch extends BasePatternMatch {
  private Stereotype fStereotype;
  
  private Property fAttribute;
  
  private static List<String> parameterNames = makeImmutableList("stereotype", "attribute");
  
  private StereotypesMatch(final Stereotype pStereotype, final Property pAttribute) {
    this.fStereotype = pStereotype;
    this.fAttribute = pAttribute;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    if ("attribute".equals(parameterName)) return this.fAttribute;
    return null;
  }
  
  public Stereotype getStereotype() {
    return this.fStereotype;
  }
  
  public Property getAttribute() {
    return this.fAttribute;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("stereotype".equals(parameterName) ) {
        this.fStereotype = (Stereotype) newValue;
        return true;
    }
    if ("attribute".equals(parameterName) ) {
        this.fAttribute = (Property) newValue;
        return true;
    }
    return false;
  }
  
  public void setStereotype(final Stereotype pStereotype) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStereotype = pStereotype;
  }
  
  public void setAttribute(final Property pAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute = pAttribute;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.stereotypes";
  }
  
  @Override
  public List<String> parameterNames() {
    return StereotypesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStereotype, fAttribute};
  }
  
  @Override
  public StereotypesMatch toImmutable() {
    return isMutable() ? newMatch(fStereotype, fAttribute) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype) + ", ");
    
    result.append("\"attribute\"=" + prettyPrintValue(fAttribute)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fStereotype == null) ? 0 : fStereotype.hashCode());
    result = prime * result + ((fAttribute == null) ? 0 : fAttribute.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof StereotypesMatch)) { // this should be infrequent
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof IPatternMatch)) {
            return false;
        }
        IPatternMatch otherSig  = (IPatternMatch) obj;
        if (!specification().equals(otherSig.specification()))
            return false;
        return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    StereotypesMatch other = (StereotypesMatch) obj;
    if (fStereotype == null) {if (other.fStereotype != null) return false;}
    else if (!fStereotype.equals(other.fStereotype)) return false;
    if (fAttribute == null) {if (other.fAttribute != null) return false;}
    else if (!fAttribute.equals(other.fAttribute)) return false;
    return true;
  }
  
  @Override
  public StereotypesQuerySpecification specification() {
    try {
        return StereotypesQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
         // This cannot happen, as the match object can only be instantiated if the query specification exists
         throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static StereotypesMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StereotypesMatch newMutableMatch(final Stereotype pStereotype, final Property pAttribute) {
    return new Mutable(pStereotype, pAttribute);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pAttribute the fixed value of pattern parameter attribute, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StereotypesMatch newMatch(final Stereotype pStereotype, final Property pAttribute) {
    return new Immutable(pStereotype, pAttribute);
  }
  
  private static final class Mutable extends StereotypesMatch {
    Mutable(final Stereotype pStereotype, final Property pAttribute) {
      super(pStereotype, pAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StereotypesMatch {
    Immutable(final Stereotype pStereotype, final Property pAttribute) {
      super(pStereotype, pAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
