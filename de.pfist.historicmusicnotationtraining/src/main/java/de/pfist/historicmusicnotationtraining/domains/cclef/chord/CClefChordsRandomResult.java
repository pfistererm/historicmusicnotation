package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import de.pfist.historicmusicnotationtraining.data.AbsoluteChord;
import de.pfist.historicmusicnotationtraining.data.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultChord;

/**
 * Random result for C clef chords domain.
 * 
 * @see CClefChordsDomain
 */
public class CClefChordsRandomResult extends AbstractRandomResultChord<ClefAndNote[]> {

	/**
	 * @param chord
	 * @param clefAndNotes
	 * @param midiNotes
	 */
	public CClefChordsRandomResult(final AbsoluteChord chord, final ClefAndNote[] clefAndNotes, final int[] midiNotes) {
		super(clefAndNotes, chord, midiNotes);
	}
}
