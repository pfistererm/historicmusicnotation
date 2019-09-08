package de.pfist.historicmusicnotationtraining.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.JPanel;

public class BarLineLabel<T> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6468888844255264261L;

	private boolean valuesReversed = true;
	private Map<T, Color> colorMap = null;
	private T[] values;

	/**
	 * 
	 */
	public BarLineLabel() {
		super();
		setOpaque(true);
	}

	public void setColorMap(final Map<T, Color> colorMap) {
		this.colorMap = colorMap;
	}

	/**
	 * @return the colorMap
	 */
	public final Map<T, Color> getColorMap() {
		return colorMap;
	}

	/**
	 * @return the values
	 */
	public final T[] getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public final void setValues(T[] values) {
		this.values = values;
	}

	/**
	 * @return the valuesReversed
	 */
	public final boolean isValuesReversed() {
		return valuesReversed;
	}

	/**
	 * @param valuesReversed
	 *            the valuesReversed to set
	 */
	public final void setValuesReversed(boolean valuesReversed) {
		this.valuesReversed = valuesReversed;
	}

	private Color getColor(T t) {
		if (colorMap == null) {
			return getDefaultColor();
		} else {
			Color c = colorMap.get(t);
			if (c == null) {
				return getDefaultColor();
			} else {
				return c;
			}
		}
	}

	protected Color getDefaultColor() {
		return getBackground();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// System.out.println("component insets: " + getInsets());
		// System.out.println("component bounds: " + getBounds());
		// System.out.println("graphics clip shape: " + g.getClip());
		// System.out.println("graphics clip bounds: " + g.getClipBounds());

		Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		int originX = effectiveDimensions.x;
		int originY = effectiveDimensions.y;
		int width = effectiveDimensions.width;
		int height = effectiveDimensions.height;
		boolean leftToRight = getComponentOrientation().isLeftToRight();
		if (values == null) {
			return;
		}
		int numValues = values.length;
		int numValuesToPaint = Math.min(numValues, width);
		int x = leftToRight ? originX : width - 1;
		for (int i = 0; i < numValuesToPaint; i++) {
			int valueIndex = valuesReversed ? numValuesToPaint - i - 1 : i;
			g.setColor(getColor(values[valueIndex]));
			g.drawLine(x, originY, x, originY + height);
			x = leftToRight ? x + 1 : x - 1;
		}
	}

}
