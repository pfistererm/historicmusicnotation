package de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note;

import de.pfist.historicmusicnotationtraining.Worker;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

/**
 *
 */
public class NewGermanOrganTablatureWorkerExtension
		implements WorkerExtension<NewGermanOrganTablatureDomainSpecificState, NewGermanOrganTablatureRandomResult> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NewGermanOrganTablatureRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		NewGermanOrganTablatureDomainSpecificState domainSpecificState2 = (NewGermanOrganTablatureDomainSpecificState) domainSpecificState;
		// 0 .. 3
		int octave = Worker.randomInteger(4);
		final int noteOffset;
		int[] offsetTable = domainSpecificState2.getKeyMode().getOffsets();
		int tableIndex = Worker.randomInteger(offsetTable.length);
		noteOffset = offsetTable[tableIndex];
		final int midiNote = 12 * (3 + octave) + noteOffset;

		NewGermanOrganTablatureRandomResult randomResult = new NewGermanOrganTablatureRandomResult(midiNote);
		System.out.println("octave: " + octave); //$NON-NLS-1$
		System.out.println("noteOffset: " + noteOffset); //$NON-NLS-1$
		System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

}
