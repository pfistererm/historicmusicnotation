package de.pfist.historicmusicnotationtraining.util;

import java.awt.Rectangle;

/**
 * Black and white keys on the piano.
 * 
 * Contains the dimension of the key (for hit testing) and the MIDI note number
 * related to the key.
 */
class PianoKey {
	private final Rectangle dimensions;
	private final int midiNoteNumber;
	private boolean pressed;

	public PianoKey(final int x, final int y, final int width, final int height, final int midiNum) {
		this.dimensions = new Rectangle(x, y, width, height);
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

}