package com.dapr.sdk.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
        String msg = "dapr-pub-sub-examples-java-http";

        @GetMapping("/")
        public String home() {
            return msg;
        }
}
