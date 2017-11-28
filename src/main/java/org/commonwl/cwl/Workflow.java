/**
 * Copyright 2013 Netherlands eScience Center
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonwl.cwl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Workflow extends Process {
	private static final long serialVersionUID = -2170400805154307949L;
	private InputParameter[] inputs;
	private OutputParameter[] outputs;
	
	public Workflow(
			@JsonProperty("inputs") InputParameter[] inputs,
			@JsonProperty("outputs") OutputParameter[] outputs
			){
		super();
		this.setInputs(inputs);
		this.setOutputs(outputs);
	}

	public InputParameter[] getInputs() {
		return inputs;
	}

	public void setInputs(InputParameter[] inputs) {
		this.inputs = inputs;
	}

	public OutputParameter[] getOutputs() {
		return outputs;
	}

	public void setOutputs(OutputParameter[] outputs) {
		this.outputs = outputs;
	}
	
	public static Workflow fromFile(File file) throws JsonParseException, JsonMappingException, IOException {
		Process p = Process.fromFile(file);
		Workflow wf = (Workflow)p;
		return wf;
	}
	
	public static Workflow fromInputStream(InputStream inputStream, String type) throws JsonParseException, JsonMappingException, IOException {
		Process p = Process.fromInputStream(inputStream, type);
		Workflow wf = (Workflow)p;
		return wf;
	}

	@Override
	public String toString() {
		return "Workflow [inputs=" + Arrays.toString(inputs) + ", outputs=" + Arrays.toString(outputs) + "]";
	}
}
