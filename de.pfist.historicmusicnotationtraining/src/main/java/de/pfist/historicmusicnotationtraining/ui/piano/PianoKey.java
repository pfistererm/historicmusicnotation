package de.pfist.historicmusicnotationtraining.ui.piano;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Black and white keys on the piano.
 * 
 * Contains the dimension of the key (for hit testing and painting) and the MIDI
 * note number related to the key.
 */
class PianoKey {

	private final Rectangle dimensions;
	private final int midiNoteNumber;
	private boolean pressed;

	public PianoKey(final int midiNum) {
		this.dimensions = new Rectangle(0, 0, 0, 0);
		this.midiNoteNumber = midiNum;
	}

	/**
	 * @return the dimensions
	 */
	public final Rectangle getDimensions() {
		return dimensions;
	}

	/**
	 * @return the midiNoteNumber
	 */
	public final int getMidiNoteNumber() {
		return midiNoteNumber;
	}

	/**
	 * @return the pressed
	 */
	public final boolean isPressed() {
		return pressed;
	}

	/**
	 * @param pressed
	 *            the pressed to set
	 */
	public final void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public final void setDimensions(final int x, final int y, final int width, final int height) {
		dimensions.setBounds(x, y, width, height);
	}

	public void paintWhite(Graphics2D g2) {
		if (isPressed()) {
			g2.setColor(PianoKeyColors.SELECTED);
			g2.fill(getDimensions());
		}
		g2.setColor(PianoKeyColors.BLACK);
		g2.draw(getDimensions());
	}

	public void paintBlack(Graphics2D g2) {
		if (isPressed()) {
			g2.setColor(PianoKeyColors.SELECTED);
			g2.fill(getDimensions());
			g2.setColor(PianoKeyColors.BLACK);
			g2.draw(getDimensions());
		} else {
			g2.setColor(PianoKeyColors.BLACK);
			g2.fill(getDimensions());
		}
	}

	public void paint() {

	}
}