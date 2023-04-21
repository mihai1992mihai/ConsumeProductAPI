package com.example.getCustomer;

import com.example.DTO.Foo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentProxyRestTemplate {

    //@Autowired //daca nu faci DI in constructor
    private  RestTemplate rest;
    @Value("https://api.predic8.de:443/shop")
    private String paymentsServiceUrl;

    public PaymentProxyRestTemplate(RestTemplate rest) {
        this.rest = rest;
    }


    public Foo getCustomers() { //  V2 public ResponseEntity<Payment> createPayment(Payment payment)
        String uri = paymentsServiceUrl + "/customers/";

        ResponseEntity<Foo> response =
                rest.exchange(uri,
                        HttpMethod.GET,
                        new HttpEntity<>(Foo.class),
                        Foo.class);
        return response.getBody();      // V2 return response;
    }

}
//    V3, ca sa lucreze trebuie activat Bean-ul RestTemplate din ProjectConfig ca sa faca autowire din constructor