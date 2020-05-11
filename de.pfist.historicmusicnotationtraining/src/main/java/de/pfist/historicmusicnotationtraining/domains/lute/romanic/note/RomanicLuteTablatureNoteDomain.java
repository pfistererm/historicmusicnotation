package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

public class RomanicLuteTablatureNoteDomain extends AbstractMusicDomain<RomanicLuteTablatureNoteDomainSpecificState> {

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

		init();
		JPanel specificPanel = new JPanel();
		I18NComponentHelper.createRomanicLuteTablatureVariantCombo(specificPanel, getStateObject());

		I18NComponentHelper.createLuteTuningCombo(specificPanel, getStateObject());

		I18NComponentHelper.createKeyModeCombo(specificPanel, getStateObject());

		I18NComponentHelper.createLuteStringModeCombo(specificPanel, getStateObject());

		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected RomanicLuteTablatureNoteDomainSpecificState createDomainSpecificState() {
		return new RomanicLuteTablatureNoteDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new RomanicLuteTablatureNoteWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new RomanicLuteTablatureNoteNotePanel(controller);
	}

}
