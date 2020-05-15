package de.pfist.historicmusicnotationtraining.ui;

import de.pfist.historicmusicnotationtraining.AnswerState;
import de.pfist.historicmusicnotationtraining.ui.util.NoteButtonPanelType;

public interface IMainGui {

	public void setAnswerState(AnswerState answerState);

	public void setNotePanelVisible(NoteButtonPanelType noteButtonPanelType);

	public void setNotePanelTypes(NoteButtonPanelType[] noteButtonPanelTypes);

	public void setStatusMesssage(String message);
}
