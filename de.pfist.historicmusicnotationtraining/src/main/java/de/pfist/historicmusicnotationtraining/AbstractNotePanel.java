package de.pfist.historicmusicnotationtraining;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public abstract class AbstractNotePanel extends JPanel {

	private static final String SMUFL_FONT_NAME = "Bravura"; //$NON-NLS-1$

	/**
	 * 
	 */
	private static final long serialVersionUID = 5639322492906295423L;

	private static Font unscaledSmuflFont = null;

	protected AbstractNotePanel(final Controller controller) {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				controller.doNext(false);
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}

	public abstract void setRandomResult(DomainRandomResult domainRandomResult);

	/**
	 * Loads a truetype font from the resources directory.
	 * 
	 * @param fontName
	 * @return
	 */
	protected static Font loadFont(final String fontName) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/" + fontName + ".otf")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Obtains a SMUFL ( Standard music font layout) font.
	 * 
	 * @return an unscaled font
	 */
	protected static Font getUnscaledSmuflFont() {
		if (unscaledSmuflFont == null) {
			unscaledSmuflFont = loadFont(SMUFL_FONT_NAME);
		}
		return unscaledSmuflFont;
	}

}