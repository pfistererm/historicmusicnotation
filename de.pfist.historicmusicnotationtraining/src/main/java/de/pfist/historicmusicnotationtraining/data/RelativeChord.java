package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RelativeChord")
@XmlEnum
public enum RelativeChord {
	_0_MAJOR(0, ChordType.MAJOR, ChordInversion.ROOT), //
	_0_MAJOR_6(0, ChordType.MAJOR, ChordInversion.FIRST), //
	_0_MAJOR_64(0, ChordType.MAJOR, ChordInversion.SECOND), //
	_0_MINOR(0, ChordType.MINOR, ChordInversion.ROOT), //
	_0_MINOR_6(0, ChordType.MINOR, ChordInversion.FIRST), //
	_0_MINOR_64(0, ChordType.MINOR, ChordInversion.SECOND), //
	_0_POWER(0, ChordType.POWER, ChordInversion.ROOT), //
	_0_POWER_64(0, ChordType.POWER, ChordInversion.SECOND), //
	_1_MAJOR(1, ChordType.MAJOR, ChordInversion.ROOT), //
	_1_MAJOR_6(1, ChordType.MAJOR, ChordInversion.FIRST), //
	_1_MAJOR_64(1, ChordType.MAJOR, ChordInversion.SECOND), //
	_1_MINOR(1, ChordType.MINOR, ChordInversion.ROOT), //
	_1_MINOR_6(1, ChordType.MINOR, ChordInversion.FIRST), //
	_1_MINOR_64(1, ChordType.MINOR, ChordInversion.SECOND), //
	_1_POWER(1, ChordType.POWER, ChordInversion.ROOT), //
	_1_POWER_64(1, ChordType.POWER, ChordInversion.SECOND), //
	_2_MAJOR(2, ChordType.MAJOR, ChordInversion.ROOT), //
	_2_MAJOR_6(2, ChordType.MAJOR, ChordInversion.FIRST), //
	_2_MAJOR_64(2, ChordType.MAJOR, ChordInversion.SECOND), //
	_2_MINOR(2, ChordType.MINOR, ChordInversion.ROOT), //
	_2_MINOR_6(2, ChordType.MINOR, ChordInversion.FIRST), //
	_2_MINOR_64(2, ChordType.MINOR, ChordInversion.SECOND), //
	_2_POWER(2, ChordType.POWER, ChordInversion.ROOT), //
	_2_POWER_64(2, ChordType.POWER, ChordInversion.SECOND), //
	_3_MAJOR(3, ChordType.MAJOR, ChordInversion.ROOT), //
	_3_MAJOR_6(3, ChordType.MAJOR, ChordInversion.FIRST), //
	_3_MAJOR_64(3, ChordType.MAJOR, ChordInversion.SECOND), //
	_3_MINOR(3, ChordType.MINOR, ChordInversion.ROOT), //
	_3_MINOR_6(3, ChordType.MINOR, ChordInversion.FIRST), //
	_3_MINOR_64(3, ChordType.MINOR, ChordInversion.SECOND), //
	_3_POWER(3, ChordType.POWER, ChordInversion.ROOT), //
	_3_POWER_64(3, ChordType.POWER, ChordInversion.SECOND), //
	_4_MAJOR(4, ChordType.MAJOR, ChordInversion.ROOT), //
	_4_MAJOR_6(4, ChordType.MAJOR, ChordInversion.FIRST), //
	_4_MAJOR_64(4, ChordType.MAJOR, ChordInversion.SECOND), //
	_4_MINOR(4, ChordType.MINOR, ChordInversion.ROOT), //
	_4_MINOR_6(4, ChordType.MINOR, ChordInversion.FIRST), //
	_4_MINOR_64(4, ChordType.MINOR, ChordInversion.SECOND), //
	_4_POWER(4, ChordType.POWER, ChordInversion.ROOT), //
	_4_POWER_64(4, ChordType.POWER, ChordInversion.SECOND), //
	_5_MAJOR(5, ChordType.MAJOR, ChordInversion.ROOT), //
	_5_MAJOR_6(5, ChordType.MAJOR, ChordInversion.FIRST), //
	_5_MAJOR_64(5, ChordType.MAJOR, ChordInversion.SECOND), //
	_5_MINOR(5, ChordType.MINOR, ChordInversion.ROOT), //
	_5_MINOR_6(5, ChordType.MINOR, ChordInversion.FIRST), //
	_5_MINOR_64(5, ChordType.MINOR, ChordInversion.SECOND), //
	_5_POWER(5, ChordType.POWER, ChordInversion.ROOT), //
	_5_POWER_64(5, ChordType.POWER, ChordInversion.SECOND), //
	_6_MAJOR(6, ChordType.MAJOR, ChordInversion.ROOT), //
	_6_MAJOR_6(6, ChordType.MAJOR, ChordInversion.FIRST), //
	_6_MAJOR_64(6, ChordType.MAJOR, ChordInversion.SECOND), //
	_6_MINOR(6, ChordType.MINOR, ChordInversion.ROOT), //
	_6_MINOR_6(6, ChordType.MINOR, ChordInversion.FIRST), //
	_6_MINOR_64(6, ChordType.MINOR, ChordInversion.SECOND), //
	_6_POWER(6, ChordType.POWER, ChordInversion.ROOT), //
	_6_POWER_64(6, ChordType.POWER, ChordInversion.SECOND), //
	_7_MAJOR(7, ChordType.MAJOR, ChordInversion.ROOT), //
	_7_MAJOR_6(7, ChordType.MAJOR, ChordInversion.FIRST), //
	_7_MAJOR_64(7, ChordType.MAJOR, ChordInversion.SECOND), //
	_7_MINOR(7, ChordType.MINOR, ChordInversion.ROOT), //
	_7_MINOR_6(7, ChordType.MINOR, ChordInversion.FIRST), //
	_7_MINOR_64(7, ChordType.MINOR, ChordInversion.SECOND), //
	_7_POWER(7, ChordType.POWER, ChordInversion.ROOT), //
	_7_POWER_64(7, ChordType.POWER, ChordInversion.SECOND), //
	_8_MAJOR(8, ChordType.MAJOR, ChordInversion.ROOT), //
	_8_MAJOR_6(8, ChordType.MAJOR, ChordInversion.FIRST), //
	_8_MAJOR_64(8, ChordType.MAJOR, ChordInversion.SECOND), //
	_8_MINOR(8, ChordType.MINOR, ChordInversion.ROOT), //
	_8_MINOR_6(8, ChordType.MINOR, ChordInversion.FIRST), //
	_8_MINOR_64(8, ChordType.MINOR, ChordInversion.SECOND), //
	_8_POWER(8, ChordType.POWER, ChordInversion.ROOT), //
	_8_POWER_64(8, ChordType.POWER, ChordInversion.SECOND), //
	_9_MAJOR(9, ChordType.MAJOR, ChordInversion.ROOT), //
	_9_MAJOR_6(9, ChordType.MAJOR, ChordInversion.FIRST), //
	_9_MAJOR_64(9, ChordType.MAJOR, ChordInversion.SECOND), //
	_9_MINOR(9, ChordType.MINOR, ChordInversion.ROOT), //
	_9_MINOR_6(9, ChordType.MINOR, ChordInversion.FIRST), //
	_9_MINOR_64(9, ChordType.MINOR, ChordInversion.SECOND), //
	_9_POWER(9, ChordType.POWER, ChordInversion.ROOT), //
	_9_POWER_64(9, ChordType.POWER, ChordInversion.SECOND), //
	_10_MAJOR(10, ChordType.MAJOR, ChordInversion.ROOT), //
	_10_MAJOR_6(10, ChordType.MAJOR, ChordInversion.FIRST), //
	_10_MAJOR_64(10, ChordType.MAJOR, ChordInversion.SECOND), //
	_10_MINOR(10, ChordType.MINOR, ChordInversion.ROOT), //
	_10_MINOR_6(10, ChordType.MINOR, ChordInversion.FIRST), //
	_10_MINOR_64(10, ChordType.MINOR, ChordInversion.SECOND), //
	_10_POWER(10, ChordType.POWER, ChordInversion.ROOT), //
	_10_POWER_64(10, ChordType.POWER, ChordInversion.SECOND), //
	_11_MAJOR(11, ChordType.MAJOR, ChordInversion.ROOT), //
	_11_MAJOR_6(11, ChordType.MAJOR, ChordInversion.FIRST), //
	_11_MAJOR_64(11, ChordType.MAJOR, ChordInversion.SECOND), //
	_11_MINOR(11, ChordType.MINOR, ChordInversion.ROOT), //
	_11_MINOR_6(11, ChordType.MINOR, ChordInversion.FIRST), //
	_11_MINOR_64(11, ChordType.MINOR, ChordInversion.SECOND), //
	_11_POWER(11, ChordType.POWER, ChordInversion.ROOT), //
	_11_POWER_64(11, ChordType.POWER, ChordInversion.SECOND), //
	;

	private final int relativeIndex;
	private final ChordType chordType;
	private final ChordInversion chordInversion;

	/**
	 * @param relativeIndex
	 * @param chordType
	 * @param chordInversion
	 */
	private RelativeChord(int relativeIndex, ChordType chordType, ChordInversion chordInversion) {
		this.relativeIndex = relativeIndex;
		this.chordType = chordType;
		this.chordInversion = chordInversion;
	}

	/**
	 * @return the relativeIndex
	 */
	public final int getRelativeIndex() {
		return relativeIndex;
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

}
