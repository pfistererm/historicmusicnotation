package de.pfist.historicmusicnotationtraining.domains;

import javax.swing.JComponent;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;

public interface MusicDomain {
	public String getName();

	public NoteButtonPanelType[] getNoteButtonPanelTypes();

	public int getTabMnemonic();

	default public String getToolTip() {
		return getName();
	}

	public JComponent createSpecificTopPanel();

	public DomainSpecificState getStateObject();

	public WorkerExtension<?, ?> createWorkerExtension();

	public AbstractNotePanel<?> createNotePanel(Controller controller);
}
