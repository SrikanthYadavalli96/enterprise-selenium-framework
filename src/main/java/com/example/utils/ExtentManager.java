package com.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
     private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/TestReport.html");

            spark.config().setReportName(
                    "Automation Execution Report");     

            spark.config().setDocumentTitle(
                    "Selenium Framework Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Srikanth");

            extent.setSystemInfo("Environment", "QA");

            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}
