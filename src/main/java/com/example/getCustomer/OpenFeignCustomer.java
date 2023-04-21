package com.example.getCustomer;

import com.example.DTO.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer", url = "${name.service.url}")
public interface OpenFeignCustomer {
    @GetMapping("/customers/{id}")
    Customer getCustomers(@PathVariable int id);
}

