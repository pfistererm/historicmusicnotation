package de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.ui.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.ui.util.GuiUtils;

public class NewGermanOrganTablatureNoteNotePanel extends AbstractNotePanel<NewGermanOrganTablatureNoteDomainSpecificState, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	/**
	 * Note names.
	 */
	private static final String[] NOTE_NAMES_LOWER = { //
			"\uEE0C", "\uEE0D", "\uEE0E", "\uEE0F", "\uEE10", "\uEE11", "\uEE12", "\uEE13", "\uEE14", "\uEE15", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"\uEE16", "\uEE17" //$NON-NLS-1$ //$NON-NLS-2$
	};
	/**
	 * Note names.
	 */
	private static final String[] NOTE_NAMES_UPPER = { //
			"\uEE00", "\uEE01", "\uEE02", "\uEE03", "\uEE04", "\uEE05", "\uEE06", "\uEE07", "\uEE08", "\uEE09", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
			"\uEE0A", "\uEE0B" //$NON-NLS-1$ //$NON-NLS-2$
	};
	private static final String[] OCTAVE_ADDITIONS = { //
			"", "", "\uEE18", "\uEE19", "\uEE19\uEE18" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	};

	private Font font;

	public NewGermanOrganTablatureNoteNotePanel(final Controller controller) {
		super(controller);
		fontSize = 40;
		font = getUnscaledSmuflFont();
		if (font != null) {
			font = font.deriveFont(Font.BOLD, fontSize);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		final int originX = effectiveDimensions.x;
		final int originY = effectiveDimensions.y;
		final int width = effectiveDimensions.width;
		final int height = effectiveDimensions.height;

		g.setFont(font);
		g.setColor(Color.black);
		if (isInitialized()) {
			final int octave = (getDomainObject() / 12) - 3;
			final int noteOffset = getDomainObject() % 12;
			final boolean upperCase = octave == 0;
			String letter = (upperCase ? NOTE_NAMES_UPPER[noteOffset] : NOTE_NAMES_LOWER[noteOffset])
					+ OCTAVE_ADDITIONS[octave];
			System.out.println("midiNote: " + getDomainObject()); //$NON-NLS-1$
			System.out.println("octave: " + octave); //$NON-NLS-1$
			System.out.println("noteOffset: " + noteOffset); //$NON-NLS-1$
			System.out.println("characters to draw: " + letter); //$NON-NLS-1$
			// draw letter
			int letterY = originY + height / 2;
			int letterX = originX + width / 2;
			g.drawString(letter, letterX, letterY);
		}
	}

}