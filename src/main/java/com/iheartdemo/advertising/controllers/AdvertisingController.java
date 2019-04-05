package com.iheartdemo.advertising.controllers;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.service.AdvertisingService;
import com.iheartdemo.advertising.serviceImpl.AdvertisingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/advertiser")
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

    @GetMapping("/getAdvertiserByName")
    ArrayList<Advertiser> getAdveriserByName(@RequestParam("name") String name) {
        return advertisingService.getAdvertiser(name);
    }

    @PutMapping("/updateAdvertiser")
    Advertiser updateAdvertiser(@RequestBody Advertiser advertiser) {
        return advertisingService.saveOrUpdateAdvertiser(advertiser);
    }

    @PostMapping("/saveAdvertiser")
    Advertiser saveAdvertiser(@RequestParam("advertiserName") String advertiserName,
                              @RequestParam("primaryContactName") String primaryContactName,
                              @RequestParam("maxLimit") Integer maxLimit) {
//        return advertisingService.saveOrUpdateAdvertiser(new Advertiser(advertiserName, primaryContactName, maxLimit))
        return advertisingService.saveOrUpdateAdvertiser(Advertiser.builder()
                .advertiserName(advertiserName)
                .primaryContactName(primaryContactName)
                .maxLimit(maxLimit)
                .build());
    }

    @DeleteMapping("/deleteAdvertiser")
    public ArrayList<Advertiser> deleteAdvertiser(@RequestBody Advertiser advertiser) {
        return advertisingService.deleteAdvertiser(advertiser);
    }

    @PostMapping("/verifyTransactionAbility")
    public Boolean verifyTransactionAbility(@RequestParam("advertiserId") Long advertiserId,
                                            @RequestParam("transactionCost") Integer cost) {
        return advertisingService.verifyTransactionAbility(advertiserId, cost);
    }


}
