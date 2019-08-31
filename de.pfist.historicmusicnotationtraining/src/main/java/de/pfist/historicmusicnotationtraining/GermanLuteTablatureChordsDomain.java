package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GermanLuteTablatureChordsDomain implements MusicDomain {

	private static final String NAME = Messages.getString("GermanLuteTablatureChordsDomain.domainTitle"); //$NON-NLS-1$

	private GermanLuteTablatureChordsDomainSpecificState domainSpecificState;

	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTabMnemonic() {
		return KeyEvent.VK_1;
	}

	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.CHORDS};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new GermanLuteTablatureChordsDomainSpecificState();
		JPanel specificPanel = new JPanel();

		// tuning selection
		I18NComponentHelper.createLuteTuningCombo(specificPanel, domainSpecificState);

		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DomainSpecificState getStateObject() {
		return domainSpecificState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new GermanLuteTablatureChordsWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel createNotePanel(Controller controller) {
		return new GermanLuteTablatureChordsNotePanel(controller);
	}

}
