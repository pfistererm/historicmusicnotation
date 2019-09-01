package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;

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
	public void paintComponent(Graphics g) {
		final int width = getWidth();
		final int height = getHeight();
		final int xBase = 0;
		final int yBase = 0;
		drawLines(g, width, height, xBase, yBase);
		if (initialized) {
			drawClefAndNote(g, width, height, xBase, yBase, clefAndNote);
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