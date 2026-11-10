package com.boricuavocab.api.v1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoricuaGreetingController {
    private static final String GREETING = "¡Hola, Boricua!";

    @GetMapping("/api/v1/hello")
    public String greet() {
        return GREETING;
    }
}