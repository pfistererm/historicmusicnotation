package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import de.pfist.historicmusicnotationtraining.Chord;
import de.pfist.historicmusicnotationtraining.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultChord;

public class CClefChordsRandomResult extends AbstractRandomResultChord {

	private final ClefAndNote[] clefAndNotes;

	/**
	 * @param chord
	 * @param clefAndNotes
	 * @param midiNotes
	 */
	public CClefChordsRandomResult(final Chord chord, final ClefAndNote[] clefAndNotes, final int[] midiNotes) {
		super(chord, midiNotes);
		this.clefAndNotes = clefAndNotes;
	}

	/**
	 * @return the clefAndNote
	 */
	public final ClefAndNote[] getClefAndNotes() {
		return clefAndNotes;
	}

}
