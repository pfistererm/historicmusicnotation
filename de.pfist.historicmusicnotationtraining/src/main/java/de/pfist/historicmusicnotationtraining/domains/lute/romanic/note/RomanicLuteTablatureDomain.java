package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;
import de.pfist.historicmusicnotationtraining.messages.Messages;

public class RomanicLuteTablatureDomain implements MusicDomain {

	private static final String NAME = Messages.getString("RomanicLuteTablatureDomain.domainTitle"); //$NON-NLS-1$

	private RomanicLuteTablatureDomainSpecificState domainSpecificState;

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
		return KeyEvent.VK_R;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NoteButtonPanelType[] getNoteButtonPanelTypes() {
		return new NoteButtonPanelType[] { NoteButtonPanelType.SINGLE_CHROMATIC, NoteButtonPanelType.SINGLE_KEYBOARD };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel createSpecificTopPanel() {

		domainSpecificState = new RomanicLuteTablatureDomainSpecificState();
		JPanel specificPanel = new JPanel();
		I18NComponentHelper.createRomanicLuteTablatureVariantCombo(specificPanel, domainSpecificState);

		I18NComponentHelper.createLuteTuningCombo(specificPanel, domainSpecificState);

		I18NComponentHelper.createKeyModeCombo(specificPanel, domainSpecificState);

		I18NComponentHelper.createLuteStringModeCombo(specificPanel, domainSpecificState);

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
		return new RomanicLuteTablatureWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new RomanicLuteTablatureNotePanel(controller);
	}

}
