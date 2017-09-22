/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.UsedStereotypesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.usedStereotypes pattern,
 * to be used in conjunction with {@link UsedStereotypesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UsedStereotypesMatcher
 *  @see UsedStereotypesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class UsedStereotypesMatch extends BasePatternMatch {
  private Stereotype fStereotype;
  
  private static List<String> parameterNames = makeImmutableList("stereotype");
  
  private UsedStereotypesMatch(final Stereotype pStereotype) {
    this.fStereotype = pStereotype;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    return null;
  }
  
  public Stereotype getStereotype() {
    return this.fStereotype;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("stereotype".equals(parameterName) ) {
        this.fStereotype = (Stereotype) newValue;
        return true;
    }
    return false;
  }
  
  public void setStereotype(final Stereotype pStereotype) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStereotype = pStereotype;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.usedStereotypes";
  }
  
  @Override
  public List<String> parameterNames() {
    return UsedStereotypesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fStereotype};
  }
  
  @Override
  public UsedStereotypesMatch toImmutable() {
    return isMutable() ? newMatch(fStereotype) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fStereotype);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof UsedStereotypesMatch)) {
        UsedStereotypesMatch other = (UsedStereotypesMatch) obj;
        return Objects.equals(fStereotype, other.fStereotype);
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
  public UsedStereotypesQuerySpecification specification() {
    try {
        return UsedStereotypesQuerySpecification.instance();
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
  public static UsedStereotypesMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static UsedStereotypesMatch newMutableMatch(final Stereotype pStereotype) {
    return new Mutable(pStereotype);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static UsedStereotypesMatch newMatch(final Stereotype pStereotype) {
    return new Immutable(pStereotype);
  }
  
  private static final class Mutable extends UsedStereotypesMatch {
    Mutable(final Stereotype pStereotype) {
      super(pStereotype);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends UsedStereotypesMatch {
    Immutable(final Stereotype pStereotype) {
      super(pStereotype);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
