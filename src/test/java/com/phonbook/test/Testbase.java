package com.phonbook.test;

import com.phonebook.fw.ApplcationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class Testbase {

    Logger logger = LoggerFactory.getLogger(Testbase.class);

    protected static ApplcationManager app = new ApplcationManager(System
            .getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //@AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }
    @BeforeMethod
    public void startTest(){
        logger.info("Start test");
    }
    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }

}
