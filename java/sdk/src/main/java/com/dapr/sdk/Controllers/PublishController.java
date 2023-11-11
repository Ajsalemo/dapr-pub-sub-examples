package com.dapr.sdk.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@RestController
public class PublishController {
    @GetMapping("/api/pub")
    public ResponseEntity<String> publish() {
        UUID uuid = UUID.randomUUID();
        Map<String, String> orders = new HashMap<>();
        orders.put("orderId", uuid.toString());

        List<Map<String, String>> data = new ArrayList<>();
        data.add(orders);

        DaprClient client = new DaprClientBuilder().build();
        client.publishEvent(
                "pubsub",
                "orders",
                orders).block();

        return new ResponseEntity<String>("Order published with order id: " + uuid.toString(), HttpStatus.OK);
    }
}
