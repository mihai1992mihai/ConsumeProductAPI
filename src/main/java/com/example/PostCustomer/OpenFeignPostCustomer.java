package com.example.PostCustomer;

import com.example.DTO.Customer;
import com.example.DTO.Foo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "postCustomers", url = "${name.service.url}")
public interface OpenFeignPostCustomer {
    @PostMapping ("/customers/")
    Customer postCustomer(Customer customer);
}

