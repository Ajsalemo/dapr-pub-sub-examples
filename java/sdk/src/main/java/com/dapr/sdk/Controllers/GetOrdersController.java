package com.dapr.sdk.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import reactor.core.publisher.Mono;

// The Dapr SDK for Java allows us to subscribe to a topic and receive messages from it in the same controller
@RestController
public class GetOrdersController {
    @Topic(name = "orders", pubsubName = "pubsub")
    @PostMapping("/orders")
    public String getOrders(@RequestBody(required = false) CloudEvent<String> cloudEvent)
            throws JsonProcessingException {
        String msg = "dapr-pub-sub-examples-java-sdk";

        Mono.fromRunnable(() -> {
            try {
                System.out.println(cloudEvent.getData());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return msg;
    }
}
