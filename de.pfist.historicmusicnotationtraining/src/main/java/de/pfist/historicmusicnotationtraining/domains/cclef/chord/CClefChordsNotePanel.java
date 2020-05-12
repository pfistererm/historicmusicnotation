package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.pfist.historicmusicnotationtraining.ClefAndNote;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.cclef.BaseClefNotePanel;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class CClefChordsNotePanel extends BaseClefNotePanel<CClefChordsDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private ClefAndNote[] clefAndNotes;

	public CClefChordsNotePanel(Controller controller) {
		super(controller);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		final Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		final int originX = effectiveDimensions.x;
		final int originY = effectiveDimensions.y;
		final int totalWidth = effectiveDimensions.width;
		final int width = effectiveDimensions.width / 2;
		final int height = effectiveDimensions.height / 2;
		drawLines(g, originX, originY, totalWidth, height);
		drawLines(g, originX, originY + height, totalWidth, height);
		if (initialized) {
			drawClefAndNote(g, originX, originY, width, height, clefAndNotes[0]);
			drawClefAndNote(g, originX + width, originY, width, height, clefAndNotes[0]);
			drawClefAndNote(g, originX, originY + height, width, height, clefAndNotes[0]);
			drawClefAndNote(g, originX + width, originY + height, width, height, clefAndNotes[0]);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRandomResult(DomainRandomResult domainRandomResult) {
		final CClefChordsRandomResult cClefRandomResult = (CClefChordsRandomResult) domainRandomResult;
		this.clefAndNotes = cClefRandomResult.getClefAndNotes();
		initialized = true;
	}

}