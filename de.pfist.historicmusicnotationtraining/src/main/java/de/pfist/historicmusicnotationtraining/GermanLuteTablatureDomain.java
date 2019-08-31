package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GermanLuteTablatureDomain implements MusicDomain {

	private static final String NAME = Messages.getString("GermanLuteTablatureDomain.domainTitle"); //$NON-NLS-1$

	private GermanLuteTablatureDomainSpecificState domainSpecificState;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTabMnemonic() {
		return KeyEvent.VK_G;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.SINGLE_CHROMATIC,
				NoteButtonPanelType.SINGLE_LUTE_FRETBOARD, NoteButtonPanelType.SINGLE_KEYBOARD };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new GermanLuteTablatureDomainSpecificState();
		JPanel specificPanel = new JPanel();

		I18NComponentHelper.createLuteTuningCombo(specificPanel, domainSpecificState);

		I18NComponentHelper.createKeyModeCombo(specificPanel, domainSpecificState);

		I18NComponentHelper.createLuteStringModeCombo(specificPanel, domainSpecificState);

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
		return new GermanLuteTablatureWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel createNotePanel(Controller controller) {
		return new GermanLuteTablatureNotePanel(controller);
	}

}
