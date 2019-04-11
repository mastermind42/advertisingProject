package com.iheartdemo.advertising;

import com.iheartdemo.advertising.models.Advertiser;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Advertiser.class)
@MapperScan("com.iheartdemo.advertising.mapper")
@SpringBootApplication
public class AdvertisingApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisingApplication.class, args);
    }
}
