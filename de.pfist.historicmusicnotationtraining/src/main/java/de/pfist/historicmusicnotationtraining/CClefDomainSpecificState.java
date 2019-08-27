package de.pfist.historicmusicnotationtraining;

public class CClefDomainSpecificState implements DomainSpecificState {

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
