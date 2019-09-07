package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class CClefNotePanel extends BaseClefNotePanel<CClefDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private ClefAndNote clefAndNote;

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
		if (initialized) {
			drawClefAndNote(g, originX, originY, width, height, clefAndNote);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRandomResult(DomainRandomResult domainRandomResult) {
		final CClefRandomResult cClefRandomResult = (CClefRandomResult) domainRandomResult;
		this.clefAndNote = cClefRandomResult.getClefAndNote();
		initialized = true;
	}

}