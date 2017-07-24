/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.util.BlocksWithTaggedValuesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.blocksWithTaggedValues pattern,
 * to be used in conjunction with {@link BlocksWithTaggedValuesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlocksWithTaggedValuesMatcher
 * @see BlocksWithTaggedValuesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlocksWithTaggedValuesMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock;
  
  private String fLower;
  
  private String fHigher;
  
  private static List<String> parameterNames = makeImmutableList("block", "lower", "higher");
  
  private BlocksWithTaggedValuesMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    this.fBlock = pBlock;
    this.fLower = pLower;
    this.fHigher = pHigher;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("block".equals(parameterName)) return this.fBlock;
    if ("lower".equals(parameterName)) return this.fLower;
    if ("higher".equals(parameterName)) return this.fHigher;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock() {
    return this.fBlock;
  }
  
  public String getLower() {
    return this.fLower;
  }
  
  public String getHigher() {
    return this.fHigher;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("block".equals(parameterName) ) {
        this.fBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("lower".equals(parameterName) ) {
        this.fLower = (String) newValue;
        return true;
    }
    if ("higher".equals(parameterName) ) {
        this.fHigher = (String) newValue;
        return true;
    }
    return false;
  }
  
  public void setBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlock = pBlock;
  }
  
  public void setLower(final String pLower) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLower = pLower;
  }
  
  public void setHigher(final String pHigher) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fHigher = pHigher;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.blocksWithTaggedValues";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlocksWithTaggedValuesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlock, fLower, fHigher};
  }
  
  @Override
  public BlocksWithTaggedValuesMatch toImmutable() {
    return isMutable() ? newMatch(fBlock, fLower, fHigher) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
    
    result.append("\"lower\"=" + prettyPrintValue(fLower) + ", ");
    
    result.append("\"higher\"=" + prettyPrintValue(fHigher)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlock == null) ? 0 : fBlock.hashCode());
    result = prime * result + ((fLower == null) ? 0 : fLower.hashCode());
    result = prime * result + ((fHigher == null) ? 0 : fHigher.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof BlocksWithTaggedValuesMatch)) { // this should be infrequent
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
    BlocksWithTaggedValuesMatch other = (BlocksWithTaggedValuesMatch) obj;
    if (fBlock == null) {if (other.fBlock != null) return false;}
    else if (!fBlock.equals(other.fBlock)) return false;
    if (fLower == null) {if (other.fLower != null) return false;}
    else if (!fLower.equals(other.fLower)) return false;
    if (fHigher == null) {if (other.fHigher != null) return false;}
    else if (!fHigher.equals(other.fHigher)) return false;
    return true;
  }
  
  @Override
  public BlocksWithTaggedValuesQuerySpecification specification() {
    try {
        return BlocksWithTaggedValuesQuerySpecification.instance();
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
  public static BlocksWithTaggedValuesMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BlocksWithTaggedValuesMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return new Mutable(pBlock, pLower, pHigher);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlock the fixed value of pattern parameter block, or null if not bound.
   * @param pLower the fixed value of pattern parameter lower, or null if not bound.
   * @param pHigher the fixed value of pattern parameter higher, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BlocksWithTaggedValuesMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
    return new Immutable(pBlock, pLower, pHigher);
  }
  
  private static final class Mutable extends BlocksWithTaggedValuesMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
      super(pBlock, pLower, pHigher);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlocksWithTaggedValuesMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final String pLower, final String pHigher) {
      super(pBlock, pLower, pHigher);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
