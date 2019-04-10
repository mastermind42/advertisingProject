package com.iheartdemo.advertising.mappers;

import com.iheartdemo.advertising.models.Advertiser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AdvertiserMapper {

    @Select("select * from advertiser")
    ArrayList<Advertiser> getAllAdvertisers();

    @Select("select * from advertiser where ADVERTISER_NAME=#{advertiserName}")
    ArrayList<Advertiser> getAdvertiserByName(@Param("advertiserName") String advertiserName);
}
