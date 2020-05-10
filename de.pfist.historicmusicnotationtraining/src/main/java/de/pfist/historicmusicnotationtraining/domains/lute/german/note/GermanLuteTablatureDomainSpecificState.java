package de.pfist.historicmusicnotationtraining.domains.lute.german.note;

import de.pfist.historicmusicnotationtraining.IGermanLuteTablatureVariantState;
import de.pfist.historicmusicnotationtraining.domains.lute.AbstractLuteNoteDomainSpecificState;

public class GermanLuteTablatureDomainSpecificState extends AbstractLuteNoteDomainSpecificState
		implements IGermanLuteTablatureVariantState {

	private GermanLuteTablatureNotationVariant germanLuteTablatureNotationVariant = GermanLuteTablatureNotationVariant.WAISSEL;
	private GermanLuteTablatureFontVariant germanLuteTablatureFontVariant = GermanLuteTablatureFontVariant.FRACTURA;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public de.pfist.historicmusicnotationtraining.domains.lute.german.note.GermanLuteTablatureNotationVariant getGermanLuteTablatureNotationVariant() {
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
