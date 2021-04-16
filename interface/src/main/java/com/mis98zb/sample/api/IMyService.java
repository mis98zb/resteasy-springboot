package com.mis98zb.sample.api;

import com.mis98zb.sample.model.MyModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Tag(name="MyService", description="我的服务")
@Path("/myservice")
public interface IMyService {

    @Operation(description = "做一下测试嘛", security = @SecurityRequirement(name="wawa", scopes = "haha"))
    @GET
    @Path("/obj")
    @Produces("application/json")
    MyModel test(@Parameter(name = "君の名は") @QueryParam("name") String name);
}
