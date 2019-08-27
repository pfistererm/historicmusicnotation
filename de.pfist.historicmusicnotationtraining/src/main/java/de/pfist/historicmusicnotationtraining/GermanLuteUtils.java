package de.pfist.historicmusicnotationtraining;

public class GermanLuteUtils {

	/**
	 * Note names
	 */
	private static final String[][] NOTE_NAMES = { //
			{ "A", "B", "C", "D", "E", "F", "G", "H" }, // S0 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			{ "1", "a", "f", "l", "q", "x", "a'", "f'", "l'", "q'" }, // S1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "2", "b", "g", "m", "r", "y", "b'", "g'", "m'", "r'" }, // S2 //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "3", "c", "h", "n", "s", "z", "c'", "h'", "n'", "s'" }, // S3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "4", "d", "i", "o", "t", "7", "d'", "i'", "o'", "t'" }, // S4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "5", "e", "k", "p", "v", "9", "e'", "k'", "p'", "v'" }, // S5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	};

	public static String getNoteName(final int stringIndex, final int fretPosition) {
		return NOTE_NAMES[stringIndex][fretPosition];
	}

	public static String getNoteName(final LuteNote luteNote) {
		return getNoteName(luteNote.getString().getStringIndex(), luteNote.getFretPosition());
	}
}