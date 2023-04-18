package com.example.proxy;

import com.example.DTO.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateCustomers {

    //@Autowired //daca nu faci DI in constructor
    private  RestTemplate rest;
    @Value("https://api.predic8.de:443/shop")
    private String paymentsServiceUrl;

    public RestTemplateCustomers(RestTemplate rest) {
        this.rest = rest;
    }


    public Customer getCustomers(String number) { //  V2 public ResponseEntity<Payment> createPayment(Payment payment)
        String uri = paymentsServiceUrl + "/customers/" + number;

        ResponseEntity<Customer> response =
                rest.exchange(uri,
                        HttpMethod.GET,
                        new HttpEntity<>(Customer.class),
                        Customer.class);
        return response.getBody();      // V2 return response;
    }

}
//    V3, ca sa lucreze trebuie activat Bean-ul RestTemplate din ProjectConfig ca sa faca autowire din constructor