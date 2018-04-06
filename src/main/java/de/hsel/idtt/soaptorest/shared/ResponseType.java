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
