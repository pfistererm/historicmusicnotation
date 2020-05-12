package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

public class CClefChordsDomain extends AbstractMusicDomain<CClefChordsDomainSpecificState> {

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

		init();
		JPanel specificPanel = new JPanel();

		// clef selection
		// specificPanel.add(new JLabel(Messages.getString("CClefDomain.Clef")));
		// $NON-NLS-1$
		// I18NComponentHelper.createComboBox(Clef.class, specificPanel, //
		// (t) -> domainSpecificState.setClefSelection(t), //
		// Clef.ALL, Clef.C1, Clef.C2, Clef.C3, Clef.C4, Clef.F4);
		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CClefChordsDomainSpecificState createDomainSpecificState() {
		return new CClefChordsDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new CClefChordsWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?, ?> createNotePanel(Controller controller) {
		return new CClefChordsNotePanel(controller);
	}

}
