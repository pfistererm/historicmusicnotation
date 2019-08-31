package de.pfist.historicmusicnotationtraining;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoteButtonPanelContainer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1130754558315947299L;

	private Controller controller;
	private final JPanel mainPanel;
	private JComboBox<NoteButtonPanelType> typeSelectionCombo;

	/**
	 * Constructor.
	 */
	public NoteButtonPanelContainer() {
		this.setLayout(new BorderLayout());
		final JPanel controlPanel = new JPanel();
		controlPanel.add(new JLabel(Messages.getString("NoteButtonPanelContainer.typeLabel"))); //$NON-NLS-1$
		// TODO: use I18nhelper combo
		typeSelectionCombo = new JComboBox<>();
		// typeSelectionCombo.addItem(NoteButtonPanelType.SINGLE_CHROMATIC);
		// typeSelectionCombo.addItem(NoteButtonPanelType.SINGLE_LUTE_FRETBOARD);
		controlPanel.add(typeSelectionCombo);

		typeSelectionCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				NoteButtonPanelType noteButtonPanelType = (NoteButtonPanelType) (typeSelectionCombo.getSelectedItem());
				getController().setNoteButtonPanel(noteButtonPanelType);
			}
		});

		this.add(controlPanel, BorderLayout.PAGE_START);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel, BorderLayout.CENTER);
	}

	public AbstractNoteButtonPanel createNoteButtonPanel(NoteButtonPanelType type) {
		return AbstractNoteButtonPanel.createNoteButtonPanel(mainPanel, type);
	}

	/**
	 * @return the controller
	 */
	public final Controller getController() {
		return controller;
	}

	/**
	 * @param controller
	 *            the controller to set
	 */
	public final void setController(final Controller controller) {
		this.controller = controller;
	}

	public final void setNoteButtonPanelTypes(final NoteButtonPanelType[] noteButtonPanelTypes) {
		typeSelectionCombo.setModel(new DefaultComboBoxModel<>(noteButtonPanelTypes));
		typeSelectionCombo.setEnabled(noteButtonPanelTypes.length != 1);
		controller.setNoteButtonPanel(noteButtonPanelTypes[0]);
	}
}