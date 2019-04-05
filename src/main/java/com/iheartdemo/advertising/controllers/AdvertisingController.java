package com.iheartdemo.advertising.controllers;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.service.AdvertisingService;
import com.iheartdemo.advertising.serviceImpl.AdvertisingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdvertisingController {

    private final AdvertisingService advertisingService;

    @Autowired
    public AdvertisingController(AdvertisingService advertisingService) {
        this.advertisingService = advertisingService;
    }

    //todo delete this endpoint
    @GetMapping("/test")
    String test() {
        return "Hello World!";
    }

    @GetMapping("/getAllAdvertisers")
    ArrayList<Advertiser> getAllAdvertisers() {
        return advertisingService.getAllAdvertisers();
    }
}
