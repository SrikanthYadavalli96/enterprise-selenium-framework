package com.example.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class WebAPIs {
    public static void clickElement(WebElement element) {
        try {
            WaitUtils.waitToBeClicked(element).click();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException("Failed to click element: " + e.getMessage());
            
        }
    }

    public static  void typeInTextBox(WebElement element, String text) {
        try {
            WaitUtils.waitForElementToBeVisible(element).sendKeys(text);
        } catch (Exception e) {
             System.out.println(e.getStackTrace());
            throw new RuntimeException("Failed to type in textbox: " + e.getMessage());
        }
    }

    public static String getElementText(WebElement element) {
        try {
            return WaitUtils.waitForElementToBeVisible(element).getText();
        } catch (Exception e) {
             System.out.println(e.getStackTrace());
            throw new RuntimeException("Failed to get element text: " + e.getMessage());
        }
    }   
}
