package com.automation.utils;

import com.automation.config.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtil – explicit-wait convenience methods.
 * Each instance is bound to the driver passed at construction.
 */
public class WaitUtil {

    private final WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        this.wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.explicitWait()));
    }

    public WebElement untilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement untilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement untilClickable(WebElement el) {
        return wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public WebElement untilPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Alert untilAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean untilTextPresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** Unconditional pause – use sparingly, only where animation must settle. */
    public static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) { }
    }
}