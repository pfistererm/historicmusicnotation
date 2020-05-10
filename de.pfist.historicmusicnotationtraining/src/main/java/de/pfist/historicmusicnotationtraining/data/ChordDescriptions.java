package de.pfist.historicmusicnotationtraining.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chords")
@XmlAccessorType (XmlAccessType.FIELD)
public class ChordDescriptions 
{
	@XmlElement(name = "chorddescription")
	private List<ChordDescription> chordDescriptions = null;

	public List<ChordDescription> getChordDescriptions() {
		return chordDescriptions;
	}

	public void setChordDescriptions(List<ChordDescription> chordDescriptions) {
		this.chordDescriptions = chordDescriptions;
	}
}