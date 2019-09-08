package de.pfist.historicmusicnotationtraining;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import de.pfist.historicmusicnotationtraining.messages.Messages;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;
import de.pfist.historicmusicnotationtraining.util.NoteConstants;

public class NoteButtonPanel extends AbstractNoteButtonPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1130754558315947299L;

	private JButton[] noteButtons;

	/**
	 * Constructor.
	 * 
	 * @param noteButtonPanelType
	 */
	public NoteButtonPanel(final NoteButtonPanelType noteButtonPanelType) {
		super(noteButtonPanelType);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createInterface(JPanel noteButtonPanel) {
		noteButtons = new JButton[getNoteNames().length];
		if (getNoteButtonPanelType() == NoteButtonPanelType.SINGLE_LUTE_FRETBOARD) {
			createInterfaceLuteFretboard(this);
		} else {
			createInterfaceStandard(this);
		}
	}

	private void createInterfaceLuteFretboard(final JPanel noteButtonPanel) {

		final LuteTuning luteTuning = LuteTuning.A_TUNING;

		noteButtonPanel.setBorder(GuiUtils.createTripleEtchedBorder(5, EtchedBorder.RAISED, 6));
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
				final int fretIndexFinal = fretIndex;
				// TODO: remove hard coded tuning
				final String buttonText = (fretIndex == 0) ? Messages.getString(string.getTextKey())
						: Messages.getString("NoteButtonPanel.fret") + fretIndex; //$NON-NLS-1$
				noteButtons[fretIndex] = new JButton(buttonText);
				noteButtons[fretIndex].setMargin(new Insets(2, 1, 2, 1));
				noteButtons[fretIndex].addActionListener(new ActionListener() {

					/** {@inheritDoc} */
					@Override
					public void actionPerformed(ActionEvent e) {
						final int midiNote = string.getOffset(luteTuning) + fretIndexFinal;
						getController().noteButtonPressed(midiNote);
					}
				});
				noteButtonPanel.add(noteButtons[fretIndex]);
			}
			for (int j = availableFrets; j < totalMaxFrets; j++) {
				noteButtonPanel.add(new JLabel());
			}
		}
	}

	private void createInterfaceStandard(final JPanel noteButtonPanel) {

		noteButtonPanel.setBorder(GuiUtils.createTripleEtchedBorder(5, EtchedBorder.RAISED, 6));
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
		switch (getNoteButtonPanelType()) {
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
		switch (getNoteButtonPanelType()) {
		case SINGLE_LUTE_FRETBOARD:
			return new String[6 * 10]; // hack to get the number of buttons
		case SINGLE_KEYBOARD:
			return null;
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
		default:
			break;
		}
		return null;
	}

	/** {@inheritDoc} */
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
			switch (getNoteButtonPanelType()) {
			case SINGLE_KEYBOARD:
				// should not happen
				break;
			case SINGLE_LUTE_FRETBOARD:
				// handled by local action listener
				break;
			case SINGLE_CHROMATIC:
				midiNote = noteButtonIndex + NoteConstants.BASE_MIDI_NOTE_CROMATIC;
				getController().noteButtonPressed(midiNote);
				break;
			case SINGLE_CHROMATIC_4_OCTAVES:
				midiNote = noteButtonIndex + NoteConstants.BASE_MIDI_NOTE_CROMATIC_4_OCTAVES;
				getController().noteButtonPressed(midiNote);
				break;
			case SINGLE_DIATONIC:
				midiNote = NoteConstants.NOTE_MIDI_NOTE_TABLE_DIATONIC[noteButtonIndex];
				getController().noteButtonPressed(midiNote);
				break;
			case CHORDS:
				getController().chordButtonPressed(NoteConstants.CHORDS[noteButtonIndex]);
				break;
			}
		}
	}

}