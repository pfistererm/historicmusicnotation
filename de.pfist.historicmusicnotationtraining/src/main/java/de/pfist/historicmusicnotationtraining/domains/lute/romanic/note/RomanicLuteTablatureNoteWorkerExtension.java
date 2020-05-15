package de.pfist.historicmusicnotationtraining.domains.lute.romanic.note;

import java.util.ArrayList;
import java.util.List;

import de.pfist.historicmusicnotationtraining.Worker;
import de.pfist.historicmusicnotationtraining.WorkerExtension;
import de.pfist.historicmusicnotationtraining.data.LuteNote;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;
import de.pfist.historicmusicnotationtraining.util.KeyMode;
import de.pfist.historicmusicnotationtraining.util.LuteStringMode;
import de.pfist.historicmusicnotationtraining.util.LuteTuning;

/**
 *
 */
public class RomanicLuteTablatureNoteWorkerExtension
		implements WorkerExtension<RomanicLuteTablatureNoteDomainSpecificState, RomanicLuteTablatureNoteRandomResult> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RomanicLuteTablatureNoteRandomResult doRandom(final DomainSpecificState domainSpecificState) {
		RomanicLuteTablatureNoteDomainSpecificState domainSpecificState2 = (RomanicLuteTablatureNoteDomainSpecificState) domainSpecificState;
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

		RomanicLuteTablatureNoteRandomResult randomResult = new RomanicLuteTablatureNoteRandomResult(luteNote, midiNote,
				domainSpecificState2.getRomanicLuteTablatureVariant());
		// System.out.println("string: " + string); //$NON-NLS-1$
		// System.out.println("fretPosition: " + fretPosition); //$NON-NLS-1$
		// System.out.println("midiNote: " + midiNote); //$NON-NLS-1$
		return randomResult;
	}

	private static LuteStringMode getString(RomanicLuteTablatureNoteDomainSpecificState domainSpecificState2,
			final LuteTuning luteTuning) {
		LuteStringMode string;
		if (domainSpecificState2.getLuteStringMode() == LuteStringMode.ALL) {
			int stringIndex = Worker.randomInteger(luteTuning.getStringCount());
			string = LuteStringMode.values()[stringIndex];
		} else {
			string = domainSpecificState2.getLuteStringMode();
		}
		return string;
	}

	private static List<Integer> getFretPositonTableForKey(
			final RomanicLuteTablatureNoteDomainSpecificState domainSpecificState2, LuteStringMode luteString) {
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
