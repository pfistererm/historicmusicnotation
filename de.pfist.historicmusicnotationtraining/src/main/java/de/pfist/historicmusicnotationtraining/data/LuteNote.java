package de.pfist.historicmusicnotationtraining.data;

import static de.pfist.historicmusicnotationtraining.LuteStringMode.S0;
import static de.pfist.historicmusicnotationtraining.LuteStringMode.S1;
import static de.pfist.historicmusicnotationtraining.LuteStringMode.S2;
import static de.pfist.historicmusicnotationtraining.LuteStringMode.S3;
import static de.pfist.historicmusicnotationtraining.LuteStringMode.S4;
import static de.pfist.historicmusicnotationtraining.LuteStringMode.S5;

import de.pfist.historicmusicnotationtraining.LuteStringMode;
import de.pfist.historicmusicnotationtraining.LuteTuning;

public enum LuteNote {
	// String 0
	S0_0(S0, 0), S0_1(S0, 1), S0_2(S0, 2), S0_3(S0, 3), S0_4(S0, 4), //
	S0_5(S0, 5), S0_6(S0, 6), S0_7(S0, 7), S0_8(S0, 8), S0_9(S0, 9), //
	// String 1
	S1_0(S1, 0), S1_1(S1, 1), S1_2(S1, 2), S1_3(S1, 3), S1_4(S1, 4), //
	S1_5(S1, 5), S1_6(S1, 6), S1_7(S1, 7), S1_8(S1, 8), S1_9(S1, 9), //
	// String 2
	S2_0(S2, 0), S2_1(S2, 1), S2_2(S2, 2), S2_3(S2, 3), S2_4(S2, 4), //
	S2_5(S2, 5), S2_6(S2, 6), S2_7(S2, 7), S2_8(S2, 8), S2_9(S2, 9), //
	// String 3
	S3_0(S3, 0), S3_1(S3, 1), S3_2(S3, 2), S3_3(S3, 3), S3_4(S3, 4), //
	S3_5(S3, 5), S3_6(S3, 6), S3_7(S3, 7), S3_8(S3, 8), S3_9(S3, 9), //
	// String 4
	S4_0(S4, 0), S4_1(S4, 1), S4_2(S4, 2), S4_3(S4, 3), S4_4(S4, 4), //
	S4_5(S4, 5), S4_6(S4, 6), S4_7(S4, 7), S4_8(S4, 8), S4_9(S4, 9), //
	// String 5
	S5_0(S5, 0), S5_1(S5, 1), S5_2(S5, 2), S5_3(S5, 3), S5_4(S5, 4), //
	S5_5(S5, 5), S5_6(S5, 6), S5_7(S5, 7), S5_8(S5, 8), S5_9(S5, 9), //
	;

	private final LuteStringMode string;
	private final int fretPosition;

	/**
	 * @param string
	 * @param fretPosition
	 */
	private LuteNote(LuteStringMode string, int fretPosition) {
		this.string = string;
		this.fretPosition = fretPosition;
	}

	/**
	 * @return the string
	 */
	public final LuteStringMode getString() {
		return string;
	}

	/**
	 * @return the fretPosition
	 */
	public final int getFretPosition() {
		return fretPosition;
	}

	public int getMidiNote(final LuteTuning luteTuning) {
		return this.getString().getOffset(luteTuning) + this.getFretPosition();
	}

	public static LuteNote getNote(final LuteStringMode luteString, final int fretPosition) {
		for (final LuteNote luteNote : LuteNote.values()) {
			if (luteNote.getString() == luteString && luteNote.getFretPosition() == fretPosition) {
				return luteNote;
			}
		}
		return null;
	}
}
