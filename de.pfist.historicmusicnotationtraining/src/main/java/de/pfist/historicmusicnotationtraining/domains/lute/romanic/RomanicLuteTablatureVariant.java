package de.pfist.historicmusicnotationtraining.domains.lute.romanic;

import de.pfist.historicmusicnotationtraining.I18NEnum;

public enum RomanicLuteTablatureVariant implements I18NEnum {
	FRENCH(true, false, true, "RomanicLuteTablatureVariant.french"), //$NON-NLS-1$
	ITALIAN(false, true, false, "RomanicLuteTablatureVariant.italian"), //$NON-NLS-1$
	SPANISH(false, true, true, "RomanicLuteTablatureVariant.spanish"), //$NON-NLS-1$
	;

	private final boolean useLetters;
	private final boolean drawCharactersOnLine;
	private final boolean highestStringTop;
	private final String textKey;

	/**
	 * @param useLetters
	 * @param drawCharactersOnLine
	 * @param lowestStringTop
	 * @param textKey
	 */
	private RomanicLuteTablatureVariant(final boolean useLetters, final boolean drawCharactersOnLine,
			final boolean highestStringTop, final String textKey) {
		this.useLetters = useLetters;
		this.drawCharactersOnLine = drawCharactersOnLine;
		this.highestStringTop = highestStringTop;
		this.textKey = textKey;
	}

	/**
	 * @return the useLetters
	 */
	public final boolean isUseLetters() {
		return useLetters;
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
