package de.pfist.historicmusicnotationtraining;

public class GermanLuteUtils {

	/**
	 * Note names (Antiqua) for strings S1 .. S5.
	 */
	private static final String[][] NOTE_NAMES_LATIN = { //
			{ "1", "a", "f", "l", "q", "x", "a'", "f'", "l'", "q'" }, // S1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "2", "b", "g", "m", "r", "y", "b'", "g'", "m'", "r'" }, // S2 //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "3", "c", "h", "n", "s", "z", "c'", "h'", "n'", "s'" }, // S3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "4", "d", "i", "o", "t", "7", "d'", "i'", "o'", "t'" }, // S4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "5", "e", "k", "p", "v", "9", "e'", "k'", "p'", "v'" }, // S5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	};

	/**
	 * Note names for strings S1 .. S5 (Fractura, from SMuFL sections "German
	 * Renaissance lute tablature" and "Italian and Spanish Renaissance lute
	 * tablature" [for digits])
	 */
	private static final String[][] NOTE_NAMES_SMUFL = { //
			{ "\uEBE1", "\uEC00", "\uEC05", "\uEC0A", "\uEC0F", "\uEC14", "\uEC00'", "\uEC05'", "\uEC0A'", "\uEC0F'" }, // S1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE2", "\uEC01", "\uEC06", "\uEC0B", "\uEC10", "\uEC15", "\uEC01'", "\uEC06'", "\uEC0B'", "\uEC10'" }, // S2 //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE3", "\uEC02", "\uEC07", "\uEC0C", "\uEC11", "\uEC16", "\uEC02'", "\uEC07'", "\uEC0C'", "\uEC11'" }, // S3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE4", "\uEC03", "\uEC08", "\uEC0D", "\uEC12", "\uEBE7", "\uEC03'", "\uEC08'", "\uEC0D'", "\uEC12'" }, // S4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			{ "\uEBE5", "\uEC04", "\uEC09", "\uEC0E", "\uEC13", "\uEBE9", "\uEC04'", "\uEC09'", "\uEC0E'", "\uEC13'" }, // S5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
	};

	/**
	 * Note names (Antiqua) for string S0 - different notation variants.
	 */
	private static final String[][] NOTE_NAMES_LATIN_S0 = { //
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I" }, // WAISSEL //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			{ "1'", "A", "B", "C", "D", "E", "F", "G", "H" }, // NEWSIDLER //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			// $NON-NLS-9$ //$NON-NLS-10$
			{ "1'", "a'", "f'", "l'", "q'", "x'", "aa", "ff", "ll" }, // JOBIN //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			// $NON-NLS-9$ //$NON-NLS-10$
			{ "7'", "a'", "f'", "l'", "q'", "x'", "aa'", "ff'", "ll'" }, // HECKEL //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			// $NON-NLS-9$ //$NON-NLS-10$
			{ "1'", "2'", "3'", "4'", "5'", "6'", "7'", "8'", "9'" }, // GERLE //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			// $NON-NLS-9$ //$NON-NLS-10$
	};
	/**
	 * Note names for string S0 - different notation ariants (Fractura, from SMuFL
	 * sections "German Renaissance lute tablature" and "Italian and Spanish
	 * Renaissance lute tablature" [for digits])
	 */
	private static final String[][] NOTE_NAMES_SMUFL_S0 = { //
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // WAISSEL //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // NEWSIDLER //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
																								// //$NON-NLS-9$
																								// //$NON-NLS-10$
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // JOBIN //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
																								// //$NON-NLS-9$
																								// //$NON-NLS-10$
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // HECKEL //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
																								// //$NON-NLS-9$
																								// //$NON-NLS-10$
			{ "\uEC17", "\uEC18", "\uEC19", "\uEC1A", "\uEC1B", "\uEC1C", "\uEC1D", "\uEC1E" }, // GERLE //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
																								// //$NON-NLS-9$
																								// //$NON-NLS-10$
	};

	public static String getNoteName(final LuteNote luteNote, final GermanLuteTablatureNotationVariant notationVariant,
			final GermanLuteTablatureFontVariant germanLuteTablatureFontVariant) {
		if (luteNote.getString() == LuteStringMode.S0) {
			/*
			 * Special handling for 'grossbrummer', because different notation variants
			 * exist.
			 */
			return (germanLuteTablatureFontVariant.isUseSmufl() ? NOTE_NAMES_SMUFL_S0
					: NOTE_NAMES_LATIN_S0)[notationVariant.ordinal()][luteNote.getFretPosition()];
		} else {
			return (germanLuteTablatureFontVariant.isUseSmufl() ? NOTE_NAMES_SMUFL : NOTE_NAMES_LATIN)[luteNote
					.getString().getStringIndex() - 1][luteNote.getFretPosition()];
		}
	}
}