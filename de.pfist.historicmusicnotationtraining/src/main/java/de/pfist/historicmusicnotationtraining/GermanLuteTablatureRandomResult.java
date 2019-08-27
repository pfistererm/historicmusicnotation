package de.pfist.historicmusicnotationtraining;

public class GermanLuteTablatureRandomResult extends AbstractRandomResultNote {

	private final LuteNote luteNote;

	/**
	 * @param luteNote
	 * @param midiNote
	 */
	public GermanLuteTablatureRandomResult(LuteNote luteNote, int midiNote) {
		super(midiNote);
		this.luteNote = luteNote;
	}

	/**
	 * @return the luteNote
	 */
	public final LuteNote getLuteNote() {
		return luteNote;
	}

}
