package de.pfist.historicmusicnotationtraining;

public class GermanLuteUtils {

	/**
	 * Note names
	 */
	private static final String[][] NOTE_NAMES_LATIN = { //
			{ "A", "B", "C", "D", "E", "F", "G", "H" }, // S0 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			{ "1", "a", "f", "l", "q", "x", "a'", "f'", "l'", "q'" }, // S1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "2", "b", "g", "m", "r", "y", "b'", "g'", "m'", "r'" }, // S2 //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "3", "c", "h", "n", "s", "z", "c'", "h'", "n'", "s'" }, // S3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "4", "d", "i", "o", "t", "7", "d'", "i'", "o'", "t'" }, // S4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "5", "e", "k", "p", "v", "9", "e'", "k'", "p'", "v'" }, // S5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	};

	/**
	 * Note names
	 */
	private static final String[][] NOTE_NAMES_SMUFL = { //
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // S0 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			{ "\uEBE1", "\uEC00", "\uEC05", "\uEC0A", "\uEC0F", "\uEC14", "\uEC00'", "\uEC05'", "\uEC0A'", "\uEC0F'" }, // S1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE2", "\uEC01", "\uEC06", "\uEC0B", "\uEC10", "\uEC15", "\uEC01'", "\uEC06'", "EC0B'", "\uEC10'" }, // S2 //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE3", "\uEC02", "\uEC07", "\uEC0C", "\uEC11", "\uEC16", "\uEC02'", "\uEC07'", "\uEC0C'", "\uEC11'" }, // S3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE4", "\uEC03", "\uEC08", "\uEC0D", "\uEC12", "\uEBE7", "\uEC03'", "\uEC08'", "\uEC0D'", "\uEC12'" }, // S4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE5", "\uEC04", "\uEC09", "\uEC0E", "\uEC13", "\uEBE9", "\uEC04'", "\uEC09'", "\uEC0E'", "\uEC13'" }, // S5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	};

	public static String getNoteName(final LuteNote luteNote, final GermanLuteTablatureNameVariant nameVariant) {
		return (nameVariant.isUseSmufl()? NOTE_NAMES_SMUFL: NOTE_NAMES_LATIN)[luteNote.getString().getStringIndex()][luteNote.getFretPosition()];
	}
}