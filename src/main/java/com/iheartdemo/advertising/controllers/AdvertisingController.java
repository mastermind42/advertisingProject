package com.iheartdemo.advertising.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertisingController {

    @GetMapping("/")
    String home() {
        return "Hello World!";
    }
}
