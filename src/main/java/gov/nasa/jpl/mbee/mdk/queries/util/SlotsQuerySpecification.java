/**
 * Generated from platform:/resource/mdk.querygenerator/src/gov/nasa/jpl/mbee/mdk/queries/TestQueries.vql
 */
package gov.nasa.jpl.mbee.mdk.queries.util;

import com.google.common.collect.Sets;
import gov.nasa.jpl.mbee.mdk.queries.SlotsMatch;
import gov.nasa.jpl.mbee.mdk.queries.SlotsMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IInputKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.viatra.query.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SlotsMatcher in a type-safe way.
 * 
 * @see SlotsMatcher
 * @see SlotsMatch
 * 
 */
@SuppressWarnings("all")
public final class SlotsQuerySpecification extends BaseGeneratedEMFQuerySpecification<SlotsMatcher> {
  private SlotsQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static SlotsQuerySpecification instance() throws ViatraQueryException {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SlotsMatcher instantiate(final ViatraQueryEngine engine) throws ViatraQueryException {
    return SlotsMatcher.on(engine);
  }
  
  @Override
  public SlotsMatcher instantiate() throws ViatraQueryException {
    return SlotsMatcher.create();
  }
  
  @Override
  public SlotsMatch newEmptyMatch() {
    return SlotsMatch.newEmptyMatch();
  }
  
  @Override
  public SlotsMatch newMatch(final Object... parameters) {
    return SlotsMatch.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.StructuralFeature) parameters[2], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification) parameters[3]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SlotsQuerySpecification} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SlotsQuerySpecification#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static SlotsQuerySpecification INSTANCE = new SlotsQuerySpecification();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternalSneaky();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SlotsQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pSlot = new PParameter("slot", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Slot", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pOwningInstance = new PParameter("owningInstance", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pFeature = new PParameter("feature", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.StructuralFeature", (IInputKey)null, PParameterDirection.INOUT);
    
    private final PParameter parameter_pValue = new PParameter("value", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.ValueSpecification", (IInputKey)null, PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pSlot, parameter_pOwningInstance, parameter_pFeature, parameter_pValue);
    
    @Override
    public String getFullyQualifiedName() {
      return "gov.nasa.jpl.mbee.mdk.queries.slots";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("slot","owningInstance","feature","value");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      setEvaluationHints(new QueryEvaluationHint(null, (IQueryBackendFactory)null));
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
          {
              PBody body = new PBody(this);
              PVariable var_slot = body.getOrCreateVariableByName("slot");
              PVariable var_owningInstance = body.getOrCreateVariableByName("owningInstance");
              PVariable var_feature = body.getOrCreateVariableByName("feature");
              PVariable var_value = body.getOrCreateVariableByName("value");
              body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
                 new ExportedParameter(body, var_slot, parameter_pSlot),
                 new ExportedParameter(body, var_owningInstance, parameter_pOwningInstance),
                 new ExportedParameter(body, var_feature, parameter_pFeature),
                 new ExportedParameter(body, var_value, parameter_pValue)
              ));
              // 	Slot(slot)
              new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
              // 	Slot.owningInstance(slot, owningInstance)
              new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
              PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
              new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot", "owningInstance")));
              new TypeConstraint(body, new FlatTuple(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "InstanceSpecification")));
              new Equality(body, var__virtual_0_, var_owningInstance);
              // 	Slot.definingFeature(slot, feature)
              new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
              PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
              new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot", "definingFeature")));
              new TypeConstraint(body, new FlatTuple(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "StructuralFeature")));
              new Equality(body, var__virtual_1_, var_feature);
              // 	Slot.value(slot, value)
              new TypeConstraint(body, new FlatTuple(var_slot), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot")));
              PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
              new TypeConstraint(body, new FlatTuple(var_slot, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Slot", "value")));
              new TypeConstraint(body, new FlatTuple(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "ValueSpecification")));
              new Equality(body, var__virtual_2_, var_value);
              bodies.add(body);
          }
          // to silence compiler error
          if (false) throw new ViatraQueryException("Never", "happens");
      } catch (ViatraQueryException ex) {
          throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
