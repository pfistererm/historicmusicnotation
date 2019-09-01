package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;

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
	public void paintComponent(final Graphics g) {
		prepareDraw(g);
		if (initialized) {
			drawSingleLetter(g, 0, luteNote);
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