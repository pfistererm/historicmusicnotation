package de.pfist.historicmusicnotationtraining;

public class AbstractLuteDomainSpecificState implements DomainSpecificState {

	private LuteTuning luteTuning = LuteTuning.A_TUNING;

	/**
	 * @return the luteTuning
	 */
	public final LuteTuning getLuteTuning() {
		return luteTuning;
	}

	/**
	 * @param luteTuning
	 *            the luteTuning to set
	 */
	public final void setLuteTuning(LuteTuning luteTuning) {
		this.luteTuning = luteTuning;
	}

}
