package com.automation.tests;

import com.automation.utils.WaitUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * TC07 – Alerts & Popups
 * Covers: Simple Alert · Confirmation Alert (accept + dismiss) ·
 *         Prompt Alert · New Tab · Popup Window
 */
public class TC07_AlertsTest extends BaseTest {

    @Test(priority = 1, description = "Handle Simple Alert – accept it")
    public void testSimpleAlert() {
        homePage.clickSimpleAlert();
        String text = homePage.acceptAlert();
        log().info("Simple alert text: " + text);
        Assert.assertNotNull(text, "Alert text should not be null");
        Assert.assertFalse(text.isEmpty(), "Alert text should not be empty");
        log().pass("Simple alert accepted. Text: " + text);
    }

    @Test(priority = 2, description = "Handle Confirmation Alert – click OK (accept)")
    public void testConfirmationAlertAccept() {
        resetPage();
        homePage.clickConfirmationAlert();
        String text = homePage.acceptAlert();
        log().info("Confirm alert text: " + text);

        String result = homePage.getAlertResultText();
        log().info("Result after OK: " + result);
        Assert.assertFalse(result.isEmpty(), "Result text should appear after accepting confirm");
        log().pass("Confirmation alert accepted. Result: " + result);
    }

    @Test(priority = 3, description = "Handle Confirmation Alert – click Cancel (dismiss)")
    public void testConfirmationAlertDismiss() {
        resetPage();
        homePage.clickConfirmationAlert();
        String text = homePage.dismissAlert();
        log().info("Confirm alert dismissed. Text was: " + text);

        String result = homePage.getAlertResultText();
        log().info("Result after Cancel: " + result);
        log().pass("Confirmation alert dismissed. Result: " + result);
    }

    @Test(priority = 4, description = "Handle Prompt Alert – type text and accept")
    public void testPromptAlert() {
        resetPage();
        String input = "SeleniumTest";
        homePage.clickPromptAlert();
        homePage.sendKeysToAlert(input);
        log().info("Prompt alert answered with: " + input);

        String result = homePage.getAlertResultText();
        log().info("Prompt result: " + result);
        Assert.assertTrue(result.contains(input),
            "Result should contain '" + input + "', got: " + result);
        log().pass("Prompt alert handled. Result: " + result);
    }

    @Test(priority = 5, description = "Open New Tab and switch to it")
    public void testNewTab() {
        String mainHandle = driver.getWindowHandle();
        homePage.clickNewTab();
        WaitUtil.sleep(2000);

        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(handles.size() > 1, "New tab should open");

        for (String h : handles) {
            if (!h.equals(mainHandle)) {
                driver.switchTo().window(h);
                log().info("New tab URL: " + driver.getCurrentUrl());
                Assert.assertFalse(driver.getCurrentUrl().isEmpty(), "New tab URL empty");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainHandle);
        log().pass("New tab opened and closed successfully ✔");
    }

    @Test(priority = 6, description = "Open Popup Window and switch to it")
    public void testPopupWindow() {
        String mainHandle = driver.getWindowHandle();
        homePage.clickPopupWindow();
        WaitUtil.sleep(2000);

        Set<String> handles = driver.getWindowHandles();
        Assert.assertTrue(handles.size() > 1, "Popup window should open");

        for (String h : handles) {
            if (!h.equals(mainHandle)) {
                driver.switchTo().window(h);
                log().info("Popup URL: " + driver.getCurrentUrl());
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainHandle);
        log().pass("Popup window opened and closed successfully ✔");
    }
}