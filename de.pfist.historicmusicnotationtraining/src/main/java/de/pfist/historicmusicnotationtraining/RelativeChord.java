package de.pfist.historicmusicnotationtraining;

public enum RelativeChord {
	_0_MAJOR(0, ChordType.MAJOR), //
	_0_MINOR(0, ChordType.MINOR), //
	_0_POWER(0, ChordType.POWER), //
	_1_MAJOR(1, ChordType.MAJOR), //
	_1_MINOR(1, ChordType.MINOR), //
	_1_POWER(1, ChordType.POWER), //
	_2_MAJOR(2, ChordType.MAJOR), //
	_2_MINOR(2, ChordType.MINOR), //
	_2_POWER(2, ChordType.POWER), //
	_3_MAJOR(3, ChordType.MAJOR), //
	_3_MINOR(3, ChordType.MINOR), //
	_3_POWER(3, ChordType.POWER), //
	_4_MAJOR(4, ChordType.MAJOR), //
	_4_MINOR(4, ChordType.MINOR), //
	_4_POWER(4, ChordType.POWER), //
	_5_MAJOR(5, ChordType.MAJOR), //
	_5_MINOR(5, ChordType.MINOR), //
	_5_POWER(5, ChordType.POWER), //
	_6_MAJOR(6, ChordType.MAJOR), //
	_6_MINOR(6, ChordType.MINOR), //
	_6_POWER(6, ChordType.POWER), //
	_7_MAJOR(7, ChordType.MAJOR), //
	_7_MINOR(7, ChordType.MINOR), //
	_7_POWER(7, ChordType.POWER), //
	_8_MAJOR(8, ChordType.MAJOR), //
	_8_MINOR(8, ChordType.MINOR), //
	_8_POWER(8, ChordType.POWER), //
	_9_MAJOR(9, ChordType.MAJOR), //
	_9_MINOR(9, ChordType.MINOR), //
	_9_POWER(9, ChordType.POWER), //
	_10_MAJOR(10, ChordType.MAJOR), //
	_10_MINOR(10, ChordType.MINOR), //
	_10_POWER(10, ChordType.POWER), //
	_11_MAJOR(11, ChordType.MAJOR), //
	_11_MINOR(11, ChordType.MINOR), //
	_11_POWER(11, ChordType.POWER), //
	;

	private final int relativeIndex;
	private final ChordType chordType;

	/**
	 * @param relativeIndex
	 * @param chordType
	 */
	private RelativeChord(int relativeIndex, ChordType chordType) {
		this.relativeIndex = relativeIndex;
		this.chordType = chordType;
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

}
