package com.bjrxtd.sample.client;

import com.bjrxtd.sample.api.IMyService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(App.class)
                .web(WebApplicationType.NONE).run(args);

        var fclient = ctx.getBean(IMyService.class);

        var ret = fclient.test("xxxx");
        System.out.println(ret);
    }
}
