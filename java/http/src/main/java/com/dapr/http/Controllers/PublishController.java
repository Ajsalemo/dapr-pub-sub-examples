package com.dapr.http.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import reactor.core.publisher.Mono;

@RestController
public class PublishController {
    @GetMapping("/api/pub")
    public ResponseEntity<String> publish() {
        UUID uuid = UUID.randomUUID();
        Map<String, String> orders = new HashMap<>();
        orders.put("orderId", uuid.toString());

        List<Map<String, String>> data = new ArrayList<>();
        data.add(orders);

        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:3500")
                .build();

        UriSpec<RequestBodySpec> uriSpec = client.post();
        RequestBodySpec bodySpec = uriSpec.uri("/v1.0/publish/pubsub/orders");
        RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(data);

        Mono<String> response = headersSpec.retrieve()
                .bodyToMono(String.class);
        System.out.println(response.block());

        return new ResponseEntity<String>("Order published with order id: " + uuid.toString(), HttpStatus.OK);
    }
}
