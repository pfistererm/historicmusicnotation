package de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note;

import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultNote;

/**
 *
 * 
 * <p>Contains:</p>
 * <ul>
 * <li>A single MIDI note number</li>
 * </ul>
 * 
 * <p>Note: uses the MIDI note number also as domain specific object
 */
public class NewGermanOrganTablatureNoteRandomResult extends AbstractRandomResultNote<Integer> {

	/**
	 * Constructor.
	 * 
	 * @param midiNote
	 */
	public NewGermanOrganTablatureNoteRandomResult(int midiNote) {
		super(midiNote, midiNote);
	}
}
