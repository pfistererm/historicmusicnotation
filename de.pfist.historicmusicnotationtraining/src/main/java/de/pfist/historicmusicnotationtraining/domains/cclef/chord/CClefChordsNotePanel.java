package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.pfist.historicmusicnotationtraining.ClefAndNote;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.domains.cclef.BaseClefNotePanel;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class CClefChordsNotePanel extends BaseClefNotePanel<CClefChordsDomainSpecificState, ClefAndNote[]> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

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
		if (isInitialized()) {
			drawClefAndNote(g, originX, originY, width, height, getDomainObject()[0]);
			drawClefAndNote(g, originX + width, originY, width, height, getDomainObject()[0]);
			drawClefAndNote(g, originX, originY + height, width, height, getDomainObject()[0]);
			drawClefAndNote(g, originX + width, originY + height, width, height, getDomainObject()[0]);
		}
	}

}