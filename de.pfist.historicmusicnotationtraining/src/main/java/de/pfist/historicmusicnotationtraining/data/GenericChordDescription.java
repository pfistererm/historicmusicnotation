package de.pfist.historicmusicnotationtraining.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @param <C> type for chords
 * @param <N> type for notes
 */
@XmlRootElement(name = "chord")
public class GenericChordDescription<C, N> {

	private C chord;
	private N[] notes;

	/**
	 * @param chord
	 * @param luteNotes
	 */
	@SafeVarargs
	public GenericChordDescription(final C chord, N... luteNotes) {
		this.chord = chord;
		this.notes = luteNotes;
	}

	public GenericChordDescription() {
		// DO NOTHING
	}

	/**
	 * @return the chord
	 */
	@XmlElement(name = "chord")
	public final C getChord() {
		return chord;
	}

	/**
	 * @return the luteNotes
	 */
	@XmlElement(name = "notes")
	public final N[] getNotes() {
		return notes;
	}
}
