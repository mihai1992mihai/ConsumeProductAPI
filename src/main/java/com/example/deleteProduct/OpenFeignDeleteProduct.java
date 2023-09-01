package com.example.deleteProduct;

import com.example.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "deleteProduct", url = "${name.service.url}")
public interface OpenFeignDeleteProduct {

    @DeleteMapping("/products/{id}")
    ProductDTO deleteProduct(@PathVariable int id);
}
