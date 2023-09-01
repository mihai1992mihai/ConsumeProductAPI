package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.restClient.RestTemplateClient;
import com.example.service.RestTemplateService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class RestTemplateController {

    RestTemplateClient restTemplateClient;
    RestTemplateService restTemplateService;

    @GetMapping(value = "/restTemplate/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductsDTO> getProducts() {
        ResponseEntity<ProductsDTO> responseEntity = restTemplateClient.getProducts();
        HttpStatusCode status = responseEntity.getStatusCode();
        ProductsDTO productsDTO = responseEntity.getBody();

        return restTemplateClient.getProducts();
    }

    @GetMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {

        return restTemplateClient.getProduct(id);
    }

    @PostMapping(value ="/restTemplate/products", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> postCustomer(@RequestBody ProductDTO productDTO){

        return restTemplateClient.postProduct(productDTO);
    }

    @PutMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ProductDTO> putCustomer(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return restTemplateClient.putProduct(id, productDTO);
    }

    @DeleteMapping(value = "/restTemplate/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Long id) {

        ApiResponse response = restTemplateService.deleteProduct(id);
        HttpStatus status = HttpStatus.valueOf(response.getStatus());

        return new ResponseEntity<>(response,status);
    }
}
