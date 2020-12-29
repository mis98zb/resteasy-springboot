package com.bjrxtd.sample.client.config;

import com.bjrxtd.sample.api.IMyService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClients {
    @Bean
    public IMyService iMyService(){
        return Feign.builder()
                .contract(new JAXRSContract())
                .client(new OkHttpClient())
                .logger(new Slf4jLogger())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(IMyService.class, "http://localhost:8081/");
    }
}
