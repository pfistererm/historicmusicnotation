package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import de.pfist.historicmusicnotationtraining.util.NoteConstants;

@XmlType(propOrder = { "clef", "noteRelative" })
public class ClefAndNote {

	private Clef clef;
	private int noteRelative;

	public ClefAndNote() {
		// DO NOTHING
	}

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
	@XmlAttribute(name = "clef")
	public final Clef getClef() {
		return clef;
	}

	/**
	 * @param clef the clef to set
	 */
	public final void setClef(Clef clef) {
		this.clef = clef;
	}

	/**
	 * @return the noteRelative
	 */
	@XmlAttribute(name = "noteRelative")
	public final int getNoteRelative() {
		return noteRelative;
	}

	/**
	 * @param noteRelative the noteRelative to set
	 */
	public final void setNoteRelative(int noteRelative) {
		this.noteRelative = noteRelative;
	}

	public int getMidiNote() {
		return getMidiNote(clef, noteRelative);
	}

	protected static int getMidiNote(Clef clef, int noteRelative) {
		final int midiNoteTableIndex = noteRelative + clef.getOffset();
		return NoteConstants.NOTE_MIDI_NOTE_TABLE_DIATONIC[midiNoteTableIndex];
	}

}
