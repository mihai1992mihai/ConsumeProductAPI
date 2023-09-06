package com.example.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableFeignClients(basePackages = {"com.example.restClient"})
public class ProjectConfig {


    @Bean(name = "rest")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
