package com.phonbook.test;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends Testbase{
    //precondition
    //login
    // add contact
    @BeforeMethod
    public void precondition(){

        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("bony_s@ukr.net").setPassword("12123Sdf!"));
        //click on LOGIN Button
        app.getUser().clickOnLoginButton();
        //add contact
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Bony")
                .setLastName( "Klaida")
                .setPhone( "0123456789")
                .setEmail( "bony_s@ukr.net")
                .setAddress("Berlin")
                .setDescription( "QA"));
        //click save button
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();;
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

    // click on the card
    // click on Remove button
    // verify contact is deleted(by size)
}
