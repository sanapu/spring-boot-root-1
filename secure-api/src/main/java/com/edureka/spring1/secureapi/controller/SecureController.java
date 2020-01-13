package com.edureka.spring1.secureapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping
  //  @RequestMapping("/test")
    public String secureHello() {
        return "secured API";
    }
}
