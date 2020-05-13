package de.pfist.historicmusicnotationtraining.data;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ChordDescriptionUtil {

	public static LuteChordDescriptions readLuteChordDescriptions(String filename) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(LuteChordDescriptions.class);
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		return (LuteChordDescriptions) jaxbUnmarshaller.unmarshal(new File(filename));
	}

	public static CClefChordDescriptions readCClefChordDescriptions(String filename) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(CClefChordDescriptions.class);
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		return (CClefChordDescriptions) jaxbUnmarshaller.unmarshal(new File(filename));
	}

}
