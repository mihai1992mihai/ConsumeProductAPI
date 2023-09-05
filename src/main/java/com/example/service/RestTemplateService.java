package com.example.service;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("restTemplate")
@AllArgsConstructor
public class RestTemplateService implements ClientService{

    com.example.restClient.RestTemplateClient RestTemplateClient;

    public ResponseEntity<ProductsDTO> getProducts() {
        System.out.println("restTemplateService");
        return RestTemplateClient.getProducts();
    }

    public ResponseEntity<ProductDTO> getProduct(Long id) {

        return RestTemplateClient.getProduct(id);
    }

    public ResponseEntity<ProductDTO> postProduct(ProductDTO productDTO) {

        return RestTemplateClient.postProduct(productDTO);
    }

    public ResponseEntity<ProductDTO> putProduct(Long id, ProductDTO productDTO) {

        return RestTemplateClient.putProduct(id, productDTO);
    }

    public ResponseEntity<JsonNode> deleteProduct(Long id) {

           return RestTemplateClient.deleteProduct(id);
    }


}
