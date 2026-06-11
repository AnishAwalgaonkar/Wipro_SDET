package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TC04 – Static Web Table
 * Covers: row count · headers · cell data · book search · price validation
 */
public class TC04_StaticTableTest extends BaseTest {

    @Test(priority = 1, description = "Verify static table has 6 data rows")
    public void testRowCount() {
        int rows = homePage.getStaticTableRowCount();
        log().info("Static table data rows: " + rows);
        Assert.assertEquals(rows, 6, "Expected 6 data rows");
        log().pass("Row count = 6 ✔");
    }

    @Test(priority = 2, description = "Verify table header names")
    public void testTableHeaders() {
        List<WebElement> headers = driver.findElements(
            By.xpath("//table[@name='BookTable']//th"));
        Assert.assertEquals(headers.size(), 4, "Expected 4 columns");
        Assert.assertEquals(headers.get(0).getText().trim(), "BookName");
        Assert.assertEquals(headers.get(1).getText().trim(), "Author");
        Assert.assertEquals(headers.get(2).getText().trim(), "Subject");
        Assert.assertEquals(headers.get(3).getText().trim(), "Price");
        log().pass("All 4 headers verified");
    }

    @Test(priority = 3, description = "Verify first row: 'Learn Selenium' by Amit, price 300")
    public void testFirstRow() {
        Assert.assertEquals(homePage.getTableCell(1, 1), "Learn Selenium");
        Assert.assertEquals(homePage.getTableCell(1, 2), "Amit");
        Assert.assertEquals(homePage.getTableCell(1, 3), "Selenium");
        Assert.assertEquals(homePage.getTableCell(1, 4), "300");
        log().pass("First row data verified");
    }

    @Test(priority = 4, description = "Verify 'Learn Java' exists in table")
    public void testBookExists() {
        Assert.assertTrue(homePage.isBookInTable("Learn Java"), "'Learn Java' not found");
        log().pass("'Learn Java' found in table");
    }

    @Test(priority = 5, description = "Verify 'Master In Selenium' has price 3000")
    public void testMasterSeleniumPrice() {
        // Find row where BookName = 'Master In Selenium' then read price
        List<WebElement> rows = driver.findElements(
            By.xpath("//table[@name='BookTable']//tr[position()>1]"));
        String price = null;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().trim().equals("Master In Selenium")) {
                price = cells.get(3).getText().trim();
                break;
            }
        }
        Assert.assertNotNull(price, "'Master In Selenium' row not found");
        Assert.assertEquals(price, "3000", "Price mismatch for 'Master In Selenium'");
        log().pass("'Master In Selenium' price = 3000 ✔");
    }

    @Test(priority = 6, description = "Verify all prices are positive integers")
    public void testAllPricesPositive() {
        List<WebElement> priceCells = driver.findElements(
            By.xpath("//table[@name='BookTable']//tr[position()>1]/td[4]"));
        for (WebElement cell : priceCells) {
            int price = Integer.parseInt(cell.getText().trim());
            Assert.assertTrue(price > 0, "Price must be > 0, got: " + price);
        }
        log().pass("All prices are positive ✔");
    }

    @Test(priority = 7, description = "Search each book by name and verify it exists")
    public void testAllBooksExist() {
        String[] books = {
            "Learn Selenium", "Learn Java", "Learn JS",
            "Master In Selenium", "Master In Java", "Master In JS"
        };
        for (String book : books) {
            Assert.assertTrue(homePage.isBookInTable(book), book + " not found in table");
            log().info("Found: " + book);
        }
        log().pass("All 6 books found in table ✔");
    }
}