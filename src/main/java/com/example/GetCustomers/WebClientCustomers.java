package com.example.GetCustomers;

import com.example.DTO.Foo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientCustomers {

    public Foo getCustomers() {
        return WebClient.create("https://api.predic8.de:443/shop")
                .get()
                .uri("/customers/")
                .retrieve()
                .bodyToMono(Foo.class)

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



