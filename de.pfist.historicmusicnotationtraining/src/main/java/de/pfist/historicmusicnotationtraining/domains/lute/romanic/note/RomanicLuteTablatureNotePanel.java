package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import java.awt.Graphics;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.BaseRomanicLuteTablatureNotePanel;

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
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
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