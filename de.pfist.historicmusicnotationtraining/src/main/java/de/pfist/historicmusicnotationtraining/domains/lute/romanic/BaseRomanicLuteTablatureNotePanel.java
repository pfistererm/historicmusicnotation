package de.pfist.historicmusicnotationtraining.domains.lute.romanic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public abstract class BaseRomanicLuteTablatureNotePanel<D extends DomainSpecificState> extends AbstractNotePanel<D> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6070175707376820131L;

	private static final String[] DIGITS = new String[] { "\uEBE0", "\uEBE1", "\uEBE2", "\uEBE3", "\uEBE4", "\uEBE5", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"\uEBE6", "\uEBE7", "\uEBE8", "\uEBE9" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	private static final String[] LETTERS = new String[] { "\uebc0", "\uebc1", "\uebc2", "\uebc3", "\uebc4", "\uebc5", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"\uebc6", "\uebc7", "\uebc8", "\uebc9" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	private Font scaledFont;

	public BaseRomanicLuteTablatureNotePanel(final Controller controller) {
		super(controller);
		getUnscaledSmuflFont();

		scaleFont();
		this.addComponentListener(new ComponentAdapter() {
			/** {@inheritDoc} */
			@Override
			public void componentResized(ComponentEvent e) {
				fontSize = e.getComponent().getHeight() / 3.0F;
				// System.out.println("Resized to " + e.getComponent().getSize()); //$NON-NLS-1$
				// System.out.println("fontSize: " + fontSize); //$NON-NLS-1$
				scaleFont();
			}
		});
	}

	private void scaleFont() {
		scaledFont = getUnscaledSmuflFont().deriveFont(fontSize);
	}

	protected void prepareDraw(final Graphics g) {
		g.setFont(scaledFont);
		g.setColor(Color.black);
		final Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		drawLines(g, effectiveDimensions.x, effectiveDimensions.y, effectiveDimensions.width,
				effectiveDimensions.height);
	}

	protected static void drawLines(Graphics g, final int xBase, final int yBase, final int width, final int height) {
		// half of space between lines
		final float halfLineSpaceUnit = height / 16.0F;
		g.setColor(Color.black);
		// draw lines
		int xLeft = xBase;
		int xRight = xBase + width;
		for (int i = 0; i < 6; i++) {
			final int lineY = calculateY(i * 2, halfLineSpaceUnit) + yBase;
			g.drawLine(xLeft, lineY, xRight, lineY);
		}
	}

	protected void drawSingleLetter(final Graphics g, int noteIndex, LuteNote luteNote,
			RomanicLuteTablatureVariant romanicLuteTablatureVariant) {
		System.out.println("luteNote:" + luteNote); //$NON-NLS-1$
		final Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		final int originX = effectiveDimensions.x;
		final int originY = effectiveDimensions.y;
		final int width = effectiveDimensions.width;
		final int height = effectiveDimensions.height;
		final float halfLineSpaceUnit = height / 16.0F;

		String character = getNoteName(luteNote, romanicLuteTablatureVariant);
		int stringIndex = luteNote.getString().getStringIndex();
		int positionInHalfUnits;
		if (romanicLuteTablatureVariant.isHighestStringTop()) {
			positionInHalfUnits = -1 + stringIndex * 2 + (romanicLuteTablatureVariant.isDrawCharactersOnLine() ? 0 : 1);
		} else {
			positionInHalfUnits = 9 - stringIndex * 2 - (romanicLuteTablatureVariant.isDrawCharactersOnLine() ? 0 : 1);
		}
		// draw letter
		int letterY = originY + calculateY(positionInHalfUnits, halfLineSpaceUnit);
		int letterX = originX + (int) (width / 2 + noteIndex * fontSize);
		g.drawString(character, letterX, letterY);
	}

	/**
	 * @param positionInHalfUnits
	 * @param halfLineSpaceUnit
	 * @return
	 */
	private static int calculateY(final int positionInHalfUnits, final float halfLineSpaceUnit) {
		return Math.round((14 - positionInHalfUnits) * halfLineSpaceUnit);
	}

	private static String getNoteName(final LuteNote luteNote,
			final RomanicLuteTablatureVariant romanicLuteTablatureVariant) {
		return (romanicLuteTablatureVariant.isUseLetters() ? LETTERS : DIGITS)[luteNote.getFretPosition()];
	}
}