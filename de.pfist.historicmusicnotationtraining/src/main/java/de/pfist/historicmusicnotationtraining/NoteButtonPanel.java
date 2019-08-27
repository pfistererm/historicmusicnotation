package de.pfist.historicmusicnotationtraining;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.util.MidiSynth;

public class NoteButtonPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1130754558315947299L;

	private final NoteButtonPanelType noteButtonPanelType;
	private final JButton[] noteButtons;
	private Controller controller;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 * @param noteButtonPanelType
	 */
	public NoteButtonPanel(final Container parent, final NoteButtonPanelType noteButtonPanelType) {
		this.noteButtonPanelType = noteButtonPanelType;

		if (noteButtonPanelType == NoteButtonPanelType.SINGLE_KEYBOARD) {
			MidiSynth piano = new MidiSynth();
			this.add(piano);
			noteButtons = null;
		} else {
			noteButtons = new JButton[getNoteNames().length];
			if (noteButtonPanelType == NoteButtonPanelType.SINGLE_LUTE_FRETBOARD) {
				createInterfaceLuteFretboard(this);
			} else {
				createInterface(this);
			}
		}
		parent.add(this);
	}

	private void createInterfaceLuteFretboard(final Container noteButtonPanel) {

		final LuteTuning luteTuning = LuteTuning.A_TUNING;

		noteButtonPanel.setLayout(new GridLayout(luteTuning.getStringCount(), 0));

		final LuteStringMode[] strings = LuteStringMode.getStringValues();
		int totalMaxFrets = 0;
		for (LuteStringMode luteStringMode : strings) {
			totalMaxFrets = Math.max(totalMaxFrets, luteStringMode.getAvailableFrets(luteTuning));
		}
		for (int stringIndex = strings.length - 1; stringIndex >= 0; stringIndex--) {
			final LuteStringMode string = strings[stringIndex];
			final int availableFrets = string.getAvailableFrets(luteTuning);
			for (int fretIndex = 0; fretIndex < availableFrets; fretIndex++) {
				final String buttonText = (fretIndex == 0) ? Messages.getString(string.getTextKey())
						: "Bund " + fretIndex;
				noteButtons[fretIndex] = new JButton(buttonText);
				noteButtons[fretIndex].setMargin(new Insets(2, 1, 2, 1));
				noteButtons[fretIndex].addActionListener(this);
				noteButtonPanel.add(noteButtons[fretIndex]);
			}
			for (int j = availableFrets; j < totalMaxFrets; j++) {
				noteButtonPanel.add(new JLabel());
			}
		}
	}

	/**
	 * GUI code
	 */
	private void createInterface(final JPanel noteButtonPanel) {

		noteButtonPanel.setLayout(new GridLayout(getLayouRows(), 0));
		final String[] noteNames = getNoteNames();
		for (int i = 0; i < noteNames.length; i++) {
			noteButtons[i] = new JButton(noteNames[i]);
			noteButtons[i].setMargin(new Insets(2, 1, 2, 1));
			noteButtons[i].addActionListener(this);
			noteButtonPanel.add(noteButtons[i]);
		}
	}

	private int getLayouRows() {
		switch (noteButtonPanelType) {
		case SINGLE_LUTE_FRETBOARD:
			return 6;
		case SINGLE_CHROMATIC:
			return 3;
		case SINGLE_CHROMATIC_4_OCTAVES:
			return 4;
		case SINGLE_DIATONIC:
			return 4;
		case CHORDS:
			return 3;
		default:
			return 5;
		}
	}

	private String[] getNoteNames() {
		switch (noteButtonPanelType) {
		case SINGLE_LUTE_FRETBOARD:
			return new String[6 * 10]; // hack to get the number of buttons
		case SINGLE_CHROMATIC:
			return NoteConstants.NOTE_NAMES_CHROMATIC;
		case SINGLE_CHROMATIC_4_OCTAVES:
			return NoteConstants.NOTE_NAMES_CHROMATIC_4_OCTAVES;
		case SINGLE_DIATONIC:
			return NoteConstants.NOTE_NAMES_DIATONIC;
		case CHORDS:
			final Chord[] chords = NoteConstants.CHORDS;
			final String[] names = new String[chords.length];
			int namesIndex = 0;
			for (final Chord chord : chords) {
				names[namesIndex] = Messages.getString(chord.getTextKey());
				namesIndex++;
			}
			return names;
		}
		return null;
	}

	/**
	 * Handle the button clicks
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// find index in note buttons
		int noteButtonIndex = -1;
		for (int i = 0; i < noteButtons.length; i++) {
			if (e.getSource() == noteButtons[i]) {
				noteButtonIndex = i;
				break;
			}
		}
		if (noteButtonIndex != -1) {
			int midiNote = 0;
			switch (noteButtonPanelType) {
			case SINGLE_CHROMATIC:
				midiNote = noteButtonIndex + NoteConstants.BASE_MIDI_NOTE_CROMATIC;
				controller.noteButtonPressed(midiNote);
				break;
			case SINGLE_CHROMATIC_4_OCTAVES:
				midiNote = noteButtonIndex + NoteConstants.BASE_MIDI_NOTE_CROMATIC_4_OCTAVES;
				controller.noteButtonPressed(midiNote);
				break;
			case SINGLE_DIATONIC:
				midiNote = NoteConstants.NOTE_MIDI_NOTE_TABLE_DIATONIC[noteButtonIndex];
				controller.noteButtonPressed(midiNote);
				break;
			case CHORDS:
				controller.chordButtonPressed(NoteConstants.CHORDS[noteButtonIndex]);
				break;
			}
		}
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

}