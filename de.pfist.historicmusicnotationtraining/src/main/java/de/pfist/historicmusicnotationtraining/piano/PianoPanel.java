package de.pfist.historicmusicnotationtraining.piano;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.util.GuiUtils;
import de.pfist.historicmusicnotationtraining.util.NoteConstants2;

/**
 * Piano renders black & white keys and plays the notes for a MIDI channel.
 */
class PianoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -440840510196719195L;

	private static final int midiOffsetsWhiteKeys[] = { 0, 2, 4, 5, 7, 9, 11 };
	private static final int midiOffsetsBlackKeys[] = { 1, 3, 6, 8, 10 };

	private final PianoNoteButtonPanel pianoNoteButtonPanel;

	private int octaves;
	private int startOctave;

	private final List<PianoKey> blackKeys;
	private final List<PianoKey> whiteKeys;

	private PianoKey currentKey;
	private static final int keyWidth = 20;
	private static final int keyHeight = 80;

	public PianoPanel(PianoNoteButtonPanel pianoNoteButtonPanel, final int octaves, final int startOctave) {
		this.pianoNoteButtonPanel = pianoNoteButtonPanel;
		this.octaves = octaves;
		this.startOctave = startOctave;
		blackKeys = new ArrayList<>();
		whiteKeys = new ArrayList<>();

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.red));
		setMinimumSize(new Dimension(getNumWhiteKeys() * keyWidth, keyHeight + 1));
		setPreferredSize(new Dimension(getNumWhiteKeys() * keyWidth, keyHeight + 1));
		setMaximumSize(new Dimension(getNumWhiteKeys() * keyWidth, keyHeight + 1));

		final int midiNoteBase = getStartOctave() * 12;

		for (int octave = 0; octave < getOctaves(); octave++) {
			for (int j = 0; j < midiOffsetsWhiteKeys.length; j++) {
				int keyNum = octave * 12 + midiOffsetsWhiteKeys[j] + midiNoteBase;
				whiteKeys.add(new PianoKey(keyNum));
			}
			for (int j = 0; j < midiOffsetsBlackKeys.length; j++) {
				int keyNum = octave * 12 + midiOffsetsBlackKeys[j] + midiNoteBase;
				blackKeys.add(new PianoKey(keyNum));
			}
		}

		addMouseListener(new MouseAdapter() {
			/** {@inheritDoc} */
			@Override
			public void mousePressed(MouseEvent e) {
				currentKey = getKey(e.getPoint());
				if (currentKey != null) {
					PianoPanel.this.pianoNoteButtonPanel.getController()
							.noteButtonPressed(currentKey.getMidiNoteNumber());
					currentKey.setPressed(true);
					repaint();
				}
			}

			/** {@inheritDoc} */
			@Override
			public void mouseReleased(MouseEvent e) {
				if (currentKey != null) {
					currentKey.setPressed(false);
					repaint();
				}
			}

			/** {@inheritDoc} */
			@Override
			public void mouseExited(MouseEvent e) {
				if (currentKey != null) {
					currentKey.setPressed(false);
					repaint();
					currentKey = null;
				}
			}
		});
		setKeySizes(keyWidth, keyHeight);
		// actual text will be calculated by getToolTipText(MouseEvent event)
		setToolTipText("");
	}

	private void setKeySizes(final int keyWidthParam, final int keyHeightParam) {
		int keyIndex = 0;
		final Rectangle effectiveDimensions = GuiUtils.getEffectiveDimensions(this);
		final int originX = effectiveDimensions.x;
		final int originY = effectiveDimensions.y;
		int x = originX;
		for (int octave = 0; octave < getOctaves(); octave++) {
			for (int j = 0; j < midiOffsetsWhiteKeys.length; j++) {
				whiteKeys.get(keyIndex).setDimensions(x, originY, keyWidthParam, keyHeightParam);
				x += keyWidthParam;
				keyIndex++;
			}
		}
		final int blackKeyWidth = keyWidthParam / 2;
		final int blackKeyHeight = (keyHeightParam * 2) / 3;
		final int blackKeyXOffset = keyWidthParam / 4 - 1;
		keyIndex = 0;
		x = originX + keyWidthParam - blackKeyXOffset;
		for (int octave = 0; octave < getOctaves(); octave++) {
			for (int j = 0; j < midiOffsetsBlackKeys.length; j++) {
				blackKeys.get(keyIndex).setDimensions(x, originY, blackKeyWidth, blackKeyHeight);
				keyIndex++;
				if (j == 1 || j == 4) {
					x += keyWidthParam;
					x += keyWidthParam;
				} else {
					x += keyWidthParam;
				}
			}
		}
	}

	private PianoKey getKey(final Point point) {
		/*
		 * NOTE: this works correctly because black keys (that are overlapping white
		 * keys) are tested first.
		 */
		for (PianoKey key : blackKeys) {
			if (key.getDimensions().contains(point)) {
				return key;
			}
		}
		for (PianoKey key : whiteKeys) {
			if (key.getDimensions().contains(point)) {
				return key;
			}
		}
		return null;
	}

	/**
	 * @return the octaves
	 */
	private final int getOctaves() {
		return octaves;
	}

	/**
	 * @return the startOctave
	 */
	private final int getStartOctave() {
		return startOctave;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getToolTipText(MouseEvent event) {
		PianoKey key = getKey(event.getPoint());
		if (key != null) {
			return getNoteName(key.getMidiNoteNumber());
		} else
			return null;
	}

	private static String getNoteName(int midiNoteNumber) {
		final int noteNumberRelative = midiNoteNumber - NoteConstants2.BASE_MIDI_NOTE_CROMATIC_6_OCTAVES;
		if (noteNumberRelative >= 0 && noteNumberRelative < NoteConstants2.NOTE_NAMES_CHROMATIC_6_OCTAVES.length) {
			return NoteConstants2.NOTE_NAMES_CHROMATIC_6_OCTAVES[noteNumberRelative] + " (" + midiNoteNumber + ")";
		} else {
			return "MIDI: " + midiNoteNumber;
		}
	}

	/** {@inheritDoc} */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(PianoKeyColors.WHITE);
		int numWhiteKeys = getNumWhiteKeys();
		g2.fillRect(0, 0, numWhiteKeys * keyWidth, keyHeight);

		for (int i = 0; i < whiteKeys.size(); i++) {
			PianoKey key = whiteKeys.get(i);
			key.paintWhite(g2);
		}
		for (int i = 0; i < blackKeys.size(); i++) {
			PianoKey key = blackKeys.get(i);
			key.paintBlack(g2);
		}
	}

	private int getNumWhiteKeys() {
		return getOctaves() * 7;
	}
}