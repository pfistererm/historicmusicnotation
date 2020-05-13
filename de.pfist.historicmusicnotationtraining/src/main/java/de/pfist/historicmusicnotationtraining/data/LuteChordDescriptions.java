package de.pfist.historicmusicnotationtraining.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chorddescriptions")
@XmlAccessorType (XmlAccessType.FIELD)
public class LuteChordDescriptions 
{
	@XmlElement(name = "chorddescription")
	private List<LuteChordDescription> chordDescriptions = null;

	public List<LuteChordDescription> getChordDescriptions() {
		return chordDescriptions;
	}

	public void setChordDescriptions(List<LuteChordDescription> chordDescriptions) {
		this.chordDescriptions = chordDescriptions;
	}
}