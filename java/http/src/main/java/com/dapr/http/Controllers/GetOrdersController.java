package com.dapr.http.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GetOrdersController {
    @PostMapping("/orders")
    public String getOrders(@RequestBody String body) throws JsonProcessingException {
        String msg = "dapr-pub-sub-examples-java-http";
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(body));
        return msg;
    }
}
