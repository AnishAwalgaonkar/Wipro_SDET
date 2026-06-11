package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.ActionsPage;

public class ActionsTest extends BaseTest {

    @Test
    public void verifyActions()
    {
        ActionsPage action =
                new ActionsPage(
                        DriverFactory.getDriver());

        action.dragAndDrop();

        action.adjustSliderRange();
    }
}