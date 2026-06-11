package com.automation.tests;

import com.automation.config.ConfigReader;
import com.automation.pages.HomePage;
import com.automation.utils.DriverFactory;
import com.automation.utils.ExtentReportListener;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest – parent for every test class.
 *
 * Responsibilities:
 *   • Opens a browser before the first test in the class (@BeforeClass)
 *   • Navigates to the home page
 *   • Creates the HomePage POM instance
 *   • Closes the browser after all tests in the class (@AfterClass)
 *   • Exposes a log() helper so tests can write to the Extent report
 */
public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage  homePage;

    /** Shortcut so tests can call log().info("…") / log().pass("…") */
    protected ExtentTest log() {
        return ExtentReportListener.getTest();
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        DriverFactory.init();
        driver   = DriverFactory.get();
        driver.get(ConfigReader.baseUrl());
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quit();
    }

    /** Re-navigates to the base URL and recreates the POM (use between destructive tests). */
    protected void resetPage() {
        driver.get(ConfigReader.baseUrl());
        homePage = new HomePage(driver);
    }
}