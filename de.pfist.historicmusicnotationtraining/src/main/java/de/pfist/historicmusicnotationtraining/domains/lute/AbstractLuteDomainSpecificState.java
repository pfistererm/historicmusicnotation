package de.pfist.historicmusicnotationtraining.domains.lute;

import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.util.LuteTuning;

/**
 * <p>Contains a {@link LuteTuning}.</p>
 */
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
