package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.DatePickerPage;

public class DatePickerTest extends BaseTest {

    @Test
    public void verifyDatePicker()
    {
        DatePickerPage page =
                new DatePickerPage(
                        DriverFactory.getDriver());

        page.selectDate();
    }
}