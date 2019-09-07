package de.pfist.historicmusicnotationtraining;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;

import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class CClefChordsNotePanel extends BaseClefNotePanel<CClefChordsDomainSpecificState> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private boolean initialized = false;
	private ClefAndNote[] clefAndNotes;

	public CClefChordsNotePanel(Controller controller) {
		super(controller);
//		// setBorder(BorderFactory.createLineBorder(Color.GREEN, 10, true));
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