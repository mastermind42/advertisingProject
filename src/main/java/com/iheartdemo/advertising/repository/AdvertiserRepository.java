package com.iheartdemo.advertising.repository;

import com.iheartdemo.advertising.models.Advertiser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AdvertiserRepository {
    @Select("SELECT * FROM Advertiser")
    ArrayList<Advertiser> findAll();
}
