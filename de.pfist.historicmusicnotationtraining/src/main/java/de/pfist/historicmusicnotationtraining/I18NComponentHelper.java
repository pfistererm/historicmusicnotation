package de.pfist.historicmusicnotationtraining;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.function.Consumer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.domains.lute.AbstractLuteDomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.lute.AbstractLuteNoteDomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureFontVariant;
import de.pfist.historicmusicnotationtraining.domains.lute.german.GermanLuteTablatureNotationVariant;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.RomanicLuteTablatureVariant;
import de.pfist.historicmusicnotationtraining.messages.Messages;

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

		/** {@inheritDoc} */
		@Override
		public String toString() {
			return getLabelText();
		}
	}

	public static <E extends Enum<E> & I18NEnum> JComboBox<EnumComboItem<E>> createComboBox(Class<E> enumClass,
			JComponent parent, final Consumer<E> selectionHandler, final E selectedValue) {
		JComboBox<EnumComboItem<E>> combo = createComboBox(enumClass, parent, selectionHandler);
		setSelectedItem(combo, selectedValue);
		return combo;
	}

	public static <E extends Enum<E> & I18NEnum> JComboBox<EnumComboItem<E>> createComboBox(Class<E> enumClass,
			JComponent parent, final Consumer<E> selectionHandler) {
		final E[] enumConstants = enumClass.getEnumConstants();
		return createComboBox(enumClass, parent, selectionHandler, enumConstants);
	}

	@SafeVarargs
	public static <E extends Enum<E> & I18NEnum> JComboBox<EnumComboItem<E>> createComboBox(Class<E> enumClass,
			JComponent parent, final Consumer<E> selectionHandler, E... enumConstants) {
		Vector<EnumComboItem<E>> enumItems = createItemVector(enumConstants);
		JComboBox<EnumComboItem<E>> combo = new JComboBox<>(enumItems);
		if (selectionHandler != null) {
			combo.addItemListener(new ItemListener() {

				/** {@inheritDoc} */
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

	@SafeVarargs
	private static <E extends Enum<E> & I18NEnum> Vector<EnumComboItem<E>> createItemVector(E... enumConstants) {
		Vector<EnumComboItem<E>> enumItems = new Vector<>();
		for (final E e : enumConstants) {
			enumItems.add(new EnumComboItem<>(e, Messages.getString(e.getTextKey())));
		}
		return enumItems;
	}

	public static <E extends Enum<E> & I18NEnum> void setItems(JComboBox<EnumComboItem<E>> comboBox, E[] items) {
		Vector<EnumComboItem<E>> enumItems = createItemVector(items);
		comboBox.setModel(new DefaultComboBoxModel<>(enumItems));
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

	public static void createLuteTuningCombo(final JPanel specificPanel,
			final AbstractLuteDomainSpecificState domainSpecificState) {
		// tuning selection
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.tuningLabel"))); //$NON-NLS-1$
		JComboBox<LuteTuning> luteTuningCombo = new JComboBox<>();
		luteTuningCombo.addItem(LuteTuning.A_TUNING);
		luteTuningCombo.addItem(LuteTuning.G_TUNING);
		specificPanel.add(luteTuningCombo);

		luteTuningCombo.addItemListener(new ItemListener() {

			/** {@inheritDoc} */
			@Override
			public void itemStateChanged(ItemEvent e) {
				LuteTuning luteTuning = (LuteTuning) (luteTuningCombo.getSelectedItem());
				domainSpecificState.setLuteTuning(luteTuning);
			}
		});
	}

	public static void createLuteStringModeCombo(JPanel specificPanel,
			final AbstractLuteNoteDomainSpecificState domainSpecificState) {
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.stringLabel"))); //$NON-NLS-1$
		JComboBox<EnumComboItem<LuteStringMode>> combo = createComboBox(LuteStringMode.class, specificPanel, (t) -> {
			domainSpecificState.setLuteStringMode(t);
		}, //
				LuteStringMode.ALL, LuteStringMode.S45, LuteStringMode.S345, LuteStringMode.S5, LuteStringMode.S4, LuteStringMode.S3, LuteStringMode.S2,
				LuteStringMode.S1, LuteStringMode.S0);
		setSelectedItem(combo, domainSpecificState.getLuteStringMode());
	}

	public static void createKeyModeCombo(final JPanel specificPanel,
			final AbstractLuteNoteDomainSpecificState domainSpecificState) {
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.keyLabel"))); //$NON-NLS-1$
		createComboBox(KeyMode.class, specificPanel, (t) -> domainSpecificState.setKeyMode(t),
				domainSpecificState.getKeyMode());
	}

	public static void createRomanicLuteTablatureVariantCombo(final JPanel specificPanel,
			final IRomanicLuteTablatureVariantState domainSpecificState) {
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.romanicLuteTablatureVariantLabel"))); //$NON-NLS-1$
		createComboBox(RomanicLuteTablatureVariant.class, specificPanel,
				(t) -> domainSpecificState.setRomanicLuteTablatureVariant(t),
				domainSpecificState.getRomanicLuteTablatureVariant());
	}

	public static void createGermanLuteTablatureNotationVariantCombo(final JPanel specificPanel,
			final IGermanLuteTablatureVariantState domainSpecificState) {
		specificPanel
				.add(new JLabel(Messages.getString("I18NComponentHelper.germanLuteTablatureNotationVariantLabel"))); //$NON-NLS-1$
		createComboBox(GermanLuteTablatureNotationVariant.class, specificPanel,
				(t) -> domainSpecificState.setGermanLuteTablatureNotationVariant(t),
				domainSpecificState.getGermanLuteTablatureNotationVariant());
	}

	public static void createGermanLuteTablatureFontVariantCombo(final JPanel specificPanel,
			final IGermanLuteTablatureVariantState domainSpecificState) {
		specificPanel.add(new JLabel(Messages.getString("I18NComponentHelper.germanLuteTablatureFontVariantLabel"))); //$NON-NLS-1$
		createComboBox(GermanLuteTablatureFontVariant.class, specificPanel,
				(t) -> domainSpecificState.setGermanLuteTablatureFontVariant(t),
				domainSpecificState.getGermanLuteTablatureFontVariant());
	}
}
