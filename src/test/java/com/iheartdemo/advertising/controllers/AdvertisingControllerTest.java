package com.iheartdemo.advertising.controllers;

import com.iheartdemo.advertising.models.Advertiser;
import com.iheartdemo.advertising.services.AdvertiserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@SpringBootTest
public class AdvertisingControllerTest {

    @Spy
    @InjectMocks
    AdvertisingController controller;

    @Mock
    AdvertiserService service;

    @Mock Advertiser advertiserOne;
    @Mock Advertiser advertiserTwo;

    ArrayList<Advertiser> advertisers;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        advertiserOne = Advertiser.builder()
                .advertiserName("Advertiser 1")
                .primaryContactName("priamryContact")
                .maxLimit(100)
                .build();
        advertiserTwo = Advertiser.builder()
                .advertiserName("Advertiser 2")
                .primaryContactName("primaryContact 2")
                .maxLimit(10000)
                .build();
        advertisers = new ArrayList<Advertiser>(Arrays.asList(advertiserOne, advertiserTwo));
    }

    @Test
    public void getAllAdvertisers() {
        Mockito.when(service.getAllAdvertisers()).thenReturn(advertisers);
        ArrayList<Advertiser> allAdvertisers = controller.getAllAdvertisers();
        Assert.assertEquals(advertisers, allAdvertisers);
    }

    @Test
    public void getAdvertiserByName() {
        ArrayList<Advertiser> advertiserOneSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserOne));
        Mockito.when(service.getAdvertiserByName("Advertiser 1")).thenReturn(advertiserOneSearchResults);
        ArrayList<Advertiser> advertiserTwoSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserTwo));
        Mockito.when(service.getAdvertiserByName("Advertiser 2")).thenReturn(advertiserTwoSearchResults);

        ArrayList<Advertiser> onlyAdvertiserOne = controller.getAdvertiserByName("Advertiser 1");
        Assert.assertEquals(onlyAdvertiserOne, advertiserOneSearchResults);
        Assert.assertNotEquals(onlyAdvertiserOne, advertiserTwoSearchResults);
    }

    @Test
    public void updateAdvertiser() {
        ArrayList<Advertiser> advertiserOneSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserOne));
        Mockito.when(service.updateAdvertiser(Mockito.any())).thenReturn(advertiserOneSearchResults);

        ArrayList<Advertiser> updateAdvertiser = controller.updateAdvertiser(advertiserOne);
        Assert.assertEquals(advertiserOneSearchResults, updateAdvertiser);
    }

    @Test
    public void saveAdvertiser() {
        ArrayList<Advertiser> advertiserOneSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserOne));
        Mockito.when(service.saveAdvertiser(Mockito.any(Advertiser.class))).thenReturn(advertiserOneSearchResults);

        ArrayList<Advertiser> saveAdvertiser = controller.saveAdvertiser("Advertiser 1", "priamryContact", 100);
        Assert.assertEquals(advertiserOneSearchResults, saveAdvertiser);
    }

    @Test
    public void deleteAdvertiser() {
        ArrayList<Advertiser> advertiserOneSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserOne));
        ArrayList<Advertiser> advertiserTwoSearchResults = new ArrayList<Advertiser>(Arrays.asList(advertiserTwo));
        Mockito.when(service.deleteAdvertiser(advertiserOne)).thenReturn(advertiserTwoSearchResults);

        ArrayList<Advertiser> deleteAdvertiser = controller.deleteAdvertiser(advertiserOne);
        Assert.assertEquals(deleteAdvertiser, advertiserTwoSearchResults);
        Assert.assertNotEquals(deleteAdvertiser, advertiserOneSearchResults);
    }

    @Test
    public void verifyTransactionAbility() {
        Mockito.when(service.verifyTransactionAbility((long) 0, 0)).thenReturn(true);
        Mockito.when(service.verifyTransactionAbility((long) 1, 100)).thenReturn(false);

        Assert.assertEquals(controller.verifyTransactionAbility((long) 0, 0), true);
        Assert.assertEquals(controller.verifyTransactionAbility((long) 1, 100), false);
    }
}