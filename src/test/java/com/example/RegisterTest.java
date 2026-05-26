package com.example;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;
     @BeforeTest
    public void initPage() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void enterNewUserDetails() {

        System.out.println("Registering a new user...");
        registerPage.clickRegisterLink();
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterAddress("123 Main St");
        registerPage.enterCity("Anytown");
        registerPage.enterState("Anystate");
        registerPage.enterZipCode("12345");
        registerPage.enterPhoneNumber("555-1234");
        registerPage.enterSsn("123-45-6789");
                
    }

    @Test
    public void registerNewUser(){
        registerPage.enterUsername("demoQA123");
        registerPage.enterPassword("demo@123");
        registerPage.enterRepeatedPassword("demo@123");
        registerPage.clickRegisterButton();
    }
}
