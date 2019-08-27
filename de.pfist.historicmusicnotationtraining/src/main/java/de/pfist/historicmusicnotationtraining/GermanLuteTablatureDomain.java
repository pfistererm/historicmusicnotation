package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import javax.swing.JLabel;
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

		// key mode selection
		specificPanel.add(new JLabel(Messages.getString("GermanLuteTablatureDomain.keyLabel"))); //$NON-NLS-1$
		Consumer<KeyMode> selectionHandler = new Consumer<KeyMode>() {

			@Override
			public void accept(KeyMode t) {
				domainSpecificState.setKeyMode(t);
			}
		};
		I18NComponentHelper.createComboBox(KeyMode.class, specificPanel, selectionHandler);

		// string mode selection
		specificPanel.add(new JLabel(Messages.getString("GermanLuteTablatureDomain.stringLabel"))); //$NON-NLS-1$
		I18NComponentHelper.createComboBox(LuteStringMode.class, specificPanel,
				(t) -> domainSpecificState.setLuteStringMode(t), //
				LuteStringMode.ALL, LuteStringMode.S5, LuteStringMode.S4, LuteStringMode.S3, LuteStringMode.S2,
				LuteStringMode.S1, LuteStringMode.S0);

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
	public WorkerExtension createWorkerExtension() {
		return new GermanLuteTablatureWorkerExtension();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pfist.learncclefs.MusicDomain#createNotePanel()
	 */
	@Override
	public AbstractNotePanel createNotePanel(Controller controller) {
		return new GermanLuteTablatureNotePanel(controller);
	}

}
