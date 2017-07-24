/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.StructuralFeature;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification;
import gov.nasa.jpl.mbee.mdk.queries.util.SlotsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.slots pattern,
 * to be used in conjunction with {@link SlotsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SlotsMatcher
 * @see SlotsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SlotsMatch extends BasePatternMatch {
  private Slot fSlot;
  
  private InstanceSpecification fOwningInstance;
  
  private StructuralFeature fFeature;
  
  private ValueSpecification fValue;
  
  private static List<String> parameterNames = makeImmutableList("slot", "owningInstance", "feature", "value");
  
  private SlotsMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    this.fSlot = pSlot;
    this.fOwningInstance = pOwningInstance;
    this.fFeature = pFeature;
    this.fValue = pValue;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("slot".equals(parameterName)) return this.fSlot;
    if ("owningInstance".equals(parameterName)) return this.fOwningInstance;
    if ("feature".equals(parameterName)) return this.fFeature;
    if ("value".equals(parameterName)) return this.fValue;
    return null;
  }
  
  public Slot getSlot() {
    return this.fSlot;
  }
  
  public InstanceSpecification getOwningInstance() {
    return this.fOwningInstance;
  }
  
  public StructuralFeature getFeature() {
    return this.fFeature;
  }
  
  public ValueSpecification getValue() {
    return this.fValue;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("slot".equals(parameterName) ) {
        this.fSlot = (Slot) newValue;
        return true;
    }
    if ("owningInstance".equals(parameterName) ) {
        this.fOwningInstance = (InstanceSpecification) newValue;
        return true;
    }
    if ("feature".equals(parameterName) ) {
        this.fFeature = (StructuralFeature) newValue;
        return true;
    }
    if ("value".equals(parameterName) ) {
        this.fValue = (ValueSpecification) newValue;
        return true;
    }
    return false;
  }
  
  public void setSlot(final Slot pSlot) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSlot = pSlot;
  }
  
  public void setOwningInstance(final InstanceSpecification pOwningInstance) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOwningInstance = pOwningInstance;
  }
  
  public void setFeature(final StructuralFeature pFeature) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fFeature = pFeature;
  }
  
  public void setValue(final ValueSpecification pValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fValue = pValue;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.slots";
  }
  
  @Override
  public List<String> parameterNames() {
    return SlotsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSlot, fOwningInstance, fFeature, fValue};
  }
  
  @Override
  public SlotsMatch toImmutable() {
    return isMutable() ? newMatch(fSlot, fOwningInstance, fFeature, fValue) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"slot\"=" + prettyPrintValue(fSlot) + ", ");
    
    result.append("\"owningInstance\"=" + prettyPrintValue(fOwningInstance) + ", ");
    
    result.append("\"feature\"=" + prettyPrintValue(fFeature) + ", ");
    
    result.append("\"value\"=" + prettyPrintValue(fValue)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSlot == null) ? 0 : fSlot.hashCode());
    result = prime * result + ((fOwningInstance == null) ? 0 : fOwningInstance.hashCode());
    result = prime * result + ((fFeature == null) ? 0 : fFeature.hashCode());
    result = prime * result + ((fValue == null) ? 0 : fValue.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof SlotsMatch)) { // this should be infrequent
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
    SlotsMatch other = (SlotsMatch) obj;
    if (fSlot == null) {if (other.fSlot != null) return false;}
    else if (!fSlot.equals(other.fSlot)) return false;
    if (fOwningInstance == null) {if (other.fOwningInstance != null) return false;}
    else if (!fOwningInstance.equals(other.fOwningInstance)) return false;
    if (fFeature == null) {if (other.fFeature != null) return false;}
    else if (!fFeature.equals(other.fFeature)) return false;
    if (fValue == null) {if (other.fValue != null) return false;}
    else if (!fValue.equals(other.fValue)) return false;
    return true;
  }
  
  @Override
  public SlotsQuerySpecification specification() {
    try {
        return SlotsQuerySpecification.instance();
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
  public static SlotsMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSlot the fixed value of pattern parameter slot, or null if not bound.
   * @param pOwningInstance the fixed value of pattern parameter owningInstance, or null if not bound.
   * @param pFeature the fixed value of pattern parameter feature, or null if not bound.
   * @param pValue the fixed value of pattern parameter value, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SlotsMatch newMutableMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return new Mutable(pSlot, pOwningInstance, pFeature, pValue);
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
  public static SlotsMatch newMatch(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
    return new Immutable(pSlot, pOwningInstance, pFeature, pValue);
  }
  
  private static final class Mutable extends SlotsMatch {
    Mutable(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
      super(pSlot, pOwningInstance, pFeature, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SlotsMatch {
    Immutable(final Slot pSlot, final InstanceSpecification pOwningInstance, final StructuralFeature pFeature, final ValueSpecification pValue) {
      super(pSlot, pOwningInstance, pFeature, pValue);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
