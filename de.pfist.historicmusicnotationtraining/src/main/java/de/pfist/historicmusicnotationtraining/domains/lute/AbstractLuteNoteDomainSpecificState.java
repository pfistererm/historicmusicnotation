package de.pfist.historicmusicnotationtraining.domains.lute;

import de.pfist.historicmusicnotationtraining.KeyMode;
import de.pfist.historicmusicnotationtraining.LuteStringMode;

public class AbstractLuteNoteDomainSpecificState extends AbstractLuteDomainSpecificState {

	private KeyMode keyMode = KeyMode.CHROMATIC;
	private LuteStringMode luteStringMode = LuteStringMode.ALL;

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

	/**
	 * @return the luteStringMode
	 */
	public final LuteStringMode getLuteStringMode() {
		return luteStringMode;
	}

	/**
	 * @param luteStringMode
	 *            the luteStringMode to set
	 */
	public final void setLuteStringMode(LuteStringMode luteStringMode) {
		this.luteStringMode = luteStringMode;
	}

}
