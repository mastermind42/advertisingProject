package com.iheartdemo.advertising.mappers;

import com.iheartdemo.advertising.models.Advertiser;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface AdvertiserMapper {

    @Select("select * from advertiser")
    ArrayList<Advertiser> getAllAdvertisers();

    @Select("select * from advertiser where ADVERTISER_NAME=#{advertiserName}")
    ArrayList<Advertiser> getAdvertiserByName(@Param("advertiserName") String advertiserName);

    @Update("UPDATE advertiser SET ADVERTISER_NAME=#{advertiserName}, PRIMARY_CONTACT_NAME=#{primaryContactName}, MAX_LIMIT=#{maxLimit} where id=#{id}")
    void updateAdvertiser(Advertiser advertiser);

    @Insert("INSERT into ADVERTISER(ADVERTISER_NAME,PRIMARY_CONTACT_NAME,MAX_LIMIT) VALUES(#{advertiserName},#{primaryContactName},#{maxLimit})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void saveAdvertiser(Advertiser advertiser);

    @Delete("DELETE FROM advertiser where id=#{id}")
    void deleteAdvertiser(Advertiser advertiser);

    @Select("SELECT MAX_LIMIT from advertiser where id=#{advertiserId} ")
    Long verifyTransactionAbility(Long advertiserId);
}
