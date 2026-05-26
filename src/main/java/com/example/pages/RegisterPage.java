package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utils.WebAPIs;

public class RegisterPage {

    private WebDriver driver;

    @FindBy(xpath = ".//a[text()='Register']")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(id = "customer.address.street")
    private WebElement addressInput;

    @FindBy(id = "customer.address.city")
    private WebElement cityInput;

    @FindBy(id = "customer.address.state")
    private WebElement stateInput;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "customer.ssn")
    private WebElement ssnInput;

    @FindBy(id = "customer.username")
    private WebElement usernameInput;

    @FindBy(id = "customer.password")
    private WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPasswordInput;

    @FindBy(xpath = ".//input[@value='Register']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLink() {
        WebAPIs.clickElement(registerLink);
        // registerLink.click();
    }

    public void enterFirstName(String firstName) {
        WebAPIs.typeInTextBox(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        WebAPIs.typeInTextBox(lastNameInput, lastName);
    }

    public void enterAddress(String address) {
        WebAPIs.typeInTextBox(addressInput, address);
    }

    public void enterCity(String city) {
        WebAPIs.typeInTextBox(cityInput, city);
    }

    public void enterState(String state) {
        WebAPIs.typeInTextBox(stateInput, state);
    }

    public void enterZipCode(String zipCode) {
        WebAPIs.typeInTextBox(zipCodeInput, zipCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebAPIs.typeInTextBox(phoneNumberInput, phoneNumber);
    }

    public void enterSsn(String ssn) {
        WebAPIs.typeInTextBox(ssnInput, ssn);
    }

    public void enterUsername(String username) {
        WebAPIs.typeInTextBox(usernameInput, username);
    }

    public void enterPassword(String password) {
        WebAPIs.typeInTextBox(passwordInput, password);
    }

    public void enterRepeatedPassword(String repeatedPassword) {
        WebAPIs.typeInTextBox(repeatedPasswordInput, repeatedPassword);
    }

    public void clickRegisterButton() {
        WebAPIs.clickElement(registerButton);
    }

}
