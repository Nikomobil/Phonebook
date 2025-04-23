package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistration() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementpresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {
        return isElementpresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean isLoginLinkPresent() {
        return isElementpresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
