package de.pfist.historicmusicnotationtraining;

public enum NoteButtonPanelType implements I18NEnum {
	SINGLE_LUTE_FRETBOARD("NoteButtonPanelType.singleLuteFretboard"), //
	SINGLE_KEYBOARD("NoteButtonPanelType.singleKeyboard"), //
	SINGLE_DIATONIC("NoteButtonPanelType.singleDiatonic"), //
	SINGLE_CHROMATIC("NoteButtonPanelType.singleChromativ3Octaves"), //
	SINGLE_CHROMATIC_4_OCTAVES("NoteButtonPanelType.singleChromativ4Octaves"), //
	CHORDS("NoteButtonPanelType.chords");

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
