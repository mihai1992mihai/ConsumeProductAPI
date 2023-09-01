package com.example.postProduct;

import com.example.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplatePostCustomer {

    //@Autowired //daca nu faci DI in constructor
    private  RestTemplate rest;
    @Value("https://api.predic8.de:443/shop")
    private String paymentsServiceUrl;

    public RestTemplatePostCustomer(RestTemplate rest) {
        this.rest = rest;
    }


    public ProductDTO postCustomer(ProductDTO productDTO) { //  V2 public ResponseEntity<Payment> createPayment(Payment payment)
        String uri = paymentsServiceUrl + "/customers/";

        HttpEntity<ProductDTO> httpEntity =
                new HttpEntity<>(productDTO);

        ResponseEntity<ProductDTO> response =
                rest.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        ProductDTO.class);
        return response.getBody();      // V2 return response;


    }

}
//    V3, ca sa lucreze trebuie activat Bean-ul RestTemplate din ProjectConfig ca sa faca autowire din constructor