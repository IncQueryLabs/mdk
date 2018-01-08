package gov.nasa.jpl.mbee.mdk.transformation.util;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexFeatureFilter;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.nomagic.magicdraw.core.Application;

public class EngineCreationUtil {
	@SuppressWarnings("deprecation")
	public static AdvancedViatraQueryEngine createEngine() throws ViatraQueryException {
		BaseIndexOptions baseIndexOptions = new BaseIndexOptions().withFeatureFilterConfiguration(new IBaseIndexFeatureFilter() {
			@Override
			public boolean isFiltered(EStructuralFeature arg0) {
				if (arg0 instanceof EReference && ((EReference)arg0).isContainment()) {
					return arg0.getName().contains("_from_");
				}
				return false;
			}
		}).withStrictNotificationMode(false);
		return AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(Application.getInstance().getProject().getModel(), baseIndexOptions));
	}
}
