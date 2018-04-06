package de.hsel.idtt.soaptorest.devices;

import de.hsel.idtt.soaptorest.shared.IMituyoSensor;
import de.hsel.idtt.soaptorest.shared.ResponseType;

public class MituyoSensor implements IMituyoSensor{

	public ResponseType getSensor()  {
	
		ResponseType resp = new ResponseType();
		resp.setType("double");
		resp.setValue(2.2);
		
		return resp;
	}

}
