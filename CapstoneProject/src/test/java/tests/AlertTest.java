package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void verifyAlert()
    {
        AlertPage alert =
                new AlertPage(
                        DriverFactory.getDriver());

        alert.handleAlert();
    }
}