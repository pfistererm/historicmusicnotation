package de.pfist.historicmusicnotationtraining;

/**
 * Note clef.
 * 
 * <ul>
 * <li>line: note line (1 = lowest, 5 = highest) that is the anchor for the
 * characteristic note of the clef (middle C for C clefs, G for G clefs). This
 * is used for drawing the clef.</li>
 * NoteConstants.NOTE_MIDI_NOTE_TABLE_DIATONIC
 * <li>offset: difference between the relative position of a note (-1 = below
 * lowest line, 10 = above highest line) and the index in the array
 * {@link NoteConstants#NOTE_MIDI_NOTE_TABLE_DIATONIC}.</li>
 * </ul>
 * 
 * @author matthias
 *
 */
public enum Clef implements I18NEnum {
	G1(ClefType.G_CLEF, 1, 18, "Clef.g1"), //$NON-NLS-1$
	G2(ClefType.G_CLEF, 2, 16, "Clef.g2"), //$NON-NLS-1$
	C1(ClefType.C_CLEF, 1, 14, "Clef.c1"), //$NON-NLS-1$
	C2(ClefType.C_CLEF, 2, 12, "Clef.c2"), //$NON-NLS-1$
	C3(ClefType.C_CLEF, 3, 10, "Clef.c3"), //$NON-NLS-1$
	C4(ClefType.C_CLEF, 4, 8, "Clef.c4"), //$NON-NLS-1$
	C5(ClefType.C_CLEF, 5, 6, "Clef.c5"), //$NON-NLS-1$
	F3(ClefType.F_CLEF, 3, 6, "Clef.f3"), //$NON-NLS-1$
	F4(ClefType.F_CLEF, 4, 4, "Clef.f4"), //$NON-NLS-1$
	ALL(null, 0, 0, "Clef.all"); //$NON-NLS-1$

	private static Clef[] ALL_CLEFS = new Clef[] { G1, G2, C1, C2, C3, C4, C5, F3, F4 };
	private static Clef[] ALL_C_CLEFS = new Clef[] { C1, C2, C3, C4 };

	private final ClefType clefType;
	private final int line;
	private final int offset;
	private final String textKey;

	/**
	 * @param clefType
	 * @param line
	 * @param textKey
	 * 
	 */
	private Clef(final ClefType clefType, final int line, final int offset, final String textKey) {
		this.clefType = clefType;
		this.line = line;
		this.offset = offset;
		this.textKey = textKey;
	}

	/**
	 * @return the clefType
	 */
	public final ClefType getClefType() {
		return clefType;
	}

	/**
	 * @return the line
	 */
	public final int getLine() {
		return line;
	}

	/**
	 * @return the offset
	 */
	public final int getOffset() {
		return offset;
	}

	@Override
	public final String getTextKey() {
		return textKey;
	}

	public static Clef[] getAllCClefs() {
		return ALL_C_CLEFS;
	}

	public static Clef[] getAllClefs() {
		return ALL_CLEFS;
	}
}
