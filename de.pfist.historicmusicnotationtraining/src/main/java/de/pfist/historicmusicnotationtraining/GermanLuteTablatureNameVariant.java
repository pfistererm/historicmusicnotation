package de.pfist.historicmusicnotationtraining;

// TODO: further use this enum
public enum GermanLuteTablatureNameVariant implements I18NEnum {
	ANTIQUA_1(false, false, true, "GermanLuteTablatureNameVariant.french"), //$NON-NLS-1$
	ANTIQUA_2(false, false, true, "GermanLuteTablatureNameVariant.french"), //$NON-NLS-1$
	FRACTURA_1(true, true, false, "GermanLuteTablatureNameVariant.italian"), //$NON-NLS-1$
	FRACTURA_2(true, true, true, "GermanLuteTablatureNameVariant.spanish"), //$NON-NLS-1$
	;

	private final boolean useSmufl;
	private final boolean drawCharactersOnLine;
	private final boolean highestStringTop;
	private final String textKey;

	/**
	 * @param useSmufl
	 * @param drawCharactersOnLine
	 * @param lowestStringTop
	 * @param textKey
	 */
	private GermanLuteTablatureNameVariant(final boolean useSmufl, final boolean drawCharactersOnLine,
			final boolean highestStringTop, final String textKey) {
		this.useSmufl = useSmufl;
		this.drawCharactersOnLine = drawCharactersOnLine;
		this.highestStringTop = highestStringTop;
		this.textKey = textKey;
	}

	/**
	 * @return the useLetters
	 */
	public final boolean isUseSmufl() {
		return useSmufl;
	}

	/**
	 * @return the drawCharactersOnLine
	 */
	public final boolean isDrawCharactersOnLine() {
		return drawCharactersOnLine;
	}

	/**
	 * @return the lowestStringTop
	 */
	public final boolean isHighestStringTop() {
		return highestStringTop;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}
}
