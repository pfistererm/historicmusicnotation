/**
 * 
 */
package de.pfist.historicmusicnotationtraining;

/**
 *
 */
public class CClefWorkerExtension implements WorkerExtension<CClefDomainSpecificState, CClefRandomResult> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CClefRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		Clef clef;
		CClefDomainSpecificState domainSpecificState2 = (CClefDomainSpecificState) domainSpecificState;
		if (domainSpecificState2.getClefSelection() == Clef.ALL) {
			Clef[] allClefs = Clef.getAllCClefs();
			clef = allClefs[Worker.randomInteger(allClefs.length)];
		} else {
			clef = domainSpecificState2.getClefSelection();
		}
		// values: -1 ..10
		final int noteRelative = Worker.randomInteger(11) - 1;
		final ClefAndNote clefAndNote = new ClefAndNote(clef, noteRelative);
		final CClefRandomResult randomResult = new CClefRandomResult(clefAndNote, clefAndNote.getMidiNote());
		// System.out.println("clef: " + clef.name());
		// System.out.println("note rel: " + noteRelative);
		// System.out.println("note abs: " + noteAbsolute);
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

}
