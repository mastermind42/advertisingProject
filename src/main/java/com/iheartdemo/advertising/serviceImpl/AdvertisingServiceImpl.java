package com.iheartdemo.advertising.serviceImpl;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.repository.AdvertiserRepository;
import com.iheartdemo.advertising.service.AdvertisingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
    public ArrayList<Advertiser> saveOrUpdateAdvertiser(Advertiser advertiser) {
        advertiserRepository.save(advertiser);
        return advertiserRepository.findAll();
    }

    @Override
    public Boolean verifyTransactionAbility(Long advertiserId, Integer transactionCost) {
        Optional<Advertiser> advertiser = advertiserRepository.findById(advertiserId);
        if(advertiser.isEmpty()) return false;
        else return advertiser.get().getMaxLimit() >= transactionCost;
    }

    @Override
    public ArrayList<Advertiser> deleteAdvertiser(Advertiser advertiser) {
        advertiserRepository.delete(advertiser);
        return advertiserRepository.findAll();
    }
}
