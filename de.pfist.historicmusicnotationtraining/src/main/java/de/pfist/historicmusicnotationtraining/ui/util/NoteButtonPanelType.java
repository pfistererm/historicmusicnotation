package de.pfist.historicmusicnotationtraining.ui.util;

import de.pfist.historicmusicnotationtraining.util.I18NEnum;

// TODO: implement automatic preference save of panel type per domain
public enum NoteButtonPanelType implements I18NEnum {
	SINGLE_LUTE_FRETBOARD("NoteButtonPanelType.singleLuteFretboard"), //$NON-NLS-1$
	SINGLE_KEYBOARD("NoteButtonPanelType.singleKeyboard"), //$NON-NLS-1$
	SINGLE_DIATONIC("NoteButtonPanelType.singleDiatonic"), //$NON-NLS-1$
	SINGLE_CHROMATIC("NoteButtonPanelType.singleChromativ3Octaves"), //$NON-NLS-1$
	SINGLE_CHROMATIC_4_OCTAVES("NoteButtonPanelType.singleChromativ4Octaves"), //$NON-NLS-1$
	CHORDS("NoteButtonPanelType.chords"); //$NON-NLS-1$

	private final String textKey;

	/**
	 * @param textKey
	 */
	private NoteButtonPanelType(final String textKey) {
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
