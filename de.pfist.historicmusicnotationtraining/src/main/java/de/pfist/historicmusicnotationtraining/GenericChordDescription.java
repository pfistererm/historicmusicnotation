package de.pfist.historicmusicnotationtraining;

/**
 * @author matthias
 *
 * @param <C> type for chords
 * @param <N> type for notes
 */
public class GenericChordDescription<C, N> {

	private final C chord;
	private final N[] notes;

	/**
		 * @param chord
		 * @param luteNotes
		 */
		@SafeVarargs
		public GenericChordDescription(final C chord, N... luteNotes) {
			this.chord = chord;
			this.notes = luteNotes;
		}

	/**
	 * @return the chord
	 */
	public final C getChord() {
		return chord;
	}

	/**
	 * @return the luteNotes
	 */
	public final N[] getNotes() {
		return notes;
	}
}
