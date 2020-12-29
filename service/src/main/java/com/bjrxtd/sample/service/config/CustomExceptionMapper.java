package com.bjrxtd.sample.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Component
@Provider
public class CustomExceptionMapper {
//    @Autowired
//    private CustomSingletonBean customSingletonBean;

    public Response toResponse(NotFoundException exception) {

//        // This will cause a NPE if this bean couldn't be injected,
//        // and that is all we want to check. No need for assertions here
//        customSingletonBean.amIAlive();

        Response.ResponseBuilder responseBuilder = Response.status(Response.Status.NOT_FOUND).entity("The resource you've requested, has not been found!");
        responseBuilder.type(MediaType.TEXT_PLAIN);
        return responseBuilder.build();
    }
}
