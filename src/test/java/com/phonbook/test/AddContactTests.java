package com.phonbook.test;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends Testbase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.Name)
                .setLastName(ContactData.LastName)
                .setPhone(ContactData.Phone)
                .setEmail(ContactData.Email)
                .setAddress(ContactData.Address)
                .setDescription(ContactData.Description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));

    }

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Bony","Klaid","0434656756","bony_s@mail.net","Hamburg","QA"});
        list.add(new Object[]{"Bony","Klaid","0434656745","bon_s@mail.net","Hamburg","QA"});
        list.add(new Object[]{"Bony","Klaid","043465674537","byny_s@mail.net","Hamburg","QA"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addContactPositiveFromDataProviderTest(String name, String lastName,
                                                       String phone, String email,
                                                       String address,
                                                       String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();

    }

    //click on Add link
    // enter name
    //enter LastName
    //enter Phone
    //enter email
    //enter address
    //enter description
    //click save button

    // verify contact is added
}
