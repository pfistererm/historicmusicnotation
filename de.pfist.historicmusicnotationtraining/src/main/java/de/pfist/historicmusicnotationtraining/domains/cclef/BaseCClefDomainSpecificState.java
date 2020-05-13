package de.pfist.historicmusicnotationtraining.domains.cclef;

import de.pfist.historicmusicnotationtraining.data.Clef;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

public class BaseCClefDomainSpecificState implements DomainSpecificState {

	private Clef clefSelection = Clef.ALL;

	/**
	 * @return the clefSelection
	 */
	public final Clef getClefSelection() {
		return clefSelection;
	}

	/**
	 * @param clefSelection
	 *            the clefSelection to set
	 */
	public final void setClefSelection(Clef clefSelection) {
		this.clefSelection = clefSelection;
	}

}
