package com.dapr.sdk.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(GetOrdersController.class);

    @Topic(name = "orders", pubsubName = "pubsub")
    @PostMapping("/orders")
    public String getOrders(@RequestBody(required = false) CloudEvent<String> cloudEvent)
            throws JsonProcessingException {
        String msg = "dapr-pub-sub-examples-java-sdk";

        Mono.fromRunnable(() -> {
            try {
                log.info("Subscriber received: " + cloudEvent.getData());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return msg;
    }
}
