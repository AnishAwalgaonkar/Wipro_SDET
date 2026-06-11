package listeners;

import org.testng.*;
import com.aventstack.extentreports.*;

import utilities.ExtentManager;

public class TestListener implements ITestListener {

    public static ExtentReports extent =
            ExtentManager.getInstance();

    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}