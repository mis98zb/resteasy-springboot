package com.mis98zb.sample.client.service;

import com.mis98zb.sample.api.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestService implements CommandLineRunner {

    @Autowired
    IMyService client;

    @Override
    public void run(String... args) throws Exception {
        var ret = client.test("xxxx");
        System.out.println("=======================================================");
        System.out.println(ret);
        System.out.println("=======================================================");
    }
}
