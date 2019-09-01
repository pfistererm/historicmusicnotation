package de.pfist.historicmusicnotationtraining;

public class GermanLuteTablatureDomainSpecificState extends AbstractLuteNoteDomainSpecificState
		implements IGermanLuteTablatureVariantState {

	private GermanLuteTablatureNotationVariant germanLuteTablatureNotationVariant = GermanLuteTablatureNotationVariant.WAISSEL;
	private GermanLuteTablatureFontVariant germanLuteTablatureFontVariant = GermanLuteTablatureFontVariant.ANTIQUA;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public de.pfist.historicmusicnotationtraining.GermanLuteTablatureNotationVariant getGermanLuteTablatureNotationVariant() {
		return germanLuteTablatureNotationVariant;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGermanLuteTablatureNotationVariant(
			GermanLuteTablatureNotationVariant germanLuteTablatureNotationVariant) {
		this.germanLuteTablatureNotationVariant = germanLuteTablatureNotationVariant;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GermanLuteTablatureFontVariant getGermanLuteTablatureFontVariant() {
		return germanLuteTablatureFontVariant;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setGermanLuteTablatureFontVariant(GermanLuteTablatureFontVariant germanLuteTablatureFontVariant) {
		this.germanLuteTablatureFontVariant = germanLuteTablatureFontVariant;
	}

}
