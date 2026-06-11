package tests;

import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.GUIPage;

@Listeners(TestListener.class)
public class GUIElementsTest extends BaseTest {

    Logger log =
            LogManager.getLogger(GUIElementsTest.class);

    @Test (priority = 1)
    public void verifyGUIElements() {

        GUIPage page = new GUIPage(driver);

        log.info("Entering Name");
        page.enterName("Anish");
        pause(2);

        log.info("Entering Email");
        page.enterEmail("anish@test.com");
        pause(2);

        log.info("Entering Phone");
        page.enterPhone("9876543210");
        pause(2);

        log.info("Entering Address");
        page.enterAddress("Bangalore");
        pause(2);

        log.info("Selecting Gender");
        page.selectGender();
        pause(2);

        log.info("Selecting Monday Checkbox");
        page.selectMonday();
        pause(2);

        log.info("Selecting Country");
        page.selectCountry("India");
        pause(2);

        log.info("Selecting Colors");
        page.selectColors();
        pause(2);

        log.info("Selecting Animal");
        page.selectAnimal("Cat");
        pause(2);

        log.info("GUI Elements Validation Completed Successfully");
    }
    @Test(priority = 2)
    public void verifyDatePickers() {

        GUIPage page = new GUIPage(driver);

        log.info("Selecting Date Picker 1");
        page.selectDatePicker1("06/15/2026");
        pause(2);

        log.info("Selecting Date Picker 2");
        page.selectDatePicker2("15/06/2026");
        pause(2);

        log.info("Selecting Date Range");

        page.selectDateRange(
                "06-01-2026",
                "06-30-2026");
        pause(2);
        TestListener.test.info("Selecting Date Picker 1");
        TestListener.test.info("Selecting Date Picker 2");
        TestListener.test.info("Selecting Date Range");
        log.info("Date Picker Validation Completed");
        
    } 
    @Test(priority = 3)
    public void verifyFileUpload() {

        GUIPage page = new GUIPage(driver);

        String singleFile =
                System.getProperty("user.dir")
                + "\\testdata\\Resume.pdf";

        String file1 =
                System.getProperty("user.dir")
                + "\\testdata\\Sample1.txt";

        String file2 =
                System.getProperty("user.dir")
                + "\\testdata\\Sample2.txt";

        log.info("Uploading Single File");

        page.uploadSingleFile(singleFile);
        pause(2);

        log.info(page.getSingleFileStatus());

        log.info("Uploading Multiple Files");

        page.uploadMultipleFiles(file1, file2);
        pause(2);

        log.info(page.getMultipleFileStatus());
        TestListener.test.info(
                "Uploading Single File");

        TestListener.test.info(
                "Uploading Multiple Files");
    }
    
    @Test(priority = 4)
    public void verifyPaginationTable() {
        GUIPage page = new GUIPage(driver);
        
        log.info("Selecting Laptop");
        page.selectProduct("Laptop");
        pause(2);
        
        log.info("Selecting Smartwatch");
        page.selectProduct("Smartwatch");
        pause(2);
        
        TestListener.test.info("Laptop Selected");
        TestListener.test.info("Smartwatch Selected");
        log.info("Pagination Table Validation Passed");
    }
    
    @Test(priority = 5)
    public void verifyWikipediaSearchTabs() {

        GUIPage page = new GUIPage(driver);

        log.info("Searching Animal");

        page.searchWikipedia("animal");
        page.waitForSearchResults();
        String parentWindow =
                page.getParentWindow();

        log.info("Clicking Animal Result");

        page.clickSearchResult("Animal");

        page.switchToChildWindow(parentWindow);

        log.info("Switched To Child Window");

        System.out.println(
                driver.getTitle());

        System.out.println(
                driver.getCurrentUrl());

        page.closeCurrentTab();

        page.switchBackToParent(parentWindow);
        pause(2);

        log.info("Returned To Parent Window");
    }
    
    @Test(priority = 6)
    public void verifyAlerts() {

        GUIPage page =
                new GUIPage(driver);

        log.info("Handling Simple Alert");

        String simpleAlertText =
                page.handleSimpleAlert();
        pause(2);

        System.out.println(simpleAlertText);

        log.info("Handling Confirmation Alert");

        String confirmResult =
                page.handleConfirmationAlertOK();
        pause(2);

        System.out.println(confirmResult);

        log.info("Handling Prompt Alert");

        String promptResult =
                page.handlePromptAlert("Anish");
        pause(2);

        System.out.println(promptResult);
    }
    @Test(priority = 7)
    public void verifyNewTab() {

        GUIPage page =
                new GUIPage(driver);

        String parent =
                page.openNewTab();

        log.info("New Tab Opened");

        System.out.println(
                driver.getCurrentUrl());

        driver.close();

        driver.switchTo()
                .window(parent);
        pause(2);
    }
    @Test(priority = 8)
    public void verifyPopupWindows() {

        GUIPage page =
                new GUIPage(driver);

        String parent =
                page.openPopupWindows();
        pause(2);

        // page.handlePopupWindows(parent);

        log.info(
                "Popup Windows Handled");
    }
    @Test(priority = 9)
    public void verifyMouseHover() {

        GUIPage page =
                new GUIPage(driver);

        log.info("Hovering Over Menu");

        page.hoverAndSelectOption("Mobiles");
        pause(2);

        log.info("Mouse Hover Completed");
    }
    @Test(priority = 10)
    public void verifyDoubleClick() {

        GUIPage page =
                new GUIPage(driver);

        log.info("Performing Double Click");

        page.performDoubleClickAndGetResult();
        pause(2);

        log.info("Double Click Completed");
    }
    @Test(priority = 11)
    public void verifyDragAndDrop() {

        GUIPage page =
                new GUIPage(driver);

        log.info("Performing Drag and Drop");

        page.performDragAndDrop();
        pause(2);

        log.info("Drag and Drop Completed");
    }
    @Test(priority = 12)
    public void verifySliderDropdownAndLinks()
            throws InterruptedException {

        GUIPage page =
                new GUIPage(driver);

        log.info("Setting Slider Range");

        page.setSliderRange();
        pause(2);

        log.info("Selecting Item 50");

        page.selectScrollingDropdownItem(
                "Item 50");
        pause(2);

        log.info("Opening Lenovo Link");

        page.openLaptopLink("Lenovo");

        System.out.println(
                driver.getCurrentUrl());

        driver.navigate().back();
        pause(2);

        log.info("Verifying Broken Links");

        page.verifyBrokenLinks();
        pause(2);
    }
}