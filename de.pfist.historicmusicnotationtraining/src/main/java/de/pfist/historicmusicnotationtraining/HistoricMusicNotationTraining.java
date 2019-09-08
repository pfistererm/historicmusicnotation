package de.pfist.historicmusicnotationtraining;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.l2fprod.common.swing.StatusBar;

import de.pfist.historicmusicnotationtraining.messages.Messages;
import de.pfist.historicmusicnotationtraining.midi.ControllerInstrument;
import de.pfist.historicmusicnotationtraining.util.BarLineLabel;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

public class HistoricMusicNotationTraining implements IMainGui {

	private static final String APP_TITLE = Messages.getString("HistoricMusicNotationTraining.appTitle"); //$NON-NLS-1$

	private Controller controller;

	private JButton stopButton, nextButton;
	private JComboBox<Integer> autoIntervallMenu;
	private JLabel successLabel;
	private BarLineLabel<AnswerState> successBarLineLabel;
	private JLabel statusMessage;
	private Map<AnswerState, Color> colorMap = null;

	private NoteButtonPanelContainer noteButtonPanelContainer;
	private Map<NoteButtonPanelType, AbstractNoteButtonPanel> noteButtonPanels;

	/**
	 * Constructor.
	 * 
	 * @param domains
	 */
	public HistoricMusicNotationTraining(final MusicDomain[] domains) {

		// set look and feel
		String local = javax.swing.UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(local); // use local or metal
		} catch (Exception e) {
			// DO NOTHING
		}
		controller = new Controller(domains);
		controller.setMainGui(this);
		// call other methods
		final JFrame frame = createFrame();
		createInterface(frame, domains);

		frame.setSize(700, 500);
		// frame.pack();
		frame.setVisible(true);
		controller.setCurrentDomainIndex(0);
	}

	/**
	 * @return a JFrame
	 */
	private JFrame createFrame() {
		final JFrame frame = new JFrame(APP_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			/** {@inheritDoc} */
			@Override
			public void windowClosing(WindowEvent e) {
				if (controller != null) {
					controller.close();
				}
			}
		});
		return frame;
	}

	/**
	 * @param frame
	 * @param domains
	 */
	private void createInterface(final JFrame frame, final MusicDomain[] domains) {
		final JTabbedPane tabbedPane = createDomainsTabbedPane(domains);

		final Container outerContentPane = frame.getContentPane();
		outerContentPane.setLayout(new BorderLayout());

		JPanel innerContentPane = new JPanel();
		outerContentPane.add(innerContentPane, BorderLayout.CENTER);
		innerContentPane.setLayout(new BoxLayout(innerContentPane, BoxLayout.Y_AXIS));
		innerContentPane.add(tabbedPane);

		// Note: initializes noteButtonPanelContainer and noteButtonPanels
		createNoteButtonPanels();
		innerContentPane.add(noteButtonPanelContainer);

		JPanel otherButtonPanel = createOtherButtonPanel();
		innerContentPane.add(otherButtonPanel);

		JPanel midiPanel = createMidiPanel();
		innerContentPane.add(midiPanel);

		JComponent statusBar = createStatusBar();
		outerContentPane.add(statusBar, BorderLayout.SOUTH);
	}

	/**
	 * @param domains
	 * @return
	 */
	private JTabbedPane createDomainsTabbedPane(final MusicDomain[] domains) {
		final JTabbedPane tabbedPane = new JTabbedPane();

		int tabIndex = 0;
		for (final MusicDomain domain : domains) {
			JComponent tabContentPanel = new JPanel();
			tabContentPanel.setLayout(new BorderLayout());
			tabContentPanel.add(domain.createSpecificTopPanel(), BorderLayout.PAGE_START);
			controller.addDomainSpecificState(domain.getStateObject());
			controller.addWorkerExtension(domain.createWorkerExtension());
			AbstractNotePanel<?> notePanel = domain.createNotePanel(controller);
			notePanel.setBorder(GuiUtils.createTripleBevelBorder(5, BevelBorder.LOWERED, 5));
			tabContentPanel.add(notePanel, BorderLayout.CENTER);
			controller.addNotePanel(notePanel);
			tabbedPane.addTab(domain.getName(), null, tabContentPanel, domain.getToolTip());
			tabbedPane.setMnemonicAt(tabIndex, domain.getTabMnemonic());
			tabIndex++;
		}
		tabbedPane.addChangeListener(new ChangeListener() {
			/** {@inheritDoc} */
			@Override
			public void stateChanged(final ChangeEvent e) {
				final int selectedIndex = tabbedPane.getSelectedIndex();
				controller.setCurrentDomainIndex(selectedIndex);
			}
		});
		return tabbedPane;
	}

	/**
	 * 
	 */
	private void createNoteButtonPanels() {
		noteButtonPanelContainer = new NoteButtonPanelContainer();
		noteButtonPanelContainer.setController(controller);
		noteButtonPanels = new EnumMap<>(NoteButtonPanelType.class);
		for (final NoteButtonPanelType type : NoteButtonPanelType.values()) {
			AbstractNoteButtonPanel noteButtonPanel = noteButtonPanelContainer.createNoteButtonPanel(type);
			noteButtonPanel.setController(controller);
			noteButtonPanels.put(type, noteButtonPanel);
		}
	}

	/**
	 * @return
	 */
	private JPanel createOtherButtonPanel() {
		Action nextAction = createNextAction();

		JPanel otherButtonPanel = new JPanel();
		// buttons
		nextButton = new JButton(Messages.getString("HistoricMusicNotationTraining.nextButtonLabel")); //$NON-NLS-1$
		nextButton.addActionListener(nextAction);
		nextButton.setMnemonic('N');
		otherButtonPanel.add(nextButton);
		stopButton = new JButton(Messages.getString("HistoricMusicNotationTraining.stopButtonLabel")); //$NON-NLS-1$
		stopButton.addActionListener(new ActionListener() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: implement stop
			}
		});
		otherButtonPanel.add(stopButton);

		// mode selection
		otherButtonPanel.add(new JLabel(Messages.getString("HistoricMusicNotationTraining.modeLabel"))); //$NON-NLS-1$
		I18NComponentHelper.createComboBox(Mode.class, otherButtonPanel, //
				(t) -> controller.setMode(t), controller.getMode());

		// auto intervall
		autoIntervallMenu = new JComboBox<>();
		autoIntervallMenu.addActionListener(new ActionListener() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: autoIntervallMenu.getSelectedItem()).doubleValue());
			}
		});
		autoIntervallMenu.addItem(1);
		autoIntervallMenu.addItem(2);
		autoIntervallMenu.addItem(3);
		autoIntervallMenu.addItem(4);
		autoIntervallMenu.addItem(5);
		autoIntervallMenu.addItem(6);
		otherButtonPanel.add(new JLabel(Messages.getString("HistoricMusicNotationTraining.autoIntervallLabel"))); //$NON-NLS-1$
		otherButtonPanel.add(autoIntervallMenu);
		otherButtonPanel.add(new JLabel(Messages.getString("HistoricMusicNotationTraining.seconsLabel"))); //$NON-NLS-1$
		return otherButtonPanel;
	}

	/**
	 * @return
	 */
	private AbstractAction createNextAction() {
		return new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4277462648486894183L;

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doNext(false);
			}
		};
	}

	/**
	 * @return
	 */
	private JPanel createMidiPanel() {
		JPanel midiPanel = new JPanel();
		// buttons
		JCheckBox playNotesCheckBox = new JCheckBox(Messages.getString("HistoricMusicNotationTraining.playNotesLabel"), //$NON-NLS-1$
				controller.isPlayNotes());
		midiPanel.add(playNotesCheckBox);
		playNotesCheckBox.addItemListener(new ItemListener() {
			/** {@inheritDoc} */
			@Override
			public void itemStateChanged(ItemEvent e) {
				controller.setPlayNotes(e.getStateChange() == 1);
			}
		});

		// instrument selection
		JComboBox<ControllerInstrument> instrumentCombo = new JComboBox<>();
		for (final ControllerInstrument instrument : controller.getInstruments()) {
			instrumentCombo.addItem(instrument);
		}
		instrumentCombo.addItemListener(new ItemListener() {

			/** {@inheritDoc} */
			@Override
			public void itemStateChanged(ItemEvent e) {
				controller.setIntrument((ControllerInstrument) instrumentCombo.getSelectedItem());
			}
		});
		midiPanel.add(new JLabel(Messages.getString("HistoricMusicNotationTraining.instrumentLabel"))); //$NON-NLS-1$
		midiPanel.add(instrumentCombo);

		// volume / velocity
		JSlider velocitySlider = new JSlider(SwingConstants.HORIZONTAL, 0, 127, controller.getMidiNoteVelocity());
		velocitySlider.addChangeListener(new ChangeListener() {
			/** {@inheritDoc} */
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = velocitySlider.getValue();
				controller.setMidiNoteVelocity(value);
			}
		});
		midiPanel.add(new JLabel(Messages.getString("HistoricMusicNotationTraining.volumeLabel"))); //$NON-NLS-1$
		midiPanel.add(velocitySlider);
		return midiPanel;
	}

	private JComponent createStatusBar() {
		successLabel = new JLabel("      "); //$NON-NLS-1$
		successLabel.setOpaque(true);
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		successBarLineLabel = new BarLineLabel<>();
		successBarLineLabel.setColorMap(getColorMap());
		successBarLineLabel.setBackground(getColorMap().get(AnswerState.WAITING));

		statusMessage = new JLabel(""); //$NON-NLS-1$
		statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
		StatusBar statusBar = new StatusBar();
		statusBar.setZones(new String[] { "first_zone", "second_zone", "remaining_zones" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				new Component[] { successLabel, successBarLineLabel, statusMessage }, // $NON-NLS-1$ //$NON-NLS-2$
				new String[] { "25%", "25%", "*" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return statusBar;
	}

	/**
	 * 
	 */
	private Map<AnswerState, Color> getColorMap() {
		if (colorMap == null) {
			colorMap = new EnumMap<>(AnswerState.class);
			colorMap.put(AnswerState.RIGHT, Color.GREEN);
			colorMap.put(AnswerState.WRONG, Color.RED);
			colorMap.put(AnswerState.WAITING, Color.WHITE);
		}
		return colorMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAnswerState(AnswerState answerState) {
		final String text;
		final Color bgColor;
		text = Messages.getString(answerState.getTextKey());
		switch (answerState) {
		case WAITING:
			bgColor = Color.WHITE;
			break;
		case RIGHT:
			bgColor = Color.GREEN;
			break;
		case WRONG:
			bgColor = Color.RED;
			break;
		default:
			bgColor = Color.WHITE;
		}
		// System.out.println(text);
		SwingUtilities.invokeLater(new Runnable() {

			/** {@inheritDoc} */
			@Override
			public void run() {
				successLabel.setText(text);
				successLabel.setBackground(bgColor);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStatusMesssage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {

			/** {@inheritDoc} */
			@Override
			public void run() {
				statusMessage.setText(message);
				successBarLineLabel.setValues(controller.getGlobalCounterValues());
				successBarLineLabel.repaint();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNotePanelTypes(NoteButtonPanelType[] noteButtonPanelTypes) {
		noteButtonPanelContainer.setNoteButtonPanelTypes(noteButtonPanelTypes);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNotePanelVisible(NoteButtonPanelType newNoteButtonPanelType) {
		for (NoteButtonPanelType noteButtonPanelType : NoteButtonPanelType.values()) {
			noteButtonPanels.get(noteButtonPanelType).setVisible(noteButtonPanelType == newNoteButtonPanelType);
		}
	}

}