/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.FindCommonParentClassQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClass pattern,
 * to be used in conjunction with {@link FindCommonParentClassMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FindCommonParentClassMatcher
 *  @see FindCommonParentClassProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FindCommonParentClassMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock1;
  
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock2;
  
  private Property fAttribute1;
  
  private Property fAttribute2;
  
  private Stereotype fStereotype;
  
  private static List<String> parameterNames = makeImmutableList("block1", "block2", "attribute1", "attribute2", "stereotype");
  
  private FindCommonParentClassMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    this.fBlock1 = pBlock1;
    this.fBlock2 = pBlock2;
    this.fAttribute1 = pAttribute1;
    this.fAttribute2 = pAttribute2;
    this.fStereotype = pStereotype;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("block1".equals(parameterName)) return this.fBlock1;
    if ("block2".equals(parameterName)) return this.fBlock2;
    if ("attribute1".equals(parameterName)) return this.fAttribute1;
    if ("attribute2".equals(parameterName)) return this.fAttribute2;
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock1() {
    return this.fBlock1;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock2() {
    return this.fBlock2;
  }
  
  public Property getAttribute1() {
    return this.fAttribute1;
  }
  
  public Property getAttribute2() {
    return this.fAttribute2;
  }
  
  public Stereotype getStereotype() {
    return this.fStereotype;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("block1".equals(parameterName) ) {
        this.fBlock1 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("block2".equals(parameterName) ) {
        this.fBlock2 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("attribute1".equals(parameterName) ) {
        this.fAttribute1 = (Property) newValue;
        return true;
    }
    if ("attribute2".equals(parameterName) ) {
        this.fAttribute2 = (Property) newValue;
        return true;
    }
    if ("stereotype".equals(parameterName) ) {
        this.fStereotype = (Stereotype) newValue;
        return true;
    }
    return false;
  }
  
  public void setBlock1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock1 = pBlock1;
  }
  
  public void setBlock2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock2 = pBlock2;
  }
  
  public void setAttribute1(final Property pAttribute1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute1 = pAttribute1;
  }
  
  public void setAttribute2(final Property pAttribute2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAttribute2 = pAttribute2;
  }
  
  public void setStereotype(final Stereotype pStereotype) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStereotype = pStereotype;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.FindCommonParentClass";
  }
  
  @Override
  public List<String> parameterNames() {
    return FindCommonParentClassMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock1, fBlock2, fAttribute1, fAttribute2, fStereotype};
  }
  
  @Override
  public FindCommonParentClassMatch toImmutable() {
    return isMutable() ? newMatch(fBlock1, fBlock2, fAttribute1, fAttribute2, fStereotype) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"block1\"=" + prettyPrintValue(fBlock1) + ", ");
    result.append("\"block2\"=" + prettyPrintValue(fBlock2) + ", ");
    result.append("\"attribute1\"=" + prettyPrintValue(fAttribute1) + ", ");
    result.append("\"attribute2\"=" + prettyPrintValue(fAttribute2) + ", ");
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fBlock1, fBlock2, fAttribute1, fAttribute2, fStereotype);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof FindCommonParentClassMatch)) {
        FindCommonParentClassMatch other = (FindCommonParentClassMatch) obj;
        return Objects.equals(fBlock1, other.fBlock1) && Objects.equals(fBlock2, other.fBlock2) && Objects.equals(fAttribute1, other.fAttribute1) && Objects.equals(fAttribute2, other.fAttribute2) && Objects.equals(fStereotype, other.fStereotype);
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
  public FindCommonParentClassQuerySpecification specification() {
    return FindCommonParentClassQuerySpecification.instance();
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static FindCommonParentClassMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock1 the fixed value of pattern parameter block1, or null if not bound.
   * @param pBlock2 the fixed value of pattern parameter block2, or null if not bound.
   * @param pAttribute1 the fixed value of pattern parameter attribute1, or null if not bound.
   * @param pAttribute2 the fixed value of pattern parameter attribute2, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FindCommonParentClassMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return new Mutable(pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype);
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
  public static FindCommonParentClassMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
    return new Immutable(pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype);
  }
  
  private static final class Mutable extends FindCommonParentClassMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
      super(pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FindCommonParentClassMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock2, final Property pAttribute1, final Property pAttribute2, final Stereotype pStereotype) {
      super(pBlock1, pBlock2, pAttribute1, pAttribute2, pStereotype);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
