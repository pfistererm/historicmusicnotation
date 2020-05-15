package de.pfist.historicmusicnotationtraining.ui;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.ui.piano.PianoNoteButtonPanel;
import de.pfist.historicmusicnotationtraining.ui.util.NoteButtonPanelType;

public abstract class AbstractNoteButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -812339376413952481L;

	private final NoteButtonPanelType noteButtonPanelType;
	private Controller controller;

	/**
	 * Constructor.
	 * 
	 * @param noteButtonPanelType
	 */
	public AbstractNoteButtonPanel(final NoteButtonPanelType noteButtonPanelType) {
		this.noteButtonPanelType = noteButtonPanelType;

		createInterface(this);
	}

	/**
	 * GUI code
	 */
	protected abstract void createInterface(final JPanel noteButtonPanel);

	/**
	 * @return the noteButtonPanelType
	 */
	protected final NoteButtonPanelType getNoteButtonPanelType() {
		return noteButtonPanelType;
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

	public static AbstractNoteButtonPanel createNoteButtonPanel(final NoteButtonPanelType noteButtonPanelType) {
		if (noteButtonPanelType == NoteButtonPanelType.SINGLE_KEYBOARD) {
			PianoNoteButtonPanel.setOctaves(4);
			PianoNoteButtonPanel.setStartOctave(3);
			return new PianoNoteButtonPanel();
		} else {
			return new NoteButtonPanel(noteButtonPanelType);
		}
	}

}