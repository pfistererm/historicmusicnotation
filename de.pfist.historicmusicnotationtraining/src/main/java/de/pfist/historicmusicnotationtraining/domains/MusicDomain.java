package de.pfist.historicmusicnotationtraining.domains;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import de.pfist.historicmusicnotationtraining.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.HistoricMusicNotationTraining;
import de.pfist.historicmusicnotationtraining.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.WorkerExtension;

/**
 * A domain in this context is a musical area that is available to the user of the program
 * as an area of supported learning.
 * 
 * <p>The implementation of a domain typically consists of five classes:</p>
 * <ol>
 * <li>An implementation of this interface.</li>
 * <li>An implementation of {@link DomainSpecificState}.</li>
 * <li>A subclass of {@link AbstractNotePanel}.</li>
 * <li>An implementation of {@link DomainRandomResult}. See base classes {@link AbstractRandomResultChord}
 * and {@link AbstractRandomResultNote}.</li>
 * <li>An implementation of {@link WorkerExtension}.</li>
 * </ol>
 * 
 * <p>The implementation of this interface is the entry point for the framework to obtain the configuration of a domain.
 * {@link HistoricMusicNotationTraining#HistoricMusicNotationTraining(MusicDomain[])}takes a array of domains to configure the whole
 * application.</p>
 * 
 * <p>The application framework creates a tab for each domain in the top level application window. 
 * 
 * @see DomainSpecificState
 * @see AbstractNotePanel
 * @see DomainRandomResult
 * @see WorkerExtension
 * @see NoteButtonPanelType
 */
public interface MusicDomain {

	/**
	 * @return a string to use as the name on the tab for the domain 
	 */
	public String getName();

	public NoteButtonPanelType[] getNoteButtonPanelTypes();

	/**
	 * @return a mnemonic code (one of constants in {@link KeyEvent}) to use on the tab of the domain
	 */
	public int getTabMnemonic();

	/**
	 * <p>The default implementation return the value of {@link #getName()}.</p>
	 * @return a string to use as a tool tip on the tab for the domain
	 */
	public default String getToolTip() {
		return getName();
	}

	public JComponent createSpecificTopPanel();

	public DomainSpecificState getStateObject();

	/**
	 * Creates a domain specific worker extension.
	 * 
	 * @return the worker extension for this domain
	 */
	public WorkerExtension<?, ?> createWorkerExtension();

	public AbstractNotePanel<?, ?> createNotePanel(Controller controller);
}
