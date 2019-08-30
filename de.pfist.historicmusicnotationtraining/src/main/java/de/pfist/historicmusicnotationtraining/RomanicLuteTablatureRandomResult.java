package de.pfist.historicmusicnotationtraining;

public class RomanicLuteTablatureRandomResult extends AbstractLuteTablatureRandomResult {

	private final RomanicLuteTablatureVariant romanicLuteTablatureVariant;

	/**
	 * @param luteNote
	 * @param midiNote
	 * @param romanicLuteTablatureVariant
	 */
	public RomanicLuteTablatureRandomResult(LuteNote luteNote, final int midiNote,
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
