package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.service.OpenFeignService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenFeignController {

    private OpenFeignService openFeignService;

    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductsDTO> getProducts() {

        return openFeignService.getProducts();
    }


    @GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {

        return openFeignService.getProduct(id);
    }


    @PostMapping(value ="/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> postCustomer(@RequestBody ProductDTO productDTO){

        return openFeignService.postProduct(productDTO);
    }

    @PutMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> putCustomer(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return openFeignService.putProduct(id, productDTO);
    }

    @DeleteMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<JsonNode> deleteCustomer(@PathVariable Long id) {

        return openFeignService.deleteProduct(id);

    }
}
