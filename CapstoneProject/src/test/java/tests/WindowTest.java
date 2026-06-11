package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.WindowPage;

public class WindowTest extends BaseTest {

    @Test
    public void verifyWindowHandling()
    {
        WindowPage page =
                new WindowPage(
                        DriverFactory.getDriver());

        page.openNewTab();

        page.switchToNewWindow();

        Assert.assertNotNull(
                page.getWindowTitle());

        page.closeCurrentWindow();

        page.switchBackToParent();
    }
}