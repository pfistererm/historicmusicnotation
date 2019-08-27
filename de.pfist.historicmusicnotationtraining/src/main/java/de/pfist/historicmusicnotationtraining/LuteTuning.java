package de.pfist.historicmusicnotationtraining;

public class LuteTuning {

	public static final LuteTuning A_TUNING = new LuteTuning(Messages.getString("LuteTuning.tuningNameA"), //$NON-NLS-1$
			new int[] { 45, 50, 55, 59, 64, 69 }, new int[] { 8, 10, 10, 10, 10, 10 });
	public static final LuteTuning G_TUNING = new LuteTuning(Messages.getString("LuteTuning.tuningNameG"), //$NON-NLS-1$
			new int[] { 43, 48, 53, 57, 62, 67 }, new int[] { 8, 10, 10, 10, 10, 10 });

	private final String name;
	private final int[] midiBaseNotes;
	private final int[] frets;

	/**
	 * @param name
	 * 
	 * @param midiBaseNotes
	 * @param frets
	 */
	public LuteTuning(final String name, final int[] midiBaseNotes, final int[] frets) {
		this.name = name;
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

	@Override
	public final String toString() {
		return getName();
	}

}
