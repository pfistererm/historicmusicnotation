package de.pfist.historicmusicnotationtraining.domains.lute.german.note;

import java.awt.Graphics;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.lute.german.BaseGermanLuteTablatureNotePanel;

public class GermanLuteTablatureNoteNotePanel
		extends BaseGermanLuteTablatureNotePanel<GermanLuteTablatureNoteDomainSpecificState, LuteNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	public GermanLuteTablatureNoteNotePanel(final Controller controller) {
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
			if (isInitialized()) {
				drawSingleLetter(scratchGraphics, 0, getDomainObject());
			}
		} finally {
			scratchGraphics.dispose();
		}
	}

}