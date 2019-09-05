package de.pfist.historicmusicnotationtraining;

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
