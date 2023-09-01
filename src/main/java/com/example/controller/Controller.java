//package com.example.controller;
//
//import com.example.dto.ProductDTO;
//import com.example.dto.ProductsDTO;
//import com.example.restClient.OpenFeignGetProducts;
//import com.example.restClient.RestTemplateCustomers;
//import com.example.restClient.WebClientCustomers;
//import com.example.postProduct.OpenFeignPostProduct;
//import com.example.postProduct.RestTemplatePostCustomer;
//import com.example.postProduct.WebClientPostCustomer;
//import com.example.getProduct.PaymentProxyRestTemplate;
//import com.example.getProduct.RestTemplateCustomer;
//import com.example.getProduct.WebClientConsumer;
//import com.example.getProduct.OpenFeignGetProduct;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.logging.Logger;
//
//
//
//@RestController
//public class Controller {
//    private final WebClientPostCustomer webClientPostCustomer;
//    private final RestTemplatePostCustomer restTemplatePostCustomer;
//    private final OpenFeignPostProduct openFeignPostProduct;
//    private final OpenFeignGetProducts openFeignGetProducts;
//    private final RestTemplateCustomers restTemplateCustomers;
//    private final WebClientCustomers webClientCustomers;
//    RestTemplate rest;
//    private final WebClientConsumer webClientConsumer;
//    private final PaymentProxyRestTemplate paymentProxyRestTemplate;
//    private final RestTemplateCustomer restTemplateCustomer;
//    private final OpenFeignGetProduct openFeignGetProduct;
//
//    private static Logger logger =
//            Logger.getLogger(Controller.class.getName());
//
//    public Controller(WebClientPostCustomer webClientPostCustomer, RestTemplatePostCustomer restTemplatePostCustomer, OpenFeignPostProduct openFeignPostProduct, OpenFeignGetProducts openFeignGetProducts, WebClientConsumer webClientConsumer, PaymentProxyRestTemplate paymentProxyRestTemplate, RestTemplate rest, RestTemplateCustomer restTemplateCustomer, OpenFeignGetProduct openFeignGetProduct, RestTemplateCustomers restTemplateCustomers, WebClientCustomers webClientCustomers) {
//        this.webClientPostCustomer = webClientPostCustomer;
//        this.restTemplatePostCustomer = restTemplatePostCustomer;
//        this.openFeignPostProduct = openFeignPostProduct;
//        this.openFeignGetProducts = openFeignGetProducts;
//        this.webClientConsumer = webClientConsumer;
//        this.paymentProxyRestTemplate = paymentProxyRestTemplate;
//        this.rest = rest;
//        this.restTemplateCustomer = restTemplateCustomer;
//        this.openFeignGetProduct = openFeignGetProduct;
//        this.restTemplateCustomers = restTemplateCustomers;
//        this.webClientCustomers = webClientCustomers;
//    }
//
//    @GetMapping(value = "/customers/", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ProductsDTO getCustomers() {
//
//        return openFeignGetProducts.getCustomers();             // Cu OpenFeign
////        return webClientCustomers.getCustomers(); //Cu WebClient
////        return restTemplateCustomers.getCustomers();  //Cu RestTemplate
//
////        Foo foo = rest.getForObject("https://api.predic8.de:443/shop/categories/", Foo.class);
////        System.out.println(foo);
////        return foo;
//
//
//    }
//
//    @GetMapping(value = "/customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ProductDTO getCustomer(@PathVariable int id) {
//// V1
////        Customer customer = rest.getForObject("https://api.predic8.de:443/shop/customers/" + id , Customer.class);
////        System.out.println(customer);
////        return customer;
//
//
//
//        //V2
//        return webClientConsumer.consumeAPI(id);
////        return restTemplateCustomer.getProduct(id);
////        return openFeignCustomer.getCustomers(id);
//    }
//
//    @PostMapping(value ="/customers/", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ProductDTO postCustomer(@RequestBody ProductDTO productDTO){
//        System.out.println(productDTO);
////        customer.setSelfLink("oricareUrl");
//
////        return openFeignPostCustomer.postCustomer(customer);
////        return restTemplatePostCustomer.postCustomer(customer);
////        return webClientPostCustomer.getCustomers(customer);
//
//
//        return rest.postForObject("https://api.predic8.de/shop/v2/customers", productDTO, ProductDTO.class);
//    }
//}
//
//
