package com.phonbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends Testbase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getHome().isHomeComponentPresent()){
            app.getHome().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
//        driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //driver.findElement(By.xpath("//div[2]/div/div/h1"));
        //System.out.println("Home Component " + isHomeComponentPresent());
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

}
