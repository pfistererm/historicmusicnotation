package de.pfist.historicmusicnotationtraining.data;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbTest {

	public static void test() throws JAXBException {
		marshalLute();
		readLute();
		marshalCClef();
	}

	private static void marshalLute() throws JAXBException {
		LuteChordDescription chordDescription1 = new LuteChordDescription();
		chordDescription1.setChord(RelativeChord._0_MAJOR);
		LuteChordDescription chordDescription2 = new LuteChordDescription();
		chordDescription2.setChord(RelativeChord._10_POWER);
		chordDescription2.setNotes(new LuteNote[] { LuteNote.S0_0, LuteNote.S0_8 });

		LuteChordDescriptions chordDescriptions = new LuteChordDescriptions();
		chordDescriptions.setChordDescriptions(new ArrayList<>());
		chordDescriptions.getChordDescriptions().add(chordDescription1);
		chordDescriptions.getChordDescriptions().add(chordDescription2);
		JAXBContext context = JAXBContext.newInstance(LuteChordDescriptions.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(chordDescriptions, new File("./chords-test.xml"));
	}

	private static void marshalCClef() throws JAXBException {
		CClefChordDescription chordDescription1 = new CClefChordDescription(AbsoluteChord.A_MAJOR, new ClefAndNote(Clef.G1, 0));
//		chordDescription1.setChord(Chord.A_MAJOR);
//		CClefChordDescription chordDescription2 = new CClefChordDescription();
//		chordDescription2.setChord(RelativeChord._10_POWER);
//		chordDescription2.setNotes(new LuteNote[] { LuteNote.S0_0, LuteNote.S0_8 });

		CClefChordDescriptions chordDescriptions = new CClefChordDescriptions();
		chordDescriptions.setChordDescriptions(new ArrayList<>());
		chordDescriptions.getChordDescriptions().add(chordDescription1);
//		chordDescriptions.getChordDescriptions().add(chordDescription2);
		JAXBContext context = JAXBContext.newInstance(CClefChordDescriptions.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(chordDescriptions, new File("./chords-test-cclef.xml"));
	}

	private static void readLute() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(LuteChordDescriptions.class);
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

		LuteChordDescriptions chordDescriptions = (LuteChordDescriptions) jaxbUnmarshaller
				.unmarshal(new File("./chords-test.xml"));
		System.out.println(chordDescriptions);
		System.out.println(chordDescriptions.getChordDescriptions().size());
	}

}
