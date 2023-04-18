package com.example;

import com.example.controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
//        System.out.println("test");
//        ApplicationContext applicationContext = SpringApplication.run(OpenFeignApplication.class, args);
//        Controller controller = applicationContext.getBean(Controller.class);
//
//        controller.consumeAPI();
    }


}
