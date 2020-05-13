package de.pfist.historicmusicnotationtraining.domains;

import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.data.Chord;

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
 * @param <O> the type of the domain object
 * 
 * @see AbstractRandomResultNote
 */
public abstract class AbstractRandomResultChord<O> extends AbstractRandomResult<O> {

	private final Chord chord;
	private final int[] midiNotes;

	/**
	 * @param chord
	 * @param midiNotes
	 */
	protected AbstractRandomResultChord(final O domainObject, final Chord chord, final int[] midiNotes) {
		super(domainObject);
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
