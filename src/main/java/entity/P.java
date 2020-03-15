package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class P {
	private String p;
	private String name;

	@XmlValue
	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
