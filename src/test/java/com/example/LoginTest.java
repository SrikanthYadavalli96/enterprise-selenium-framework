package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;    
    @BeforeTest
    public void initPage() {
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        System.out.println("Logging in with valid credentials...");
        loginPage.enterUsername("demo123");
        loginPage.enterPassword("demo@123");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getWelcomeText(), "Welcome John Doe");
        Thread.sleep(10000);
    }
}
