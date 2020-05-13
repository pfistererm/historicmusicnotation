package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "chord", "notes" })
public class CClefChordDescription {

	public CClefChordDescription() {
		// EMPTY
	}

	private AbsoluteChord chord;
	private ClefAndNote[] notes;

	/**
	 * @param chord
	 * @param notes
	 */
	public CClefChordDescription(final AbsoluteChord chord, ClefAndNote... notes) {
		this.chord = chord;
		this.notes = notes;
	}

	/**
	 * @return the chord
	 */
	@XmlAttribute(name = "chord")
	public final AbsoluteChord getChord() {
		return chord;
	}

	/**
	 * @param chord the chord to set
	 */
	public final void setChord(AbsoluteChord chord) {
		this.chord = chord;
	}

	/**
	 * @return the luteNotes
	 */
	@XmlElement(name = "note")
	public final ClefAndNote[] getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public final void setNotes(ClefAndNote[] notes) {
		this.notes = notes;
	}

}