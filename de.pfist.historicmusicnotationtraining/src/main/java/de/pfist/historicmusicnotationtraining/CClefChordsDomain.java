package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class CClefChordsDomain implements MusicDomain {

	private static final String NAME = Messages.getString("CClefChordsDomain.domainName"); //$NON-NLS-1$

	private CClefChordsDomainSpecificState domainSpecificState;

	@Override
	public String getName() {
		return NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#getTabMnemonic()
	 */
	@Override
	public int getTabMnemonic() {
		return KeyEvent.VK_C;
	}

	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] {NoteButtonPanelType.CHORDS};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createSpecificTopPanel()
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new CClefChordsDomainSpecificState();
		JPanel specificPanel = new JPanel();

		// clef selection
		// specificPanel.add(new JLabel(Messages.getString("CClefDomain.Clef")));
		//$NON-NLS-1$
		// I18NComponentHelper.createComboBox(Clef.class, specificPanel, //
		// (t) -> domainSpecificState.setClefSelection(t), //
		// Clef.ALL, Clef.C1, Clef.C2, Clef.C3, Clef.C4, Clef.F4);
		return specificPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#getStateObject()
	 */
	@Override
	public DomainSpecificState getStateObject() {
		return domainSpecificState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createWorkerExtension()
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new CClefChordsWorkerExtension();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createNotePanel()
	 */
	@Override
	public AbstractNotePanel createNotePanel(Controller controller) {
		return new CClefChordsNotePanel(controller);
	}

}
