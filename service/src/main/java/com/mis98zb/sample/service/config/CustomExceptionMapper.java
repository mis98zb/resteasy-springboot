package com.mis98zb.sample.service.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Provider
@Slf4j
public class CustomExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		log.info("internal error occured.", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
        		entity("internal server error.")
        		.type(MediaType.TEXT_PLAIN)
        		.build();
	}
}
