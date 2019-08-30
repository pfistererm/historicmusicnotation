package de.pfist.historicmusicnotationtraining;

public abstract class AbstractLuteTablatureRandomResult extends AbstractRandomResultNote {

	private final LuteNote luteNote;

	/**
	 * @param luteNote
	 * @param midiNote
	 */
	public AbstractLuteTablatureRandomResult(LuteNote luteNote, int midiNote) {
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
