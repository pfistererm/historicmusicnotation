package de.pfist.historicmusicnotationtraining.domains.cclef.note;

import de.pfist.historicmusicnotationtraining.data.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultNote;

public class CClefRandomResult extends AbstractRandomResultNote<ClefAndNote> {

	/**
	 * @param midiNote
	 * @param clefAndNote
	 */
	public CClefRandomResult(final ClefAndNote clefAndNote, final int midiNote) {
		super(clefAndNote, midiNote);
	}
}
