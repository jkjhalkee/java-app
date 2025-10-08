package com.jhalkee.controller;

import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        Map<String, String> resp = new HashMap<>();
        resp.put("message", "Hello World");
        return resp;
    }
}
