/*******************************************************************************
 * Copyright 2018 Frederik Gosewehr <fgosew@gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package de.hsel.idtt.soaptorest;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;

import java.util.Arrays;

import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import de.hsel.idtt.soaptorest.devices.MituyoSensorRest;
import de.hsel.idtt.soaptorest.devices.MituyoSensorSoap;


@SpringBootApplication
public class SoapToRestConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapToRestConverterApplication.class, args);
	}

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpointDeviceMituyo() {
		EndpointImpl endpoint = new EndpointImpl(bus, new MituyoSensorSoap());
		endpoint.publish("/mituyo");
		return endpoint;
	}

	@Bean
	public Server rsServerDevice() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setProvider(new JacksonJsonProvider());
		endpoint.setAddress("/device/api/");
		endpoint.setServiceBeans(Arrays.<Object>asList(new MituyoSensorRest()));
		endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
		return endpoint.create();
	}
}
