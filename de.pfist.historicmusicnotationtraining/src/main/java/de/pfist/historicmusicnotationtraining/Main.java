package de.pfist.historicmusicnotationtraining;

public class Main {

	@SuppressWarnings("unused")
	public static void main(final String[] args) {
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