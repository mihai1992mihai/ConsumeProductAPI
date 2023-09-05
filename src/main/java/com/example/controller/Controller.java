package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.service.ClientService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Qualifier("restTemplate")
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductsDTO> getProducts() {

        return clientService.getProducts();
    }


    @GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {

        return clientService.getProduct(id);
    }


    @PostMapping(value ="/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> postCustomer(@RequestBody ProductDTO productDTO){

        return clientService.postProduct(productDTO);
    }

    @PutMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> putCustomer(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return clientService.putProduct(id, productDTO);
    }

    @DeleteMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<JsonNode> deleteCustomer(@PathVariable Long id) {

        return clientService.deleteProduct(id);

    }
}
