package de.pfist.historicmusicnotationtraining;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.function.Consumer;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class I18NComponentHelper {

	public static class EnumComboItem<E extends Enum<E>> {
		private final E enumItem;
		private final String labelText;

		/**
		 * @param enumItem
		 * @param labelText
		 */
		public EnumComboItem(E enumItem, String labelText) {
			this.enumItem = enumItem;
			this.labelText = labelText;
		}

		/**
		 * @return the enumItem
		 */
		public final E getEnumItem() {
			return enumItem;
		}

		/**
		 * @return the labelText
		 */
		public final String getLabelText() {
			return labelText;
		}

		@Override
		public String toString() {
			return getLabelText();
		}
	}

	public static <E extends Enum<E> & I18NEnum> JComboBox<EnumComboItem<E>> createComboBox(Class<E> enumClass,
			JComponent parent, final Consumer<E> selectionHandler) {
		final E[] enumConstants = enumClass.getEnumConstants();
		return createComboBox(enumClass, parent, selectionHandler, enumConstants);
	}

	@SafeVarargs
	public static <E extends Enum<E> & I18NEnum> JComboBox<EnumComboItem<E>> createComboBox(Class<E> enumClass,
			JComponent parent, final Consumer<E> selectionHandler, E... enumConstants) {
		Vector<EnumComboItem<E>> enumItems = new Vector<>();
		for (E e : enumConstants) {
			enumItems.add(new EnumComboItem<>(e, Messages.getString(e.getTextKey())));
		}
		JComboBox<EnumComboItem<E>> combo = new JComboBox<>(enumItems);
		if (selectionHandler != null) {
			combo.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					@SuppressWarnings("unchecked")
					final E selection = ((EnumComboItem<E>) (combo.getSelectedItem())).getEnumItem();
					selectionHandler.accept(selection);
				}
			});
		}
		if (parent != null) {
			parent.add(combo);
		}
		return combo;
	}

	public static <E extends Enum<E> & I18NEnum> void setSelectedItem(JComboBox<EnumComboItem<E>> combo,
			final E selected) {
		for (int itemIndex = 0; itemIndex < combo.getItemCount(); itemIndex++) {
			EnumComboItem<E> item = combo.getItemAt(itemIndex);
			if (item.getEnumItem() == selected) {
				combo.setSelectedItem(item);
				break;
			}
		}
	}

	public static  void createLuteTuningCombo(JPanel specificPanel, final AbstractLuteDomainSpecificState domainSpecificState) {
		// tuning selection
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.tuningLabel"))); //$NON-NLS-1$
		JComboBox<LuteTuning> luteTuningCombo = new JComboBox<>();
		luteTuningCombo.addItem(LuteTuning.A_TUNING);
		luteTuningCombo.addItem(LuteTuning.G_TUNING);
		specificPanel.add(luteTuningCombo);
	
		luteTuningCombo.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				LuteTuning luteTuning = (LuteTuning) (luteTuningCombo.getSelectedItem());
				domainSpecificState.setLuteTuning(luteTuning);
			}
		});
	}
}
