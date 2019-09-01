package de.pfist.historicmusicnotationtraining;

import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
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
	public JComponent createSpecificTopPanel() {

		domainSpecificState = new GermanLuteTablatureDomainSpecificState();
		Box specificPanel = new Box(BoxLayout.Y_AXIS);
		JPanel specificPanel1 = new JPanel();
		JPanel specificPanel2 = new JPanel();
		specificPanel.add(specificPanel1);
		specificPanel.add(specificPanel2);

		I18NComponentHelper.createLuteTuningCombo(specificPanel1, domainSpecificState);
		I18NComponentHelper.createKeyModeCombo(specificPanel1, domainSpecificState);
		I18NComponentHelper.createLuteStringModeCombo(specificPanel1, domainSpecificState);

		I18NComponentHelper.createGermanLuteTablatureNotationVariantCombo(specificPanel2, domainSpecificState);
		I18NComponentHelper.createGermanLuteTablatureFontVariantCombo(specificPanel2, domainSpecificState);

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
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new GermanLuteTablatureNotePanel(controller);
	}

}
