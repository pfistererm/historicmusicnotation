package de.pfist.historicmusicnotationtraining.domains;

import de.pfist.historicmusicnotationtraining.WorkerExtension;

/**
 * Base class for random results.
 * 
 * <p>Contains:</p>
 * <ul>
 * <li>A domain specific object</li>
 * </ul>
 * 
 * <p>For use in implementations of {@link WorkerExtension}.</p>
 * 
 * @param <O> the type of the domain object
 * 
 * @see MusicDomain
 * 
 */
public abstract class AbstractRandomResult<O> implements DomainRandomResult {

	private final O domainObject;

	/**
	 * @param chord
	 * @param midiNotes
	 */
	protected AbstractRandomResult(final O domainObject) {
		this.domainObject = domainObject;
	}

	/**
	 * @return the domainObject
	 */
	public final O getDomainObject() {
		return domainObject;
	}
}
