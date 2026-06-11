package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC08 – Mouse Hover
 * Hovering over 'Point Me' should reveal Mobiles and Laptops links.
 */
public class TC08_MouseHoverTest extends BaseTest {

    @Test(priority = 1, description = "Hover over 'Point Me' button and verify dropdown appears")
    public void testHoverDropdownAppears() {
        homePage.hoverOverPointMe();
        Assert.assertTrue(homePage.isMobilesVisible(),
            "'Mobiles' link should be visible after hover");
        Assert.assertTrue(homePage.isLaptopsVisible(),
            "'Laptops' link should be visible after hover");
        log().pass("Mouse hover dropdown links (Mobiles, Laptops) visible ✔");
    }

    @Test(priority = 2, description = "Verify Mobiles link is clickable after hover")
    public void testMobilesLinkClickable() {
        homePage.hoverOverPointMe();
        Assert.assertTrue(homePage.isMobilesVisible(), "'Mobiles' should appear after hover");
        log().pass("'Mobiles' dropdown link is visible and clickable ✔");
    }

    @Test(priority = 3, description = "Verify Laptops link is clickable after hover")
    public void testLaptopsLinkClickable() {
        homePage.hoverOverPointMe();
        Assert.assertTrue(homePage.isLaptopsVisible(), "'Laptops' should appear after hover");
        log().pass("'Laptops' dropdown link is visible and clickable ✔");
    }
}