package gov.nasa.jpl.mbee.mdk.transformation.eventdriven;

import java.beans.PropertyChangeEvent;
import java.util.Collection;

import org.eclipse.viatra.transformation.evm.api.ScheduledExecution;
import org.eclipse.viatra.transformation.evm.api.Scheduler;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.transaction.TransactionCommitListener;
import com.nomagic.uml2.transaction.TransactionManager;

public class StereotypedTransformationScheduler extends Scheduler implements TransactionCommitListener{

	public StereotypedTransformationScheduler(ScheduledExecution execution) {
		super(execution);
    	TransactionManager transactionManager = Application.getInstance().getProject().getRepository().getTransactionManager();
    	transactionManager.addTransactionCommitListener(this);
		
	}

	@Override
	public Runnable transactionCommited(Collection<PropertyChangeEvent> arg0) {
		return new Runnable() {
			
			@Override
			public void run() {
				schedule();
				
			}
		};
	}
	
	@Override
	public void dispose() {
    	TransactionManager transactionManager = Application.getInstance().getProject().getRepository().getTransactionManager();
    	transactionManager.removeTransactionCommitListener(this);
		super.dispose();
	}

}
