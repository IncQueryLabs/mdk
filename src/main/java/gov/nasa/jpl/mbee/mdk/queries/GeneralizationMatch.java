/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/UtilityQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries;

import gov.nasa.jpl.mbee.mdk.queries.util.GeneralizationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the gov.nasa.jpl.mbee.mdk.queries.generalization pattern,
 * to be used in conjunction with {@link GeneralizationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see GeneralizationMatcher
 *  @see GeneralizationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationMatch extends BasePatternMatch {
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fGeneral;
  
  private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fSpecific;
  
  private static List<String> parameterNames = makeImmutableList("general", "specific");
  
  private GeneralizationMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    this.fGeneral = pGeneral;
    this.fSpecific = pSpecific;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("general".equals(parameterName)) return this.fGeneral;
    if ("specific".equals(parameterName)) return this.fSpecific;
    return null;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getGeneral() {
    return this.fGeneral;
  }
  
  public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getSpecific() {
    return this.fSpecific;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("general".equals(parameterName) ) {
        this.fGeneral = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    if ("specific".equals(parameterName) ) {
        this.fSpecific = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
        return true;
    }
    return false;
  }
  
  public void setGeneral(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fGeneral = pGeneral;
  }
  
  public void setSpecific(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSpecific = pSpecific;
  }
  
  @Override
  public String patternName() {
    return "gov.nasa.jpl.mbee.mdk.queries.generalization";
  }
  
  @Override
  public List<String> parameterNames() {
    return GeneralizationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fGeneral, fSpecific};
  }
  
  @Override
  public GeneralizationMatch toImmutable() {
    return isMutable() ? newMatch(fGeneral, fSpecific) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"general\"=" + prettyPrintValue(fGeneral) + ", ");
    result.append("\"specific\"=" + prettyPrintValue(fSpecific));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fGeneral, fSpecific);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof GeneralizationMatch)) {
        GeneralizationMatch other = (GeneralizationMatch) obj;
        return Objects.equals(fGeneral, other.fGeneral) && Objects.equals(fSpecific, other.fSpecific);
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
  public GeneralizationQuerySpecification specification() {
    try {
        return GeneralizationQuerySpecification.instance();
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
  public static GeneralizationMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static GeneralizationMatch newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return new Mutable(pGeneral, pSpecific);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pGeneral the fixed value of pattern parameter general, or null if not bound.
   * @param pSpecific the fixed value of pattern parameter specific, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static GeneralizationMatch newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
    return new Immutable(pGeneral, pSpecific);
  }
  
  private static final class Mutable extends GeneralizationMatch {
    Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
      super(pGeneral, pSpecific);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends GeneralizationMatch {
    Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pGeneral, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSpecific) {
      super(pGeneral, pSpecific);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
