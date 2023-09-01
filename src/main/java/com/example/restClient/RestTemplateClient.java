package com.example.restClient;

import com.example.dto.ApiResponse;
import com.example.dto.ProductDTO;
import com.example.dto.ProductsDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestTemplateClient {

    @Autowired
    private  RestTemplate rest;

    @Value(value = "${name.service.url}")
    private String baseUrl;


    public ResponseEntity<ProductsDTO> getProducts() {
        String uri = String.format("%s/products/", baseUrl);

        return rest.getForEntity(uri, ProductsDTO.class);
    }

    public ResponseEntity<ProductDTO> getProduct(Long id) {
        String uri = String.format("%s/products/%d", baseUrl, id);

        return rest.getForEntity(uri, ProductDTO.class);
    }

    public  ResponseEntity<ProductDTO> postProduct(ProductDTO productDTO) {
        String uri = String.format("%s/products", baseUrl);

        return rest.postForEntity(uri, productDTO, ProductDTO.class);
    }

    public ResponseEntity<ProductDTO> putProduct(Long id, ProductDTO productDTO) {
        String uri = String.format("%s/products/%d", baseUrl, id);
        HttpEntity<ProductDTO> request = new HttpEntity<>(productDTO);

        return rest.exchange(uri, HttpMethod.PUT, request, ProductDTO.class);
    }

    public  ResponseEntity<ApiResponse> deleteProduct(Long id) {
        String uri = String.format("%s/products/%d", baseUrl, id);
        ResponseEntity<JsonNode> response = rest.exchange(
                uri, HttpMethod.DELETE, null, JsonNode.class);
        String a = response.getBody().toString();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(a);

        return new ResponseEntity<>(apiResponse, response.getStatusCode());

    }
}
