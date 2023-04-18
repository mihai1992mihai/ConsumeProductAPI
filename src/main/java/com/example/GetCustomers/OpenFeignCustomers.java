package com.example.GetCustomers;

import com.example.DTO.Customer;
import com.example.DTO.Foo;
import com.example.DTO.Meta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customers", url = "${name.service.url}")
public interface OpenFeignCustomers {
    @GetMapping("/customers/")
    Foo getCustomers();
}

