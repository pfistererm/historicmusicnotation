package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;

public class GermanLuteTablatureChordsNotePanel
		extends BaseGermanLuteTablatureNotePanel<GermanLuteTablatureChordsDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private LuteNote[] luteNotes;

	public GermanLuteTablatureChordsNotePanel(final Controller controller) {
		super(controller);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintComponent(final Graphics g) {

		prepareDraw(g);
		if (initialized) {
			for (int noteIndex = 0; noteIndex < luteNotes.length; noteIndex++) {
				LuteNote luteNote = luteNotes[noteIndex];
				drawSingleLetter(g, noteIndex, luteNote);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		final GermanLuteTablatureChordsRandomResult randomResult = (GermanLuteTablatureChordsRandomResult) domainRandomResult;
		this.luteNotes = randomResult.getNotes();
		this.initialized = true;
	}

}