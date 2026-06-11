package com.automation.utils;

import com.automation.config.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ReportManager – creates and exposes the single ExtentReports instance.
 */
public final class ReportManager {

    private static ExtentReports extent;

    private ReportManager() { }

    public static ExtentReports getInstance() {
        if (extent == null) {
            String ts   = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = ConfigReader.reportDir() + "AutomationReport_" + ts + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("testautomationpractice.blogspot.com – Full Suite");
            spark.config().setEncoding("UTF-8");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("App",      "testautomationpractice.blogspot.com");
            extent.setSystemInfo("Browser",  ConfigReader.browser());
            extent.setSystemInfo("Env",      "QA");
            extent.setSystemInfo("Tester",   "Automation Engineer");
        }
        return extent;
    }
}