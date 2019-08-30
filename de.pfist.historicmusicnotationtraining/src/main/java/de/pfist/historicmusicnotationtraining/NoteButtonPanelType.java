package de.pfist.historicmusicnotationtraining;

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
