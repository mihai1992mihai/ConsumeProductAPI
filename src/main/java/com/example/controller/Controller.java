package com.example.controller;

import com.example.DTO.Customer;
import com.example.DTO.Foo;
import com.example.GetCustomers.OpenFeignCustomers;
import com.example.proxy.PaymentProxyRestTemplate;
import com.example.proxy.PaymentProxyRestTemplateCustomer;
import com.example.proxy.PaymentProxyWebClient;
import com.example.proxy.PaymentsProxyOpenFeign;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;


@RestController
public class Controller {
    private final OpenFeignCustomers openFeignCustomers;
    RestTemplate rest;
    private final PaymentProxyWebClient paymentProxyWebClient;

    private final PaymentProxyRestTemplate paymentProxyRestTemplate;

    private final PaymentProxyRestTemplateCustomer paymentProxyRestTemplateCustomer;
    private final PaymentsProxyOpenFeign paymentsProxyOpenFeign;

    private static Logger logger =
            Logger.getLogger(Controller.class.getName());

    public Controller(OpenFeignCustomers openFeignCustomers, PaymentProxyWebClient paymentProxyWebClient, PaymentProxyRestTemplate paymentProxyRestTemplate, RestTemplate rest, PaymentProxyRestTemplateCustomer paymentProxyRestTemplateCustomer, PaymentsProxyOpenFeign paymentsProxyOpenFeign) {
        this.openFeignCustomers = openFeignCustomers;
        this.paymentProxyWebClient = paymentProxyWebClient;
        this.paymentProxyRestTemplate = paymentProxyRestTemplate;
        this.rest = rest;
        this.paymentProxyRestTemplateCustomer = paymentProxyRestTemplateCustomer;
        this.paymentsProxyOpenFeign = paymentsProxyOpenFeign;
    }

    @GetMapping(value = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Foo getCustomers(
    ) {

        return openFeignCustomers.getCustomers();             // Cu OpenFeign
//        return paymentProxyWebClient.consumeAPI(); //Cu WebClient
//        return paymentProxyRestTemplate.getCustomers();  //Cu RestTemplate

//        Foo foo = rest.getForObject("https://api.predic8.de:443/shop/categories/", Foo.class);
//        System.out.println(foo);
//        return foo;


    }

    @GetMapping(value = "/customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Customer getCustomer(@PathVariable String id) {

//        return paymentsProxyOpenFeign.getCustomers();             // Cu OpenFeign
//        return paymentProxyWebClient.consumeAPI(); //Cu WebClient
//        return paymentProxyRestTemplate.getCustomers();  //Cu RestTemplate
//        return  paymentProxyRestTemplateCustomer.getCustomers(id);

//        Customer customer = rest.getForObject("https://api.predic8.de:443/shop/categories/" + "id" , Customer.class);
//        System.out.println(customer);
//        return customer;


//        String uri = "https://api.predic8.de:443/shop" + "/customers/" + id;
//
//        ResponseEntity<Customer> response =
//                rest.exchange(uri,
//                        HttpMethod.GET,
//                        new HttpEntity<>(Customer.class),
//                        Customer.class);
//        return response.getBody();

//        return paymentProxyRestTemplateCustomer.getCustomer(id);
        return paymentsProxyOpenFeign.getCustomers(id);
    }
}


