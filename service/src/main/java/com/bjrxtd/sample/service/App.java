package com.bjrxtd.sample.service;

import com.bjrxtd.sample.service.swagger.SwaggerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        var ac = SpringApplication.run(App.class, args);
        //SwaggerController.init(ac);
    }
}
