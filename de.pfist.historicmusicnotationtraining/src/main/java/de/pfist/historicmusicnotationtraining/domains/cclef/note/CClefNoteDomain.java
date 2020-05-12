package de.pfist.historicmusicnotationtraining.domains.cclef.note;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Clef;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

public class CClefNoteDomain extends AbstractMusicDomain<CClefDomainSpecificState> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.SINGLE_DIATONIC, NoteButtonPanelType.SINGLE_KEYBOARD };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		init();
		JPanel specificPanel = new JPanel();

		// clef selection
		specificPanel.add(new JLabel(getMessageString("Clef"))); //$NON-NLS-1$
		I18NComponentHelper.createComboBox(Clef.class, specificPanel, //
				(t) -> getStateObject().setClefSelection(t), //
				Clef.ALL, Clef.G2, Clef.G1, Clef.C1, Clef.C2, Clef.C3, Clef.C4, Clef.F4, Clef.F3);
		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CClefDomainSpecificState createDomainSpecificState() {
		return new CClefDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new CClefWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?, ?> createNotePanel(Controller controller) {
		return new CClefNotePanel(controller);
	}

}