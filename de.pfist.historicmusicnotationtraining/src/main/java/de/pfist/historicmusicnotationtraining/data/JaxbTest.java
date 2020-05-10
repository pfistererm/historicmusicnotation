package de.pfist.historicmusicnotationtraining.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import de.pfist.historicmusicnotationtraining.Chord;
import de.pfist.historicmusicnotationtraining.LuteNote;

public class JaxbTest {

	public static void test() throws JAXBException {
		marshal();
	}

	public static void marshal() throws JAXBException {
		ChordDescription chordDescription1 = new ChordDescription();
		chordDescription1.setName("Book1");
		chordDescription1.setChord(Chord.A_MAJOR);
		chordDescription1.setDate(new Date());
		ChordDescription chordDescription2 = new ChordDescription();
		chordDescription2.setName("Book2");
		chordDescription2.setChord(Chord.C_MAJOR);
		chordDescription2.setDate(new Date());
		chordDescription2.setNotes(new LuteNote[] { LuteNote.S0_0, LuteNote.S0_8 });

		ChordDescriptions chordDescriptions = new ChordDescriptions();
		chordDescriptions.setChordDescriptions(new ArrayList<>());
		chordDescriptions.getChordDescriptions().add(chordDescription1);
		chordDescriptions.getChordDescriptions().add(chordDescription2);
		JAXBContext context = JAXBContext.newInstance(ChordDescriptions.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(chordDescriptions, new File("./chords-test.xml"));
	}

	// private void doJaxB() throws JAXBException {
	// JAXBContext context = JAXBContext.newInstance(ChordDescription.class);
	// Marshaller mar = context.createMarshaller();
	// mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	// mar.marshal(CHORDS, new File("./chords-glt.xml"));
	// }

}
