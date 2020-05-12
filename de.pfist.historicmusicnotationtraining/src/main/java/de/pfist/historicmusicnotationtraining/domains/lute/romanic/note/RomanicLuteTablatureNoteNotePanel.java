package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import java.awt.Graphics;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.BaseRomanicLuteTablatureNotePanel;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.RomanicLuteTablatureVariant;

public class RomanicLuteTablatureNoteNotePanel
		extends BaseRomanicLuteTablatureNotePanel<RomanicLuteTablatureNoteDomainSpecificState, LuteNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private RomanicLuteTablatureVariant romanicLuteTablatureVariant;

	public RomanicLuteTablatureNoteNotePanel(final Controller controller) {
		super(controller);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		prepareDraw(g);
		if (isInitialized()) {
			drawSingleLetter(g, 0, getDomainObject(), romanicLuteTablatureVariant);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		final RomanicLuteTablatureNoteRandomResult randomResult = (RomanicLuteTablatureNoteRandomResult) domainRandomResult;
		super.setRandomResult(domainRandomResult);
		this.romanicLuteTablatureVariant = randomResult.getRomanicLuteTablatureVariant();
	}

}