/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import gov.nasa.jpl.mbee.mdk.queries.util.DependenciesQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.dependencies pattern,
 * to be used in conjunction with {@link DependenciesMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DependenciesMatcher
 * @see DependenciesProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DependenciesMatch extends BasePatternMatch {
  private Dependency fDependency;
  
  private NamedElement fSource;
  
  private NamedElement fTarget;
  
  private static List<String> parameterNames = makeImmutableList("dependency", "source", "target");
  
  private DependenciesMatch(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget) {
    this.fDependency = pDependency;
    this.fSource = pSource;
    this.fTarget = pTarget;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("dependency".equals(parameterName)) return this.fDependency;
    if ("source".equals(parameterName)) return this.fSource;
    if ("target".equals(parameterName)) return this.fTarget;
    return null;
  }
  
  public Dependency getDependency() {
    return this.fDependency;
  }
  
  public NamedElement getSource() {
    return this.fSource;
  }
  
  public NamedElement getTarget() {
    return this.fTarget;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("dependency".equals(parameterName) ) {
        this.fDependency = (Dependency) newValue;
        return true;
    }
    if ("source".equals(parameterName) ) {
        this.fSource = (NamedElement) newValue;
        return true;
    }
    if ("target".equals(parameterName) ) {
        this.fTarget = (NamedElement) newValue;
        return true;
    }
    return false;
  }
  
  public void setDependency(final Dependency pDependency) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDependency = pDependency;
  }
  
  public void setSource(final NamedElement pSource) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSource = pSource;
  }
  
  public void setTarget(final NamedElement pTarget) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTarget = pTarget;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.dependencies";
  }
  
  @Override
  public List<String> parameterNames() {
    return DependenciesMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fDependency, fSource, fTarget};
  }
  
  @Override
  public DependenciesMatch toImmutable() {
    return isMutable() ? newMatch(fDependency, fSource, fTarget) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"dependency\"=" + prettyPrintValue(fDependency) + ", ");
    
    result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
    
    result.append("\"target\"=" + prettyPrintValue(fTarget)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fDependency == null) ? 0 : fDependency.hashCode());
    result = prime * result + ((fSource == null) ? 0 : fSource.hashCode());
    result = prime * result + ((fTarget == null) ? 0 : fTarget.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof DependenciesMatch)) { // this should be infrequent
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
    DependenciesMatch other = (DependenciesMatch) obj;
    if (fDependency == null) {if (other.fDependency != null) return false;}
    else if (!fDependency.equals(other.fDependency)) return false;
    if (fSource == null) {if (other.fSource != null) return false;}
    else if (!fSource.equals(other.fSource)) return false;
    if (fTarget == null) {if (other.fTarget != null) return false;}
    else if (!fTarget.equals(other.fTarget)) return false;
    return true;
  }
  
  @Override
  public DependenciesQuerySpecification specification() {
    try {
        return DependenciesQuerySpecification.instance();
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
  public static DependenciesMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pDependency the fixed value of pattern parameter dependency, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DependenciesMatch newMutableMatch(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget) {
    return new Mutable(pDependency, pSource, pTarget);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pDependency the fixed value of pattern parameter dependency, or null if not bound.
   * @param pSource the fixed value of pattern parameter source, or null if not bound.
   * @param pTarget the fixed value of pattern parameter target, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DependenciesMatch newMatch(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget) {
    return new Immutable(pDependency, pSource, pTarget);
  }
  
  private static final class Mutable extends DependenciesMatch {
    Mutable(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget) {
      super(pDependency, pSource, pTarget);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DependenciesMatch {
    Immutable(final Dependency pDependency, final NamedElement pSource, final NamedElement pTarget) {
      super(pDependency, pSource, pTarget);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
