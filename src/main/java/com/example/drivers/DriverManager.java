package com.example.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    // ThreadLocal for parallel execution
    private static final ThreadLocal<WebDriver> driverThreadLocal =
            new ThreadLocal<>();

    // Set driver
    public static void setDriver(WebDriver driver) {

        driverThreadLocal.set(driver);
    }

    // Get driver
    public static WebDriver getDriver() {

        return driverThreadLocal.get();
    }

    // Quit driver
    public static void quitDriver() {

        if (driverThreadLocal.get() != null) {

            driverThreadLocal.get().quit();

            driverThreadLocal.remove();
        }
    }
}