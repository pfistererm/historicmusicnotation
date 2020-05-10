package de.pfist.historicmusicnotationtraining.domains;

import de.pfist.historicmusicnotationtraining.Chord;
import de.pfist.historicmusicnotationtraining.WorkerExtension;

/**
 * Base class for random results that represent a chord.
 * 
 * <p>Contains:</p>
 * <ul>
 * <li>A chord enum</li>
 * <li>An array of MIDI note numbers</li>
 * </ul>
 * 
 * <p>For use in implementations of {@link WorkerExtension}.</p>
 * 
 * @see AbstractRandomResultNote
 */
public abstract class AbstractRandomResultChord implements DomainRandomResult {

	private final Chord chord;
	private final int[] midiNotes;

	/**
	 * @param chord
	 * @param midiNotes
	 */
	protected AbstractRandomResultChord(final Chord chord, final int[] midiNotes) {
		this.chord = chord;
		this.midiNotes = midiNotes;
	}

	/**
	 * @return the chord
	 */
	public final Chord getChord() {
		return chord;
	}

	/**
	 * @return the midiNotes
	 */
	public final int[] getMidiNotes() {
		return midiNotes;
	}
}
