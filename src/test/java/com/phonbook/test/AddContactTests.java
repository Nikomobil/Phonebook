package com.phonbook.test;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends Testbase {

   @BeforeMethod
   public void precondition(){
       if (!app.getUser().isLoginLinkPresent()) {
           app.getUser().clickOnSignOutButton();
       }

       app.getUser().clickOnLoginLink();
       app.getUser().fillRegisterLoginForm(new User().setEmail("bony_s@ukr.net").setPassword("12123Sdf!"));
       app.getUser().clickOnLoginButton();
   }
   @Test
    public void addContactPositiveTest() {
       //click on Add link
       app.getContact().clickOnAddLink();
       //       type(By.cssSelector("input[placeholder='Name']"), "Bony");
       app.getContact().fillContactForm(new Contact()
               .setName("Bony")
               .setLastName( "Klaida")
               .setPhone( "0123456789")
               .setEmail( "bony_s@ukr.net")
               .setAddress("Berlin")
               .setDescription( "QA"));
       //click save button
       app.getContact().clickOnSaveButton();
       //verify contact is added
       Assert.assertTrue(app.getContact().isContactAdded("Bony"));

       //findElement(By.cssSelector("input[placeholder='Name']"));
    }

    @AfterMethod
    public void postCondition(){
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
