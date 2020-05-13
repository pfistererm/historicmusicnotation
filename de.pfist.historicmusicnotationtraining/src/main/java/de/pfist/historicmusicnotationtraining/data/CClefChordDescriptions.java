package de.pfist.historicmusicnotationtraining.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chorddescriptions")
@XmlAccessorType (XmlAccessType.FIELD)
public class CClefChordDescriptions 
{
	@XmlElement(name = "chorddescription")
	private List<CClefChordDescription> chordDescriptions = null;

	public List<CClefChordDescription> getChordDescriptions() {
		return chordDescriptions;
	}

	public void setChordDescriptions(List<CClefChordDescription> chordDescriptions) {
		this.chordDescriptions = chordDescriptions;
	}
}