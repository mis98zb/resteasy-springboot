package com.bjrxtd.sample.service.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Component
@ApplicationPath("/")
public class JaxrsApplication  extends Application {
    //default to mapp all root resource to '/'
}
