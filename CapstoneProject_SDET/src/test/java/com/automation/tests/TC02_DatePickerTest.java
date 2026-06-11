package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC02 – Date Pickers
 * Covers: DatePicker1 (mm/dd/yyyy) · DatePicker2 (dd/mm/yyyy) ·
 *         Date-Range picker (from / to) · Submit button
 */
public class TC02_DatePickerTest extends BaseTest {

    @Test(priority = 1, description = "Set Date Picker 1 (mm/dd/yyyy format)")
    public void testDatePicker1() {
        String date = "06/15/2025";
        homePage.setDate1(date);
        log().info("Set Date Picker 1 to: " + date);
        String actual = homePage.getDate1Value();
        Assert.assertFalse(actual.isEmpty(), "Date Picker 1 value should not be empty");
        log().pass("Date Picker 1 value: " + actual);
    }

    @Test(priority = 2, description = "Set Date Picker 2 (dd/mm/yyyy format)")
    public void testDatePicker2() {
        String date = "20/07/2025";
        homePage.setDate2(date);
        log().info("Set Date Picker 2 to: " + date);
        String actual = homePage.getDate2Value();
        Assert.assertFalse(actual.isEmpty(), "Date Picker 2 value should not be empty");
        log().pass("Date Picker 2 value: " + actual);
    }

    @Test(priority = 3, description = "Set Date Range From and To dates")
    public void testDateRangePicker() {
        homePage.setDateRange("06/01/2025", "06/30/2025");
        log().info("Date range set: 06/01/2025 → 06/30/2025");
        Assert.assertFalse(homePage.getDateFromValue().isEmpty(), "'From' date should not be empty");
        Assert.assertFalse(homePage.getDateToValue().isEmpty(),   "'To' date should not be empty");
        log().pass("Date range: from=" + homePage.getDateFromValue() +
                   "  to=" + homePage.getDateToValue());
    }

    @Test(priority = 4, description = "Click Submit button after filling date fields")
    public void testSubmitButton() {
        homePage.setDate1("07/04/2025");
        homePage.clickSubmit();
        log().pass("Submit button clicked successfully");
    }
}