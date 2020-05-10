package de.pfist.historicmusicnotationtraining.domains;

/**
 * 
 * @see AbstractRandomResultChord
 */
public abstract class AbstractRandomResultNote implements DomainRandomResult {

	private final int midiNote;

	/**
	 * @param midiNote
	 */
	public AbstractRandomResultNote(final int midiNote) {
		this.midiNote = midiNote;
	}

	/**
	 * @return the midiNote
	 */
	public final int getMidiNote() {
		return midiNote;
	}

}
