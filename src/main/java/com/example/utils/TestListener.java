package com.example.utils;

import com.aventstack.extentreports.Status;
import com.example.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.example.utils.ExtentManager;
import com.example.utils.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                result.getName() + " FAILED");

        System.out.println(
                result.getThrowable());

        BaseTest base = (BaseTest) result.getInstance();

        String path = ScreenshotUtil.captureScreenshot(
                base.getDriver(), result.getName());
        base.getTest().log(Status.FAIL, result.getThrowable());

        try {
            base.getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        BaseTest base = (BaseTest) result.getInstance();
        base.getTest().log(Status.PASS, "Test Passed");
    }
}
