package de.pfist.historicmusicnotationtraining.util;

import javax.swing.BorderFactory;
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
}
