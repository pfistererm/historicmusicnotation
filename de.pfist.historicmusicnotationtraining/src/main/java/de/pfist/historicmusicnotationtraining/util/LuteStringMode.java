package de.pfist.historicmusicnotationtraining.util;

public enum LuteStringMode implements I18NEnum {
	S0(0, "LuteStringMode.0"), //$NON-NLS-1$
	S1(1, "LuteStringMode.1"), //$NON-NLS-1$
	S2(2, "LuteStringMode.2"), //$NON-NLS-1$
	S3(3, "LuteStringMode.3"), //$NON-NLS-1$
	S4(4, "LuteStringMode.4"), //$NON-NLS-1$
	S5(5, "LuteStringMode.5"), //$NON-NLS-1$
	ALL(-1, "LuteStringMode.all"), //$NON-NLS-1$
	S45(-2, "LuteStringMode.45"), //$NON-NLS-1$
	S345(-3, "LuteStringMode.345"); //$NON-NLS-1$

	private static final LuteStringMode[] REAL_STRINGS = new LuteStringMode[] { S0, S1, S2, S3, S4, S5 };
	private final int stringIndex;
	private final String textKey;

	/**
	 * @param stringIndex
	 * @param textKey
	 */
	private LuteStringMode(final int stringIndex, final String textKey) {
		this.stringIndex = stringIndex;
		this.textKey = textKey;
	}

	/**
	 * @param luteTuning
	 * @return the offset
	 */
	public final int getOffset(final LuteTuning luteTuning) {
		return luteTuning.getMidiBaseNotes()[getStringIndex()];
	}

	/**
	 * @return the stringIndex
	 */
	public final int getStringIndex() {
		return stringIndex;
	}

	/**
	 * @param luteTuning
	 * @return the availableFrets
	 */
	public final int getAvailableFrets(final LuteTuning luteTuning) {
		return luteTuning.getFrets()[getStringIndex()];
	}

	public static final LuteStringMode[] getStringValues() {
		return REAL_STRINGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}

}
