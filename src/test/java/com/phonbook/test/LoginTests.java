package com.phonbook.test;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends Testbase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTest() {
        logger.info("Login with data --> " +UserData.EMAIL+"===" + UserData.PASSWORD);
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //click on LOGIN Button
        app. getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setPassword(UserData.PASSWORD));
        //click on LOGIN Button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
