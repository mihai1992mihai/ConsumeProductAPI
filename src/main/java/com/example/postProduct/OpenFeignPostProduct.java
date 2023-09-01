package com.example.postProduct;

import com.example.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "postCustomers", url = "${name.service.url}")
public interface OpenFeignPostProduct {
//    @PostMapping ("/products")
//    ProductDTO postProduct(ProductDTO productDTO);
}

