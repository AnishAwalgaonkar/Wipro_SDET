package com.automation.tests;

import com.automation.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC01 – Form Elements
 * Covers: Name · Email · Phone · Address ·
 *         Gender radio · Day checkboxes · Country / Colors / Sorted-List dropdowns
 */
public class TC01_FormElementsTest extends BaseTest {

    // ── Text fields ─────────────────────────────────────────

    @Test(priority = 1, description = "Enter valid Name in Name field")
    public void testNameField() {
        String name = ConfigReader.testName();
        homePage.enterName(name);
        log().info("Entered name: " + name);
        Assert.assertEquals(homePage.getNameValue(), name, "Name field mismatch");
        log().pass("Name field verified");
    }

    @Test(priority = 2, description = "Enter valid Email in Email field")
    public void testEmailField() {
        String email = ConfigReader.testEmail();
        homePage.enterEmail(email);
        log().info("Entered email: " + email);
        Assert.assertEquals(homePage.getEmailValue(), email, "Email field mismatch");
        log().pass("Email field verified");
    }

    @Test(priority = 3, description = "Enter valid Phone in Phone field")
    public void testPhoneField() {
        String phone = ConfigReader.testPhone();
        homePage.enterPhone(phone);
        log().info("Entered phone: " + phone);
        Assert.assertEquals(homePage.getPhoneValue(), phone, "Phone field mismatch");
        log().pass("Phone field verified");
    }

    @Test(priority = 4, description = "Enter valid Address in Address textarea")
    public void testAddressField() {
        String addr = ConfigReader.testAddress();
        homePage.enterAddress(addr);
        log().info("Entered address: " + addr);
        Assert.assertEquals(homePage.getAddressValue(), addr, "Address field mismatch");
        log().pass("Address textarea verified");
    }

    // ── Gender radio ─────────────────────────────────────────

    @Test(priority = 5, description = "Select Male gender radio button")
    public void testSelectMaleRadio() {
        homePage.selectGender("male");
        log().info("Selected gender: Male");
        Assert.assertTrue(homePage.isMaleSelected(), "Male radio should be selected");
        log().pass("Male radio selected");
    }

    @Test(priority = 6, description = "Select Female gender radio button")
    public void testSelectFemaleRadio() {
        homePage.selectGender("female");
        log().info("Selected gender: Female");
        Assert.assertTrue(homePage.isFemaleSelected(), "Female radio should be selected");
        log().pass("Female radio selected");
    }

    // ── Day checkboxes ───────────────────────────────────────

    @Test(priority = 7, description = "Select Sunday checkbox")
    public void testSundayCheckbox() {
        homePage.selectDay("sunday");
        Assert.assertTrue(homePage.isDayChecked("sunday"), "Sunday should be checked");
        log().pass("Sunday checkbox checked");
    }

    @Test(priority = 8, description = "Select Monday checkbox")
    public void testMondayCheckbox() {
        homePage.selectDay("monday");
        Assert.assertTrue(homePage.isDayChecked("monday"), "Monday should be checked");
        log().pass("Monday checkbox checked");
    }

    @Test(priority = 9, description = "Select Wednesday checkbox")
    public void testWednesdayCheckbox() {
        homePage.selectDay("wednesday");
        Assert.assertTrue(homePage.isDayChecked("wednesday"), "Wednesday should be checked");
        log().pass("Wednesday checkbox checked");
    }

    @Test(priority = 10, description = "Select Friday checkbox")
    public void testFridayCheckbox() {
        homePage.selectDay("friday");
        Assert.assertTrue(homePage.isDayChecked("friday"), "Friday should be checked");
        log().pass("Friday checkbox checked");
    }

    @Test(priority = 11, description = "Select all 7 day checkboxes")
    public void testSelectAllDays() {
        String[] days = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        for (String d : days) homePage.selectDay(d);
        log().info("All 7 days selected");
        for (String d : days)
            Assert.assertTrue(homePage.isDayChecked(d), d + " should be checked");
        log().pass("All 7 day checkboxes verified");
    }

    // ── Dropdowns ────────────────────────────────────────────

    @Test(priority = 12, description = "Select 'India' from Country dropdown")
    public void testCountryDropdown() {
        homePage.selectCountryByText("India");
        log().info("Selected country: India");
        Assert.assertEquals(homePage.getSelectedCountry(), "India", "Country mismatch");
        log().pass("Country dropdown verified: India");
    }

    @Test(priority = 13, description = "Select 'Blue' from Colors dropdown")
    public void testColorsDropdown() {
        homePage.selectColorByText("Blue");
        log().pass("Color 'Blue' selected successfully");
    }

    @Test(priority = 14, description = "Select 'Dog' from Sorted List dropdown")
    public void testSortedListDropdown() {
        homePage.selectAnimalByText("Dog");
        Assert.assertEquals(homePage.getSelectedAnimal(), "Dog", "Animal mismatch");
        log().pass("Sorted list dropdown verified: Dog");
    }
}