package de.pfist.historicmusicnotationtraining.util;

public enum KeyMode implements I18NEnum {
	CHROMATIC(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }, "KeyMode.chromatic"), //$NON-NLS-1$
	Bb_MAJOR(new int[] { 0, 2, 3, 5, 7, 9, 10 }, "KeyMode.Bb"), //$NON-NLS-1$
	F_MAJOR(new int[] { 0, 2, 4, 5, 7, 9, 10 }, "KeyMode.F"), //$NON-NLS-1$
	C_MAJOR(new int[] { 0, 2, 4, 5, 7, 9, 11 }, "KeyMode.C"), //$NON-NLS-1$
	G_MAJOR(new int[] { 0, 2, 4, 6, 7, 9, 11 }, "KeyMode.G"), //$NON-NLS-1$
	D_MAJOR(new int[] { 1, 2, 4, 6, 7, 9, 11 }, "KeyMode.D"), //$NON-NLS-1$
	A_MAJOR(new int[] { 1, 2, 4, 6, 8, 9, 11 }, "KeyMode.A"), //$NON-NLS-1$
	E_MAJOR(new int[] { 1, 3, 4, 6, 8, 9, 11 }, "KeyMode.E"), //$NON-NLS-1$
	;

	private final int[] midiNoteOffsets;
	private final String textKey;

	/**
	 * @param textKey
	 */
	private KeyMode(final int offsets[], String textKey) {
		this.midiNoteOffsets = offsets;
		this.textKey = textKey;
	}

	/**
	 * @return the offset
	 */
	public final int[] getOffsets() {
		return midiNoteOffsets;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}

}
