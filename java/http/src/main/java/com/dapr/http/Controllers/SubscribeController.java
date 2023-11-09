package com.dapr.http.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController {
    @GetMapping("/dapr/subscribe")
    public ResponseEntity<List<Map<String, String>>> daprSubscribe() {
        Map<String, String> subscribeObject = new HashMap<>();
        subscribeObject.put("pubsubname", "pubsub");
        subscribeObject.put("topic", "orders");
        subscribeObject.put("route", "orders");

        List<Map<String, String>> topics = new ArrayList<>();
        topics.add(subscribeObject);

        return new ResponseEntity<List<Map<String, String>>>(topics, HttpStatus.OK);
    }
}
