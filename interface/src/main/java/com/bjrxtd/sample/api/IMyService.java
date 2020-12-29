package com.bjrxtd.sample.api;

import com.bjrxtd.sample.model.MyModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@OpenAPIDefinition(info=@Info(description="一个测试服务"))
@Path("/myservice")
public interface IMyService {

    @Operation(description = "做一下测试嘛", security = @SecurityRequirement(name="wawa", scopes = "haha"))
    @GET
    @Path("/obj")
    @Produces("application/json")
    MyModel test(@Parameter(name = "君の名は") @QueryParam("name") String name);
}
