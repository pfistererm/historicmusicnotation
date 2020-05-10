package de.pfist.historicmusicnotationtraining;

import javax.xml.bind.JAXBException;

import de.pfist.historicmusicnotationtraining.data.JaxbTest;

public class Main {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		try {
			JaxbTest.test();
		} catch (JAXBException  e) {
			e.printStackTrace();
		}
		MusicDomain[] domains = new MusicDomain[] { //
				new CClefDomain(), //
				new CClefChordsDomain(), //
				new GermanLuteTablatureDomain(), //
				new GermanLuteTablatureChordsDomain(), //
				new RomanicLuteTablatureDomain(), //
				// TODO: add romanic lute chord domain
				new NewGermanOrganTablatureDomain() //
		};
		new HistoricMusicNotationTraining(domains);
	}


}