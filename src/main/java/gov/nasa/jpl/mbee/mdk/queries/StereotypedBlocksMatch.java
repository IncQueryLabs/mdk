/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/EventDrivenTransformationQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.StereotypedBlocksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocks pattern,
 * to be used in conjunction with {@link StereotypedBlocksMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StereotypedBlocksMatcher
 *  @see StereotypedBlocksProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StereotypedBlocksMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock;
  
  private Stereotype fStereotype;
  
  private Slot fSlot;
  
  private Property fProperty;
  
  private LiteralSpecification fValue;
  
  private static List<String> parameterNames = makeImmutableList("block", "stereotype", "slot", "property", "value");
  
  private StereotypedBlocksMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    this.fBlock = pBlock;
    this.fStereotype = pStereotype;
    this.fSlot = pSlot;
    this.fProperty = pProperty;
    this.fValue = pValue;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("block".equals(parameterName)) return this.fBlock;
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    if ("slot".equals(parameterName)) return this.fSlot;
    if ("property".equals(parameterName)) return this.fProperty;
    if ("value".equals(parameterName)) return this.fValue;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock() {
    return this.fBlock;
  }
  
  public Stereotype getStereotype() {
    return this.fStereotype;
  }
  
  public Slot getSlot() {
    return this.fSlot;
  }
  
  public Property getProperty() {
    return this.fProperty;
  }
  
  public LiteralSpecification getValue() {
    return this.fValue;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("block".equals(parameterName) ) {
        this.fBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("stereotype".equals(parameterName) ) {
        this.fStereotype = (Stereotype) newValue;
        return true;
    }
    if ("slot".equals(parameterName) ) {
        this.fSlot = (Slot) newValue;
        return true;
    }
    if ("property".equals(parameterName) ) {
        this.fProperty = (Property) newValue;
        return true;
    }
    if ("value".equals(parameterName) ) {
        this.fValue = (LiteralSpecification) newValue;
        return true;
    }
    return false;
  }
  
  public void setBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
  }
  
  public void setStereotype(final Stereotype pStereotype) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fStereotype = pStereotype;
  }
  
  public void setSlot(final Slot pSlot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSlot = pSlot;
  }
  
  public void setProperty(final Property pProperty) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fProperty = pProperty;
  }
  
  public void setValue(final LiteralSpecification pValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fValue = pValue;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.StereotypedBlocks";
  }
  
  @Override
  public List<String> parameterNames() {
    return StereotypedBlocksMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fStereotype, fSlot, fProperty, fValue};
  }
  
  @Override
  public StereotypedBlocksMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fStereotype, fSlot, fProperty, fValue) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype) + ", ");
    result.append("\"slot\"=" + prettyPrintValue(fSlot) + ", ");
    result.append("\"property\"=" + prettyPrintValue(fProperty) + ", ");
    result.append("\"value\"=" + prettyPrintValue(fValue));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fBlock, fStereotype, fSlot, fProperty, fValue);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof StereotypedBlocksMatch)) {
        StereotypedBlocksMatch other = (StereotypedBlocksMatch) obj;
        return Objects.equals(fBlock, other.fBlock) && Objects.equals(fStereotype, other.fStereotype) && Objects.equals(fSlot, other.fSlot) && Objects.equals(fProperty, other.fProperty) && Objects.equals(fValue, other.fValue);
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
  public StereotypedBlocksQuerySpecification specification() {
    try {
        return StereotypedBlocksQuerySpecification.instance();
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
  public static StereotypedBlocksMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pStereotype the fixed value of pattern parameter stereotype, or null if not bound.
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pProperty the fixed value of pattern parameter property, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StereotypedBlocksMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return new Mutable(pBlock, pStereotype, pSlot, pProperty, pValue);
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
  public static StereotypedBlocksMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
    return new Immutable(pBlock, pStereotype, pSlot, pProperty, pValue);
  }
  
  private static final class Mutable extends StereotypedBlocksMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
      super(pBlock, pStereotype, pSlot, pProperty, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StereotypedBlocksMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pValue) {
      super(pBlock, pStereotype, pSlot, pProperty, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
