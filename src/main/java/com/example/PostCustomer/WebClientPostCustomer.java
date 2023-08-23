package com.example.PostCustomer;

import com.example.DTO.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientPostCustomer {

    public Customer getCustomers(Customer customer) {
        return WebClient.create("https://api.predic8.de:443/shop")
                .post()
                .uri("/customers/")
                .bodyValue(customer)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();


    }
//    V2, ca sa lucreze trebuie activat Bean-ul WebClient din ProjectConfig
//    private final WebClient webClient;

//    @Value("${name.service.url}")
//    private String url;

//    public PaymentProxyWebClient(WebClient webClient) {
//        this.webClient = webClient;
//    }
//    public Mono<Payment> createPayment(String requestId, Payment payment) {
//        return webClient.post()
//                .uri(url + "/payment")
//                .header("requestId", requestId)
//                .body(Mono.just(payment), Payment.class)
//                .retrieve()
//                .bodyToMono(Payment.class);
//    }
}



