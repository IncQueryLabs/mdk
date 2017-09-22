package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import org.eclipse.viatra.transformation.evm.api.ScheduledExecution;
import org.eclipse.viatra.transformation.evm.api.Scheduler;
import org.eclipse.viatra.transformation.evm.api.Scheduler.ISchedulerFactory;
import org.eclipse.viatra.transformation.evm.update.IUpdateCompleteProvider;

public class StereotypedTransformationSchedulerFactory implements ISchedulerFactory{

	private IUpdateCompleteProvider provider;

    /**
     * @return the provider
     */
    public IUpdateCompleteProvider getProvider() {
        return provider;
    }

    /**
     * Creates a scheduler factory for the given provider.
     * 
     * @param provider
     */
    public StereotypedTransformationSchedulerFactory(final IUpdateCompleteProvider provider) {
        this.provider = provider;
    }

    @Override
    public Scheduler prepareScheduler(final ScheduledExecution execution) {
    	return new StereotypedTransformationScheduler(execution);
    }

}
