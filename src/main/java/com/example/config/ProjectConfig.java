package com.example.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableFeignClients(basePackages = {"com.example.getCustomer", "com.example.GetCustomers", "com.example.PostCustomer"})
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }

    @Bean(name = "rest")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
