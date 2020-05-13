package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.data.Chord;
import de.pfist.historicmusicnotationtraining.data.RelativeChord;
import de.pfist.historicmusicnotationtraining.messages.Messages;

public class LuteTuning {

	public static final LuteTuning A_TUNING = new LuteTuning(Messages.getString("LuteTuning.tuningNameA"), //$NON-NLS-1$
			9, new int[] { 45, 50, 55, 59, 64, 69 }, new int[] { 8, 10, 10, 10, 10, 10 });
	public static final LuteTuning G_TUNING = new LuteTuning(Messages.getString("LuteTuning.tuningNameG"), //$NON-NLS-1$
			7, new int[] { 43, 48, 53, 57, 62, 67 }, new int[] { 8, 10, 10, 10, 10, 10 });

	private final String name;
	private final int relativeNoteIndex;
	private final int[] midiBaseNotes;
	private final int[] frets;

	/**
	 * @param name
	 * @param relativeNoteIndex
	 * @param midiBaseNotes
	 * @param frets
	 */
	public LuteTuning(final String name, int relativeNoteIndex, final int[] midiBaseNotes, final int[] frets) {
		this.name = name;
		this.relativeNoteIndex = relativeNoteIndex;
		this.midiBaseNotes = midiBaseNotes;
		this.frets = frets;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @return the midiBaseNotes
	 */
	public final int[] getMidiBaseNotes() {
		return midiBaseNotes;
	}

	/**
	 * @return the frets
	 */
	public final int[] getFrets() {
		return frets;
	}

	public int getStringCount() {
		return midiBaseNotes.length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {
		return getName();
	}

	public Chord getAbsoluteChord(RelativeChord relativeChord) {
		int relativeIndex = (relativeChord.getRelativeIndex() + relativeNoteIndex) % 12;
		return Chord.getChord(relativeIndex, relativeChord.getChordType());
	}
}
