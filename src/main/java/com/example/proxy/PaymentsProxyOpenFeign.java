package com.example.proxy;

import com.example.DTO.Customer;
import com.example.DTO.Foo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer", url = "${name.service.url}")
public interface PaymentsProxyOpenFeign {
    @GetMapping("/customers/{id}")
    Customer getCustomers(@PathVariable String id);
}

