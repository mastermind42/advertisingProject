package com.iheartdemo.advertising;

import com.iheartdemo.advertising.controllers.AdvertisingControllerTest;
import com.iheartdemo.advertising.services.AdvertiserServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdvertisingControllerTest.class,
        AdvertiserServiceTest.class
})
public class AdvertisingApplicationTests {

}
