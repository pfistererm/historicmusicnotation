package de.pfist.historicmusicnotationtraining.util;

import de.pfist.historicmusicnotationtraining.data.AbsoluteChord;
import de.pfist.historicmusicnotationtraining.data.ChordInversion;
import de.pfist.historicmusicnotationtraining.data.ChordType;

public abstract class NoteConstants {

	public static final String[] NOTE_NAMES_DIATONIC = new String[] { "C", "D", "E", "F", "G", "A", "H", "c", "d", "e",
			"f", "g", "a", "h", "c'", "d'", "e'", "f'", "g'", "a'", "h'", "c''", "d''", "e''", "f''", "g''", "a''",
			"h''" };
	public static final int[] NOTE_MIDI_NOTE_TABLE_DIATONIC = new int[] { 36, 38, 40, 41, 43, 45, 47, 48, 50, 52, 53,
			55, 57, 59, 60, 62, 64, 65, 67, 69, 71, 72, 74, 76, 77, 78, 79, 81, 83 };

	public static final String[] NOTE_NAMES_CHROMATIC = new String[] { "G", "G# / Ab", "A", "A# / B", "H", "c",
			"c# / db", "d", "d# / eb", "e", "f", "f# / gb", "g", "g# / ab", "a", "a# / b", "h", "c'", "c#' / db'", "d'",
			"d#' / eb'", "e'", "f'", "f#' / gb'", "g'", "g#' / ab'", "a'", "a#' / b'", "h'", "c''", "c#'' / db''",
			"d''", "d#'' / eb''", "e''", "f''", "f#'' / gb''" };
	public static final int BASE_MIDI_NOTE_CROMATIC = 43;

	public static final String[] NOTE_NAMES_CHROMATIC_4_OCTAVES = new String[] { //
			"C", "C# / Db", "D", "D# / Eb", "E", "F", "F# / Gb", "G", "G# / Ab", "A", "A# / B", "H", //
			"c", "c# / db", "d", "d# / eb", "e", "f", "f# / gb", "g", "g# / ab", "a", "a# / b", "h", //
			"c'", "c#' / db'", "d'", "d#' / eb'", "e'", "f'", "f#' / gb'", "g'", "g#' / ab'", "a'", "a#' / b'", "h'",
			"c''", "c#'' / db''", "d''", "d#'' / eb''", "e''", "f''", "f#'' / gb''", "g''", "g#'' / ab''", "a''",
			"a#'' / b''", "h''" };
	public static final int BASE_MIDI_NOTE_CROMATIC_4_OCTAVES = 36;

	public static final AbsoluteChord[] CHORDS = initChords();

	private static AbsoluteChord[] initChords() {
		AbsoluteChord[] chords = new AbsoluteChord[AbsoluteChord.values().length];
		int chordIndex = 0;
		for (ChordType chordType : ChordType.values()) {
			for (ChordInversion chordInversion : ChordInversion.values()) {
				if (chordType == ChordType.POWER && chordInversion == ChordInversion.FIRST) {
					continue;
				}
				for (AbsoluteChord chord : AbsoluteChord.values()) {
					if (chord.getChordType() == chordType && chord.getChordInversion() == chordInversion) {
						chords[chordIndex] = chord;
						chordIndex++;
					}
				}
			}
		}
		return chords;
	}
}
