package com.bjrxtd.sample.service.swagger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.core.filter.OpenAPISpecFilter;
import io.swagger.v3.core.filter.SpecFilter;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.GenericOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;

@Controller
@Path("")
public class SwaggerController {
	
	private static String yaml;
	private static String json;
	private static String prettyYaml;
	private static String prettyJson;

	private static Logger logger = LoggerFactory.getLogger(SwaggerController.class);
	
	public static void init(ApplicationContext ac) {
		String filterClass = "";
		Set<String> packages = new HashSet<>();
		packages.add("com.bjrxtd.sample.service.controller");
		
        SwaggerConfiguration config = ac.getBean(SwaggerConfiguration.class);

        try {
            GenericOpenApiContextBuilder builder = new JaxrsOpenApiContextBuilder()
                    .openApiConfiguration(config);

            OpenAPI openAPI = builder.buildContext(true).read();
            if (StringUtils.isNotBlank(filterClass)) {
				OpenAPISpecFilter filterImpl = (OpenAPISpecFilter) ac.getClassLoader().loadClass(filterClass).newInstance();
				SpecFilter f = new SpecFilter();
				openAPI = f.filter(openAPI, filterImpl, new HashMap<>(), new HashMap<>(),
						new HashMap<>());
            }

    		prettyYaml = Yaml.pretty(openAPI);
    		yaml = Yaml.mapper().writeValueAsString(openAPI);
    		prettyJson = Json.pretty(openAPI);
    		json = Json.mapper().writeValueAsString(openAPI);

        } catch (Exception e) {
                logger.error("Error resolving API specification.", e);
        }
	}
	

	@PermitAll
	@GET
	@Path("/swagger")
	public Response get(@QueryParam("outputFormat") String type, @QueryParam("prettyPrint") boolean pretty)
			throws JsonProcessingException {
		
		String result = "";
		if ("yaml".equalsIgnoreCase(type)) {
			result = pretty ? prettyYaml : yaml;
			return Response.ok(result).type("application/yaml").header("Access-Control-Allow-Origin", "*").build();
		} else {
			result = pretty ? prettyJson : json;
			return Response.ok(result).type("application/json").header("Access-Control-Allow-Origin", "*").build();
		}
	}
}
