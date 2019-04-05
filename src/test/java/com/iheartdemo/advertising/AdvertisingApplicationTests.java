package com.iheartdemo.advertising;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.repository.AdvertiserRepository;
import com.iheartdemo.advertising.service.AdvertisingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertisingApplicationTests {

    @Autowired
    private AdvertisingService service;

    @MockBean
    private AdvertiserRepository repository;

    @Test
    public void setUp() {
        Advertiser person = Advertiser.builder().advertiserName("Advertiser 1").primaryContactName("Joe Smith").maxLimit(100).build();
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<Advertiser>(Arrays.asList(person)));

        Assert.assertEquals(1, service.getAllAdvertisers().size());
    }


    @Test
    public void contextLoads() {
    }

}
