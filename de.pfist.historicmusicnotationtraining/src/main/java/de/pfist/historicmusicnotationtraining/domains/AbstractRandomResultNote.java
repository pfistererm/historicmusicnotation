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
 * @see AbstractRandomResultChord
 */
public abstract class AbstractRandomResultNote implements DomainRandomResult {

	private final int midiNote;

	/**
	 * @param midiNote
	 */
	public AbstractRandomResultNote(final int midiNote) {
		this.midiNote = midiNote;
	}

	/**
	 * @return the midiNote
	 */
	public final int getMidiNote() {
		return midiNote;
	}

}
