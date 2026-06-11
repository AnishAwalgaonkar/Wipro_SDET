package com.automation.tests;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC12 – Dynamic Button
 * Clicking START causes the button to hide and a STOP button to appear.
 */
public class TC12_DynamicButtonTest extends BaseTest {

    @Test(priority = 1, description = "Verify START button is visible and labelled correctly")
    public void testStartButtonVisible() {
        WebElement startBtn = driver.findElement(By.id("start"));
        scrollEl(startBtn);
        Assert.assertTrue(startBtn.isDisplayed(), "START button should be visible");
        Assert.assertEquals(startBtn.getText().trim(), "START");
        log().pass("START button visible with label 'START' ✔");
    }

    @Test(priority = 2, description = "Click START – STOP button must appear dynamically")
    public void testClickStartRevealStop() {
        homePage.clickStart();
        log().info("Clicked START – waiting for STOP…");
        WaitUtil w = new WaitUtil(driver);
        WebElement stopBtn = w.untilClickable(By.id("stop"));
        Assert.assertTrue(stopBtn.isDisplayed(), "STOP button should appear after START");
        log().pass("STOP button appeared dynamically ✔");
    }

    @Test(priority = 3, description = "Click STOP button once it appears")
    public void testClickStop() {
        resetPage();
        homePage.clickStart();
        new WaitUtil(driver).untilClickable(By.id("stop")).click();
        WaitUtil.sleep(400);
        log().pass("STOP clicked successfully ✔");
    }

    private void scrollEl(WebElement el) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }
}