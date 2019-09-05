package de.pfist.historicmusicnotationtraining.util;

import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

public class GuiUtils {

	public static Border createCompoundBorder(Border... borders) {
		if (borders == null || borders.length == 0) {
			return null;
		} else if (borders.length == 1) {
			return borders[0];
		} else {
			Border current = borders[0];
			for (int i = 1; i < borders.length; i++) {
				current = BorderFactory.createCompoundBorder(current, borders[i]);
			}
			return current;
		}
	}

	/**
	 * @param component a component
	 * @return a rectangle containing the effective drawing area
	 */
	public static Rectangle getEffectiveDimensions(final JComponent component) {
		Insets insets = component.getInsets();
		int width = component.getWidth() - insets.left - insets.right;
		int height = component.getHeight() - insets.top - insets.bottom;
		return new Rectangle(insets.left, insets.top, width, height);
	}
}
