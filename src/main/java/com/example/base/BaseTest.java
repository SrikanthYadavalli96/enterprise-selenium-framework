package com.example.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.example.utils.ExtentManager;
import com.example.utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.example.drivers.DriverManager;
import com.example.factory.Browserfactory;
import com.example.utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    Properties prop;

    @BeforeSuite
    public void setupReport() {

        extent = ExtentManager.getInstance();

    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @BeforeTest
    public void setup() {
        prop = ConfigReader.initProperties();
        String browserName = prop.getProperty("browser");
        DriverManager.setDriver( Browserfactory.getDriver(browserName));
        driver = DriverManager.getDriver();
        driver.get(prop.getProperty("url"));
    }
 
    @AfterMethod
    public void tearDown(ITestResult result)
            throws IOException {

        System.out.println("AfterMethod executed for: " + result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {

            String path
                    = ScreenshotUtil.captureScreenshot(
                            driver,
                            result.getName());

            test.fail(result.getThrowable());

            test.addScreenCaptureFromPath(path);
        }

       
    }

    @AfterTest
    public void closeBrowser() {

        if (driver != null) {
             DriverManager.quitDriver();
        }
    }

    @AfterSuite
    public void flushReport() {

        extent.flush();
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return this.driver;
    }

    public com.aventstack.extentreports.ExtentTest getTest() {
        return this.test;
    }
}
