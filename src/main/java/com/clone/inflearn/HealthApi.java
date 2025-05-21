package com.clone.inflearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthApi {
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
