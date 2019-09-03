package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.util.NoteConstants;

public class ClefAndNote {

	private final Clef clef;
	private final int noteRelative;

	/**
	 * @param clef
	 * @param noteRelative
	 */
	public ClefAndNote(Clef clef, int noteRelative) {
		this.clef = clef;
		this.noteRelative = noteRelative;
	}

	/**
	 * @return the clef
	 */
	public final Clef getClef() {
		return clef;
	}

	/**
	 * @return the noteRelative
	 */
	public final int getNoteRelative() {
		return noteRelative;
	}

	public int getMidiNote() {
		return getMidiNote(clef, noteRelative);
	}

	protected static int getMidiNote(Clef clef, int noteRelative) {
		final int midiNoteTableIndex = noteRelative + clef.getOffset();
		return NoteConstants.NOTE_MIDI_NOTE_TABLE_DIATONIC[midiNoteTableIndex];
	}

}
