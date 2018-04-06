package de.hsel.idtt.soaptorest.middleware;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.hsel.idtt.soaptorest.shared.ResponseType;
import io.swagger.annotations.Api;

@Path("/mituyo")
@Api("/mituyo")
public interface MiddlewareServiceRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseType getSensor();
	
}
