package com.iheartdemo.advertising.services;

import com.iheartdemo.advertising.models.Advertiser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdvertiserServiceTest {

    // Mocks the DB layer and tests the service layer.

    @Autowired
    private AdvertiserService service;

    private Advertiser testPerson;
    private Integer initialDBSize;

    @Before
    public void setUp() throws Exception {
        testPerson = Advertiser.builder().advertiserName("Targaryen").primaryContactName("King's Landing").maxLimit(1000).build();
        initialDBSize = service.getAllAdvertisers().size();
        ArrayList<Advertiser> advertisers = service.saveAdvertiser(testPerson);
        testPerson.setId(advertisers.get(0).getId());
    }

    @Test
    public void getAllAdvertisers() {
        ArrayList<Advertiser> advertisers = service.getAllAdvertisers();
        Advertiser foundAdvertiser = advertisers.stream().filter(advertiser -> testPerson.getId().equals(advertiser.getId())).findAny().orElse(null);

        if (foundAdvertiser == null) Assert.fail("Failed to get test person.");

        Assert.assertEquals(initialDBSize + 1, advertisers.size());

        Assert.assertEquals(foundAdvertiser, testPerson);
    }

    @Test
    public void getAdvertiserByName() {
        ArrayList<Advertiser> advertiserByName = service.getAdvertiserByName(testPerson.getAdvertiserName());

        Assert.assertEquals(testPerson, advertiserByName.get(0));
    }

    @Test
    public void updateAdvertiser() {
        Advertiser updateTestPerson = Advertiser.builder().id(testPerson.getId()).advertiserName("John Snow").primaryContactName("The Wall").maxLimit(1000).build();
        ArrayList<Advertiser> updatedAdvertisers = service.updateAdvertiser(updateTestPerson);

        Advertiser updatedAdvertiser = updatedAdvertisers.stream()
                .filter(advertiser -> testPerson.getId().equals(advertiser.getId()))
                .findAny()
                .orElse(null);

        if (updatedAdvertiser == null) Assert.fail("Failed to get test person.");
        System.out.println(updatedAdvertiser);

        Assert.assertEquals(updatedAdvertiser, updateTestPerson);
    }

    @Test
    public void deleteAdvertiser() {
        ArrayList<Advertiser> advertisers = service.deleteAdvertiser(testPerson);
        advertisers.stream().filter(advertiser -> testPerson.getId()
                .equals(advertiser.getId()))
                .findAny()
                .ifPresent(ignore -> Assert.fail("failed to delete advertiser"));

        Assert.assertEquals(initialDBSize, (Integer) advertisers.size());
    }

    @Test
    public void verifyTransactionAbility() {
    }
}