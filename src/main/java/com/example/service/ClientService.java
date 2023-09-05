package com.example.service;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.restClient.OpenFeignClient;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

 public interface ClientService {

    public ResponseEntity<ProductsDTO> getProducts();


    public ResponseEntity<ProductDTO> getProduct(Long id);


    public ResponseEntity<ProductDTO> postProduct(ProductDTO productDTO);



    public ResponseEntity<ProductDTO> putProduct(Long id, ProductDTO productDTO);


    public ResponseEntity<JsonNode> deleteProduct(Long id);
}
