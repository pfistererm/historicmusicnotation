package de.pfist.historicmusicnotationtraining.domains.cclef.chord;

import java.util.List;

import javax.xml.bind.JAXBException;

import de.pfist.historicmusicnotationtraining.Worker;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.data.CClefChordDescription;
import de.pfist.historicmusicnotationtraining.data.ChordDescriptionUtil;
import de.pfist.historicmusicnotationtraining.data.ClefAndNote;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

/**
 * Worker extension for C clef chords domain.
 * 
 * @see CClefChordsDomain
 */
public class CClefChordsWorkerExtension
		implements WorkerExtension<CClefChordsDomainSpecificState, CClefChordsRandomResult> {

	private boolean CHORD_TEST = false;

	private int chordDescriptionIndexTest = 0;

	private static List<CClefChordDescription> getChords() {
		try {
			return ChordDescriptionUtil.readCClefChordDescriptions("./chords-cclef.xml").getChordDescriptions();
		} catch (JAXBException e) {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CClefChordsRandomResult doRandom(final DomainSpecificState domainSpecificState) {

		final List<CClefChordDescription> chords = getChords();
		final int chordDescriptionIndex = CHORD_TEST ? chordDescriptionIndexTest : Worker.randomInteger(chords.size());
		System.out.println("chordDescriptionIndex: " + chordDescriptionIndex); //$NON-NLS-1$
		final CClefChordDescription chordDescription = chords.get(chordDescriptionIndex);
		if (CHORD_TEST && chordDescriptionIndexTest < chords.size()) {
			chordDescriptionIndexTest++;
		}

		final ClefAndNote[] clefAndNotes = chordDescription.getNotes();
		final int[] midiNotes = getMidiNotes(clefAndNotes);

		final CClefChordsRandomResult randomResult = new CClefChordsRandomResult(chordDescription.getChord(),
				clefAndNotes, midiNotes);
		System.out.println("chord: " + chordDescription.getChord()); //$NON-NLS-1$
		return randomResult;
	}

	private static int[] getMidiNotes(final ClefAndNote[] clefAndNotes) {
		final int[] midiNotes = new int[clefAndNotes.length];
		for (int i = 0; i < clefAndNotes.length; i++) {
			midiNotes[i] = clefAndNotes[i].getMidiNote();
		}
		return midiNotes;
	}

}
