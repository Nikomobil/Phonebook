package com.phonbook.test;


import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends Testbase {
    @BeforeMethod
            public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
//        int i=(int)((System.currentTimeMillis()/1000)%3600);
//        type(By.name("email"), "test"+i+"@test.com");
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("bony_s@ukr.net").setPassword("12123Sdf!"));
        app.getUser().clickOnRegistration();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("bony_s@ukr.net").setPassword("12123Sdf!"));
        app.getUser().clickOnRegistration();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }


}
