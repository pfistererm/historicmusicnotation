package de.pfist.historicmusicnotationtraining.domains.lute.german.note;

import java.awt.Graphics;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.lute.german.BaseGermanLuteTablatureNotePanel;

public class GermanLuteTablatureNotePanel
		extends BaseGermanLuteTablatureNotePanel<GermanLuteTablatureDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private LuteNote luteNote;

	public GermanLuteTablatureNotePanel(final Controller controller) {
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
        Graphics scratchGraphics =g.create();
        try {
    		prepareDraw(scratchGraphics);
    		if (initialized) {
    			drawSingleLetter(scratchGraphics, 0, luteNote);
    		}
        }
        finally {
            scratchGraphics.dispose();
        }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		final GermanLuteTablatureRandomResult randomResult = (GermanLuteTablatureRandomResult) domainRandomResult;
		this.luteNote = randomResult.getLuteNote();
		this.initialized = true;
	}

}