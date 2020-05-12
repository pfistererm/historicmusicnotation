package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import de.pfist.historicmusicnotationtraining.Chord;
import de.pfist.historicmusicnotationtraining.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultChord;

public class CClefChordsRandomResult extends AbstractRandomResultChord<ClefAndNote[]> {

	/**
	 * @param chord
	 * @param clefAndNotes
	 * @param midiNotes
	 */
	public CClefChordsRandomResult(final Chord chord, final ClefAndNote[] clefAndNotes, final int[] midiNotes) {
		super(clefAndNotes, chord, midiNotes);
	}
}
