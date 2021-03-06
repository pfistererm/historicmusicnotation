package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.SwingUtilities;

import de.pfist.historicmusicnotationtraining.data.AbsoluteChord;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultChord;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResultNote;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;
import de.pfist.historicmusicnotationtraining.messages.Messages;
import de.pfist.historicmusicnotationtraining.midi.ControllerInstrument;
import de.pfist.historicmusicnotationtraining.midi.MidiHelper;
import de.pfist.historicmusicnotationtraining.ui.AbstractNotePanel;
import de.pfist.historicmusicnotationtraining.ui.IMainGui;
import de.pfist.historicmusicnotationtraining.ui.util.NoteButtonPanelType;
import de.pfist.historicmusicnotationtraining.util.PreferencesUtils;

public class Controller {

	private final MusicDomain[] domains;
	private int expectedMidiNote;
	private AbsoluteChord expectedChord;
	private int[] chordMidiNotes;
	private IMainGui mainGui;
	private MusicDomain currentDomain;
	private DomainSpecificState currentDomainSpecificState;
	private WorkerExtension<?, ?> currentWorkerExtension;
	private AbstractNotePanel<?, ?> currentNotePanel;

	private List<DomainSpecificState> domainSpecificStates = new ArrayList<>();
	private List<WorkerExtension<?, ?>> workerExtensions = new ArrayList<>();
	private List<AbstractNotePanel<?, ?>> notePanels = new ArrayList<>();
	// TODO: store state in preferences
	private boolean playNotes = true;
	private int midiNoteVelocity = 80;
	private Mode mode = Mode.AUTO_NEXT_ON_RIGHT;

	private MidiHelper midiHelper;
	private GlobalCounter globalCounter;
	private AnswerState answerState = null;
	private boolean automaticMode;
	private int automaticInterval = 3;

	public Controller(final MusicDomain[] domains) {
		super();
		this.domains = domains;
		try {
			midiHelper = new MidiHelper();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		globalCounter = new GlobalCounter();
		globalCounter.addPropertyChangeListener((event) -> {
			if (event.getPropertyName().equals(GlobalCounter.COUNTER_PROPERTY)) {

				GlobalCounter g = ((GlobalCounter) event.getSource());
				String message = String.format(Messages.getString("Controller.statusMessage"), g.getSuccessCount(), //$NON-NLS-1$
						g.getFailureCount(), g.getMissedCount());
				getMainGui().setStatusMesssage(message);
			}
		});
	}

	public ControllerInstrument[] getInstruments() {
		return midiHelper.getInstruments();
	}

	public void setIntrument(final ControllerInstrument instrument) {
		midiHelper.setIntrument(instrument);
	}

	public void noteButtonPressed(final int midiNote) {
		// System.out.println("noteButtonPressed(): midiNote: " + midiNote);
		// $NON-NLS-1$
		final boolean comparisonResult = midiNote == expectedMidiNote;
		buttonPressed(comparisonResult, () -> playNote(midiNote));
	}

	public void chordButtonPressed(final AbsoluteChord chord) {
		System.out.println("chordButtonPressed(): chord: " + chord); //$NON-NLS-1$
		final boolean comparisonResult = chord == expectedChord;
		buttonPressed(comparisonResult, () -> playNotes());
	}

	private void buttonPressed(final boolean comparisonResult, Runnable playMethod) {
		boolean doNext = false;
		if (comparisonResult) {
			if (playNotes) {
				playMethod.run();
			}
			setAnswerState(AnswerState.RIGHT);
			globalCounter.increaseSuccessCount();
			doNext = getMode() == Mode.AUTO_NEXT_ON_RIGHT;
		} else {
			if (playNotes) {
				beep();
			}
			setAnswerState(AnswerState.WRONG);
			globalCounter.increaseFailureCount();
			doNext = getMode() == Mode.AUTO_NEXT_ALWAYS;
		}
		if (doNext) {
			SwingUtilities.invokeLater(() -> {
				doNext(true);
			});
		}
	}

	private void playNote(final int midiNote) {
		midiHelper.playNote(midiNote, getMidiNoteVelocity());
	}

	private void playNotes() {
		if (chordMidiNotes != null && chordMidiNotes.length > 0) {
			midiHelper.playNotes(chordMidiNotes, getMidiNoteVelocity());
		}
	}

	private void beep() {
		midiHelper.beep(getMidiNoteVelocity());
	}

	public void doNext(boolean withDelay) {
		setAnswerState(AnswerState.WAITING);
		Worker w = new Worker(currentDomainSpecificState, currentWorkerExtension, withDelay);
		w.addPropertyChangeListener(new PropertyChangeListener() {

			/** {@inheritDoc} */
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals(Worker.RANDOM_RESULT)) {

					DomainRandomResult randomResult = (DomainRandomResult) (evt.getNewValue());
					currentNotePanel.setRandomResult(randomResult);
					repaintNotePanel();
					if (randomResult instanceof AbstractRandomResultNote) {
						final AbstractRandomResultNote<?> abstractRandomResult = (AbstractRandomResultNote<?>) randomResult;
						expectedMidiNote = abstractRandomResult.getMidiNote();
						expectedChord = null;
						// System.out.println("expectedMidiNote: " + expectedMidiNote); //$NON-NLS-1$
					} else if (randomResult instanceof AbstractRandomResultChord) {
						final AbstractRandomResultChord<?> abstractRandomResult = (AbstractRandomResultChord<?>) randomResult;
						expectedMidiNote = 0;
						expectedChord = abstractRandomResult.getChord();
						chordMidiNotes = abstractRandomResult.getMidiNotes();
						System.out.println("expectedChord: " + expectedChord); //$NON-NLS-1$
					}
				}
			}
		});
		w.run();
	}

	private void setAnswerState(final AnswerState answerState) {
		this.answerState = answerState;
		getMainGui().setAnswerState(answerState);
	}

	private void repaintNotePanel() {
		SwingUtilities.invokeLater(() -> currentNotePanel.repaint());
	}

	/**
	 * @return the mainGui
	 */
	public final IMainGui getMainGui() {
		return mainGui;
	}

	/**
	 * @param mainGui the mainGui to set
	 */
	public final void setMainGui(IMainGui mainGui) {
		this.mainGui = mainGui;
	}

	public void setCurrentDomainIndex(int selectedIndex) {
		currentDomain = domains[selectedIndex];
		currentDomainSpecificState = domainSpecificStates.get(selectedIndex);
		currentWorkerExtension = workerExtensions.get(selectedIndex);
		currentNotePanel = notePanels.get(selectedIndex);
		getMainGui().setNotePanelTypes(currentDomain.getNoteButtonPanelTypes());
		PreferencesUtils.setLastUsedDomain(currentDomain);
	}

	/**
	 * @return the currentDomainSpecificState
	 */
	public final DomainSpecificState getCurrentDomainSpecificState() {
		return currentDomainSpecificState;
	}

	public DomainSpecificState getDomainSpecificState(final Class<?> domainSpecificStateClass) {
		for (DomainSpecificState domainSpecificState : domainSpecificStates) {
			if (domainSpecificStateClass.isAssignableFrom(domainSpecificState.getClass())) {
				return domainSpecificState;
			}
		}
		throw new RuntimeException(
				"No domain specific stat found with type: " + domainSpecificStateClass.getSimpleName()); //$NON-NLS-1$
	}

	public void addDomainSpecificState(final DomainSpecificState domainSpecificState) {
		domainSpecificStates.add(domainSpecificState);
	}

	public void addWorkerExtension(final WorkerExtension<?, ?> workerExtension) {
		workerExtensions.add(workerExtension);
	}

	public void addNotePanel(final AbstractNotePanel<?, ?> notePanel) {
		notePanels.add(notePanel);
	}

	/**
	 * @return the playNotes
	 */
	public final boolean isPlayNotes() {
		return playNotes;
	}

	/**
	 * @param playNotes the playNotes to set
	 */
	public final void setPlayNotes(boolean playNotes) {
		this.playNotes = playNotes;
	}

	/**
	 * @return the midiNoteVelocity
	 */
	public final int getMidiNoteVelocity() {
		return midiNoteVelocity;
	}

	/**
	 * @param midiNoteVelocity the midiNoteVelocity to set
	 */
	public final void setMidiNoteVelocity(int midiNoteVelocity) {
		this.midiNoteVelocity = midiNoteVelocity;
	}

	/**
	 * @return the mode
	 */
	public final Mode getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public final void setMode(Mode mode) {
		this.mode = mode;
	}

	/**
	 * @return the automaticMode
	 */
	public final boolean isAutomaticMode() {
		return automaticMode;
	}

	/**
	 * @param automaticMode the automaticMode to set
	 */
	public final void setAutomaticMode(boolean automaticMode) {
		this.automaticMode = automaticMode;
	}

	/**
	 * @return the automaticInterval
	 */
	public final int getAutomaticInterval() {
		return automaticInterval;
	}

	/**
	 * @param automaticInterval the automaticInterval to set
	 */
	public final void setAutomaticInterval(int automaticInterval) {
		this.automaticInterval = automaticInterval;
	}

	public void setNoteButtonPanel(final NoteButtonPanelType noteButtonPanelType) {
		getMainGui().setNotePanelVisible(noteButtonPanelType);
	}

	public AnswerState[] getGlobalCounterValues() {
		return globalCounter.getQueueValues();
	}

	public void close() {
		if (midiHelper != null) {
			midiHelper.close();
		}
	}

	public int getDomainIndex(MusicDomain domain) {
		for (int i = 0; i < domains.length; i++) {
			if (domains[i].equals(domain)) {
				return i;
			}
		}
		return -1;
	}
}
