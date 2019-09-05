package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.messages.Messages;

public class GermanLuteTablatureChordsDomain implements MusicDomain {

	private static final String NAME = Messages.getString("GermanLuteTablatureChordsDomain.domainTitle"); //$NON-NLS-1$

	private GermanLuteTablatureChordsDomainSpecificState domainSpecificState;

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
		return KeyEvent.VK_1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.CHORDS };
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

		I18NComponentHelper.createGermanLuteTablatureNotationVariantCombo(specificPanel, domainSpecificState);
		I18NComponentHelper.createGermanLuteTablatureFontVariantCombo(specificPanel, domainSpecificState);

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
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new GermanLuteTablatureChordsNotePanel(controller);
	}

}
