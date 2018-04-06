package de.hsel.idtt.soaptorest.middleware;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Configuration;

import de.hsel.idtt.soaptorest.shared.ResponseType;

@Configuration
public class MiddlewareRules extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		///////////////////////////// REST TO SOAP ///////////////////////////////
		
		// using an wadl approach to setup the routes, requires the service to be alive!
		// from("cxfrs:http://localhost:8081/api/mituyo?publishedEndpointUrl=http://127.0.0.1:8080/services/device/api/?_wadl&bindingStyle=SimpleConsumer")
		
		//version using an interface class 
		from("cxfrs:http://localhost:8081/api?resourceClasses=de.hsel.idtt.soaptorest.middleware.MiddlewareServiceRest&bindingStyle=SimpleConsumer")
		.toD("direct:${header.operationName}Rest");
		
		from("direct:getSensorRest")
		.to("cxf:http://localhost:8080/services/mituyo?"
				+ "serviceClass=de.hsel.idtt.soaptorest.shared.IMituyoSensorSoap&"
				+ "serviceName={http://shared.soaptorest.idtt.hsel.de/}getSensor&"
				+ "dataFormat=POJO&"
				//+ "loggingFeatureEnabled=true&"
				+ "synchronous=true")
		
		.log("${body}")
		.marshal().json(JsonLibrary.Jackson, ResponseType.class)
		;
		
		///////////////////////////// SOAP TO REST ///////////////////////////////
		
		from("cxf:http://localhost:8082/api/mituyo?" +
		"serviceClass=de.hsel.idtt.soaptorest.middleware.MiddlewareServiceSoap")
		.toD("direct:${header.operationName}SOAP");

		/** @IMPORTANT 
		* response of the "to" will be org.apache.camel.converter.stream.CachedOutputStream$WrappedInputStream so it needs to 
		* be cast to String first  before it can be unmarshaled correctly. This seems to be a bug in the implementation ... or a feature
		*/
		from("direct:getMituyoSensorSOAP")
		.removeHeaders("CamelHttp*") //very important! We need a fresh camel header, so throw everything away that's not needed!
		// alternative approach using service contract: .to("rest-swagger:http://127.0.0.1:8080/services/device/api/swagger.json#getMituyoSensor")
		.to("http4://127.0.0.1:8080/services/device/api/mituyo/")
		.convertBodyTo(String.class).unmarshal().json(JsonLibrary.Jackson, ResponseType.class);


	}

}
