package com.mis98zb.sample.service.config;

import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ApplicationPath("/")
public class JaxrsApplication  extends Application {
    //default to mapp all root resource to '/'

    // be called by ResteasyEmbeddedServletInitializer.findJaxrsApplicationBeans()
    public JaxrsApplication() {
        super();
    }

    // be called by ServletContainerDispatcher.init()
    public JaxrsApplication(@Context ServletConfig servletConfig) {
        super();
        initSwagger(servletConfig);
    }

    private void initSwagger(ServletConfig servletConfig) {
        var oas = new OpenAPI();
        var info = new Info()
                .title("Swagger Sample App bootstrap code")
                .description("This is a sample server.")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact()
                        .email("apiteam@swagger.io"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        oas.info(info);
        var oasConfig = new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .resourcePackages(Stream.of("com.mis98zb.sample.api").collect(Collectors.toSet()));


        try {
            new JaxrsOpenApiContextBuilder()
                    .servletConfig(servletConfig)
                    .application(this)
                    .openApiConfiguration(oasConfig)
                    .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
