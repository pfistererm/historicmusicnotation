package de.pfist.historicmusicnotationtraining;

public class RomanicLuteTablatureDomainSpecificState extends AbstractLuteNoteDomainSpecificState
		implements IRomanicLuteTablatureVariantState {

	private RomanicLuteTablatureVariant romanicLuteTablatureVariant = RomanicLuteTablatureVariant.FRENCH;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final RomanicLuteTablatureVariant getRomanicLuteTablatureVariant() {
		return romanicLuteTablatureVariant;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRomanicLuteTablatureVariant(RomanicLuteTablatureVariant romanicLuteTablatureVariant) {
		this.romanicLuteTablatureVariant = romanicLuteTablatureVariant;
	}

}
