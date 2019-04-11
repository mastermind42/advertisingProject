package com.iheartdemo.advertising.services;

import com.iheartdemo.advertising.mappers.AdvertiserMapper;
import com.iheartdemo.advertising.models.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdvertiserService {

    private AdvertiserMapper advertiserMapper;

    @Autowired
    public AdvertiserService(AdvertiserMapper advertiserMapper) {
        this.advertiserMapper = advertiserMapper;
    }

    public ArrayList<Advertiser> getAllAdvertisers() {
        return advertiserMapper.getAllAdvertisers();
    }

    public ArrayList<Advertiser> getAdvertiserByName(String name){
        return advertiserMapper.getAdvertiserByName(name);
    }

    public ArrayList<Advertiser> updateAdvertiser(Advertiser advertiser) {
        advertiserMapper.updateAdvertiser(advertiser);
        // Verifies change is made
        return advertiserMapper.getAdvertiserByName(advertiser.getAdvertiserName());
    }

    public ArrayList<Advertiser> saveAdvertiser(Advertiser advertiser) {
        advertiserMapper.saveAdvertiser(advertiser);
        // Verifies change is made
        return advertiserMapper.getAdvertiserByName(advertiser.getAdvertiserName());
    }

    public ArrayList<Advertiser> deleteAdvertiser(Advertiser advertiser){
        advertiserMapper.deleteAdvertiser(advertiser);
        return advertiserMapper.getAllAdvertisers();
    }

    public Boolean verifyTransactionAbility(Long advertiserId, Integer cost){
        return cost <= advertiserMapper.verifyTransactionAbility(advertiserId);
    }


}
