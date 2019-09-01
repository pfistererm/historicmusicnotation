package de.pfist.historicmusicnotationtraining;

import javax.swing.JComponent;

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
