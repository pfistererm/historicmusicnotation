package de.pfist.historicmusicnotationtraining;

public enum Chord implements I18NEnum {
	C_MAJOR(ChordType.MAJOR, "Chord.C"), // //$NON-NLS-1$
	C_MINOR(ChordType.MINOR, "Chord.c"), // //$NON-NLS-1$
	C_POWER(ChordType.POWER, "Chord.cp"), // //$NON-NLS-1$
	CS_MAJOR(ChordType.MAJOR, "Chord.Cs"), // //$NON-NLS-1$
	CS_MINOR(ChordType.MINOR, "Chord.cs"), // //$NON-NLS-1$
	CS_POWER(ChordType.POWER, "Chord.csp"), // //$NON-NLS-1$
	D_MAJOR(ChordType.MAJOR, "Chord.D"), // //$NON-NLS-1$
	D_MINOR(ChordType.MINOR, "Chord.d"), // //$NON-NLS-1$
	D_POWER(ChordType.POWER, "Chord.dp"), // //$NON-NLS-1$
	DS_MAJOR(ChordType.MAJOR, "Chord.Ds"), // //$NON-NLS-1$
	DS_MINOR(ChordType.MINOR, "Chord.ds"), // //$NON-NLS-1$
	DS_POWER(ChordType.POWER, "Chord.dsp"), // //$NON-NLS-1$
	E_MAJOR(ChordType.MAJOR, "Chord.E"), // //$NON-NLS-1$
	E_MINOR(ChordType.MINOR, "Chord.e"), // //$NON-NLS-1$
	E_POWER(ChordType.POWER, "Chord.ep"), // //$NON-NLS-1$
	F_MAJOR(ChordType.MAJOR, "Chord.F"), // //$NON-NLS-1$
	F_MINOR(ChordType.MINOR, "Chord.f"), // //$NON-NLS-1$
	F_POWER(ChordType.POWER, "Chord.fp"), // //$NON-NLS-1$
	FS_MAJOR(ChordType.MAJOR, "Chord.Fs"), // //$NON-NLS-1$
	FS_MINOR(ChordType.MINOR, "Chord.fs"), // //$NON-NLS-1$
	FS_POWER(ChordType.POWER, "Chord.fsp"), // //$NON-NLS-1$
	G_MAJOR(ChordType.MAJOR, "Chord.G"), // //$NON-NLS-1$
	G_MINOR(ChordType.MINOR, "Chord.g"), // //$NON-NLS-1$
	G_POWER(ChordType.POWER, "Chord.gp"), // //$NON-NLS-1$
	GS_MAJOR(ChordType.MAJOR, "Chord.Gs"), // //$NON-NLS-1$
	GS_MINOR(ChordType.MINOR, "Chord.gs"), // //$NON-NLS-1$
	GS_POWER(ChordType.POWER, "Chord.gsp"), // //$NON-NLS-1$
	A_MAJOR(ChordType.MAJOR, "Chord.A"), // //$NON-NLS-1$
	A_MINOR(ChordType.MINOR, "Chord.a"), // //$NON-NLS-1$
	A_POWER(ChordType.POWER, "Chord.ap"), // //$NON-NLS-1$
	AS_MAJOR(ChordType.MAJOR, "Chord.As"), // //$NON-NLS-1$
	AS_MINOR(ChordType.MINOR, "Chord.as"), // //$NON-NLS-1$
	AS_POWER(ChordType.POWER, "Chord.asp"), // //$NON-NLS-1$
	B_MAJOR(ChordType.MAJOR, "Chord.B"), // //$NON-NLS-1$
	B_MINOR(ChordType.MINOR, "Chord.b"), // //$NON-NLS-1$
	B_POWER(ChordType.POWER, "Chord.bp"), // //$NON-NLS-1$
	;

	private final ChordType chordType;
	private final String textKey;

	/**
	 * @param chordType
	 * @param textKey
	 */
	private Chord(ChordType chordType, String textKey) {
		this.chordType = chordType;
		this.textKey = textKey;
	}

	/**
	 * @return the chordType
	 */
	public final ChordType getChordType() {
		return chordType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}

}
