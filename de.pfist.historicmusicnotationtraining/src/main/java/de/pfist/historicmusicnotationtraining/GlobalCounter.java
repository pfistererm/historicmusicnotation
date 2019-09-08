package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public class GlobalCounter {

	public static final String COUNTER_PROPERTY = "COUNTER_PROPERTY"; //$NON-NLS-1$

	private int successCount = 0;
	private int failureCount = 0;
	private int missedCount = 0;
	private Queue<AnswerState> queue = new CircularFifoQueue<>(170);

	private final PropertyChangeSupport propertyChangeSupport;

	public GlobalCounter() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public void increaseSuccessCount() {
		successCount++;
		queue.add(AnswerState.RIGHT);
		firePropertyChange();
	}

	public void increaseFailureCount() {
		failureCount++;
		queue.add(AnswerState.WRONG);
		firePropertyChange();
	}

	public void increaseMissedCount() {
		missedCount++;
		queue.add(AnswerState.WAITING);
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

	public AnswerState[] getQueueValues() {
		return queue.toArray(new AnswerState[0]);
	}

	private void firePropertyChange() {
		propertyChangeSupport.firePropertyChange(COUNTER_PROPERTY, 0, 1);
	}
}
