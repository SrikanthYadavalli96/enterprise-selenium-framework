package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utils.WebAPIs;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement userNameInput;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = ".//p[@class='smallText']")
    private WebElement welcomeText;    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebElements
        PageFactory.initElements(driver, this);  // Uncomment if using PageFactory   

    }

    public void enterUsername(String username) {
        WebAPIs.typeInTextBox(userNameInput, username);
    }

    public void enterPassword(String password) {
        WebAPIs.typeInTextBox(passwordInput, password);
    }

    public void clickLogin() {
        WebAPIs.clickElement(loginButton);
    }

    public String getWelcomeText() {
        return WebAPIs.getElementText(welcomeText);
    }
}
