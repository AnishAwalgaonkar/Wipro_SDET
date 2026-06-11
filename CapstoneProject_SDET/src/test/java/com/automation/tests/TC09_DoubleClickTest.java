package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC09 – Double Click
 * Enters text in Field1, double-clicks 'Copy Text', verifies Field2 gets the same text.
 */
public class TC09_DoubleClickTest extends BaseTest {

    @Test(priority = 1, description = "Enter text in Field1")
    public void testEnterTextField1() {
        homePage.enterField1("SeleniumAutomation");
        Assert.assertEquals(homePage.getField1Value(), "SeleniumAutomation",
            "Field1 should contain entered text");
        log().pass("Text entered in Field1 ✔");
    }

    @Test(priority = 2, dependsOnMethods = "testEnterTextField1",
          description = "Double-click 'Copy Text' button and verify Field2 matches Field1")
    public void testDoubleClickCopy() {
        String expected = homePage.getField1Value();
        homePage.doubleClickCopy();
        String actual = homePage.getField2Value();
        log().info("Field1='" + expected + "'  Field2='" + actual + "'");
        Assert.assertEquals(actual, expected,
            "Field2 should equal Field1 after double-click copy");
        log().pass("Double-click copy verified: Field2='" + actual + "' ✔");
    }

    @Test(priority = 3, description = "Verify Field1 retains its value after copy")
    public void testField1RetainsValue() {
        homePage.enterField1("PracticeTest");
        homePage.doubleClickCopy();
        Assert.assertEquals(homePage.getField1Value(), "PracticeTest",
            "Field1 should retain its value after copy");
        log().pass("Field1 retained value after double-click ✔");
    }
}