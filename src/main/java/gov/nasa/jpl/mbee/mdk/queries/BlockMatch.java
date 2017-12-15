/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.util.BlockQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.block pattern,
 * to be used in conjunction with {@link BlockMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlockMatcher
 *  @see BlockProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlockMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fClass;
  
  private static List<String> parameterNames = makeImmutableList("class");
  
  private BlockMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
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
    return "gov.nasa.jpl.mbee.mdk.queries.block";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlockMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass};
  }
  
  @Override
  public BlockMatch toImmutable() {
    return isMutable() ? newMatch(fClass) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fClass);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof BlockMatch)) {
        BlockMatch other = (BlockMatch) obj;
        return Objects.equals(fClass, other.fClass);
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
  public BlockQuerySpecification specification() {
    return BlockQuerySpecification.instance();
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static BlockMatch newEmptyMatch() {
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
  public static BlockMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
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
  public static BlockMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    return new Immutable(pClass);
  }
  
  private static final class Mutable extends BlockMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlockMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
      super(pClass);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
