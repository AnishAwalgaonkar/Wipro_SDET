package listeners;

import com.aventstack.extentreports.*;

import factory.DriverFactory;

import org.testng.*;

import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener
        implements ITestListener {

    ExtentReports extent=
            ExtentManager.getExtent();

    ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result)
    {
        test=
                extent.createTest(
                        result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result)
    {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result)
    {
        String path=
                ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getName());

        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(
            ITestContext context)
    {
        extent.flush();
    }
}