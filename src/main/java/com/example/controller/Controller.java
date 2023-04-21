package com.example.controller;

import com.example.DTO.Customer;
import com.example.DTO.Foo;
import com.example.GetCustomers.OpenFeignCustomers;
import com.example.GetCustomers.RestTemplateCustomers;
import com.example.GetCustomers.WebClientCustomers;
import com.example.PostCustomer.OpenFeignPostCustomer;
import com.example.PostCustomer.RestTemplatePostCustomer;
import com.example.PostCustomer.WebClientPostCustomer;
import com.example.getCustomer.PaymentProxyRestTemplate;
import com.example.getCustomer.RestTemplateCustomer;
import com.example.getCustomer.WebClientConsumer;
import com.example.getCustomer.OpenFeignCustomer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;


@RestController
public class Controller {
    private final WebClientPostCustomer webClientPostCustomer;
    private final RestTemplatePostCustomer restTemplatePostCustomer;
    private final OpenFeignPostCustomer openFeignPostCustomer;
    private final OpenFeignCustomers openFeignCustomers;

    private final RestTemplateCustomers restTemplateCustomers;

    private final WebClientCustomers webClientCustomers;
    RestTemplate rest;
    private final WebClientConsumer webClientConsumer;

    private final PaymentProxyRestTemplate paymentProxyRestTemplate;

    private final RestTemplateCustomer restTemplateCustomer;
    private final OpenFeignCustomer openFeignCustomer;



    private static Logger logger =
            Logger.getLogger(Controller.class.getName());

    public Controller(WebClientPostCustomer webClientPostCustomer, RestTemplatePostCustomer restTemplatePostCustomer, OpenFeignPostCustomer openFeignPostCustomer, OpenFeignCustomers openFeignCustomers, WebClientConsumer webClientConsumer, PaymentProxyRestTemplate paymentProxyRestTemplate, RestTemplate rest, RestTemplateCustomer restTemplateCustomer, OpenFeignCustomer openFeignCustomer, RestTemplateCustomers restTemplateCustomers, WebClientCustomers webClientCustomers) {
        this.webClientPostCustomer = webClientPostCustomer;
        this.restTemplatePostCustomer = restTemplatePostCustomer;
        this.openFeignPostCustomer = openFeignPostCustomer;
        this.openFeignCustomers = openFeignCustomers;
        this.webClientConsumer = webClientConsumer;
        this.paymentProxyRestTemplate = paymentProxyRestTemplate;
        this.rest = rest;
        this.restTemplateCustomer = restTemplateCustomer;
        this.openFeignCustomer = openFeignCustomer;
        this.restTemplateCustomers = restTemplateCustomers;
        this.webClientCustomers = webClientCustomers;
    }

    @GetMapping(value = "/customers/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Foo getCustomers(
    ) {

        return openFeignCustomers.getCustomers();             // Cu OpenFeign
//        return webClientCustomers.getCustomers(); //Cu WebClient
//        return restTemplateCustomers.getCustomers();  //Cu RestTemplate

//        Foo foo = rest.getForObject("https://api.predic8.de:443/shop/categories/", Foo.class);
//        System.out.println(foo);
//        return foo;


    }

    @GetMapping(value = "/customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Customer getCustomer(@PathVariable int id) {
// V1
//        Customer customer = rest.getForObject("https://api.predic8.de:443/shop/customers/" + id , Customer.class);
//        System.out.println(customer);
//        return customer;



        //V2
        return webClientConsumer.consumeAPI(id);
//        return restTemplateCustomer.getCustomer(id);
//        return openFeignCustomer.getCustomers(id);
    }

    @PostMapping(value ="/customers/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Customer postCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customer.setCustomerUrl("oricareUrl");

//        return openFeignPostCustomer.postCustomer(customer);
//        return restTemplatePostCustomer.postCustomer(customer);
//        return webClientPostCustomer.getCustomers(customer);


        return rest.postForObject("https://api.predic8.de:443/shop/customers/", customer, Customer.class);
    }
}


