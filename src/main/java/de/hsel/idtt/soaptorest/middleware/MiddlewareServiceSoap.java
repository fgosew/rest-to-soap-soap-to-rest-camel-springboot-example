package de.hsel.idtt.soaptorest.middleware;

import javax.jws.WebService;

import de.hsel.idtt.soaptorest.shared.ResponseType;

@WebService
public interface MiddlewareServiceSoap {

	public ResponseType getMituyoSensor();

}
