package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

// TODO: use reading chord descriptions from XML
@XmlSeeAlso({ RelativeChord.class, AbsoluteChord.class, LuteNote.class, ClefAndNote.class  })
@XmlType(propOrder = { "chord", "notes" })
public class LuteChordDescription {

	private RelativeChord chord;
	private LuteNote[] notes;

	@XmlAttribute
	public void setChord(RelativeChord chord) {
		this.chord = chord;
	}

	/**
	 * @return the chord
	 */
	public final RelativeChord getChord() {
		return chord;
	}

	/**
	 * @return the notes
	 */
	public final LuteNote[] getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	@XmlElement(name="note")
	public final void setNotes(LuteNote[] notes) {
		this.notes = notes;
	}

}