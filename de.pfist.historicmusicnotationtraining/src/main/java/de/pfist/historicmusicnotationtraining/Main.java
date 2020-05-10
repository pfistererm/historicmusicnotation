package de.pfist.historicmusicnotationtraining;

import javax.xml.bind.JAXBException;

import de.pfist.historicmusicnotationtraining.data.JaxbTest;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;
import de.pfist.historicmusicnotationtraining.domains.cclef.chord.CClefChordsDomain;
import de.pfist.historicmusicnotationtraining.domains.cclef.note.CClefDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.german.chord.GermanLuteTablatureChordsDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.german.note.GermanLuteTablatureDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.note.RomanicLuteTablatureDomain;
import de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note.NewGermanOrganTablatureDomain;

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