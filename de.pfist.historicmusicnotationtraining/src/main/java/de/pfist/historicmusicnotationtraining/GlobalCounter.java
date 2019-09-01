package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GlobalCounter {

	public static final String COUNTER_PROPERTY = "COUNTER_PROPERTY";

	private int successCount = 0;
	private int failureCount = 0;
	private int missedCount = 0;

	private final PropertyChangeSupport propertyChangeSupport;

	public GlobalCounter() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public void increaseSuccessCount() {
		successCount++;
		firePropertyChange();
	}

	public void increaseFailureCount() {
		failureCount++;
		firePropertyChange();
	}

	public void increaseMissedCount() {
		missedCount++;
		firePropertyChange();
	}

	/**
	 * @return the successCount
	 */
	public final int getSuccessCount() {
		return successCount;
	}

	/**
	 * @return the failureCount
	 */
	public final int getFailureCount() {
		return failureCount;
	}

	/**
	 * @return the missedCount
	 */
	public final int getMissedCount() {
		return missedCount;
	}

	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	private void firePropertyChange() {
		propertyChangeSupport.firePropertyChange(COUNTER_PROPERTY, 0, 1);
	}
}
