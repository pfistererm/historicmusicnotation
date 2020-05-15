package de.pfist.historicmusicnotationtraining.domains.organ.newgerman.note;

import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.util.KeyMode;

public class NewGermanOrganTablatureNoteDomainSpecificState implements DomainSpecificState {

	private KeyMode keyMode = KeyMode.CHROMATIC;

	/**
	 * @return the KeyMode
	 */
	public final KeyMode getKeyMode() {
		return keyMode;
	}

	/**
	 * @param keyMode
	 *            the KeyMode to set
	 */
	public final void setKeyMode(KeyMode keyMode) {
		this.keyMode = keyMode;
	}

}
