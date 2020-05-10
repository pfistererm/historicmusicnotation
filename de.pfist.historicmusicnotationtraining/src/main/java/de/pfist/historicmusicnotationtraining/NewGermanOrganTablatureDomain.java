package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.messages.Messages;

/**
 *
 */
public class NewGermanOrganTablatureDomain implements MusicDomain {

	private static final String NAME = Messages.getString("NewGermanOrganTablatureDomain.domainTitle"); //$NON-NLS-1$

	private NewGermanOrganTablatureDomainSpecificState domainSpecificState;

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
		return new NoteButtonPanelType[] { NoteButtonPanelType.SINGLE_CHROMATIC_4_OCTAVES,
				NoteButtonPanelType.SINGLE_KEYBOARD };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new NewGermanOrganTablatureDomainSpecificState();
		JPanel specificPanel = new JPanel();

		// key mode selection
		specificPanel.add(new JLabel(Messages.getString("NewGermanOrganTablatureDomain.keyLabel"))); //$NON-NLS-1$
		I18NComponentHelper.createComboBox(KeyMode.class, specificPanel, (t) -> domainSpecificState.setKeyMode(t),
				domainSpecificState.getKeyMode());

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
		return new NewGermanOrganTablatureWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new NewGermanOrganTablatureNotePanel(controller);
	}

}
