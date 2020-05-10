package de.pfist.historicmusicnotationtraining;

/**
 * NOTE: do not change order! Order correlaates with arrays in
 * {@link GermanLuteUtils}.
 * 
 *
 */
public enum GermanLuteTablatureNotationVariant implements I18NEnum {
	WAISSEL("GermanLuteTablatureNotationVariant.waissel"), //$NON-NLS-1$
	NEWSIDLER("GermanLuteTablatureNotationVariant.newsidler"), //$NON-NLS-1$
	JOBIN("GermanLuteTablatureNameVariant.jobin"), //$NON-NLS-1$
	HECKEL("GermanLuteTablatureNameVariant.heckel"), //$NON-NLS-1$
	GERLE("GermanLuteTablatureNameVariant.gerle"), //$NON-NLS-1$
	;

	private final String textKey;

	/**
	 * @param textKey
	 * @param lowestStringTop
	 */
	private GermanLuteTablatureNotationVariant(final String textKey) {
		this.textKey = textKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}
}
