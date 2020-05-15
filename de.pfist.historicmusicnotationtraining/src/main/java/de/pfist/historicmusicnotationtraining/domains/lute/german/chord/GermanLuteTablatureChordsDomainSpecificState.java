package de.pfist.historicmusicnotationtraining.domains.lute.german.chord;

import de.pfist.historicmusicnotationtraining.domains.lute.AbstractLuteDomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureFontVariant;
import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureNotationVariant;
import de.pfist.historicmusicnotationtraining.domains.lute.german.IGermanLuteTablatureVariantState;

public class GermanLuteTablatureChordsDomainSpecificState extends AbstractLuteDomainSpecificState
		implements IGermanLuteTablatureVariantState {

	private GermanLuteTablatureNotationVariant germanLuteTablatureNotationVariant = GermanLuteTablatureNotationVariant.WAISSEL;
	private GermanLuteTablatureFontVariant germanLuteTablatureFontVariant = GermanLuteTablatureFontVariant.FRACTURA;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GermanLuteTablatureNotationVariant getGermanLuteTablatureNotationVariant() {
		return germanLuteTablatureNotationVariant;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setGermanLuteTablatureNotationVariant(
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
