/**
 * 
 */
package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

/**
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

	/**
	 * <p>This method is especially intended for use in the implementation of {@link WorkerExtension#doRandom(DomainSpecificState)}.</p>
	 * @param range
	 * @return a random integer value
	 */
	public static int randomInteger(final int range) {
		return (int) (Math.random() * range);
	}

	/**
	 * Adds a property change listener.
	 * 
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
}
