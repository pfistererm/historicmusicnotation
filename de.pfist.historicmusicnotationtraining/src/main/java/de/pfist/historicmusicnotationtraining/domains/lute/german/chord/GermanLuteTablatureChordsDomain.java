package de.pfist.historicmusicnotationtraining.domains.lute.german.chord;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

public class GermanLuteTablatureChordsDomain extends AbstractMusicDomain<GermanLuteTablatureChordsDomainSpecificState> {

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

		// tuning selection
		I18NComponentHelper.createLuteTuningCombo(specificPanel, getStateObject());

		I18NComponentHelper.createGermanLuteTablatureNotationVariantCombo(specificPanel, getStateObject());
		I18NComponentHelper.createGermanLuteTablatureFontVariantCombo(specificPanel, getStateObject());

		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected GermanLuteTablatureChordsDomainSpecificState createDomainSpecificState() {
		return new GermanLuteTablatureChordsDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new GermanLuteTablatureChordsWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new GermanLuteTablatureChordsNotePanel(controller);
	}

}
