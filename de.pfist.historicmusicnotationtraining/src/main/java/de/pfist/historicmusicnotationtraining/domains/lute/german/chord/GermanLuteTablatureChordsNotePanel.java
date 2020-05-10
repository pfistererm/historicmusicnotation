package de.pfist.historicmusicnotationtraining.domains.lute.german.chord;

import java.awt.Graphics;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.lute.german.BaseGermanLuteTablatureNotePanel;

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
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		// copy of Graphics needed because prepareDraw() sets the stroke,
		// whiich leads to problems in border drawing
		Graphics scratchGraphics = g.create();
		try {
			prepareDraw(scratchGraphics);
			if (initialized) {
				for (int noteIndex = 0; noteIndex < luteNotes.length; noteIndex++) {
					LuteNote luteNote = luteNotes[noteIndex];
					drawSingleLetter(scratchGraphics, noteIndex, luteNote);
				}
			}
		} finally {
			scratchGraphics.dispose();
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