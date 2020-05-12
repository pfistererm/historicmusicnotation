package de.pfist.historicmusicnotationtraining.domains;

import de.pfist.historicmusicnotationtraining.WorkerExtension;

/**
 * Base class for random results that represent a single note.
 * 
 * <p>Contains:</p>
 * <ul>
 * <li>A single MIDI note number</li>
 * </ul>
 * 
 * <p>For use in implementations of {@link WorkerExtension}.</p>
 * 
 * @param <O> the type of the domain object
 * 
 * @see AbstractRandomResultChord
 */
public abstract class AbstractRandomResultNote<O> extends AbstractRandomResult<O> {

	private final int midiNote;

	/**
	 * @param domainObject 
	 * @param midiNote
	 */
	public AbstractRandomResultNote(final O domainObject, final int midiNote) {
		super(domainObject);
		this.midiNote = midiNote;
	}

	/**
	 * @return the midiNote
	 */
	public final int getMidiNote() {
		return midiNote;
	}

}
