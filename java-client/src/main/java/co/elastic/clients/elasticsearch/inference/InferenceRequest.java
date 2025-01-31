/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.clients.elasticsearch.inference;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

//----------------------------------------------------------------
//       THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------------------
//
// This code is generated from the Elasticsearch API specification
// at https://github.com/elastic/elasticsearch-specification
//
// Manual updates to this file will be lost when the code is
// re-generated.
//
// If you find a property that is missing or wrongly typed, please
// open an issue or a PR on the API specification repository.
//
//----------------------------------------------------------------

// typedef: inference.inference.Request

/**
 * Perform inference on the service
 * 
 * @see <a href="../doc-files/api-spec.html#inference.inference.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class InferenceRequest extends RequestBase implements JsonpSerializable {
	private final List<String> input;

	private final String modelId;

	@Nullable
	private final JsonData taskSettings;

	private final TaskType taskType;

	// ---------------------------------------------------------------------------------------------

	private InferenceRequest(Builder builder) {

		this.input = ApiTypeHelper.unmodifiableRequired(builder.input, this, "input");
		this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
		this.taskSettings = builder.taskSettings;
		this.taskType = ApiTypeHelper.requireNonNull(builder.taskType, this, "taskType");

	}

	public static InferenceRequest of(Function<Builder, ObjectBuilder<InferenceRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Text input to the model. Either a string or an array of strings.
	 * <p>
	 * API name: {@code input}
	 */
	public final List<String> input() {
		return this.input;
	}

	/**
	 * Required - The unique identifier of the inference model.
	 * <p>
	 * API name: {@code model_id}
	 */
	public final String modelId() {
		return this.modelId;
	}

	/**
	 * Optional task settings
	 * <p>
	 * API name: {@code task_settings}
	 */
	@Nullable
	public final JsonData taskSettings() {
		return this.taskSettings;
	}

	/**
	 * Required - The model task type
	 * <p>
	 * API name: {@code task_type}
	 */
	public final TaskType taskType() {
		return this.taskType;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (ApiTypeHelper.isDefined(this.input)) {
			generator.writeKey("input");
			generator.writeStartArray();
			for (String item0 : this.input) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.taskSettings != null) {
			generator.writeKey("task_settings");
			this.taskSettings.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link InferenceRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<InferenceRequest> {
		private List<String> input;

		private String modelId;

		@Nullable
		private JsonData taskSettings;

		private TaskType taskType;

		/**
		 * Required - Text input to the model. Either a string or an array of strings.
		 * <p>
		 * API name: {@code input}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>input</code>.
		 */
		public final Builder input(List<String> list) {
			this.input = _listAddAll(this.input, list);
			return this;
		}

		/**
		 * Required - Text input to the model. Either a string or an array of strings.
		 * <p>
		 * API name: {@code input}
		 * <p>
		 * Adds one or more values to <code>input</code>.
		 */
		public final Builder input(String value, String... values) {
			this.input = _listAdd(this.input, value, values);
			return this;
		}

		/**
		 * Required - The unique identifier of the inference model.
		 * <p>
		 * API name: {@code model_id}
		 */
		public final Builder modelId(String value) {
			this.modelId = value;
			return this;
		}

		/**
		 * Optional task settings
		 * <p>
		 * API name: {@code task_settings}
		 */
		public final Builder taskSettings(@Nullable JsonData value) {
			this.taskSettings = value;
			return this;
		}

		/**
		 * Required - The model task type
		 * <p>
		 * API name: {@code task_type}
		 */
		public final Builder taskType(TaskType value) {
			this.taskType = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link InferenceRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public InferenceRequest build() {
			_checkSingleUse();

			return new InferenceRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link InferenceRequest}
	 */
	public static final JsonpDeserializer<InferenceRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			InferenceRequest::setupInferenceRequestDeserializer);

	protected static void setupInferenceRequestDeserializer(ObjectDeserializer<InferenceRequest.Builder> op) {

		op.add(Builder::input, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "input");
		op.add(Builder::taskSettings, JsonData._DESERIALIZER, "task_settings");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code inference.inference}".
	 */
	public static final Endpoint<InferenceRequest, InferenceResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/inference.inference",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _modelId = 1 << 0;
				final int _taskType = 1 << 1;

				int propsSet = 0;

				propsSet |= _modelId;
				propsSet |= _taskType;

				if (propsSet == (_taskType | _modelId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_inference");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.taskType.jsonValue(), buf);
					buf.append("/");
					SimpleEndpoint.pathEncode(request.modelId, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _modelId = 1 << 0;
				final int _taskType = 1 << 1;

				int propsSet = 0;

				propsSet |= _modelId;
				propsSet |= _taskType;

				if (propsSet == (_taskType | _modelId)) {
					params.put("taskType", request.taskType.jsonValue());
					params.put("modelId", request.modelId);
				}
				return params;
			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), true, InferenceResponse._DESERIALIZER);
}
