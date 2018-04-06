package de.hsel.idtt.soaptorest.devices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;

@Path("/mituyo")
@Api("/mituyo")
public class MituyoSensorRest extends MituyoSensor {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSensorData() {
		return Response.ok(super.getSensor(), MediaType.APPLICATION_JSON).build();
	}
}
