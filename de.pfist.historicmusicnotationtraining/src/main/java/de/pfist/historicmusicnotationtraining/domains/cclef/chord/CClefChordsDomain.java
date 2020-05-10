package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;
import de.pfist.historicmusicnotationtraining.messages.Messages;

public class CClefChordsDomain implements MusicDomain {

	private static final String NAME = Messages.getString("CClefChordsDomain.domainName"); //$NON-NLS-1$

	private CClefChordsDomainSpecificState domainSpecificState;

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTabMnemonic() {
		// TODO: configure via properties (to allow language specific mnemonics)
		return KeyEvent.VK_H;
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

		domainSpecificState = new CClefChordsDomainSpecificState();
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
	public DomainSpecificState getStateObject() {
		return domainSpecificState;
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
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new CClefChordsNotePanel(controller);
	}

}
