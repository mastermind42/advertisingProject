package com.iheartdemo.advertising.service;

import com.iheartdemo.advertising.models.Advertiser;

import java.util.ArrayList;

public interface AdvertisingService {
    ArrayList<Advertiser> getAllAdvertisers();
    ArrayList<Advertiser> getAdvertiser(String advertiserName);
    ArrayList<Advertiser> saveOrUpdateAdvertiser(Advertiser advertiser);
    Boolean verifyTransactionAbility(Long advertiserId, Integer transactionCost);
    ArrayList<Advertiser> deleteAdvertiser(Advertiser advertiser);
}
