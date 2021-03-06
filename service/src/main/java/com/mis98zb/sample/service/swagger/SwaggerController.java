package com.mis98zb.sample.service.swagger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.integration.OpenApiContextLocator;
import io.swagger.v3.oas.integration.api.OpenApiContext;

@Controller
@Path("spec")
public class SwaggerController {
	@GET
	@Path("yaml")
	public Response getYaml() throws JsonProcessingException {
		var ctx = OpenApiContextLocator.getInstance().getOpenApiContext(OpenApiContext.OPENAPI_CONTEXT_ID_DEFAULT);
		var openAPI = ctx.read();

		var result = Yaml.pretty(openAPI);
		return Response.ok(result).type("application/yaml").header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("json")
	public Response getJson() throws JsonProcessingException {
		var ctx = OpenApiContextLocator.getInstance().getOpenApiContext(OpenApiContext.OPENAPI_CONTEXT_ID_DEFAULT);
		var openAPI = ctx.read();

		var result = Json.pretty(openAPI);
		return Response.ok(result).type("application/json").header("Access-Control-Allow-Origin", "*").build();
	}
}
