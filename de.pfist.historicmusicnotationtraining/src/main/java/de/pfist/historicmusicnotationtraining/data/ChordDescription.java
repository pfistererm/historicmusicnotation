package de.pfist.historicmusicnotationtraining.data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: use reading chord descriptions from XML
@XmlRootElement(name = "book")
// @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "chord", "name", "date", "notes" })
public class ChordDescription {
	private Chord chord;
	private String name;
	private Date date;
	private LuteNote[] notes;

	@XmlAttribute
	public void setChord(Chord chord) {
		this.chord = chord;
	}

	/**
	 * @return the chord
	 */
	public final Chord getChord() {
		return chord;
	}

	@XmlElement(name = "title")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public final Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public final void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
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