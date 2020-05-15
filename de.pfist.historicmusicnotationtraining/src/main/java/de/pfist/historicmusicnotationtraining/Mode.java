package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.util.I18NEnum;

public enum Mode implements I18NEnum {
	MANUAL("Mode.manual"), //$NON-NLS-1$
	AUTO_NEXT_ON_RIGHT("Mode.next_on_right"), //$NON-NLS-1$
	AUTO_NEXT_ALWAYS("Mode.next_always"), //$NON-NLS-1$
	AUTOMATIC("Mode.automatic"); //$NON-NLS-1$

	private final String textKey;

	private Mode(String textKey) {
		this.textKey = textKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTextKey() {
		return textKey;
	}

}