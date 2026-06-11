package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * ExtentReportListener – plugged into testng.xml as a listener.
 * Automatically logs PASS / FAIL / SKIP and embeds screenshots on failure.
 */
public class ExtentReportListener implements ITestListener {

    private static final ExtentReports          EXTENT = ReportManager.getInstance();
    private static final ThreadLocal<ExtentTest> TEST   = new ThreadLocal<>();

    /** Expose to BaseTest so individual steps can log info/pass messages. */
    public static ExtentTest getTest() { return TEST.get(); }

    @Override
    public void onTestStart(ITestResult r) {
        ExtentTest test = EXTENT.createTest(
                r.getTestClass().getName() + " :: " + r.getMethod().getMethodName(),
                r.getMethod().getDescription());
        TEST.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult r) {
        TEST.get().log(Status.PASS, "Test PASSED ✔");
    }

    @Override
    public void onTestFailure(ITestResult r) {
        TEST.get().log(Status.FAIL, "Test FAILED ✘ – " + r.getThrowable().getMessage());
        try {
            String b64 = ScreenshotUtil.captureBase64(DriverFactory.get());
            TEST.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(b64).build());
        } catch (Exception ignored) { }
    }

    @Override
    public void onTestSkipped(ITestResult r) {
        TEST.get().log(Status.SKIP, "Test SKIPPED – " + r.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext ctx) {
        EXTENT.flush();
    }
}