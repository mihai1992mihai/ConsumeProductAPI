package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.service.RestTemplateService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class RestTemplateController {
    RestTemplateService restTemplateService;

    @GetMapping(value = "/restTemplate/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductsDTO> getProducts() {

        return restTemplateService.getProducts();
    }

    @GetMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {

        return restTemplateService.getProduct(id);
    }

    @PostMapping(value ="/restTemplate/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> postCustomer(@RequestBody ProductDTO productDTO){

        return restTemplateService.postProduct(productDTO);
    }

    @PutMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> putCustomer(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return restTemplateService.putProduct(id, productDTO);
    }

    @DeleteMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<JsonNode> deleteCustomer(@PathVariable Long id) {

        return restTemplateService.deleteProduct(id);

    }
}
