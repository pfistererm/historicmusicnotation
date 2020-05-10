package de.pfist.historicmusicnotationtraining;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "chord")
@XmlEnum
public enum Chord implements I18NEnum {
	C_MAJOR(0, ChordType.MAJOR, "Chord.C"), //$NON-NLS-1$
	C_MINOR(0, ChordType.MINOR, "Chord.c"), //$NON-NLS-1$
	C_POWER(0, ChordType.POWER, "Chord.cp"), //$NON-NLS-1$
	CS_MAJOR(1, ChordType.MAJOR, "Chord.Cs"), //$NON-NLS-1$
	CS_MINOR(1, ChordType.MINOR, "Chord.cs"), //$NON-NLS-1$
	CS_POWER(1, ChordType.POWER, "Chord.csp"), //$NON-NLS-1$
	D_MAJOR(2, ChordType.MAJOR, "Chord.D"), //$NON-NLS-1$
	D_MINOR(2, ChordType.MINOR, "Chord.d"), //$NON-NLS-1$
	D_POWER(2, ChordType.POWER, "Chord.dp"), //$NON-NLS-1$
	DS_MAJOR(3, ChordType.MAJOR, "Chord.Ds"), //$NON-NLS-1$
	DS_MINOR(3, ChordType.MINOR, "Chord.ds"), //$NON-NLS-1$
	DS_POWER(3, ChordType.POWER, "Chord.dsp"), //$NON-NLS-1$
	E_MAJOR(4, ChordType.MAJOR, "Chord.E"), //$NON-NLS-1$
	E_MINOR(4, ChordType.MINOR, "Chord.e"), //$NON-NLS-1$
	E_POWER(4, ChordType.POWER, "Chord.ep"), //$NON-NLS-1$
	F_MAJOR(5, ChordType.MAJOR, "Chord.F"), //$NON-NLS-1$
	F_MINOR(5, ChordType.MINOR, "Chord.f"), //$NON-NLS-1$
	F_POWER(5, ChordType.POWER, "Chord.fp"), //$NON-NLS-1$
	FS_MAJOR(6, ChordType.MAJOR, "Chord.Fs"), //$NON-NLS-1$
	FS_MINOR(6, ChordType.MINOR, "Chord.fs"), //$NON-NLS-1$
	FS_POWER(6, ChordType.POWER, "Chord.fsp"), //$NON-NLS-1$
	G_MAJOR(7, ChordType.MAJOR, "Chord.G"), //$NON-NLS-1$
	G_MINOR(7, ChordType.MINOR, "Chord.g"), //$NON-NLS-1$
	G_POWER(7, ChordType.POWER, "Chord.gp"), //$NON-NLS-1$
	GS_MAJOR(8, ChordType.MAJOR, "Chord.Gs"), //$NON-NLS-1$
	GS_MINOR(8, ChordType.MINOR, "Chord.gs"), //$NON-NLS-1$
	GS_POWER(8, ChordType.POWER, "Chord.gsp"), //$NON-NLS-1$
	A_MAJOR(9, ChordType.MAJOR, "Chord.A"), //$NON-NLS-1$
	A_MINOR(9, ChordType.MINOR, "Chord.a"), //$NON-NLS-1$
	A_POWER(9, ChordType.POWER, "Chord.ap"), //$NON-NLS-1$
	AS_MAJOR(10, ChordType.MAJOR, "Chord.As"), //$NON-NLS-1$
	AS_MINOR(10, ChordType.MINOR, "Chord.as"), //$NON-NLS-1$
	AS_POWER(10, ChordType.POWER, "Chord.asp"), //$NON-NLS-1$
	B_MAJOR(11, ChordType.MAJOR, "Chord.B"), //$NON-NLS-1$
	B_MINOR(11, ChordType.MINOR, "Chord.b"), //$NON-NLS-1$
	B_POWER(11, ChordType.POWER, "Chord.bp"), //$NON-NLS-1$
	;

	private final int relativeIndex;
	private final ChordType chordType;
	private final String textKey;

	/**
	 * @param relativeIndex
	 * @param chordType
	 * @param textKey
	 */
	private Chord(int relativeIndex, ChordType chordType, String textKey) {
		this.relativeIndex = relativeIndex;
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

	public static Chord getChord(int relativeIndex, ChordType chordType) {
		for (Chord chord : values()) {
			if (chord.relativeIndex == relativeIndex && chord.getChordType() == chordType) {
				return chord;
			}
		}
		return null;
	}
}
