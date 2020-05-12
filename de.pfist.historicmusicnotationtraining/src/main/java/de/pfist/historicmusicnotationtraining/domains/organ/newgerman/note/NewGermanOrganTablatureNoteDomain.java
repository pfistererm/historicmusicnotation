package de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.KeyMode;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

/**
 *
 */
public class NewGermanOrganTablatureNoteDomain
		extends AbstractMusicDomain<NewGermanOrganTablatureNoteDomainSpecificState> {

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

		init();
		JPanel specificPanel = new JPanel();

		// key mode selection
		specificPanel.add(new JLabel(getMessageString("keyLabel"))); //$NON-NLS-1$
		I18NComponentHelper.createComboBox(KeyMode.class, specificPanel, (t) -> getStateObject().setKeyMode(t),
				getStateObject().getKeyMode());

		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected NewGermanOrganTablatureNoteDomainSpecificState createDomainSpecificState() {
		return new NewGermanOrganTablatureNoteDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new NewGermanOrganTablatureNoteWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?, ?> createNotePanel(Controller controller) {
		return new NewGermanOrganTablatureNoteNotePanel(controller);
	}

}
