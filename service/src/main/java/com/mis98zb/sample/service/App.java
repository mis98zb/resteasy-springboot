package com.mis98zb.sample.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        var ac = SpringApplication.run(App.class, args);
        //SwaggerController.init(ac);
    }
}
