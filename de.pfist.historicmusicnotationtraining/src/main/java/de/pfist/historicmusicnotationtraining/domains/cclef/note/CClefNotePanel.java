package de.pfist.historicmusicnotationtraining.domains.cclef.note;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.cclef.BaseClefNotePanel;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class CClefNotePanel extends BaseClefNotePanel<CClefDomainSpecificState, ClefAndNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	public CClefNotePanel(Controller controller) {
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
		final int width = effectiveDimensions.width;
		final int height = effectiveDimensions.height;
		drawLines(g, originX, originY, width, height);
		if (isInitialized()) {
			drawClefAndNote(g, originX, originY, width, height, getDomainObject());
		}
	}

}