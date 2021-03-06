package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.domains.MusicDomain;
import de.pfist.historicmusicnotationtraining.domains.cclef.chord.CClefChordsDomain;
import de.pfist.historicmusicnotationtraining.domains.cclef.note.CClefNoteDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.german.chord.GermanLuteTablatureChordsDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.german.note.GermanLuteTablatureNoteDomain;
import de.pfist.historicmusicnotationtraining.domains.lute.romanic.note.RomanicLuteTablatureNoteDomain;
import de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note.NewGermanOrganTablatureNoteDomain;
import de.pfist.historicmusicnotationtraining.ui.HistoricMusicNotationTraining;

public class Main {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		MusicDomain[] domains = new MusicDomain[] { //
				new CClefNoteDomain(), //
				new CClefChordsDomain(), //
				new GermanLuteTablatureNoteDomain(), //
				new GermanLuteTablatureChordsDomain(), //
				new RomanicLuteTablatureNoteDomain(), //
				// TODO: add romanic lute chord domain
				new NewGermanOrganTablatureNoteDomain() //
		};
		new HistoricMusicNotationTraining(domains);
	}

}