package de.pfist.historicmusicnotationtraining;

/**
 *
 */
public class CClefChordsWorkerExtension
		implements WorkerExtension<CClefChordsDomainSpecificState, CClefChordsRandomResult> {

	private static class ChordDescription extends GenericChordDescription<Chord, ClefAndNote> {

		/**
		 * @param chord
		 * @param notes
		 */
		public ChordDescription(final Chord chord, ClefAndNote... notes) {
			super(chord, notes);
		}
	}

	private static final ChordDescription[] CHORDS = new ChordDescription[] {
			new ChordDescription(Chord.C_MAJOR, new ClefAndNote(Clef.C1, 0), new ClefAndNote(Clef.C1, 0),
					new ClefAndNote(Clef.C1, 0), new ClefAndNote(Clef.C1, 0)), //
	};

	private boolean CHORD_TEST = false;

	private int chordDescriptionIndexTest = 0;

	private static ChordDescription[] getChords() {
		return CHORDS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CClefChordsRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		// CClefChordsDomainSpecificState domainSpecificState2 =
		// (CClefChordsDomainSpecificState) domainSpecificState;

		final ChordDescription[] chords = getChords();
		final int chordDescriptionIndex = CHORD_TEST ? chordDescriptionIndexTest : Worker.randomInteger(chords.length);
		System.out.println("chordDescriptionIndex: " + chordDescriptionIndex); //$NON-NLS-1$
		final ChordDescription chordDescription = chords[chordDescriptionIndex];
		if (CHORD_TEST && chordDescriptionIndexTest < chords.length) {
			chordDescriptionIndexTest++;
		}

		final ClefAndNote[] clefAndNotes = chordDescription.getNotes();
		final int[] midiNotes = new int[clefAndNotes.length];
		for (int i = 0; i < clefAndNotes.length; i++) {
			midiNotes[i] = clefAndNotes[i].getMidiNote();
		}

		final CClefChordsRandomResult randomResult = new CClefChordsRandomResult(chordDescription.getChord(),
				clefAndNotes, midiNotes);
		System.out.println("chord: " + chordDescription.getChord()); //$NON-NLS-1$
		return randomResult;
	}

}
