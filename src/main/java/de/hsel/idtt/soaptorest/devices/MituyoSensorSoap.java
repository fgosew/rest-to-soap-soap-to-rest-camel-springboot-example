package de.hsel.idtt.soaptorest.devices;

import javax.jws.WebService;

import de.hsel.idtt.soaptorest.shared.IMituyoSensorSoap;
import de.hsel.idtt.soaptorest.shared.ResponseType;

@WebService
public class MituyoSensorSoap extends MituyoSensor implements IMituyoSensorSoap {

	public ResponseType getSensor() {
		return super.getSensor();
	}
}
