package com.example.utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.drivers.DriverManager;

public class WaitUtils {

    private static final int TIMEOUT = 15;

    public static WebElement waitForElementToBeVisible(WebElement element) {

        System.out.println("Waiting for element to be visible: " + element);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitToBeClicked(WebElement element) {
        System.out.println("Waiting for element to be clickable: " + element);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitForElementToBePresent(WebElement element) {
        System.out.println("Waiting for element to be present: " + element);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeSelected(element));
    }
}
