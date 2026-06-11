package com.automation.utils;

import com.automation.config.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtil – captures screenshots on test failure.
 */
public final class ScreenshotUtil {

    private ScreenshotUtil() { }

    /**
     * Saves a PNG under screenshots/<testName>_<timestamp>.png
     * and returns the absolute path (used to embed in the Extent report).
     */
    public static String capture(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName  = testName + "_" + timestamp + ".png";
        String dir       = ConfigReader.screenshotDir();
        String fullPath  = dir + fileName;

        try {
            File src  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(fullPath);
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.err.println("[ScreenshotUtil] Could not save screenshot: " + e.getMessage());
        }
        return new File(fullPath).getAbsolutePath();
    }

    /** Returns a Base64-encoded PNG string (for embedding in ExtentReports). */
    public static String captureBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}