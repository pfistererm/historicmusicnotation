package de.pfist.historicmusicnotationtraining;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class BaseGermanLuteTablatureNotePanel extends AbstractNotePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6912518755149078029L;

	private Font font;
	private float fontSize = 24;

	public BaseGermanLuteTablatureNotePanel(final Controller controller) {
		super(controller);
		scaleFont();
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				fontSize = e.getComponent().getHeight() / 3.0F;
				scaleFont();
				// System.out.println("Resized to " + e.getComponent().getSize()); //$NON-NLS-1$
			}
		});
	}

	private void scaleFont() {
		font = new Font("default", Font.BOLD, (int) fontSize); //$NON-NLS-1$
	}

	protected void prepareDraw(final Graphics g) {
		g.setFont(font);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(fontSize / 10));
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
	}

	protected void drawSingleLetter(final Graphics g, int noteIndex, LuteNote luteNote) {
		int width = getWidth();
		int height = getHeight();
		String letter = GermanLuteUtils.getNoteName(luteNote);
		boolean paintBar = false;
		if (letter.endsWith("'")) { //$NON-NLS-1$
			paintBar = true;
			letter = letter.substring(0, letter.length() - 1);
		}
		// draw letter
		int letterY = height / 2;
		int letterX = (int) (width / 2 + noteIndex * fontSize);
		FontMetrics fontMetricesForLabel = g.getFontMetrics();
		double LetterWidth = fontMetricesForLabel.getStringBounds(letter, g).getWidth();
		g.drawString(letter, letterX, letterY);
		if (paintBar) {
			int lineY = (int) (letterY - fontSize);
			g.drawLine(letterX, lineY, (int) (letterX + LetterWidth), lineY);
		}
	}

}