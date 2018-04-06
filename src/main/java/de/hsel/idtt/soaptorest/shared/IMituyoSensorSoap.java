package de.hsel.idtt.soaptorest.shared;

import javax.jws.WebService;

@WebService
public interface IMituyoSensorSoap {
	public ResponseType getSensor();
}
