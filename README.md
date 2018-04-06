# Description

This is an example to showcase how to develop a SOAP to REST and REST to SOAP adapter / middleware using 
JAXB for automagically marshall/unmarshall the XML/JSON to POJO and vice versa.

# How to use

mvn install
mvn spring-boot:run

services will be available under: 127.0.0.1:8080/services

The middleware REST service has currently no swagger page as this need the rest-dsl to be created. 
This will be added in a future revision. 


