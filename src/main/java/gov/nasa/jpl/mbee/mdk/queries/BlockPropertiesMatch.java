/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.mdprofiles.Stereotype;
import gov.nasa.jpl.mbee.mdk.queries.util.BlockPropertiesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.blockProperties pattern,
 * to be used in conjunction with {@link BlockPropertiesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlockPropertiesMatcher
 * @see BlockPropertiesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlockPropertiesMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock;
  
  private Stereotype fStereotype;
  
  private Slot fSlot;
  
  private Property fProperty;
  
  private LiteralSpecification fLiteral;
  
  private static List<String> parameterNames = makeImmutableList("block", "stereotype", "slot", "property", "literal");
  
  private BlockPropertiesMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    this.fBlock = pBlock;
    this.fStereotype = pStereotype;
    this.fSlot = pSlot;
    this.fProperty = pProperty;
    this.fLiteral = pLiteral;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("block".equals(parameterName)) return this.fBlock;
    if ("stereotype".equals(parameterName)) return this.fStereotype;
    if ("slot".equals(parameterName)) return this.fSlot;
    if ("property".equals(parameterName)) return this.fProperty;
    if ("literal".equals(parameterName)) return this.fLiteral;
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
  
  public LiteralSpecification getLiteral() {
    return this.fLiteral;
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
    if ("literal".equals(parameterName) ) {
        this.fLiteral = (LiteralSpecification) newValue;
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
  
  public void setLiteral(final LiteralSpecification pLiteral) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLiteral = pLiteral;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.blockProperties";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlockPropertiesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fStereotype, fSlot, fProperty, fLiteral};
  }
  
  @Override
  public BlockPropertiesMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fStereotype, fSlot, fProperty, fLiteral) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
    
    result.append("\"stereotype\"=" + prettyPrintValue(fStereotype) + ", ");
    
    result.append("\"slot\"=" + prettyPrintValue(fSlot) + ", ");
    
    result.append("\"property\"=" + prettyPrintValue(fProperty) + ", ");
    
    result.append("\"literal\"=" + prettyPrintValue(fLiteral)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fStereotype == null) ? 0 : fStereotype.hashCode());
    result = prime * result + ((fSlot == null) ? 0 : fSlot.hashCode());
    result = prime * result + ((fProperty == null) ? 0 : fProperty.hashCode());
    result = prime * result + ((fLiteral == null) ? 0 : fLiteral.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof BlockPropertiesMatch)) { // this should be infrequent
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
    BlockPropertiesMatch other = (BlockPropertiesMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fStereotype == null) {if (other.fStereotype != null) return false;}
    else if (!fStereotype.equals(other.fStereotype)) return false;
    if (fSlot == null) {if (other.fSlot != null) return false;}
    else if (!fSlot.equals(other.fSlot)) return false;
    if (fProperty == null) {if (other.fProperty != null) return false;}
    else if (!fProperty.equals(other.fProperty)) return false;
    if (fLiteral == null) {if (other.fLiteral != null) return false;}
    else if (!fLiteral.equals(other.fLiteral)) return false;
    return true;
  }
  
  @Override
  public BlockPropertiesQuerySpecification specification() {
    try {
        return BlockPropertiesQuerySpecification.instance();
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
  public static BlockPropertiesMatch newEmptyMatch() {
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
   * @param pLiteral the fixed value of pattern parameter literal, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BlockPropertiesMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return new Mutable(pBlock, pStereotype, pSlot, pProperty, pLiteral);
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
  public static BlockPropertiesMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
    return new Immutable(pBlock, pStereotype, pSlot, pProperty, pLiteral);
  }
  
  private static final class Mutable extends BlockPropertiesMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
      super(pBlock, pStereotype, pSlot, pProperty, pLiteral);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlockPropertiesMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final Stereotype pStereotype, final Slot pSlot, final Property pProperty, final LiteralSpecification pLiteral) {
      super(pBlock, pStereotype, pSlot, pProperty, pLiteral);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
