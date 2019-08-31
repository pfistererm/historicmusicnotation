package de.pfist.historicmusicnotationtraining;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public abstract class BaseClefNotePanel extends AbstractNotePanel {

	private static final String G_CLEF_CHAR = "\ue050"; //$NON-NLS-1$
	private static final String C_CLEF_CHAR = "\ue05c"; //$NON-NLS-1$
	private static final String F_CLEF_CHAR = "\ue062"; //$NON-NLS-1$
	private static final String NOTEHEAD_CHAR = "\ue0A4"; //$NON-NLS-1$

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	private Font unscaledFont;

	protected BaseClefNotePanel(Controller controller) {
		super(controller);
		unscaledFont = getUnscaledSmuflFont();
	}

	protected static void drawLines(Graphics g, final int width, final int height, final int xBase, final int yBase) {
		// half of space between lines
		final float halfLineSpaceUnit = height / 16.0F;
		g.clearRect(xBase, yBase, width, height);
		g.setColor(Color.black);
		// draw lines
		int xLeft = xBase;
		int xRight = xBase + width;
		for (int i = 0; i < 5; i++) {
			final int lineY = calculateY(i * 2, halfLineSpaceUnit) + yBase;
			g.drawLine(xLeft, lineY, xRight, lineY);
		}
	}

	protected void drawClefAndNote(Graphics g, final int width, final int height, final int xBase, final int yBase,
			ClefAndNote clefAndNote) {
		final float halfLineSpaceUnit = height / 16.0F;
		final float fontSize = halfLineSpaceUnit * 8.0F;
		final Font scaledFont = unscaledFont.deriveFont(fontSize);
		g.setFont(scaledFont);
		Clef clef = clefAndNote.getClef();
		int note = clefAndNote.getNoteRelative();
		// draw clef
		int clefX = width / 4 + xBase;
		int clefY = calculateY((clef.getLine() * 2 - 2), halfLineSpaceUnit) + yBase;
		final String clefChar = getClefCharacter(clef);
		g.drawString(clefChar, clefX, clefY);
		// draw note
		int noteX = width / 2 + xBase;
		int noteY = calculateY(note, halfLineSpaceUnit) + yBase;
		g.drawString(NOTEHEAD_CHAR, noteX, noteY);
	}

	private static String getClefCharacter(final Clef clef) {
		switch (clef.getClefType()) {
		case G_CLEF:
			return G_CLEF_CHAR;
		case C_CLEF:
			return C_CLEF_CHAR;
		case F_CLEF:
			return F_CLEF_CHAR;
		default:
			throw new RuntimeException("Unsupported clef type: " + clef.getClefType());
		}
	}

	/**
	 * @param positionInHalfUnits
	 * @param halfLineSpaceUnit
	 * @return
	 */
	private static int calculateY(final int positionInHalfUnits, final float halfLineSpaceUnit) {
		return Math.round((12 - positionInHalfUnits) * halfLineSpaceUnit);
	}

}