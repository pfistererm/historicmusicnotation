package de.pfist.historicmusicnotationtraining;

/**
 *
 */
public class GermanLuteTablatureChordsWorkerExtension implements
		WorkerExtension<GermanLuteTablatureChordsDomainSpecificState, GermanLuteTablatureChordsRandomResult> {

	public static class ChordDescription {
		private final Chord chord;
		private final LuteNote[] luteNotes;

		/**
		 * @param chord
		 * @param luteNotes
		 */
		public ChordDescription(final Chord chord, LuteNote... luteNotes) {
			this.chord = chord;
			this.luteNotes = luteNotes;
		}

		/**
		 * @return the chord
		 */
		public final Chord getChord() {
			return chord;
		}

		/**
		 * @return the luteNotes
		 */
		public final LuteNote[] getLuteNotes() {
			return luteNotes;
		}
	}

	// TODO: chord depends on tuning
	private static final ChordDescription[] CHORDS = new ChordDescription[] {
			// A
			new ChordDescription(Chord.A_MINOR, LuteNote.S4_0, LuteNote.S3_1, LuteNote.S2_2), // 4cg
			new ChordDescription(Chord.A_POWER, LuteNote.S4_0, LuteNote.S2_2, LuteNote.S1_2), // 4gf
			new ChordDescription(Chord.A_MINOR, LuteNote.S4_0, LuteNote.S3_1, LuteNote.S0_0), // 4cA
			new ChordDescription(Chord.A_POWER, LuteNote.S4_0, LuteNote.S2_2, LuteNote.S0_0), // 4gA
			new ChordDescription(Chord.A_MINOR, LuteNote.S4_5, LuteNote.S3_5, LuteNote.S2_5), // 7zy
			new ChordDescription(Chord.A_POWER, LuteNote.S4_5, LuteNote.S3_5, LuteNote.S1_2), // 7zf
			new ChordDescription(Chord.A_MAJOR, LuteNote.S4_0, LuteNote.S3_2, LuteNote.S2_2), // 4hg
			new ChordDescription(Chord.A_MAJOR, LuteNote.S4_0, LuteNote.S3_2, LuteNote.S0_0), // 4hA
			new ChordDescription(Chord.A_MAJOR, LuteNote.S3_2, LuteNote.S2_2, LuteNote.S0_0), // hgA
			// B
			new ChordDescription(Chord.B_MAJOR, LuteNote.S4_2, LuteNote.S3_4, LuteNote.S2_4), // isr
			new ChordDescription(Chord.B_MAJOR, LuteNote.S4_2, LuteNote.S3_4, LuteNote.S0_2), // isC
			new ChordDescription(Chord.B_POWER, LuteNote.S4_2, LuteNote.S2_4, LuteNote.S0_2), // irC
			new ChordDescription(Chord.B_MINOR, LuteNote.S3_3, LuteNote.S2_4, LuteNote.S0_2), // nrC
			new ChordDescription(Chord.B_MINOR, LuteNote.S4_2, LuteNote.S3_3, LuteNote.S0_2), // inC
			// C
			new ChordDescription(Chord.C_POWER, LuteNote.S3_1, LuteNote.S2_0, LuteNote.S0_3), // c2D
			new ChordDescription(Chord.C_MAJOR, LuteNote.S4_0, LuteNote.S2_0, LuteNote.S0_3), // 42D
			new ChordDescription(Chord.C_MAJOR, LuteNote.S3_5, LuteNote.S2_5, LuteNote.S1_2), // zyf
			new ChordDescription(Chord.C_POWER, LuteNote.S4_3, LuteNote.S2_5, LuteNote.S0_3), // oyD
			new ChordDescription(Chord.C_MAJOR, LuteNote.S3_1, LuteNote.S2_0, LuteNote.S1_2), // c2f
			new ChordDescription(Chord.C_MAJOR, LuteNote.S4_3, LuteNote.S3_5, LuteNote.S0_3), // ozD
			new ChordDescription(Chord.C_MAJOR, LuteNote.S3_5, LuteNote.S2_5, LuteNote.S0_3), // zyD
			new ChordDescription(Chord.C_POWER, LuteNote.S4_8, LuteNote.S3_8, LuteNote.S2_5), // o'n'y
			new ChordDescription(Chord.C_POWER, LuteNote.S4_3, LuteNote.S3_1, LuteNote.S0_3), // ocD
			// D
			new ChordDescription(Chord.D_MINOR, LuteNote.S4_1, LuteNote.S3_3, LuteNote.S1_0), // dn1
			new ChordDescription(Chord.D_MINOR, LuteNote.S4_5, LuteNote.S3_6, LuteNote.S2_7), // 7c'g'
			new ChordDescription(Chord.D_POWER, LuteNote.S3_3, LuteNote.S2_2, LuteNote.S1_0), // ng1
			new ChordDescription(Chord.D_MAJOR, LuteNote.S4_2, LuteNote.S3_3, LuteNote.S1_0), // in1
			new ChordDescription(Chord.D_MAJOR, LuteNote.S4_5, LuteNote.S3_7, LuteNote.S0_5), // 7h'F
			new ChordDescription(Chord.D_POWER, LuteNote.S4_5, LuteNote.S2_7, LuteNote.S0_5), // 7g'F
			// E
			new ChordDescription(Chord.E_MINOR, LuteNote.S4_0, LuteNote.S3_0, LuteNote.S2_0), // 432
			new ChordDescription(Chord.E_POWER, LuteNote.S3_5, LuteNote.S2_4, LuteNote.S1_2), // zrf
			new ChordDescription(Chord.E_POWER, LuteNote.S4_0, LuteNote.S3_0, LuteNote.S1_2), // 43f
			new ChordDescription(Chord.E_MINOR, LuteNote.S3_0, LuteNote.S2_0, LuteNote.S1_2), // 32f
			new ChordDescription(Chord.E_MINOR, LuteNote.S4_3, LuteNote.S3_0, LuteNote.S1_2), // o3f
			new ChordDescription(Chord.E_MAJOR, LuteNote.S4_0, LuteNote.S2_1, LuteNote.S1_2), // 4bf
			new ChordDescription(Chord.E_MAJOR, LuteNote.S4_4, LuteNote.S3_5, LuteNote.S1_2), // tzf
			new ChordDescription(Chord.E_MAJOR, LuteNote.S4_7, LuteNote.S3_9, LuteNote.S0_7), // i's'H
			// F
			new ChordDescription(Chord.F_MAJOR, LuteNote.S3_1, LuteNote.S2_2, LuteNote.S1_3), // cgL
			new ChordDescription(Chord.F_POWER, LuteNote.S4_1, LuteNote.S3_1, LuteNote.S1_3), // dcL
			// F#
			new ChordDescription(Chord.FS_POWER, LuteNote.S4_2, LuteNote.S3_2, LuteNote.S1_4), // ihq
			// G
			new ChordDescription(Chord.G_POWER, LuteNote.S4_3, LuteNote.S3_3, LuteNote.S2_0), // on2
			new ChordDescription(Chord.G_MAJOR, LuteNote.S4_3, LuteNote.S3_3, LuteNote.S2_4, LuteNote.S0_2), // onrC
			new ChordDescription(Chord.G_MAJOR, LuteNote.S4_7, LuteNote.S3_8, LuteNote.S0_2), // i'n'C
			new ChordDescription(Chord.G_POWER, LuteNote.S3_8, LuteNote.S2_7, LuteNote.S0_5), // n'g'F
			new ChordDescription(Chord.G_MAJOR, LuteNote.S4_3, LuteNote.S2_4, LuteNote.S0_2), // orC
	};

//	 int chordDescriptionIndex = 0;

	private static ChordDescription[] getChords(final LuteTuning luteTuning) {
		return CHORDS;
	}

	@Override
	public GermanLuteTablatureChordsRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		final GermanLuteTablatureChordsDomainSpecificState domainSpecificState2 = (GermanLuteTablatureChordsDomainSpecificState) domainSpecificState;
		final LuteTuning luteTuning = domainSpecificState2.getLuteTuning();
		final ChordDescription[] chords = getChords(luteTuning);
		final int chordDescriptionIndex = Worker.randomInteger(chords.length);
		System.out.println("chordDescriptionIndex: " + chordDescriptionIndex);
		final ChordDescription chordDescription = chords[chordDescriptionIndex];

		final LuteNote[] luteNotes = chordDescription.getLuteNotes();
		final int[] midiNotes = new int[luteNotes.length];
		for (int i = 0; i < luteNotes.length; i++) {
			midiNotes[i] = luteNotes[i].getMidiNote(luteTuning);
		}

		final GermanLuteTablatureChordsRandomResult randomResult = new GermanLuteTablatureChordsRandomResult(
				chordDescription.getChord(), luteNotes, midiNotes);
		System.out.println("chord: " + chordDescription.getChord()); //$NON-NLS-1$
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

}
