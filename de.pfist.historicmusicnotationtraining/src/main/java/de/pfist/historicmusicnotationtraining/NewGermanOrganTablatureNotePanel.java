package de.pfist.historicmusicnotationtraining;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class NewGermanOrganTablatureNotePanel extends AbstractNotePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039585713624309532L;

	/**
	 * Note names.
	 */
	private static final String[] NOTE_NAMES_LOWER = { //
			"c", "v", "d", "r", "e", "f", "t", "g", "y", "a", "b", "h" // //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
	};
	/**
	 * Note names.
	 */
	private static final String[] NOTE_NAMES_UPPER = { //
			"C", "V", "D", "R", "E", "F", "T", "G", "Y", "A", "B", "H" // //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
	};
	private static final String[] OCTAVE_ADDITIONS = { //
			"", "", "-", "=", "=-" // //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	};

	private boolean initialized = false;
	private int midiNote = 0;
	private Font font;
	private int fontSize = 40;

	public NewGermanOrganTablatureNotePanel(final Controller controller) {
		super(controller);
		final String fontName = "Möller"; //$NON-NLS-1$
		font = loadFont(fontName);
		if (font != null) {
			font = font.deriveFont(Font.BOLD, fontSize);
		}
	}

	@Override
	public void paintComponent(final Graphics g) {
		int width = getWidth();
		int height = getHeight();

		g.setFont(font);
		g.clearRect(0, 0, width, height);
		g.setColor(Color.black);
		if (initialized) {
			final int octave = (midiNote / 12) - 3;
			final int noteOffset = midiNote % 12;
			final boolean upperCase = octave == 0;
			String letter = (upperCase ? NOTE_NAMES_UPPER[noteOffset] : NOTE_NAMES_LOWER[noteOffset])
					+ OCTAVE_ADDITIONS[octave];
			System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
			System.out.println("octave: " + octave); //$NON-NLS-1$
			System.out.println("noteOffset: " + noteOffset); //$NON-NLS-1$
			System.out.println("characters to draw: " + letter); //$NON-NLS-1$
			// draw letter
			int letterY = height / 2;
			int letterX = width / 2;
			g.drawString(letter, letterX, letterY);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.pfist.learncclefs.AbstractNotePanel#setRandomResult(de.pfist.learncclefs.
	 * DomainRandomResult)
	 */
	@Override
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		final NewGermanOrganTablatureRandomResult randomResult = (NewGermanOrganTablatureRandomResult) domainRandomResult;
		this.midiNote = randomResult.getMidiNote();
		this.initialized = true;
	}

}