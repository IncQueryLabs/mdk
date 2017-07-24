/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import gov.nasa.jpl.mbee.mdk.queries.util.CircularDependencyErrorQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.CircularDependencyError pattern,
 * to be used in conjunction with {@link CircularDependencyErrorMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CircularDependencyErrorMatcher
 * @see CircularDependencyErrorProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CircularDependencyErrorMatch extends BasePatternMatch {
  private Dependency fDep;
  
  private static List<String> parameterNames = makeImmutableList("dep");
  
  private CircularDependencyErrorMatch(final Dependency pDep) {
    this.fDep = pDep;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("dep".equals(parameterName)) return this.fDep;
    return null;
  }
  
  public Dependency getDep() {
    return this.fDep;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("dep".equals(parameterName) ) {
        this.fDep = (Dependency) newValue;
        return true;
    }
    return false;
  }
  
  public void setDep(final Dependency pDep) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDep = pDep;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.CircularDependencyError";
  }
  
  @Override
  public List<String> parameterNames() {
    return CircularDependencyErrorMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fDep};
  }
  
  @Override
  public CircularDependencyErrorMatch toImmutable() {
    return isMutable() ? newMatch(fDep) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"dep\"=" + prettyPrintValue(fDep)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fDep == null) ? 0 : fDep.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof CircularDependencyErrorMatch)) { // this should be infrequent
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
    CircularDependencyErrorMatch other = (CircularDependencyErrorMatch) obj;
    if (fDep == null) {if (other.fDep != null) return false;}
    else if (!fDep.equals(other.fDep)) return false;
    return true;
  }
  
  @Override
  public CircularDependencyErrorQuerySpecification specification() {
    try {
        return CircularDependencyErrorQuerySpecification.instance();
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
  public static CircularDependencyErrorMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CircularDependencyErrorMatch newMutableMatch(final Dependency pDep) {
    return new Mutable(pDep);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pDep the fixed value of pattern parameter dep, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CircularDependencyErrorMatch newMatch(final Dependency pDep) {
    return new Immutable(pDep);
  }
  
  private static final class Mutable extends CircularDependencyErrorMatch {
    Mutable(final Dependency pDep) {
      super(pDep);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CircularDependencyErrorMatch {
    Immutable(final Dependency pDep) {
      super(pDep);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
