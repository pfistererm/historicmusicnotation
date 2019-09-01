package de.pfist.historicmusicnotationtraining;

public enum GermanLuteTablatureFontVariant implements I18NEnum {
	FRACTURA(true, "GermanLuteTablatureFontVariant.fractura"), //$NON-NLS-1$
	ANTIQUA(false, "GermanLuteTablatureFontVariant.antiqua"), //$NON-NLS-1$
	;

	private final boolean useSmufl;
	private final String textKey;

	/**
	 * @param useSmufl
	 * @param textKey
	 * @param lowestStringTop
	 */
	private GermanLuteTablatureFontVariant(final boolean useSmufl, final String textKey) {
		this.useSmufl = useSmufl;
		this.textKey = textKey;
	}

	/**
	 * @return the useLetters
	 */
	public final boolean isUseSmufl() {
		return useSmufl;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}
}
