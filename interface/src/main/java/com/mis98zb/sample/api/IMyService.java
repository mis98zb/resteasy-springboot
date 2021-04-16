package com.mis98zb.sample.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.mis98zb.sample.model.MyModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name="MyService", description="我的服务")
@Path("myservice")
public interface IMyService {
    @Operation(description = "做一下测试嘛",  
    		summary="这种方式指定了能返回的类型。对swagger友好。", 
    		security = @SecurityRequirement(name="wawa", scopes = "haha"))
    @GET
    @Path("test")
    @Produces("application/json")
    MyModel test(@Parameter(name = "君の名は") @QueryParam("name") String name);
    
    @Operation(description = "测试一下Response嘛",  
    		summary=" 这种方式能返回任意类型的内容。但是这个对swagger不友好。", 
    		security = @SecurityRequirement(name="wawa", scopes = "haha"))
    @GET
    @Path("testResponse")
    @Produces("application/json")
    public Response testResponse(@Parameter(name = "君の名は") @QueryParam("name") String name);
    
    @Operation(description = "测试一下流嘛",  
    		summary="这种方式能以流的形式返回。对返回大数据量很有用。", 
    		security = @SecurityRequirement(name="wawa", scopes = "haha"))
    @GET
    @Path("/testStream")
    @Produces({"application/octet-stream", "application/json"})
    public Response testStream(@Parameter(name = "ファイルの名は") @QueryParam("fname") String fname);
}
