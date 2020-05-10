package de.pfist.historicmusicnotationtraining.piano;

import java.awt.Color;

import javax.swing.UIDefaults;

/**
 * Colors for painting piano keys.
 */
public abstract class PianoKeyColors {
	public static final Color BLACK = Color.black;
	public static final Color WHITE = Color.white;
	public static final Color SELECTED = getSelectionColor();

	private static Color getSelectionColor() {
		UIDefaults defaults = javax.swing.UIManager.getDefaults();
		return defaults.getColor("List.selectionBackground");

	}
}
