package com.iheartdemo.advertising;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.repository.AdvertiserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvertisingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertisingApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(AdvertiserRepository advertiserRepository) {
//        return args -> {
//            advertiserRepository.save(new Advertiser("Advertiser 1", "Primary Contact 1", 100));
//            advertiserRepository.save(new Advertiser("Advertiser 2", "Primary Contact 2", 50000));
//            advertiserRepository.save(new Advertiser("Advertiser 3", "Primary Contact 3", 999));
//        };
//    }

}
