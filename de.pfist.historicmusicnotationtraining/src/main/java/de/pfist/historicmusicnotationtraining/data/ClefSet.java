package de.pfist.historicmusicnotationtraining.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "clefs" })
public class ClefSet {

	private Clef[] clefs;

	public ClefSet() {
		// DO NOTHING
	}

	/**
	 * @return the clefs
	 */
	@XmlAttribute(name = "clef")
	public final Clef[] getClefs() {
		return clefs;
	}

	/**
	 * @param clefs the clefs to set
	 */
	public final void setClef(Clef[] clefs) {
		this.clefs = clefs;
	}

	public String getDisplayText(Clef clef, int noteRelative) {
		StringBuilder sb = new StringBuilder();
		List<String> names = Arrays.asList(getClefs()).stream().map(e -> e.toString()).collect(Collectors.toList());
		String.join("/", names);
		return sb.toString();
	}

}
