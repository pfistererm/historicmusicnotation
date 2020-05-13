package de.pfist.historicmusicnotationtraining.domains.lute.german.chord;

import java.util.List;

import javax.xml.bind.JAXBException;

import de.pfist.historicmusicnotationtraining.LuteTuning;
import de.pfist.historicmusicnotationtraining.Worker;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.data.AbsoluteChord;
import de.pfist.historicmusicnotationtraining.data.ChordDescriptionUtil;
import de.pfist.historicmusicnotationtraining.data.LuteChordDescription;
import de.pfist.historicmusicnotationtraining.data.LuteChordDescriptions;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

/**
 *
 */
public class GermanLuteTablatureChordsWorkerExtension implements
		WorkerExtension<GermanLuteTablatureChordsDomainSpecificState, GermanLuteTablatureChordsRandomResult> {

	private static List<LuteChordDescription> getChords(final LuteTuning luteTuning) {
		LuteChordDescriptions chordDescriptions = null;
		try {
			chordDescriptions = ChordDescriptionUtil.readLuteChordDescriptions("./chords-germanlutetablature.xml");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return chordDescriptions.getChordDescriptions();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GermanLuteTablatureChordsRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		final GermanLuteTablatureChordsDomainSpecificState domainSpecificState2 = (GermanLuteTablatureChordsDomainSpecificState) domainSpecificState;
		final LuteTuning luteTuning = domainSpecificState2.getLuteTuning();
		final List<LuteChordDescription> chords = getChords(luteTuning);
		final int chordDescriptionIndex = Worker.randomInteger(chords.size());
		System.out.println("chordDescriptionIndex: " + chordDescriptionIndex); //$NON-NLS-1$
		final LuteChordDescription chordDescription = chords.get(chordDescriptionIndex);

		final LuteNote[] luteNotes = chordDescription.getNotes();
		final int[] midiNotes = getMidiNotes(luteTuning, luteNotes);

		final AbsoluteChord absoluteChord = luteTuning.getAbsoluteChord(chordDescription.getChord());
		final GermanLuteTablatureChordsRandomResult randomResult = new GermanLuteTablatureChordsRandomResult(
				absoluteChord, luteNotes, midiNotes);
		System.out.println("absolute chord: " + absoluteChord); //$NON-NLS-1$
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

//
//	private void doJaxB() throws JAXBException {
//		JAXBContext context = JAXBContext.newInstance(ChordDescription.class);
//		Marshaller mar = context.createMarshaller();
//		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		mar.marshal(CHORDS, new File("./chords-glt.xml"));
//	}

	private static int[] getMidiNotes(final LuteTuning luteTuning, final LuteNote[] luteNotes) {
		final int[] midiNotes = new int[luteNotes.length];
		for (int i = 0; i < luteNotes.length; i++) {
			midiNotes[i] = luteNotes[i].getMidiNote(luteTuning);
		}
		return midiNotes;
	}

}
