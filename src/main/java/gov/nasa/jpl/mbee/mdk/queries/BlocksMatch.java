/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.util.BlocksQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.blocks pattern,
 * to be used in conjunction with {@link BlocksMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlocksMatcher
 * @see BlocksProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlocksMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fClass;
  
  private static List<String> parameterNames = makeImmutableList("class");
  
  private BlocksMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    this.fClass = pClass;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("class".equals(parameterName)) return this.fClass;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getValueOfClass() {
    return this.fClass;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("class".equals(parameterName) ) {
        this.fClass = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    return false;
  }
  
  public void setClass(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClass = pClass;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.blocks";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlocksMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass};
  }
  
  @Override
  public BlocksMatch toImmutable() {
    return isMutable() ? newMatch(fClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClass == null) ? 0 : fClass.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof BlocksMatch)) { // this should be infrequent
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
    BlocksMatch other = (BlocksMatch) obj;
    if (fClass == null) {if (other.fClass != null) return false;}
    else if (!fClass.equals(other.fClass)) return false;
    return true;
  }
  
  @Override
  public BlocksQuerySpecification specification() {
    try {
        return BlocksQuerySpecification.instance();
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
  public static BlocksMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BlocksMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return new Mutable(pClass);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BlocksMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return new Immutable(pClass);
  }
  
  private static final class Mutable extends BlocksMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlocksMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
