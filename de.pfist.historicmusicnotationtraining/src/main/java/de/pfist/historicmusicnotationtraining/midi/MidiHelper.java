package de.pfist.historicmusicnotationtraining.midi;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

public class MidiHelper {

	private MidiChannel midiChannel;
	private List<MidiChannel> midiChannels;
	private Synthesizer midiSynth;

	public MidiHelper() throws MidiUnavailableException {
		initSynth();
	}

	private void initSynth() throws MidiUnavailableException {
		midiSynth = MidiSystem.getSynthesizer();
		midiSynth.open();
		Soundbank defaultSoundbank = midiSynth.getDefaultSoundbank();
		final Instrument[] instruments = defaultSoundbank.getInstruments();
		midiSynth.loadInstrument(instruments[0]);
		midiChannel = midiSynth.getChannels()[0];
		midiChannels = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			midiChannels.add(midiSynth.getChannels()[i]);
		}
	}

	public ControllerInstrument[] getInstruments() {
		List<ControllerInstrument> controllerInstruments = new ArrayList<>();
		Soundbank defaultSoundbank = midiSynth.getDefaultSoundbank();
		final Instrument[] instruments = defaultSoundbank.getInstruments();
		for (Instrument instrument : instruments) {
			controllerInstruments.add(new ControllerInstrument(instrument));
		}
		return controllerInstruments.toArray(new ControllerInstrument[0]);
	}

	public void setIntrument(final ControllerInstrument instrument) {
		midiSynth.loadInstrument(instrument.getMidiInstrument());
		final int programNumber = instrument.getMidiInstrument().getPatch().getProgram();
		midiChannel.programChange(programNumber);
		for (MidiChannel midiCh : midiChannels) {
			midiCh.programChange(programNumber);
		}
	}

	public void playNote(final int midiNote, int midiNoteVelocity) {

		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				midiChannel.noteOn(midiNote, midiNoteVelocity);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
				}
				midiChannel.noteOff(midiNote);
			}
		};
		new Thread(runnable).start();
	}

	public void playNotes(final int[] midiNotes, final int midiNoteVelocity) {

		final int noteCount = Math.min(midiNotes.length, midiChannels.size());
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < noteCount; i++) {
					midiChannels.get(i).noteOn(midiNotes[i], midiNoteVelocity);
				}
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
				}
				for (int i = 0; i < noteCount; i++) {
					midiChannels.get(i).noteOff(midiNotes[i]);
				}
			}
		};
		new Thread(runnable).start();
	}

	public void beep(int midiNoteVelocity) {
		playNote(20, midiNoteVelocity);
	}

	public void close() {
		midiSynth.close();
	}

}
