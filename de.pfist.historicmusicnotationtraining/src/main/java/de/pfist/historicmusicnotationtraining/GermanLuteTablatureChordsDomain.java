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

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#getTabMnemonic()
	 */
	@Override
	public int getTabMnemonic() {
		return KeyEvent.VK_1;
	}

	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.CHORDS};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createSpecificTopPanel()
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new GermanLuteTablatureChordsDomainSpecificState();
		JPanel specificPanel = new JPanel();

		// tuning selection
		I18NComponentHelper.createLuteTuningCombo(specificPanel, domainSpecificState);

		// key mode selection
//		specificPanel.add(new JLabel(Messages.getString("GermanLuteTablatureDomain.keyLabel"))); //$NON-NLS-1$
//		Consumer<KeyMode> selectionHandler = new Consumer<KeyMode>() {
//
//			@Override
//			public void accept(KeyMode t) {
//				domainSpecificState.setKeyMode(t);
//			}
//		};
//		I18NComponentHelper.createComboBox(KeyMode.class, specificPanel, selectionHandler);

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
		return new GermanLuteTablatureChordsWorkerExtension();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createNotePanel()
	 */
	@Override
	public AbstractNotePanel createNotePanel(Controller controller) {
		return new GermanLuteTablatureChordsNotePanel(controller);
	}

}
