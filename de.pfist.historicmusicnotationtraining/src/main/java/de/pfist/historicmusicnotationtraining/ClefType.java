package de.pfist.historicmusicnotationtraining;

public enum ClefType {
	G_CLEF(0, "ClefType.g"), // //$NON-NLS-1$
	C_CLEF(0, "ClefType.c"), // //$NON-NLS-1$
	F_CLEF(-2, "ClefType.f"), // //$NON-NLS-1$
	;

	private final int offset;
	private final String textKey;

	/**
	 * @param textKey
	 * 
	 */
	private ClefType(final int offset, String textKey) {
		this.offset = offset;
		this.textKey = textKey;
	}

	/**
	 * @return the offset
	 */
	public final int getOffset() {
		return offset;
	}

	/**
	 * @return the textKey
	 */
	public final String getTextKey() {
		return textKey;
	}

}
