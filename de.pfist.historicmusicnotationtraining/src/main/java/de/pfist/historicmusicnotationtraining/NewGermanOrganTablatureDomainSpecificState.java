package de.pfist.historicmusicnotationtraining;

public class NewGermanOrganTablatureDomainSpecificState implements DomainSpecificState {

	private KeyMode keyMode = KeyMode.CHROMATIC;

	/**
	 * @return the KeyMode
	 */
	public final KeyMode getKeyMode() {
		return keyMode;
	}

	/**
	 * @param keyMode the KeyMode to set
	 */
	public final void setKeyMode(KeyMode keyMode) {
		this.keyMode = keyMode;
	}

}
