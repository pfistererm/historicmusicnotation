package de.pfist.historicmusicnotationtraining.domains.cclef.note;

import de.pfist.historicmusicnotationtraining.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultNote;

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
