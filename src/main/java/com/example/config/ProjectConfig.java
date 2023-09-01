package com.example.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableFeignClients(basePackages = {"com.example.getProduct", "com.example.restClient", "com.example.postProduct", "com.example.deleteProduct"})
public class ProjectConfig {


    @Bean(name = "rest")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
