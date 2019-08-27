package de.pfist.historicmusicnotationtraining.midi;

import javax.sound.midi.Instrument;
import javax.swing.JComboBox;

/**
 * Representation of a MIDI instrumnt.
 * 
 * Abstracted for two reasons:
 * 
 * override toString() for display in a {@link JComboBox}
 * 
 * GUI does not depend on javax.midi directly
 * 
 * @author matthias
 *
 */
public class ControllerInstrument {
	private final Instrument midiInstrument;

	/**
	 * @param midiInstrument
	 */
	public ControllerInstrument(final Instrument midiInstrument) {
		this.midiInstrument = midiInstrument;
	}

	/**
	 * @return the midiInstrument
	 */
	public final Instrument getMidiInstrument() {
		return midiInstrument;
	}

	public final String getName() {
		return midiInstrument.getName();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}
}