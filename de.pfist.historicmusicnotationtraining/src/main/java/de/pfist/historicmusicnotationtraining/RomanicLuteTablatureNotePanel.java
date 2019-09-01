package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;

public class RomanicLuteTablatureNotePanel
		extends BaseRomanicLuteTablatureNotePanel<RomanicLuteTablatureDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private LuteNote luteNote;
	private RomanicLuteTablatureVariant romanicLuteTablatureVariant;

	public RomanicLuteTablatureNotePanel(final Controller controller) {
		super(controller);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintComponent(final Graphics g) {
		prepareDraw(g);
		if (initialized) {
			drawSingleLetter(g, 0, luteNote, romanicLuteTablatureVariant);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		final RomanicLuteTablatureRandomResult randomResult = (RomanicLuteTablatureRandomResult) domainRandomResult;
		this.luteNote = randomResult.getLuteNote();
		this.romanicLuteTablatureVariant = randomResult.getRomanicLuteTablatureVariant();
		this.initialized = true;
	}

}