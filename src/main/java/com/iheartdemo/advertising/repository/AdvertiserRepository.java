package com.iheartdemo.advertising.repository;

import com.iheartdemo.advertising.models.Advertiser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AdvertiserRepository extends CrudRepository<Advertiser, Long> {
    ArrayList<Advertiser> findAll();
    ArrayList<Advertiser> findAllByAdvertiserName(String advertiserName);

}
