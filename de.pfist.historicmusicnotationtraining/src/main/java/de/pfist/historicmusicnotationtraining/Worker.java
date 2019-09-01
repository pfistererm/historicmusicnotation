/**
 * 
 */
package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author matthias
 *
 */
public class Worker implements Runnable {

	public static final String RANDOM_RESULT = "RANDOM_RESULT"; //$NON-NLS-1$

	private PropertyChangeSupport propertyChangeSupport;

	private boolean withDelay;
	private DomainSpecificState domainSpecificState;
	private WorkerExtension<?, ?> workerExtension;

	public Worker(final DomainSpecificState domainSpecificState, final WorkerExtension<?, ?> workerExtension,
			final boolean withDelay) {
		this.withDelay = withDelay;
		this.domainSpecificState = domainSpecificState;
		this.workerExtension = workerExtension;
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		if (withDelay) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// DO NOTHING
			}
		}
		final DomainRandomResult randomResult = workerExtension.doRandom(domainSpecificState);
		propertyChangeSupport.firePropertyChange(RANDOM_RESULT, null, randomResult);
	}

	public static int randomInteger(final int range) {
		return (int) (Math.random() * range);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
}
