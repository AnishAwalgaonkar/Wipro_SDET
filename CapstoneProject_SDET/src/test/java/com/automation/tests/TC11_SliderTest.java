package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC11 – Slider
 * Sets the price-range slider to specific values via JS and keyboard.
 */
public class TC11_SliderTest extends BaseTest {

    @Test(priority = 1, description = "Set slider to value 300 via JavaScript")
    public void testSetSliderTo300() {
        homePage.setSliderValue(300);
        Assert.assertEquals(homePage.getSliderValue(), "300",
            "Slider value should be 300");
        log().pass("Slider set to 300 via JS ✔");
    }

    @Test(priority = 2, description = "Set slider to minimum value 0")
    public void testSetSliderToMin() {
        homePage.setSliderValue(0);
        Assert.assertEquals(homePage.getSliderValue(), "0",
            "Slider value should be 0");
        log().pass("Slider at minimum (0) ✔");
    }

    @Test(priority = 3, description = "Set slider to maximum value 500")
    public void testSetSliderToMax() {
        homePage.setSliderValue(500);
        Assert.assertEquals(homePage.getSliderValue(), "500",
            "Slider value should be 500");
        log().pass("Slider at maximum (500) ✔");
    }

    @Test(priority = 4, description = "Move slider with keyboard arrow keys")
    public void testSliderWithKeyboard() {
        homePage.setSliderValue(200);
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        slider.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT);

        int val = Integer.parseInt(slider.getAttribute("value"));
        Assert.assertTrue(val >= 200,
            "Slider should be >= 200 after right-key presses, got: " + val);
        log().pass("Slider keyboard navigation verified. Value = " + val + " ✔");
    }
}