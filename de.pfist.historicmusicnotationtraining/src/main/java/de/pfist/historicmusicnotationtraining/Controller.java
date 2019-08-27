package de.pfist.historicmusicnotationtraining;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.SwingUtilities;

import de.pfist.historicmusicnotationtraining.midi.ControllerInstrument;
import de.pfist.historicmusicnotationtraining.midi.MidiHelper;

public class Controller {

	private final MusicDomain[] domains;
	private int expectedMidiNote;
	private Chord expectedChord;
	private int[] chordMidiNotes;
	private IMainGui mainGui;
	private MusicDomain currentDomain;
	private DomainSpecificState currentDomainSpecificState;
	private WorkerExtension currentWorkerExtension;
	private AbstractNotePanel currentNotePanel;

	private List<DomainSpecificState> domainSpecificStates = new ArrayList<>();
	private List<WorkerExtension> workerExtensions = new ArrayList<>();
	private List<AbstractNotePanel> notePanels = new ArrayList<>();
	private boolean playNotes = true;
	private int midiNoteVelocity = 80;
	private Mode mode = Mode.AUTO_NEXT_ON_RIGHT;

	private MidiHelper midiHelper;

	public Controller(final MusicDomain[] domains) {
		super();
		this.domains = domains;
		try {
			midiHelper = new MidiHelper();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

	public ControllerInstrument[] getInstruments() {
		return midiHelper.getInstruments();
	}

	public void setIntrument(final ControllerInstrument instrument) {
		midiHelper.setIntrument(instrument);
	}

	public void noteButtonPressed(int midiNote) {
		// System.out.println("noteButtonPressed(): midiNote: " + midiNote);
		// //$NON-NLS-1$
		boolean doNext = false;
		if (midiNote == expectedMidiNote) {
			if (playNotes) {
				playNote(midiNote);
			}
			setAnswerState(AnswerState.RIGHT);
			doNext = getMode() == Mode.AUTO_NEXT_ON_RIGHT;
		} else {
			if (playNotes) {
				beep();
			}
			setAnswerState(AnswerState.WRONG);
			doNext = getMode() == Mode.AUTO_NEXT_ALWAYS;
		}
		if (doNext) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					doNext(true);
				}
			});
		}
	}

	private void playNote(final int midiNote) {
		midiHelper.playNote(midiNote, getMidiNoteVelocity());
	}

	private void beep() {
		midiHelper.beep(getMidiNoteVelocity());
	}

	public void chordButtonPressed(final Chord chord) {
		System.out.println("chordButtonPressed(): chord: " + chord); //$NON-NLS-1$
		boolean doNext = false;
		if (chord == expectedChord) {
			if (playNotes) {
				playNotes();
			}
			setAnswerState(AnswerState.RIGHT);
			doNext = getMode() == Mode.AUTO_NEXT_ON_RIGHT;
		} else {
			if (playNotes) {
				beep();
			}
			setAnswerState(AnswerState.WRONG);
			doNext = getMode() == Mode.AUTO_NEXT_ALWAYS;
		}
		if (doNext) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					doNext(true);
				}
			});
		}
	}

	private void playNotes() {
		if (chordMidiNotes != null && chordMidiNotes.length > 0) {
			midiHelper.playNotes(chordMidiNotes, getMidiNoteVelocity());
		}
	}

	public void doNext(boolean withDelay) {
		setAnswerState(AnswerState.WAITING);
		Worker w = new Worker(currentDomainSpecificState, currentWorkerExtension, withDelay);
		w.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals(Worker.RANDOM_RESULT)) {

					DomainRandomResult randomResult = (DomainRandomResult) (evt.getNewValue());
					currentNotePanel.setRandomResult(randomResult);
					repaintNotePanel();
					if (randomResult instanceof AbstractRandomResultNote) {
						final AbstractRandomResultNote abstractRandomResult = (AbstractRandomResultNote) randomResult;
						expectedMidiNote = abstractRandomResult.getMidiNote();
						expectedChord = null;
						// System.out.println("expectedMidiNote: " + expectedMidiNote); //$NON-NLS-1$
					} else if (randomResult instanceof AbstractRandomResultChord) {
						final AbstractRandomResultChord abstractRandomResult = (AbstractRandomResultChord) randomResult;
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
		getMainGui().setAnswerState(answerState);
	}

	private void repaintNotePanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				currentNotePanel.repaint();
			}
		});
	}

	/**
	 * @return the mainGui
	 */
	public final IMainGui getMainGui() {
		return mainGui;
	}

	/**
	 * @param mainGui
	 *            the mainGui to set
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
	}

	public void addDomainSpecificState(final DomainSpecificState domainSpecificState) {
		domainSpecificStates.add(domainSpecificState);
	}

	public void addWorkerExtension(final WorkerExtension workerExtension) {
		workerExtensions.add(workerExtension);
	}

	public void addNotePanel(final AbstractNotePanel notePanel) {
		notePanels.add(notePanel);
	}

	/**
	 * @return the playNotes
	 */
	public final boolean isPlayNotes() {
		return playNotes;
	}

	/**
	 * @param playNotes
	 *            the playNotes to set
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
	 * @param midiNoteVelocity
	 *            the midiNoteVelocity to set
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
	 * @param mode
	 *            the mode to set
	 */
	public final void setMode(Mode mode) {
		this.mode = mode;
	}

	public void setNoteButtonPanel(final NoteButtonPanelType noteButtonPanelType) {
		getMainGui().setNotePanelVisible(noteButtonPanelType);
	}

	public void close() {
		if (midiHelper != null) {
			midiHelper.close();
		}
	}

}
