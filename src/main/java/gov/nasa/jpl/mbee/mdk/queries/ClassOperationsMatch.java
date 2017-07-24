/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Operation;
import gov.nasa.jpl.mbee.mdk.queries.util.ClassOperationsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.classOperations pattern,
 * to be used in conjunction with {@link ClassOperationsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ClassOperationsMatcher
 * @see ClassOperationsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ClassOperationsMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fClass;
  
  private Operation fOperation;
  
  private static List<String> parameterNames = makeImmutableList("class", "operation");
  
  private ClassOperationsMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final Operation pOperation) {
    this.fClass = pClass;
    this.fOperation = pOperation;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("class".equals(parameterName)) return this.fClass;
    if ("operation".equals(parameterName)) return this.fOperation;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getValueOfClass() {
    return this.fClass;
  }
  
  public Operation getOperation() {
    return this.fOperation;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("class".equals(parameterName) ) {
        this.fClass = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("operation".equals(parameterName) ) {
        this.fOperation = (Operation) newValue;
        return true;
    }
    return false;
  }
  
  public void setClass(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fClass = pClass;
  }
  
  public void setOperation(final Operation pOperation) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOperation = pOperation;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.classOperations";
  }
  
  @Override
  public List<String> parameterNames() {
    return ClassOperationsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fClass, fOperation};
  }
  
  @Override
  public ClassOperationsMatch toImmutable() {
    return isMutable() ? newMatch(fClass, fOperation) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"class\"=" + prettyPrintValue(fClass) + ", ");
    
    result.append("\"operation\"=" + prettyPrintValue(fOperation)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fClass == null) ? 0 : fClass.hashCode());
    result = prime * result + ((fOperation == null) ? 0 : fOperation.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof ClassOperationsMatch)) { // this should be infrequent
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
    ClassOperationsMatch other = (ClassOperationsMatch) obj;
    if (fClass == null) {if (other.fClass != null) return false;}
    else if (!fClass.equals(other.fClass)) return false;
    if (fOperation == null) {if (other.fOperation != null) return false;}
    else if (!fOperation.equals(other.fOperation)) return false;
    return true;
  }
  
  @Override
  public ClassOperationsQuerySpecification specification() {
    try {
        return ClassOperationsQuerySpecification.instance();
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
  public static ClassOperationsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ClassOperationsMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final Operation pOperation) {
    return new Mutable(pClass, pOperation);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pClass the fixed value of pattern parameter class, or null if not bound.
   * @param pOperation the fixed value of pattern parameter operation, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ClassOperationsMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final Operation pOperation) {
    return new Immutable(pClass, pOperation);
  }
  
  private static final class Mutable extends ClassOperationsMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final Operation pOperation) {
      super(pClass, pOperation);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ClassOperationsMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass, final Operation pOperation) {
      super(pClass, pOperation);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
