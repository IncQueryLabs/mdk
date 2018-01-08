/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizedTaggedBlockPairsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlockPairs pattern,
 * to be used in conjunction with {@link GeneralizedTaggedBlockPairsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GeneralizedTaggedBlockPairsMatcher
 *  @see GeneralizedTaggedBlockPairsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizedTaggedBlockPairsMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fParentBlock;
  
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fChildBlock;
  
  private Stereotype fStereotype;
  
  private Property fParentAttribute;
  
  private Property fChildAttribute;
  
  private static List<String> parameterNames = makeImmutableList("parentBlock", "childBlock", "stereotype", "parentAttribute", "childAttribute");
  
  private GeneralizedTaggedBlockPairsMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    this.fParentBlock = pParentBlock;
    this.fChildBlock = pChildBlock;
    this.fStereotype = pStereotype;
    this.fParentAttribute = pParentAttribute;
    this.fChildAttribute = pChildAttribute;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parentBlock".equals(parameterName)) return this.fParentBlock;
    if ("childBlock".equals(parameterName)) return this.fChildBlock;
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    if ("parentAttribute".equals(parameterName)) return this.fParentAttribute;
    if ("childAttribute".equals(parameterName)) return this.fChildAttribute;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getParentBlock() {
    return this.fParentBlock;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getChildBlock() {
    return this.fChildBlock;
  }
  
  public Stereotype getStereotype() {
    return this.fStereotype;
  }
  
  public Property getParentAttribute() {
    return this.fParentAttribute;
  }
  
  public Property getChildAttribute() {
    return this.fChildAttribute;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parentBlock".equals(parameterName) ) {
        this.fParentBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("childBlock".equals(parameterName) ) {
        this.fChildBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("stereotype".equals(parameterName) ) {
        this.fStereotype = (Stereotype) newValue;
        return true;
    }
    if ("parentAttribute".equals(parameterName) ) {
        this.fParentAttribute = (Property) newValue;
        return true;
    }
    if ("childAttribute".equals(parameterName) ) {
        this.fChildAttribute = (Property) newValue;
        return true;
    }
    return false;
  }
  
  public void setParentBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParentBlock = pParentBlock;
  }
  
  public void setChildBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChildBlock = pChildBlock;
  }
  
  public void setStereotype(final Stereotype pStereotype) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStereotype = pStereotype;
  }
  
  public void setParentAttribute(final Property pParentAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParentAttribute = pParentAttribute;
  }
  
  public void setChildAttribute(final Property pChildAttribute) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChildAttribute = pChildAttribute;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.generalizedTaggedBlockPairs";
  }
  
  @Override
  public List<String> parameterNames() {
    return GeneralizedTaggedBlockPairsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParentBlock, fChildBlock, fStereotype, fParentAttribute, fChildAttribute};
  }
  
  @Override
  public GeneralizedTaggedBlockPairsMatch toImmutable() {
    return isMutable() ? newMatch(fParentBlock, fChildBlock, fStereotype, fParentAttribute, fChildAttribute) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parentBlock\"=" + prettyPrintValue(fParentBlock) + ", ");
    result.append("\"childBlock\"=" + prettyPrintValue(fChildBlock) + ", ");
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype) + ", ");
    result.append("\"parentAttribute\"=" + prettyPrintValue(fParentAttribute) + ", ");
    result.append("\"childAttribute\"=" + prettyPrintValue(fChildAttribute));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fParentBlock, fChildBlock, fStereotype, fParentAttribute, fChildAttribute);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof GeneralizedTaggedBlockPairsMatch)) {
        GeneralizedTaggedBlockPairsMatch other = (GeneralizedTaggedBlockPairsMatch) obj;
        return Objects.equals(fParentBlock, other.fParentBlock) && Objects.equals(fChildBlock, other.fChildBlock) && Objects.equals(fStereotype, other.fStereotype) && Objects.equals(fParentAttribute, other.fParentAttribute) && Objects.equals(fChildAttribute, other.fChildAttribute);
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
  public GeneralizedTaggedBlockPairsQuerySpecification specification() {
    return GeneralizedTaggedBlockPairsQuerySpecification.instance();
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static GeneralizedTaggedBlockPairsMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParentBlock the fixed value of pattern parameter parentBlock, or null if not bound.
   * @param pChildBlock the fixed value of pattern parameter childBlock, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pParentAttribute the fixed value of pattern parameter parentAttribute, or null if not bound.
   * @param pChildAttribute the fixed value of pattern parameter childAttribute, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GeneralizedTaggedBlockPairsMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return new Mutable(pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute);
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
  public static GeneralizedTaggedBlockPairsMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
    return new Immutable(pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute);
  }
  
  private static final class Mutable extends GeneralizedTaggedBlockPairsMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
      super(pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GeneralizedTaggedBlockPairsMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParentBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pChildBlock, final Stereotype pStereotype, final Property pParentAttribute, final Property pChildAttribute) {
      super(pParentBlock, pChildBlock, pStereotype, pParentAttribute, pChildAttribute);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
