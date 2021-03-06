package de.pfist.historicmusicnotationtraining.domains.lute.german.chord;

import de.pfist.historicmusicnotationtraining.data.AbsoluteChord;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultChord;

public class GermanLuteTablatureChordsRandomResult extends AbstractRandomResultChord<LuteNote[]> {

	/**
	 * Constructor.
	 * 
	 * @param chord
	 * @param luteNotes
	 * @param midiNotes
	 */
	public GermanLuteTablatureChordsRandomResult(final AbsoluteChord chord, final LuteNote[] luteNotes, final int[] midiNotes) {
		super(luteNotes, chord, midiNotes);
	}

}
