package de.pfist.historicmusicnotationtraining;

public class CClefRandomResult extends AbstractRandomResultNote {

	private final ClefAndNote clefAndNote;

	/**
	 * @param midiNote
	 * @param clefAndNote
	 */
	public CClefRandomResult(final ClefAndNote clefAndNote, final int midiNote) {
		super(midiNote);
		this.clefAndNote = clefAndNote;
	}

	/**
	 * @return the clefAndNote
	 */
	public final ClefAndNote getClefAndNote() {
		return clefAndNote;
	}

}
