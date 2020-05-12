package de.pfist.historicmusicnotationtraining.domains.lute;

import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultNote;

public abstract class AbstractLuteTablatureRandomResult extends AbstractRandomResultNote<LuteNote> {

	/**
	 * @param luteNote
	 * @param midiNote
	 */
	public AbstractLuteTablatureRandomResult(LuteNote luteNote, int midiNote) {
		super(luteNote, midiNote);
	}
}
