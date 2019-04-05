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

    @Bean
    CommandLineRunner runner(AdvertiserRepository advertiserRepository) {
        return args -> {
            advertiserRepository.save(Advertiser.builder().advertiserName("Advertiser 1").primaryContactName("Priamry Contact 1").maxLimit(100).build());
            advertiserRepository.save(Advertiser.builder().advertiserName("Advertiser 2").primaryContactName("Priamry Contact 2").maxLimit(50000).build());
            advertiserRepository.save(Advertiser.builder().advertiserName("Advertiser 3").primaryContactName("Priamry Contact 3").maxLimit(999).build());
        };
    }

}
