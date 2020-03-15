package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Smart {
	private Header header;
	private Checks checks;

	public Checks getChecks() {
		return checks;
	}

	public void setChecks(Checks checks) {
		this.checks = checks;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
}
