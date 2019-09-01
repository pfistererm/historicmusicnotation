package de.pfist.historicmusicnotationtraining;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class BaseGermanLuteTablatureNotePanel<D extends IGermanLuteTablatureVariantState & DomainSpecificState>
		extends AbstractNotePanel<D> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6912518755149078029L;

	private Font font;
	private float fontSize = 24;
	private boolean fontIsSmufl;

	public BaseGermanLuteTablatureNotePanel(final Controller controller) {
		super(controller);
		// BevelBorder bb = new BevelBorder(BevelBorder.LOWERED);
		// setBorder(bb);
		scaleFont();
		this.addComponentListener(new ComponentAdapter() {
			/** {@inheritDoc} */
			@Override
			public void componentResized(ComponentEvent e) {
				scaleFont();
				// System.out.println("Resized to " + e.getComponent().getSize()); //$NON-NLS-1$
			}
		});
	}

	private void scaleFont() {
		int componentHeight = this.getHeight();
		fontSize = componentHeight / 3.0F;
		if (getDomainSpecificState(IGermanLuteTablatureVariantState.class) != null) {
			fontIsSmufl = isUseSmufl();
			if (fontIsSmufl) {
				fontSize *= 1.5f;
				font = getUnscaledSmuflFont().deriveFont(fontSize);
			} else {
				font = new Font("default", Font.BOLD, (int) fontSize); //$NON-NLS-1$
			}
		}
	}

	private boolean isUseSmufl() {
		return getGermanLuteTablatureFontVariant().isUseSmufl();
	}

	private void checkFont() {
		if (isUseSmufl() != fontIsSmufl) {
			scaleFont();
		}
	}

	private GermanLuteTablatureNotationVariant getGermanLuteTablatureNotationVariant() {
		return getDomainSpecificState(IGermanLuteTablatureVariantState.class).getGermanLuteTablatureNotationVariant();
	}

	private GermanLuteTablatureFontVariant getGermanLuteTablatureFontVariant() {
		return getDomainSpecificState(IGermanLuteTablatureVariantState.class) != null
				? getDomainSpecificState(IGermanLuteTablatureVariantState.class).getGermanLuteTablatureFontVariant()
				: GermanLuteTablatureFontVariant.ANTIQUA;
	}

	protected void prepareDraw(final Graphics g) {
		checkFont();
		g.setFont(font);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(fontSize / 10));
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
	}

	protected void drawSingleLetter(final Graphics g, int noteIndex, LuteNote luteNote) {
		int width = getWidth();
		int height = getHeight();
		String letter = GermanLuteUtils.getNoteName(luteNote, getGermanLuteTablatureNotationVariant(),
				getGermanLuteTablatureFontVariant());
		boolean paintBar = false;
		if (letter.endsWith("'")) { //$NON-NLS-1$
			paintBar = true;
			letter = letter.substring(0, letter.length() - 1);
		}
		// System.out.println("char (hex): "+ Integer.toHexString(letter.charAt(0)));
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