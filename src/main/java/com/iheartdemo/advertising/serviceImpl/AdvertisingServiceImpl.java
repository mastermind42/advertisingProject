package com.iheartdemo.advertising.serviceImpl;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.repository.AdvertiserRepository;
import com.iheartdemo.advertising.service.AdvertisingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {
    private final AdvertiserRepository advertiserRepository;

    public AdvertisingServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public ArrayList<Advertiser> getAllAdvertisers() {
        return advertiserRepository.findAll();
    }

    @Override
    public  ArrayList<Advertiser> getAdvertiser(String advertiserName) {
        return advertiserRepository.findAllByAdvertiserName(advertiserName);
    }

    @Override
    public Advertiser updateAdvertiser() {
        return null;
    }

    @Override
    public Boolean verifyTransaction(Integer transactionCost) {
        return null;
    }

    @Override
    public ArrayList<Advertiser> deleteAdvertiser() {
        return null;
    }
}
