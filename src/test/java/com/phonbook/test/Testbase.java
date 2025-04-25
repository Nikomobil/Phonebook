package com.phonbook.test;

import com.phonebook.fw.ApplcationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

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
    public void startTest(Method method, Object[] p){
        logger.info("Start test" + method.getName() + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED:" + result.getMethod().getMethodName() + "Screenshot path:"
            + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("===============================");
    }

}
