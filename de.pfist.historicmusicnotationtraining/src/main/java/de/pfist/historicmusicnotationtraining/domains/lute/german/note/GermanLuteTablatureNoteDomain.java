package de.pfist.historicmusicnotationtraining.domains.lute.german.note;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.I18NComponentHelper;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.AbstractMusicDomain;

public class GermanLuteTablatureNoteDomain extends AbstractMusicDomain<GermanLuteTablatureNoteDomainSpecificState> {

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

		init();

		Box specificPanel = new Box(BoxLayout.Y_AXIS);
		JPanel specificPanel1 = new JPanel();
		JPanel specificPanel2 = new JPanel();
		specificPanel.add(specificPanel1);
		specificPanel.add(specificPanel2);

		I18NComponentHelper.createLuteTuningCombo(specificPanel1, getStateObject());
		I18NComponentHelper.createKeyModeCombo(specificPanel1, getStateObject());
		I18NComponentHelper.createLuteStringModeCombo(specificPanel1, getStateObject());

		I18NComponentHelper.createGermanLuteTablatureNotationVariantCombo(specificPanel2, getStateObject());
		I18NComponentHelper.createGermanLuteTablatureFontVariantCombo(specificPanel2, getStateObject());

		return specificPanel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected GermanLuteTablatureNoteDomainSpecificState createDomainSpecificState() {
		return new GermanLuteTablatureNoteDomainSpecificState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkerExtension<?, ?> createWorkerExtension() {
		return new GermanLuteTablatureNoteWorkerExtension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNotePanel<?> createNotePanel(Controller controller) {
		return new GermanLuteTablatureNoteNotePanel(controller);
	}

}
