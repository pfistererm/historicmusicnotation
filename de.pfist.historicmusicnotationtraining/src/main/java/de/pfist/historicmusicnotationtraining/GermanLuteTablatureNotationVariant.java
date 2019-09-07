package de.pfist.historicmusicnotationtraining;

public enum GermanLuteTablatureNotationVariant implements I18NEnum {
	WAISSEL(true, false, "GermanLuteTablatureNotationVariant.waissel"), //$NON-NLS-1$
	NEWSIDLER(true, true, "GermanLuteTablatureNotationVariant.newsidler"), //$NON-NLS-1$
	JOBIN(false, true, "GermanLuteTablatureNameVariant.jobin"), //$NON-NLS-1$
	HECKEL(false, true, "GermanLuteTablatureNameVariant.heckel"), //$NON-NLS-1$
	GERLE(false, true, "GermanLuteTablatureNameVariant.gerle"), //$NON-NLS-1$
	;

	// TODO: cleanup
	private final boolean drawCharactersOnLine;
	private final boolean highestStringTop;
	private final String textKey;

	/**
	 * @param drawCharactersOnLine
	 * @param textKey
	 * @param lowestStringTop
	 */
	private GermanLuteTablatureNotationVariant(final boolean drawCharactersOnLine, final boolean highestStringTop,
			final String textKey) {

		this.drawCharactersOnLine = drawCharactersOnLine;
		this.highestStringTop = highestStringTop;
		this.textKey = textKey;
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
