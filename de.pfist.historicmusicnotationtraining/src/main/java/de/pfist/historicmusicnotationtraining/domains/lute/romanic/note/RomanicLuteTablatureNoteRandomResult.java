package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.lute.AbstractLuteTablatureRandomResult;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.RomanicLuteTablatureVariant;

public class RomanicLuteTablatureNoteRandomResult extends AbstractLuteTablatureRandomResult {

	private final RomanicLuteTablatureVariant romanicLuteTablatureVariant;

	/**
	 * @param luteNote
	 * @param midiNote
	 * @param romanicLuteTablatureVariant
	 */
	public RomanicLuteTablatureNoteRandomResult(LuteNote luteNote, final int midiNote,
			final RomanicLuteTablatureVariant romanicLuteTablatureVariant) {
		super(luteNote, midiNote);
		this.romanicLuteTablatureVariant = romanicLuteTablatureVariant;
	}

	/**
	 * @return the romanicLuteTablatureVariant
	 */
	public final RomanicLuteTablatureVariant getRomanicLuteTablatureVariant() {
		return romanicLuteTablatureVariant;
	}

}
