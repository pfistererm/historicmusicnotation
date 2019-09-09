package de.pfist.historicmusicnotationtraining;

/**
 *
 */
public class GermanLuteTablatureChordsWorkerExtension implements
		WorkerExtension<GermanLuteTablatureChordsDomainSpecificState, GermanLuteTablatureChordsRandomResult> {

	private static class ChordDescription extends GenericChordDescription<RelativeChord, LuteNote> {

		/**
		 * @param chord
		 * @param luteNotes
		 */
		public ChordDescription(final RelativeChord chord, LuteNote... luteNotes) {
			super(chord, luteNotes);
		}
	}

	private static final ChordDescription[] CHORDS = new ChordDescription[] {
			// A
			new ChordDescription(RelativeChord._0_MINOR, LuteNote.S4_0, LuteNote.S3_1, LuteNote.S2_2), // 4cg
			new ChordDescription(RelativeChord._0_POWER, LuteNote.S4_0, LuteNote.S2_2, LuteNote.S1_2), // 4gf
			new ChordDescription(RelativeChord._0_MINOR, LuteNote.S4_0, LuteNote.S3_1, LuteNote.S0_0), // 4cA
			new ChordDescription(RelativeChord._0_POWER, LuteNote.S4_0, LuteNote.S2_2, LuteNote.S0_0), // 4gA
			new ChordDescription(RelativeChord._0_MINOR, LuteNote.S4_5, LuteNote.S3_5, LuteNote.S2_5), // 7zy
			new ChordDescription(RelativeChord._0_POWER, LuteNote.S4_5, LuteNote.S3_5, LuteNote.S1_2), // 7zf
			new ChordDescription(RelativeChord._0_MAJOR, LuteNote.S4_0, LuteNote.S3_2, LuteNote.S2_2), // 4hg
			new ChordDescription(RelativeChord._0_MAJOR, LuteNote.S4_0, LuteNote.S3_2, LuteNote.S0_0), // 4hA
			new ChordDescription(RelativeChord._0_MAJOR, LuteNote.S3_2, LuteNote.S2_2, LuteNote.S0_0), // hgA
			// B
			new ChordDescription(RelativeChord._2_MAJOR, LuteNote.S4_2, LuteNote.S3_4, LuteNote.S2_4), // isr
			new ChordDescription(RelativeChord._2_MAJOR, LuteNote.S4_2, LuteNote.S3_4, LuteNote.S0_2), // isC
			new ChordDescription(RelativeChord._2_POWER, LuteNote.S4_2, LuteNote.S2_4, LuteNote.S0_2), // irC
			new ChordDescription(RelativeChord._2_MINOR, LuteNote.S3_3, LuteNote.S2_4, LuteNote.S0_2), // nrC
			new ChordDescription(RelativeChord._2_MINOR, LuteNote.S4_2, LuteNote.S3_3, LuteNote.S0_2), // inC
			// C
			new ChordDescription(RelativeChord._3_POWER, LuteNote.S3_1, LuteNote.S2_0, LuteNote.S0_3), // c2D
			new ChordDescription(RelativeChord._3_MAJOR, LuteNote.S4_0, LuteNote.S2_0, LuteNote.S0_3), // 42D
			new ChordDescription(RelativeChord._3_MAJOR, LuteNote.S3_5, LuteNote.S2_5, LuteNote.S1_2), // zyf
			new ChordDescription(RelativeChord._3_POWER, LuteNote.S4_3, LuteNote.S2_5, LuteNote.S0_3), // oyD
			new ChordDescription(RelativeChord._3_MAJOR, LuteNote.S3_1, LuteNote.S2_0, LuteNote.S1_2), // c2f
			new ChordDescription(RelativeChord._3_MAJOR, LuteNote.S4_3, LuteNote.S3_5, LuteNote.S0_3), // ozD
			new ChordDescription(RelativeChord._3_MAJOR, LuteNote.S3_5, LuteNote.S2_5, LuteNote.S0_3), // zyD
			new ChordDescription(RelativeChord._3_POWER, LuteNote.S4_8, LuteNote.S3_8, LuteNote.S2_5), // o'n'y
			new ChordDescription(RelativeChord._3_POWER, LuteNote.S4_3, LuteNote.S3_1, LuteNote.S0_3), // ocD
			// D
			new ChordDescription(RelativeChord._5_MINOR, LuteNote.S4_1, LuteNote.S3_3, LuteNote.S1_0), // dn1
			new ChordDescription(RelativeChord._5_MINOR, LuteNote.S4_5, LuteNote.S3_6, LuteNote.S2_7), // 7c'g'
			new ChordDescription(RelativeChord._5_POWER, LuteNote.S3_3, LuteNote.S2_2, LuteNote.S1_0), // ng1
			new ChordDescription(RelativeChord._5_MAJOR, LuteNote.S4_2, LuteNote.S3_3, LuteNote.S1_0), // in1
			new ChordDescription(RelativeChord._5_MAJOR, LuteNote.S4_5, LuteNote.S3_7, LuteNote.S0_5), // 7h'F
			new ChordDescription(RelativeChord._5_POWER, LuteNote.S4_5, LuteNote.S2_7, LuteNote.S0_5), // 7g'F
			// E
			new ChordDescription(RelativeChord._7_MINOR, LuteNote.S4_0, LuteNote.S3_0, LuteNote.S2_0), // 432
			new ChordDescription(RelativeChord._7_POWER, LuteNote.S3_5, LuteNote.S2_4, LuteNote.S1_2), // zrf
			new ChordDescription(RelativeChord._7_POWER, LuteNote.S4_0, LuteNote.S3_0, LuteNote.S1_2), // 43f
			new ChordDescription(RelativeChord._7_MINOR, LuteNote.S3_0, LuteNote.S2_0, LuteNote.S1_2), // 32f
			new ChordDescription(RelativeChord._7_MINOR, LuteNote.S4_3, LuteNote.S3_0, LuteNote.S1_2), // o3f
			new ChordDescription(RelativeChord._7_MAJOR, LuteNote.S4_0, LuteNote.S2_1, LuteNote.S1_2), // 4bf
			new ChordDescription(RelativeChord._7_MAJOR, LuteNote.S4_4, LuteNote.S3_5, LuteNote.S1_2), // tzf
			new ChordDescription(RelativeChord._7_MAJOR, LuteNote.S4_7, LuteNote.S3_9, LuteNote.S0_7), // i's'H
			// F
			new ChordDescription(RelativeChord._8_MAJOR, LuteNote.S3_1, LuteNote.S2_2, LuteNote.S1_3), // cgL
			new ChordDescription(RelativeChord._8_POWER, LuteNote.S4_1, LuteNote.S3_1, LuteNote.S1_3), // dcL
			// F#
			new ChordDescription(RelativeChord._9_POWER, LuteNote.S4_2, LuteNote.S3_2, LuteNote.S1_4), // ihq
			// G
			new ChordDescription(RelativeChord._10_POWER, LuteNote.S4_3, LuteNote.S3_3, LuteNote.S2_0), // on2
			new ChordDescription(RelativeChord._10_MAJOR, LuteNote.S4_3, LuteNote.S3_3, LuteNote.S2_4, LuteNote.S0_2), // onrC
			new ChordDescription(RelativeChord._10_MAJOR, LuteNote.S4_7, LuteNote.S3_8, LuteNote.S0_2), // i'n'C
			new ChordDescription(RelativeChord._10_POWER, LuteNote.S3_8, LuteNote.S2_7, LuteNote.S0_5), // n'g'F
			new ChordDescription(RelativeChord._10_MAJOR, LuteNote.S4_3, LuteNote.S2_4, LuteNote.S0_2), // orC
	};

	// int chordDescriptionIndex = 0;

	private static ChordDescription[] getChords(final LuteTuning luteTuning) {
		return CHORDS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GermanLuteTablatureChordsRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		final GermanLuteTablatureChordsDomainSpecificState domainSpecificState2 = (GermanLuteTablatureChordsDomainSpecificState) domainSpecificState;
		final LuteTuning luteTuning = domainSpecificState2.getLuteTuning();
		final ChordDescription[] chords = getChords(luteTuning);
		final int chordDescriptionIndex = Worker.randomInteger(chords.length);
		System.out.println("chordDescriptionIndex: " + chordDescriptionIndex); //$NON-NLS-1$
		final ChordDescription chordDescription = chords[chordDescriptionIndex];

		final LuteNote[] luteNotes = chordDescription.getNotes();
		final int[] midiNotes = getMidiNotes(luteTuning, luteNotes);

		final Chord absoluteChord = luteTuning.getAbsoluteChord(chordDescription.getChord());
		final GermanLuteTablatureChordsRandomResult randomResult = new GermanLuteTablatureChordsRandomResult(
				absoluteChord, luteNotes, midiNotes);
		System.out.println("absolute chord: " + absoluteChord); //$NON-NLS-1$
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

	private static int[] getMidiNotes(final LuteTuning luteTuning, final LuteNote[] luteNotes) {
		final int[] midiNotes = new int[luteNotes.length];
		for (int i = 0; i < luteNotes.length; i++) {
			midiNotes[i] = luteNotes[i].getMidiNote(luteTuning);
		}
		return midiNotes;
	}

}
