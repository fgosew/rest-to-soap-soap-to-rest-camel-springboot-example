package de.hsel.idtt.soaptorest.shared;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseType")
public class ResponseType {

	
	private Double value;
	private String type;

	public Double getValue() {
		return value;
	}

	@XmlElement(name = "value")
	public void setValue(Double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}
	
	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

}
