package com.VedsAPI.VedsAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health-check")
    public String healthController(){
        return "OK";
    }
}
