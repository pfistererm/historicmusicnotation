package de.pfist.historicmusicnotationtraining;

import java.awt.Graphics;

public class CClefChordsNotePanel extends BaseClefNotePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private ClefAndNote[] clefAndNotes;

	public CClefChordsNotePanel(Controller controller) {
		super(controller);
	}

	@Override
	public void paintComponent(Graphics g) {
		final int totalWidth = getWidth();
		final int width = getWidth() / 2;
		final int height = getHeight() / 2;
		final int xBase = 0;
		final int yBase = 0;
		drawLines(g, totalWidth, height, xBase, yBase);
		drawLines(g, totalWidth, height, xBase, yBase + height);
		if (initialized) {
			drawClefAndNote(g, width, height, xBase, yBase, clefAndNotes[0]);
			drawClefAndNote(g, width, height, xBase + width, yBase, clefAndNotes[0]);
			drawClefAndNote(g, width, height, xBase, yBase + height, clefAndNotes[0]);
			drawClefAndNote(g, width, height, xBase + width, yBase + height, clefAndNotes[0]);
		}
	}

	/**
	 */
	@Override
	public final void setRandomResult(DomainRandomResult domainRandomResult) {
		final CClefChordsRandomResult cClefRandomResult = (CClefChordsRandomResult) domainRandomResult;
		this.clefAndNotes = cClefRandomResult.getClefAndNotes();
		initialized = true;
	}

}