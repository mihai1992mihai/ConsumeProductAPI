package com.example.service;

import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.example.restClient.OpenFeignClient;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service("openFeign")
public class OpenFeignService implements ClientService {

    private OpenFeignClient openFeignClient;


    public ResponseEntity<ProductsDTO> getProducts() {
        return openFeignClient.getProducts();
    }


    public ResponseEntity<ProductDTO> getProduct(Long id) {
        return openFeignClient.getProduct(id);
    }


    public ResponseEntity<ProductDTO> postProduct(ProductDTO productDTO) {
        return openFeignClient.postProduct(productDTO);
    }


    public ResponseEntity<ProductDTO> putProduct(Long id, ProductDTO productDTO) {
        return openFeignClient.putProduct(id, productDTO);
    }


    public ResponseEntity<JsonNode> deleteProduct(Long id) {
        return openFeignClient.deleteProduct(id);
    }
}
