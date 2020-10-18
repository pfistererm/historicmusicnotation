package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import de.pfist.historicmusicnotationtraining.util.I18NEnum;

@XmlType(name = "chord")
@XmlEnum
public enum AbsoluteChord implements I18NEnum {
	C_MAJOR(0, ChordType.MAJOR, ChordInversion.ROOT, "Chord.C"), //$NON-NLS-1$
	C_MAJOR_6(0, ChordType.MAJOR, ChordInversion.FIRST, "Chord.C6"), //$NON-NLS-1$
	C_MAJOR_64(0, ChordType.MAJOR, ChordInversion.SECOND, "Chord.C64"), //$NON-NLS-1$
	C_MINOR(0, ChordType.MINOR, ChordInversion.ROOT, "Chord.c"), //$NON-NLS-1$
	C_MINOR_6(0, ChordType.MINOR, ChordInversion.FIRST, "Chord.c6"), //$NON-NLS-1$
	C_MINOR_64(0, ChordType.MINOR, ChordInversion.SECOND, "Chord.c64"), //$NON-NLS-1$
	C_POWER(0, ChordType.POWER, ChordInversion.ROOT, "Chord.cp"), //$NON-NLS-1$
	C_POWER_64(0, ChordType.POWER, ChordInversion.SECOND, "Chord.cp64"), //$NON-NLS-1$
	CS_MAJOR(1, ChordType.MAJOR, ChordInversion.ROOT, "Chord.Cs"), //$NON-NLS-1$
	CS_MAJOR_6(1, ChordType.MAJOR, ChordInversion.FIRST, "Chord.Cs6"), //$NON-NLS-1$
	CS_MAJOR_64(1, ChordType.MAJOR, ChordInversion.SECOND, "Chord.Cs64"), //$NON-NLS-1$
	CS_MINOR(1, ChordType.MINOR, ChordInversion.ROOT, "Chord.cs"), //$NON-NLS-1$
	CS_MINOR_6(1, ChordType.MINOR, ChordInversion.FIRST, "Chord.cs6"), //$NON-NLS-1$
	CS_MINOR_64(1, ChordType.MINOR, ChordInversion.SECOND, "Chord.cs64"), //$NON-NLS-1$
	CS_POWER(1, ChordType.POWER, ChordInversion.ROOT, "Chord.csp"), //$NON-NLS-1$
	CS_POWER_64(1, ChordType.POWER, ChordInversion.SECOND, "Chord.csp64"), //$NON-NLS-1$
	D_MAJOR(2, ChordType.MAJOR, ChordInversion.ROOT, "Chord.D"), //$NON-NLS-1$
	D_MAJOR_6(2, ChordType.MAJOR, ChordInversion.FIRST, "Chord.D6"), //$NON-NLS-1$
	D_MAJOR_64(2, ChordType.MAJOR, ChordInversion.SECOND, "Chord.D64"), //$NON-NLS-1$
	D_MINOR(2, ChordType.MINOR, ChordInversion.ROOT, "Chord.d"), //$NON-NLS-1$
	D_MINOR_6(2, ChordType.MINOR, ChordInversion.FIRST, "Chord.d6"), //$NON-NLS-1$
	D_MINOR_64(2, ChordType.MINOR, ChordInversion.SECOND, "Chord.d64"), //$NON-NLS-1$
	D_POWER(2, ChordType.POWER, ChordInversion.ROOT, "Chord.dp"), //$NON-NLS-1$
	D_POWER_64(2, ChordType.POWER, ChordInversion.SECOND, "Chord.dp64"), //$NON-NLS-1$
	DS_MAJOR(3, ChordType.MAJOR, ChordInversion.ROOT, "Chord.Ds"), //$NON-NLS-1$
	DS_MAJOR_6(3, ChordType.MAJOR, ChordInversion.FIRST, "Chord.Ds6"), //$NON-NLS-1$
	DS_MAJOR_64(3, ChordType.MAJOR, ChordInversion.SECOND, "Chord.Ds64"), //$NON-NLS-1$
	DS_MINOR(3, ChordType.MINOR, ChordInversion.ROOT, "Chord.ds"), //$NON-NLS-1$
	DS_MINOR_6(3, ChordType.MINOR, ChordInversion.FIRST, "Chord.ds6"), //$NON-NLS-1$
	DS_MINOR_64(3, ChordType.MINOR, ChordInversion.SECOND, "Chord.ds64"), //$NON-NLS-1$
	DS_POWER(3, ChordType.POWER, ChordInversion.ROOT, "Chord.dsp"), //$NON-NLS-1$
	DS_POWER_64(3, ChordType.POWER, ChordInversion.SECOND, "Chord.dsp64"), //$NON-NLS-1$
	E_MAJOR(4, ChordType.MAJOR, ChordInversion.ROOT, "Chord.E"), //$NON-NLS-1$
	E_MAJOR_6(4, ChordType.MAJOR, ChordInversion.FIRST, "Chord.E6"), //$NON-NLS-1$
	E_MAJOR_64(4, ChordType.MAJOR, ChordInversion.SECOND, "Chord.E64"), //$NON-NLS-1$
	E_MINOR(4, ChordType.MINOR, ChordInversion.ROOT, "Chord.e"), //$NON-NLS-1$
	E_MINOR_6(4, ChordType.MINOR, ChordInversion.FIRST, "Chord.e6"), //$NON-NLS-1$
	E_MINOR_64(4, ChordType.MINOR, ChordInversion.SECOND, "Chord.e64"), //$NON-NLS-1$
	E_POWER(4, ChordType.POWER, ChordInversion.ROOT, "Chord.ep"), //$NON-NLS-1$
	E_POWER_64(4, ChordType.POWER, ChordInversion.SECOND, "Chord.ep64"), //$NON-NLS-1$
	F_MAJOR(5, ChordType.MAJOR, ChordInversion.ROOT, "Chord.F"), //$NON-NLS-1$
	F_MAJOR_6(5, ChordType.MAJOR, ChordInversion.FIRST, "Chord.F6"), //$NON-NLS-1$
	F_MAJOR_64(5, ChordType.MAJOR, ChordInversion.SECOND, "Chord.F64"), //$NON-NLS-1$
	F_MINOR(5, ChordType.MINOR, ChordInversion.ROOT, "Chord.f"), //$NON-NLS-1$
	F_MINOR_6(5, ChordType.MINOR, ChordInversion.FIRST, "Chord.f6"), //$NON-NLS-1$
	F_MINOR_64(5, ChordType.MINOR, ChordInversion.SECOND, "Chord.f64"), //$NON-NLS-1$
	F_POWER(5, ChordType.POWER, ChordInversion.ROOT, "Chord.fp"), //$NON-NLS-1$
	F_POWER_64(5, ChordType.POWER, ChordInversion.SECOND, "Chord.fp64"), //$NON-NLS-1$
	FS_MAJOR(6, ChordType.MAJOR, ChordInversion.ROOT, "Chord.Fs"), //$NON-NLS-1$
	FS_MAJOR_6(6, ChordType.MAJOR, ChordInversion.FIRST, "Chord.Fs6"), //$NON-NLS-1$
	FS_MAJOR_64(6, ChordType.MAJOR, ChordInversion.SECOND, "Chord.Fs64"), //$NON-NLS-1$
	FS_MINOR(6, ChordType.MINOR, ChordInversion.ROOT, "Chord.fs"), //$NON-NLS-1$
	FS_MINOR_6(6, ChordType.MINOR, ChordInversion.FIRST, "Chord.fs6"), //$NON-NLS-1$
	FS_MINOR_64(6, ChordType.MINOR, ChordInversion.SECOND, "Chord.fs64"), //$NON-NLS-1$
	FS_POWER(6, ChordType.POWER, ChordInversion.ROOT, "Chord.fsp"), //$NON-NLS-1$
	FS_POWER_64(6, ChordType.POWER, ChordInversion.SECOND, "Chord.fsp64"), //$NON-NLS-1$
	G_MAJOR(7, ChordType.MAJOR, ChordInversion.ROOT, "Chord.G"), //$NON-NLS-1$
	G_MAJOR_6(7, ChordType.MAJOR, ChordInversion.FIRST, "Chord.G6"), //$NON-NLS-1$
	G_MAJOR_64(7, ChordType.MAJOR, ChordInversion.SECOND, "Chord.G64"), //$NON-NLS-1$
	G_MINOR(7, ChordType.MINOR, ChordInversion.ROOT, "Chord.g"), //$NON-NLS-1$
	G_MINOR_6(7, ChordType.MINOR, ChordInversion.FIRST, "Chord.g6"), //$NON-NLS-1$
	G_MINOR_64(7, ChordType.MINOR, ChordInversion.SECOND, "Chord.g64"), //$NON-NLS-1$
	G_POWER(7, ChordType.POWER, ChordInversion.ROOT, "Chord.gp"), //$NON-NLS-1$
	G_POWER_64(7, ChordType.POWER, ChordInversion.SECOND, "Chord.gp64"), //$NON-NLS-1$
	GS_MAJOR(8, ChordType.MAJOR, ChordInversion.ROOT, "Chord.Gs"), //$NON-NLS-1$
	GS_MAJOR_6(8, ChordType.MAJOR, ChordInversion.FIRST, "Chord.Gs6"), //$NON-NLS-1$
	GS_MAJOR_64(8, ChordType.MAJOR, ChordInversion.SECOND, "Chord.Gs64"), //$NON-NLS-1$
	GS_MINOR(8, ChordType.MINOR, ChordInversion.ROOT, "Chord.gs"), //$NON-NLS-1$
	GS_MINOR_6(8, ChordType.MINOR, ChordInversion.FIRST, "Chord.gs6"), //$NON-NLS-1$
	GS_MINOR_64(8, ChordType.MINOR, ChordInversion.SECOND, "Chord.gs64"), //$NON-NLS-1$
	GS_POWER(8, ChordType.POWER, ChordInversion.ROOT, "Chord.gsp"), //$NON-NLS-1$
	GS_POWER_64(8, ChordType.POWER, ChordInversion.SECOND, "Chord.gsp64"), //$NON-NLS-1$
	A_MAJOR(9, ChordType.MAJOR, ChordInversion.ROOT, "Chord.A"), //$NON-NLS-1$
	A_MAJOR_6(9, ChordType.MAJOR, ChordInversion.FIRST, "Chord.A6"), //$NON-NLS-1$
	A_MAJOR_64(9, ChordType.MAJOR, ChordInversion.SECOND, "Chord.A64"), //$NON-NLS-1$
	A_MINOR(9, ChordType.MINOR, ChordInversion.ROOT, "Chord.a"), //$NON-NLS-1$
	A_MINOR_6(9, ChordType.MINOR, ChordInversion.FIRST, "Chord.a6"), //$NON-NLS-1$
	A_MINOR_64(9, ChordType.MINOR, ChordInversion.SECOND, "Chord.a64"), //$NON-NLS-1$
	A_POWER(9, ChordType.POWER, ChordInversion.ROOT, "Chord.ap"), //$NON-NLS-1$
	A_POWER_64(9, ChordType.POWER, ChordInversion.SECOND, "Chord.ap64"), //$NON-NLS-1$
	AS_MAJOR(10, ChordType.MAJOR, ChordInversion.ROOT, "Chord.As"), //$NON-NLS-1$
	AS_MAJOR_6(10, ChordType.MAJOR, ChordInversion.FIRST, "Chord.As6"), //$NON-NLS-1$
	AS_MAJOR_64(10, ChordType.MAJOR, ChordInversion.SECOND, "Chord.As64"), //$NON-NLS-1$
	AS_MINOR(10, ChordType.MINOR, ChordInversion.ROOT, "Chord.as"), //$NON-NLS-1$
	AS_MINOR_6(10, ChordType.MINOR, ChordInversion.FIRST, "Chord.as6"), //$NON-NLS-1$
	AS_MINOR_64(10, ChordType.MINOR, ChordInversion.SECOND, "Chord.as64"), //$NON-NLS-1$
	AS_POWER(10, ChordType.POWER, ChordInversion.ROOT, "Chord.asp"), //$NON-NLS-1$
	AS_POWER_64(10, ChordType.POWER, ChordInversion.SECOND, "Chord.asp64"), //$NON-NLS-1$
	B_MAJOR(11, ChordType.MAJOR, ChordInversion.ROOT, "Chord.B"), //$NON-NLS-1$
	B_MAJOR_6(11, ChordType.MAJOR, ChordInversion.FIRST, "Chord.B6"), //$NON-NLS-1$
	B_MAJOR_64(11, ChordType.MAJOR, ChordInversion.SECOND, "Chord.B64"), //$NON-NLS-1$
	B_MINOR(11, ChordType.MINOR, ChordInversion.ROOT, "Chord.b"), //$NON-NLS-1$
	B_MINOR_6(11, ChordType.MINOR, ChordInversion.FIRST, "Chord.b6"), //$NON-NLS-1$
	B_MINOR_64(11, ChordType.MINOR, ChordInversion.SECOND, "Chord.b64"), //$NON-NLS-1$
	B_POWER(11, ChordType.POWER, ChordInversion.ROOT, "Chord.bp"), //$NON-NLS-1$
	B_POWER_64(11, ChordType.POWER, ChordInversion.SECOND, "Chord.bp64"), //$NON-NLS-1$
	;

	private final int relativeIndex;
	private final ChordType chordType;
	private final ChordInversion chordInversion;
	private final String textKey;

	/**
	 * @param relativeIndex
	 * @param chordType
	 * @param chordInversion
	 * @param textKey
	 */
	private AbsoluteChord(int relativeIndex, ChordType chordType, ChordInversion chordInversion, String textKey) {
		this.relativeIndex = relativeIndex;
		this.chordType = chordType;
		this.chordInversion = chordInversion;
		this.textKey = textKey;
	}

	/**
	 * @return the chordType
	 */
	public final ChordType getChordType() {
		return chordType;
	}

	/**
	 * @return the chordInversion
	 */
	public final ChordInversion getChordInversion() {
		return chordInversion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}

	public static AbsoluteChord getChord(int relativeIndex, ChordType chordType, ChordInversion chordInversion) {
		for (AbsoluteChord chord : values()) {
			if (chord.relativeIndex == relativeIndex && chord.getChordType() == chordType && chord.chordInversion == chordInversion) {
				return chord;
			}
		}
		return null;
	}
}
