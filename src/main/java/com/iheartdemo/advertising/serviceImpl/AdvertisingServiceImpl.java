package com.iheartdemo.advertising.serviceImpl;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.repository.AdvertiserRepository;
import com.iheartdemo.advertising.service.AdvertisingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@MapperScan("AdvertiserRepository")
public class AdvertisingServiceImpl implements AdvertisingService {

    private final AdvertiserRepository advertiserRepository;

    @Autowired
    public AdvertisingServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public ArrayList<Advertiser> getAllAdvertisers() {
        return advertiserRepository.findAll();
    }

    @Override
    public  ArrayList<Advertiser> getAdvertiser(String advertiserName) {
//        return advertiserRepository.findAllByAdvertiserName(advertiserName);
        return null;
    }

    @Override
    public Advertiser saveOrUpdateAdvertiser(Advertiser advertiser) {
//        return advertiserRepository.save(advertiser);
        return null;
    }

    @Override
    public Boolean verifyTransactionAbility(Long advertiserId, Integer transactionCost) {
//        Optional<Advertiser> advertiser = advertiserRepository.findById(advertiserId);
//        if(advertiser.isEmpty()) return false;
//        else return advertiser.get().getMaxLimit() >= transactionCost;
        return null;
    }

    @Override
    public ArrayList<Advertiser> deleteAdvertiser(Advertiser advertiser) {
//        advertiserRepository.delete(advertiser);
//        return advertiserRepository.findAll();
        return null;
    }
}
