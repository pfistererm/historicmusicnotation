package de.pfist.historicmusicnotationtraining;

import de.pfist.historicmusicnotationtraining.util.I18NEnum;

public enum AnswerState implements I18NEnum {
	WAITING("AnswerState.waiting"), //$NON-NLS-1$
	RIGHT("AnswerState.right"), //$NON-NLS-1$
	WRONG("AnswerState.wrong"); //$NON-NLS-1$

	private final String textKey;

	/**
	 * @param textKey
	 */
	private AnswerState(String textKey) {
		this.textKey = textKey;
	}

	/** {@inheritDoc} */
	@Override
	public final String getTextKey() {
		return textKey;
	}

}