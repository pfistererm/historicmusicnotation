package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureFontVariant;
import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureNotationVariant;

public interface IGermanLuteTablatureVariantState {

	/**
	 * @return the germanLuteTablatureNotationVariant
	 */
	public GermanLuteTablatureNotationVariant getGermanLuteTablatureNotationVariant();

	/**
	 * @param germanLuteTablatureNotationVariant
	 *            the germanLuteTablatureNotationVariant to set
	 */
	public void setGermanLuteTablatureNotationVariant(
			GermanLuteTablatureNotationVariant germanLuteTablatureNotationVariant);

	// GermanLuteTablatureFontVariant
	/**
	 * @return the germanLuteTablatureNotationVariant
	 */
	public GermanLuteTablatureFontVariant getGermanLuteTablatureFontVariant();

	/**
	 * @param germanLuteTablatureFontVariant
	 *            the germanLuteTablatureNotationVariant to set
	 */
	public void setGermanLuteTablatureFontVariant(GermanLuteTablatureFontVariant germanLuteTablatureFontVariant);
}
