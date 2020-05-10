package de.pfist.historicmusicnotationtraining.domains.lute.german.note;

import java.util.ArrayList;
import java.util.List;

import de.pfist.historicmusicnotationtraining.KeyMode;
import de.pfist.historicmusicnotationtraining.LuteStringMode;
import de.pfist.historicmusicnotationtraining.LuteTuning;
import de.pfist.historicmusicnotationtraining.Worker;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

/**
 *
 */
public class GermanLuteTablatureNoteWorkerExtension
		implements WorkerExtension<GermanLuteTablatureNoteDomainSpecificState, GermanLuteTablatureNoteRandomResult> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GermanLuteTablatureNoteRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		GermanLuteTablatureNoteDomainSpecificState domainSpecificState2 = (GermanLuteTablatureNoteDomainSpecificState) domainSpecificState;
		final LuteTuning luteTuning = domainSpecificState2.getLuteTuning();
		final LuteStringMode string = getString(domainSpecificState2, luteTuning);
		final int fretPosition;
		final int availableFrets = string.getAvailableFrets(luteTuning);
		if (domainSpecificState2.getKeyMode() == KeyMode.CHROMATIC) {
			fretPosition = Worker.randomInteger(availableFrets);
		} else {
			final List<Integer> fretPositions = getFretPositonTableForKey(domainSpecificState2, string);
			fretPosition = fretPositions.get(Worker.randomInteger(fretPositions.size()));
		}
		LuteNote luteNote = LuteNote.getNote(string, fretPosition);
		final int midiNote = luteNote.getMidiNote(luteTuning);

		GermanLuteTablatureNoteRandomResult randomResult = new GermanLuteTablatureNoteRandomResult(luteNote, midiNote);
		// System.out.println("string: " + string); //$NON-NLS-1$
		// System.out.println("fretPosition: " + fretPosition); //$NON-NLS-1$
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

	private static LuteStringMode getString(GermanLuteTablatureNoteDomainSpecificState domainSpecificState2,
			final LuteTuning luteTuning) {
		LuteStringMode string;
		if (domainSpecificState2.getLuteStringMode() == LuteStringMode.ALL) {
			int stringIndex = Worker.randomInteger(luteTuning.getStringCount());
			string = LuteStringMode.values()[stringIndex];
		} else if (domainSpecificState2.getLuteStringMode() == LuteStringMode.S45) {
			int stringIndex = 4 + Worker.randomInteger(2);
			string = LuteStringMode.values()[stringIndex];
		} else if (domainSpecificState2.getLuteStringMode() == LuteStringMode.S345) {
			int stringIndex = 3 + Worker.randomInteger(3);
			string = LuteStringMode.values()[stringIndex];
		} else {
			string = domainSpecificState2.getLuteStringMode();
		}
		return string;
	}

	private static List<Integer> getFretPositonTableForKey(
			final GermanLuteTablatureNoteDomainSpecificState domainSpecificState2, LuteStringMode luteString) {
		List<Integer> fretPositions = new ArrayList<>();
		final LuteTuning luteTuning = domainSpecificState2.getLuteTuning();
		int[] offsetTableOnce = domainSpecificState2.getKeyMode().getOffsets();
		final int offsetTableLength = offsetTableOnce.length;
		final int[] scaleTwoTimesInSequence = new int[offsetTableLength * 2];
		System.arraycopy(offsetTableOnce, 0, scaleTwoTimesInSequence, 0, offsetTableLength);
		for (int i = 0; i < offsetTableLength; i++) {
			scaleTwoTimesInSequence[i + offsetTableLength] = offsetTableOnce[i] + 12;
		}
		// search for bginning point
		int stringMidiStart = luteString.getOffset(luteTuning);
		int stringMidiEnd = stringMidiStart + luteString.getAvailableFrets(luteTuning) - 1;
		int stringStartOctaveBase = (stringMidiStart / 12) * 12;
		int stringStartReminder = stringMidiStart - stringStartOctaveBase;
		int tableIndex = 0;
		int relPos = 0;
		while (true) {
			if (scaleTwoTimesInSequence[tableIndex] >= stringStartReminder) {
				break;
			}
			tableIndex++;
		}
		while (scaleTwoTimesInSequence[tableIndex] + stringStartOctaveBase <= stringMidiEnd) {
			relPos = scaleTwoTimesInSequence[tableIndex];
			int midiNote = stringStartOctaveBase + relPos;
			int fretPos = midiNote - stringMidiStart;
			fretPositions.add(fretPos);
			tableIndex++;
		}
		return fretPositions;
	}

}
