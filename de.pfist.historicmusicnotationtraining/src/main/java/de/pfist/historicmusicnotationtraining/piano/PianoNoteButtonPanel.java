package de.pfist.historicmusicnotationtraining.piano;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import de.pfist.historicmusicnotationtraining.AbstractNoteButtonPanel;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.util.GuiUtils;

/**
 * 
 */
public class PianoNoteButtonPanel extends AbstractNoteButtonPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029731130258491034L;

	private static int octaves;
	private static int startOctave;

	public PianoNoteButtonPanel() {
		super(NoteButtonPanelType.SINGLE_KEYBOARD);
	}

	/**
	 * @return the startOctave
	 */
	public static final int getStartOctave() {
		return startOctave;
	}

	/**
	 * @param startOctave
	 *            the startOctave to set
	 */
	public static final void setStartOctave(int startOctave) {
		PianoNoteButtonPanel.startOctave = startOctave;
	}

	/**
	 * @return the octaves
	 */
	public static final int getOctaves() {
		return octaves;
	}

	/**
	 * @param octaves
	 *            the octaves to set
	 */
	public static final void setOctaves(int octaves) {
		PianoNoteButtonPanel.octaves = octaves;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createInterface(JPanel noteButtonPanel) {
		setLayout(new BorderLayout());

		EmptyBorder emptyBorder = new EmptyBorder(5, 5, 5, 5);
		BevelBorder bevelBorder = new BevelBorder(BevelBorder.LOWERED);
		noteButtonPanel.setBorder(GuiUtils.createCompoundBorder(emptyBorder, bevelBorder, emptyBorder));
		PianoPanel piano = new PianoPanel(this, getOctaves(), getStartOctave());
		noteButtonPanel.add(piano, BorderLayout.CENTER);
	}
}
