package com.example.getProduct;

import com.example.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "getProduct", url = "${name.service.url}")
public interface OpenFeignGetProduct {
//    @GetMapping("/products/{id}")
//    ProductDTO getProduct(@PathVariable int id);
}

