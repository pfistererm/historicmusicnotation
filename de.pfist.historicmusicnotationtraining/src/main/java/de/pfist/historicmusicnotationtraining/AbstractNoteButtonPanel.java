package de.pfist.historicmusicnotationtraining;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.util.MidiSynth;

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
	 * @param parent
	 * @param noteButtonPanelType
	 */
	public AbstractNoteButtonPanel(final Container parent, final NoteButtonPanelType noteButtonPanelType) {
		this.noteButtonPanelType = noteButtonPanelType;

		createInterface(this);
		parent.add(this);
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
		// TODO: find a clean solution
		for (Component c : this.getComponents()) {
			if (c instanceof MidiSynth) {
				((MidiSynth) c).setController(controller);
			}
		}
	}

	public static AbstractNoteButtonPanel createNoteButtonPanel(final Container parent,
			final NoteButtonPanelType noteButtonPanelType) {
		if (noteButtonPanelType == NoteButtonPanelType.SINGLE_KEYBOARD) {
			return new MidiSynth(parent);
		} else {
			return new NoteButtonPanel(parent, noteButtonPanelType);
		}
	}

}