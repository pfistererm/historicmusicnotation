package de.pfist.historicmusicnotationtraining;

public class GermanLuteTablatureChordsRandomResult extends AbstractRandomResultChord {

	private final LuteNote[] luteNotes;

	/**
	 * Constructor.
	 * 
	 * @param chord
	 * @param luteNotes
	 * @param midiNotes
	 */
	public GermanLuteTablatureChordsRandomResult(final Chord chord, final LuteNote[] luteNotes, final int[] midiNotes) {
		super(chord, midiNotes);
		this.luteNotes = luteNotes;
	}

	/**
	 * @return the notes
	 */
	public final LuteNote[] getNotes() {
		return luteNotes;
	}

}
