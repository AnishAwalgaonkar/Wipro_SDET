package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.TablePage;

public class TableTest extends BaseTest {

    @Test
    public void verifyTableRows()
    {
        TablePage table =
                new TablePage(
                        DriverFactory.getDriver());

        int rows = table.getRowCount();

        Assert.assertTrue(rows > 0);
    }
}