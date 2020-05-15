package de.pfist.historicmusicnotationtraining.ui.util;

import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

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

	public static Border createTripleEtchedBorder(final int emptyOuterWidth, final int etchType,
			final int emptyInnerWidth) {
		final EtchedBorder etchedBorder = new EtchedBorder(etchType);
		return createTripleBorder(emptyOuterWidth, etchedBorder, emptyInnerWidth);
	}

	public static Border createTripleBevelBorder(final int emptyOuterWidth, final int bevelType,
			final int emptyInnerWidth) {
		final BevelBorder bevelBorder = new BevelBorder(bevelType);
		return createTripleBorder(emptyOuterWidth, bevelBorder, emptyInnerWidth);
	}

	private static Border createTripleBorder(final int emptyOuterWidth, final Border middleBorder,
			final int emptyInnerWidth) {
		final EmptyBorder outerEmptyBorder = new EmptyBorder(emptyOuterWidth, emptyOuterWidth, emptyOuterWidth,
				emptyOuterWidth);
		final EmptyBorder innerEmptyBorder = new EmptyBorder(emptyInnerWidth, emptyInnerWidth, emptyInnerWidth,
				emptyInnerWidth);
		return createCompoundBorder(outerEmptyBorder, middleBorder, innerEmptyBorder);
	}

	/**
	 * @param component
	 *            a component
	 * @return a rectangle containing the effective drawing area
	 */
	public static Rectangle getEffectiveDimensions(final JComponent component) {
		Insets insets = component.getInsets();
		int width = component.getWidth() - insets.left - insets.right;
		int height = component.getHeight() - insets.top - insets.bottom;
		return new Rectangle(insets.left, insets.top, width, height);
	}

	/**
	 * Sets the selected value on an Integer ComoBox.
	 * 
	 * @param integerCombo
	 * @param value
	 */
	public static void setIntegerInitialValue(final JComboBox<Integer> integerCombo, final int value) {
		for (int i = 0; i < integerCombo.getItemCount(); i++) {
			Integer item = integerCombo.getItemAt(i);
			if (item.intValue() == value) {
				integerCombo.setSelectedItem(item);
			}
		}
	}
}
