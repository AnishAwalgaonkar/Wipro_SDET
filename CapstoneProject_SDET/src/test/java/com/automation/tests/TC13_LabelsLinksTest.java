package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TC13 – Labels & Links
 * Covers: Mobile Labels (Samsung, Real Me, Moto) ·
 *         Laptop Links (Apple, Lenovo, Dell) · Broken Links section
 */
public class TC13_LabelsLinksTest extends BaseTest {

    // ── Mobile Labels ────────────────────────────────────────

    @Test(priority = 1, description = "Verify 'Mobile Labels' section heading is present")
    public void testMobileLabelsHeading() {
        WebElement h = driver.findElement(
            By.xpath("//h4[contains(normalize-space(),'Mobile Labels')]"));
        scrollTo(h);
        Assert.assertTrue(h.isDisplayed(), "'Mobile Labels' heading should be visible");
        log().pass("'Mobile Labels' heading visible ✔");
    }

    @Test(priority = 2, description = "Verify Samsung label is present")
    public void testSamsungLabel() {
        String text = getParentSectionText("Mobile Labels");
        Assert.assertTrue(text.contains("Samsung"), "Samsung label missing");
        log().pass("'Samsung' mobile label found ✔");
    }

    @Test(priority = 3, description = "Verify Real Me label is present")
    public void testRealMeLabel() {
        String text = getParentSectionText("Mobile Labels");
        Assert.assertTrue(text.contains("Real Me") || text.contains("RealMe"),
            "Real Me label missing");
        log().pass("'Real Me' mobile label found ✔");
    }

    @Test(priority = 4, description = "Verify Moto label is present")
    public void testMotoLabel() {
        String text = getParentSectionText("Mobile Labels");
        Assert.assertTrue(text.contains("Moto"), "Moto label missing");
        log().pass("'Moto' mobile label found ✔");
    }

    // ── Laptop Links ─────────────────────────────────────────

    @Test(priority = 5, description = "Verify Apple laptop link is displayed and points to apple.com")
    public void testAppleLink() {
        WebElement lnk = driver.findElement(By.linkText("Apple"));
        scrollTo(lnk);
        Assert.assertTrue(lnk.isDisplayed(), "Apple link should be visible");
        Assert.assertTrue(lnk.getAttribute("href").contains("apple.com"),
            "Apple href should contain 'apple.com'");
        log().pass("Apple link → " + lnk.getAttribute("href") + " ✔");
    }

    @Test(priority = 6, description = "Verify Lenovo laptop link is displayed and points to lenovo.com")
    public void testLenovoLink() {
        WebElement lnk = driver.findElement(By.linkText("Lenovo"));
        scrollTo(lnk);
        Assert.assertTrue(lnk.isDisplayed(), "Lenovo link should be visible");
        Assert.assertTrue(lnk.getAttribute("href").contains("lenovo.com"),
            "Lenovo href should contain 'lenovo.com'");
        log().pass("Lenovo link → " + lnk.getAttribute("href") + " ✔");
    }

    @Test(priority = 7, description = "Verify Dell laptop link is displayed and points to dell.com")
    public void testDellLink() {
        WebElement lnk = driver.findElement(By.linkText("Dell"));
        scrollTo(lnk);
        Assert.assertTrue(lnk.isDisplayed(), "Dell link should be visible");
        Assert.assertTrue(lnk.getAttribute("href").contains("dell.com"),
            "Dell href should contain 'dell.com'");
        log().pass("Dell link → " + lnk.getAttribute("href") + " ✔");
    }

    // ── Broken Links ─────────────────────────────────────────

    @Test(priority = 8, description = "Verify 'Broken Links' section heading is present")
    public void testBrokenLinksHeading() {
        WebElement h = driver.findElement(
            By.xpath("//h4[contains(normalize-space(),'Broken Links')]"));
        scrollTo(h);
        Assert.assertTrue(h.isDisplayed(), "'Broken Links' heading should be visible");
        log().pass("'Broken Links' heading visible ✔");
    }

    @Test(priority = 9, description = "Verify at least 4 broken-link elements are present")
    public void testBrokenLinksCount() {
        List<WebElement> broken = homePage.getBrokenLinks();
        log().info("Broken links found: " + broken.size());
        Assert.assertTrue(broken.size() >= 4,
            "Expected at least 4 broken links, found: " + broken.size());
        log().pass(broken.size() + " broken links present ✔");
    }

    @Test(priority = 10, description = "Verify Errorcode 400 broken link has correct href")
    public void testErrorcode400Link() {
        WebElement lnk = driver.findElement(By.linkText("Errorcode 400"));
        scrollTo(lnk);
        Assert.assertTrue(lnk.getAttribute("href").contains("e=400"),
            "Errorcode 400 href should contain 'e=400'");
        log().pass("Errorcode 400 link verified ✔");
    }

    @Test(priority = 11, description = "Verify Errorcode 404 broken link has correct href")
    public void testErrorcode404Link() {
        WebElement lnk = driver.findElement(By.linkText("Errorcode 404"));
        Assert.assertTrue(lnk.getAttribute("href").contains("e=404"),
            "Errorcode 404 href should contain 'e=404'");
        log().pass("Errorcode 404 link verified ✔");
    }

    // ── helpers ──────────────────────────────────────────────

    private String getParentSectionText(String heading) {
        return driver.findElement(
            By.xpath("//h4[contains(normalize-space(),'" + heading + "')]" +
                     "/parent::*")).getText();
    }

    private void scrollTo(WebElement el) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }
}