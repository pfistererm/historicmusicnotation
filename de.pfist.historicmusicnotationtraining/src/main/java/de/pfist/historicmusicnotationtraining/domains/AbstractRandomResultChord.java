package de.pfist.historicmusicnotationtraining.domains;

import de.pfist.historicmusicnotationtraining.Chord;

/**
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
