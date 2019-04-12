package com.iheartdemo.advertising.controllers;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.services.AdvertiserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Builder
@RestController
@RequestMapping("/api/advertiser")
public class AdvertisingController {

    private AdvertiserService service;

    @Autowired
    public AdvertisingController(AdvertiserService service) {
        this.service = service;
    }

    @GetMapping("/getAllAdvertisers")
    public ArrayList<Advertiser> getAllAdvertisers() {
        return service.getAllAdvertisers();
    }

    @GetMapping("/getAdvertiserByName")
    public ArrayList<Advertiser> getAdvertiserByName(@RequestParam("name") String name) {
        return service.getAdvertiserByName(name);
    }

    @PutMapping("/updateAdvertiser")
    public ArrayList<Advertiser> updateAdvertiser(@RequestBody Advertiser advertiser) {
        return service.updateAdvertiser(advertiser);
    }

    @PostMapping("/saveAdvertiser")
    public ArrayList<Advertiser> saveAdvertiser(@RequestParam("advertiserName") String advertiserName,
                                         @RequestParam("primaryContactName") String primaryContactName,
                                         @RequestParam("maxLimit") Integer maxLimit) {
        return service.saveAdvertiser(Advertiser.builder()
                .advertiserName(advertiserName)
                .primaryContactName(primaryContactName)
                .maxLimit(maxLimit)
                .build());
    }

    @DeleteMapping("/deleteAdvertiser")
    public ArrayList<Advertiser> deleteAdvertiser(@RequestBody Advertiser advertiser) {
        return service.deleteAdvertiser(advertiser);
    }

    @PostMapping("/verifyTransactionAbility")
    public Boolean verifyTransactionAbility(@RequestParam("advertiserId") Long advertiserId,
                                            @RequestParam("transactionCost") Integer cost) {
        return service.verifyTransactionAbility(advertiserId, cost);
    }

}
