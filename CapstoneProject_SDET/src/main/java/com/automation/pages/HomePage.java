package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.utils.WaitUtil;

import java.util.List;

/**
 * HomePage – Page Object Model for https://testautomationpractice.blogspot.com
 *
 * Covers every element section:
 *  • Form Elements (name, email, phone, address, radio, checkbox, dropdowns)
 *  • Date Pickers (3 types incl. date range)
 *  • File Upload (single + multiple)
 *  • Static / Dynamic / Pagination Tables
 *  • Alerts & Popups (simple, confirm, prompt, new tab, popup window)
 *  • Mouse Hover dropdown
 *  • Double Click copy
 *  • Drag and Drop
 *  • Slider
 *  • Dynamic Button (START → STOP)
 *  • Labels & Links (mobile labels, laptop links, broken links)
 *  • Accordion / Visitors section
 */
public class HomePage extends BasePage {

    // ══════════════════════════════════════════════════════════
    //  FORM ELEMENTS
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "textarea")
    private WebElement addressField;

    // Gender
    @FindBy(xpath = "//input[@type='radio' and @value='male']")
    private WebElement maleRadio;

    @FindBy(xpath = "//input[@type='radio' and @value='female']")
    private WebElement femaleRadio;

    // Days checkboxes – addressed individually AND as a list
    @FindBy(id = "sunday")    private WebElement cbSunday;
    @FindBy(id = "monday")    private WebElement cbMonday;
    @FindBy(id = "tuesday")   private WebElement cbTuesday;
    @FindBy(id = "wednesday") private WebElement cbWednesday;
    @FindBy(id = "thursday")  private WebElement cbThursday;
    @FindBy(id = "friday")    private WebElement cbFriday;
    @FindBy(id = "saturday")  private WebElement cbSaturday;

    // Dropdowns
    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "colors")
    private WebElement colorsDropdown;

    @FindBy(id = "animals")
    private WebElement animalsDropdown;

    // ══════════════════════════════════════════════════════════
    //  DATE PICKERS
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "datepicker")
    private WebElement datePicker1;

    @FindBy(id = "datepicker2")
    private WebElement datePicker2;

    @FindBy(id = "from")
    private WebElement dateRangeFrom;

    @FindBy(id = "to")
    private WebElement dateRangeTo;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    // ══════════════════════════════════════════════════════════
    //  FILE UPLOAD
    // ══════════════════════════════════════════════════════════

    @FindBy(xpath = "//input[@type='file'][1]")
    private WebElement singleFileInput;

    @FindBy(xpath = "//input[@type='file'][2]")
    private WebElement multipleFileInput;

    // ══════════════════════════════════════════════════════════
    //  STATIC TABLE
    // ══════════════════════════════════════════════════════════

    @FindBy(xpath = "//table[@name='BookTable']//tr[position()>1]")
    private List<WebElement> tableDataRows;

    // ══════════════════════════════════════════════════════════
    //  ALERTS & POPUPS
    // ══════════════════════════════════════════════════════════

    @FindBy(xpath = "//button[normalize-space()='Simple Alert']")
    private WebElement simpleAlertBtn;

    @FindBy(xpath = "//button[normalize-space()='Confirmation Alert']")
    private WebElement confirmAlertBtn;

    @FindBy(xpath = "//button[normalize-space()='Prompt Alert']")
    private WebElement promptAlertBtn;

    @FindBy(id = "demo")
    private WebElement alertResult;

    @FindBy(xpath = "//button[normalize-space()='New Tab']")
    private WebElement newTabBtn;

    @FindBy(xpath = "//button[normalize-space()='Popup Windows']")
    private WebElement popupBtn;

    // ══════════════════════════════════════════════════════════
    //  MOUSE HOVER
    // ══════════════════════════════════════════════════════════

    @FindBy(xpath = "//button[contains(text(),'Point Me')]")
    private WebElement hoverBtn;

    @FindBy(xpath = "//a[text()='Mobiles']")
    private WebElement mobilesLink;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsLink;

    // ══════════════════════════════════════════════════════════
    //  DOUBLE CLICK
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "field1")
    private WebElement field1;

    @FindBy(id = "field2")
    private WebElement field2;

    @FindBy(id = "copyButton")
    private WebElement copyButton;

    // ══════════════════════════════════════════════════════════
    //  DRAG AND DROP
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "draggable")
    private WebElement draggable;

    @FindBy(id = "droppable")
    private WebElement droppable;

    // ══════════════════════════════════════════════════════════
    //  SLIDER
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "slider")
    private WebElement sliderInput;

    // ══════════════════════════════════════════════════════════
    //  DYNAMIC BUTTON
    // ══════════════════════════════════════════════════════════

    @FindBy(id = "start")
    private WebElement startBtn;

    // ══════════════════════════════════════════════════════════
    //  ACCORDION / VISITORS
    // ══════════════════════════════════════════════════════════

    @FindBy(xpath = "//h3[contains(.,'Section 1')]")
    private WebElement section1Header;

    @FindBy(xpath = "//h3[contains(.,'Section 2')]")
    private WebElement section2Header;

    @FindBy(xpath = "//h3[contains(.,'Section 3')]")
    private WebElement section3Header;

    // ══════════════════════════════════════════════════════════
    //  LABELS & LINKS
    // ══════════════════════════════════════════════════════════

    @FindBy(linkText = "Apple")
    private WebElement appleLink;

    @FindBy(linkText = "Lenovo")
    private WebElement lenovoLink;

    @FindBy(linkText = "Dell")
    private WebElement dellLink;

    // ══════════════════════════════════════════════════════════
    //  CONSTRUCTOR
    // ══════════════════════════════════════════════════════════

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ══════════════════════════════════════════════════════════
    //  FORM ACTIONS
    // ══════════════════════════════════════════════════════════

    public void enterName(String name) {
        js.scrollIntoView(nameField);
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void enterAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public String getNameValue()    { return nameField.getAttribute("value"); }
    public String getEmailValue()   { return emailField.getAttribute("value"); }
    public String getPhoneValue()   { return phoneField.getAttribute("value"); }
    public String getAddressValue() { return addressField.getAttribute("value"); }

    /** Selects gender radio; value must be "male" or "female". */
    public void selectGender(String gender) {
        WebElement radio = gender.equalsIgnoreCase("male") ? maleRadio : femaleRadio;
        js.scrollIntoView(radio);
        if (!radio.isSelected()) radio.click();
    }

    public boolean isMaleSelected()   { return maleRadio.isSelected(); }
    public boolean isFemaleSelected() { return femaleRadio.isSelected(); }

    /** Selects a day checkbox by name (case-insensitive). */
    public void selectDay(String day) {
        WebElement cb = getDayCheckbox(day);
        js.scrollIntoView(cb);
        if (!cb.isSelected()) cb.click();
    }

    public boolean isDayChecked(String day) { return getDayCheckbox(day).isSelected(); }

    private WebElement getDayCheckbox(String day) {
        switch (day.toLowerCase()) {
            case "sunday":    return cbSunday;
            case "monday":    return cbMonday;
            case "tuesday":   return cbTuesday;
            case "wednesday": return cbWednesday;
            case "thursday":  return cbThursday;
            case "friday":    return cbFriday;
            case "saturday":  return cbSaturday;
            default: throw new IllegalArgumentException("Unknown day: " + day);
        }
    }

    public void selectCountryByText(String country) {
        js.scrollIntoView(countryDropdown);
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public String getSelectedCountry() {
        return new Select(countryDropdown).getFirstSelectedOption().getText();
    }

    public void selectColorByText(String color) {
        js.scrollIntoView(colorsDropdown);
        new Select(colorsDropdown).selectByVisibleText(color);
    }

    public void selectAnimalByText(String animal) {
        js.scrollIntoView(animalsDropdown);
        new Select(animalsDropdown).selectByVisibleText(animal);
    }

    public String getSelectedAnimal() {
        return new Select(animalsDropdown).getFirstSelectedOption().getText();
    }

    // ══════════════════════════════════════════════════════════
    //  DATE PICKER ACTIONS
    // ══════════════════════════════════════════════════════════

    /** Sets Date Picker 1 (mm/dd/yyyy). */
    public void setDate1(String date) {
        js.scrollIntoView(datePicker1);
        datePicker1.clear();
        datePicker1.sendKeys(date);
        datePicker1.sendKeys(Keys.ESCAPE);
    }

    /** Sets Date Picker 2 (dd/mm/yyyy). */
    public void setDate2(String date) {
        js.scrollIntoView(datePicker2);
        datePicker2.clear();
        datePicker2.sendKeys(date);
        datePicker2.sendKeys(Keys.ESCAPE);
    }

    /** Sets Date Range (from / to). */
    public void setDateRange(String from, String to) {
        js.scrollIntoView(dateRangeFrom);
        dateRangeFrom.clear();
        dateRangeFrom.sendKeys(from);
        dateRangeFrom.sendKeys(Keys.TAB);
        dateRangeTo.clear();
        dateRangeTo.sendKeys(to);
        dateRangeTo.sendKeys(Keys.ESCAPE);
    }

    public String getDate1Value()     { return datePicker1.getAttribute("value"); }
    public String getDate2Value()     { return datePicker2.getAttribute("value"); }
    public String getDateFromValue()  { return dateRangeFrom.getAttribute("value"); }
    public String getDateToValue()    { return dateRangeTo.getAttribute("value"); }

    public void clickSubmit() {
        js.scrollIntoView(submitBtn);
        wait.untilClickable(submitBtn).click();
    }

    // ══════════════════════════════════════════════════════════
    //  FILE UPLOAD ACTIONS
    // ══════════════════════════════════════════════════════════

    public void uploadSingleFile(String absolutePath) {
        singleFileInput.sendKeys(absolutePath);
    }

    public void uploadMultipleFiles(String path1, String path2) {
        // sendKeys with newline-separated paths works for multiple=true inputs
        multipleFileInput.sendKeys(path1 + "\n" + path2);
    }

    // ══════════════════════════════════════════════════════════
    //  STATIC TABLE QUERIES
    // ══════════════════════════════════════════════════════════

    public int getStaticTableRowCount() { return tableDataRows.size(); }

    /** Returns cell text at (1-based row, 1-based col), excluding header. */
    public String getTableCell(int row, int col) {
        String xpath = String.format(
            "//table[@name='BookTable']//tr[position()>1][%d]/td[%d]", row, col);
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

    public boolean isBookInTable(String bookName) {
        return driver.findElements(
            By.xpath("//table[@name='BookTable']//td[normalize-space()='" + bookName + "']"))
            .size() > 0;
    }

    // ══════════════════════════════════════════════════════════
    //  ALERT ACTIONS
    // ══════════════════════════════════════════════════════════

    public void clickSimpleAlert()       { js.scrollIntoView(simpleAlertBtn);  simpleAlertBtn.click(); }
    public void clickConfirmationAlert() { js.scrollIntoView(confirmAlertBtn); confirmAlertBtn.click(); }
    public void clickPromptAlert()       { js.scrollIntoView(promptAlertBtn);  promptAlertBtn.click(); }

    public String acceptAlert() {
        Alert a = wait.untilAlert();
        String txt = a.getText();
        a.accept();
        return txt;
    }

    public String dismissAlert() {
        Alert a = wait.untilAlert();
        String txt = a.getText();
        a.dismiss();
        return txt;
    }

    public String sendKeysToAlert(String text) {
        Alert a = wait.untilAlert();
        String txt = a.getText();
        a.sendKeys(text);
        a.accept();
        return txt;
    }

    public String getAlertResultText() { return alertResult.getText(); }

    public void clickNewTab()     { js.scrollIntoView(newTabBtn);  newTabBtn.click(); }
    public void clickPopupWindow() { js.scrollIntoView(popupBtn);  popupBtn.click(); }

    // ══════════════════════════════════════════════════════════
    //  MOUSE HOVER
    // ══════════════════════════════════════════════════════════

    public void hoverOverPointMe() {
        js.scrollIntoView(hoverBtn);
        new Actions(driver).moveToElement(hoverBtn).perform();
        WaitUtil.sleep(500);
    }

    public boolean isMobilesVisible() {
        try { return mobilesLink.isDisplayed(); }
        catch (NoSuchElementException e) { return false; }
    }

    public boolean isLaptopsVisible() {
        try { return laptopsLink.isDisplayed(); }
        catch (NoSuchElementException e) { return false; }
    }

    // ══════════════════════════════════════════════════════════
    //  DOUBLE CLICK
    // ══════════════════════════════════════════════════════════

    public void enterField1(String text) {
        js.scrollIntoView(field1);
        field1.clear();
        field1.sendKeys(text);
    }

    public void doubleClickCopy() {
        new Actions(driver).doubleClick(copyButton).perform();
        WaitUtil.sleep(300);
    }

    public String getField1Value() { return field1.getAttribute("value"); }
    public String getField2Value() { return field2.getAttribute("value"); }

    // ══════════════════════════════════════════════════════════
    //  DRAG AND DROP
    // ══════════════════════════════════════════════════════════

    public void performDragAndDrop() {
        js.scrollIntoView(draggable);
        WaitUtil.sleep(400);
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
        WaitUtil.sleep(500);
    }

    public String getDroppableText() { return droppable.getText().trim(); }

    // ══════════════════════════════════════════════════════════
    //  SLIDER
    // ══════════════════════════════════════════════════════════

    public void setSliderValue(int value) {
        js.scrollIntoView(sliderInput);
        js.setSlider(sliderInput, value);
    }

    public String getSliderValue() { return sliderInput.getAttribute("value"); }

    // ══════════════════════════════════════════════════════════
    //  DYNAMIC BUTTON
    // ══════════════════════════════════════════════════════════

    public void clickStart() {
        js.scrollIntoView(startBtn);
        wait.untilClickable(startBtn).click();
    }

    public void clickStop() {
        WebElement stopBtn = wait.untilClickable(By.id("stop"));
        stopBtn.click();
    }

    public boolean isStartVisible() {
        try { return startBtn.isDisplayed(); }
        catch (NoSuchElementException e) { return false; }
    }

    // ══════════════════════════════════════════════════════════
    //  ACCORDION
    // ══════════════════════════════════════════════════════════

    public void clickSection(int num) {
        WebElement h = (num == 1) ? section1Header
                     : (num == 2) ? section2Header
                     :              section3Header;
        js.scrollIntoView(h);
        h.click();
        WaitUtil.sleep(400);
    }

    // ══════════════════════════════════════════════════════════
    //  LABELS & LINKS
    // ══════════════════════════════════════════════════════════

    public String getAppleHref()  { return appleLink.getAttribute("href"); }
    public String getLenovoHref() { return lenovoLink.getAttribute("href"); }
    public String getDellHref()   { return dellLink.getAttribute("href"); }

    public boolean isAppleLinkDisplayed()  { return appleLink.isDisplayed(); }
    public boolean isLenovoLinkDisplayed() { return lenovoLink.isDisplayed(); }
    public boolean isDellLinkDisplayed()   { return dellLink.isDisplayed(); }

    /** Returns all broken-link elements found on the page. */
    public List<WebElement> getBrokenLinks() {
        return driver.findElements(
            By.xpath("//a[contains(@href,'deadlinkcity.com')]"));
    }

    /** Returns text of a mobile label by index (1-based: Samsung=1, RealMe=2, Moto=3). */
    public String getMobileLabel(int index) {
        return driver.findElement(
            By.xpath("(//h4[contains(.,'Mobile Labels')]/following-sibling::label)[" + index + "]"))
            .getText().trim();
    }
}