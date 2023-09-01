package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.restClient.OpenFeignClient;
import com.example.deleteProduct.OpenFeignDeleteProduct;
import com.fasterxml.jackson.databind.JsonNode;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenFeignController {


    private OpenFeignClient openFeignClient;

    private OpenFeignDeleteProduct openFeignDeleteProduct;


    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductsDTO> getProducts() {

        return openFeignClient.getProducts();
    }


    @GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {

        return openFeignClient.getProduct(id);
    }


    @PostMapping(value ="/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> postCustomer(@RequestBody ProductDTO productDTO){

        return openFeignClient.postProduct(productDTO);
    }

    @PutMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> putCustomer(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return openFeignClient.putProduct(id, productDTO);
    }

    @DeleteMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        openFeignClient.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
