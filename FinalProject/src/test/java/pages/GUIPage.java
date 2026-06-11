package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GUIPage {

    WebDriver driver;

    public GUIPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="name")
    WebElement txtName;

    @FindBy(id="email")
    WebElement txtEmail;

    @FindBy(id="phone")
    WebElement txtPhone;

    @FindBy(id="textarea")
    WebElement txtAddress;

    @FindBy(id="male")
    WebElement maleRadio;

    @FindBy(id="monday")
    WebElement mondayCheckBox;

    @FindBy(id="country")
    WebElement countryDropdown;

    @FindBy(id="colors")
    WebElement colorsDropdown;

    @FindBy(id="animals")
    WebElement animalDropdown;

    public void enterName(String name) {
        txtName.sendKeys(name);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void enterAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void selectGender() {
        maleRadio.click();
    }

    public void selectMonday() {
        mondayCheckBox.click();
    }

    public void selectCountry(String country) {

        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void selectColors() {

        Select select = new Select(colorsDropdown);

        select.selectByVisibleText("Red");
        select.selectByVisibleText("Blue");
    }

    public void selectAnimal(String animal) {

        Select select = new Select(animalDropdown);

        select.selectByVisibleText(animal);
    }
    
    @FindBy(id="datepicker")
    WebElement datePicker1;

    @FindBy(id="txtDate")
    WebElement datePicker2;

    @FindBy(id="start-date")
    WebElement startDatePicker;

    @FindBy(id="end-date")
    WebElement endDatePicker;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement submitDateRangeBtn;
    
    public void selectDatePicker1(String date) {

        datePicker1.clear();
        datePicker1.sendKeys(date);
    }
    public void selectDatePicker2(String date) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].value=arguments[1]",
                datePicker2,
                date);

        // Close calendar popup
        driver.findElement(By.tagName("body")).click();
    }

	public void selectDateRange(String startDate, String endDate) {
		startDatePicker.sendKeys(startDate);
		endDatePicker.sendKeys(endDate);
		driver.findElement(By.tagName("body")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", submitDateRangeBtn);
		js.executeScript("arguments[0].click();", submitDateRangeBtn);
	}
	
	// File Upload
	@FindBy(id = "singleFileInput")
	WebElement singleFileInput;

	@FindBy(xpath = "//button[text()='Upload Single File']")
	WebElement uploadSingleBtn;

	@FindBy(id = "singleFileStatus")
	WebElement singleFileStatus;

	@FindBy(id = "multipleFilesInput")
	WebElement multipleFileInput;

	@FindBy(xpath = "//button[text()='Upload Multiple Files']")
	WebElement uploadMultipleBtn;

	@FindBy(id = "multipleFilesStatus")
	WebElement multipleFilesStatus;
	
	public void uploadSingleFile(String filePath) {

	    singleFileInput.sendKeys(filePath);

	    uploadSingleBtn.click();
	}
	public String getSingleFileStatus() {

	    return singleFileStatus.getText();
	}
	public void uploadMultipleFiles(String file1, String file2) {

		multipleFileInput.sendKeys(file1 + "\n" + file2);

		uploadMultipleBtn.click();
	}
	public String getMultipleFileStatus() {

	    return multipleFilesStatus.getText();
	}
	
	// Pagination Web Table
	@FindBy(xpath = "//table[@id='productTable']/tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//ul[@id='pagination']//a")
	List<WebElement> paginationLinks;
	
	public void selectProduct(String productName) {

	    for(WebElement page : paginationLinks) {

	        page.click();

	        List<WebElement> rows =
	                driver.findElements(
	                By.xpath("//table[@id='productTable']/tbody/tr"));

	        for(WebElement row : rows) {

	            String product =
	                    row.findElement(
	                    By.xpath("./td[2]"))
	                    .getText();

	            if(product.equalsIgnoreCase(productName)) {

	                row.findElement(
	                By.xpath("./td[4]//input[@type='checkbox']"))
	                .click();

	                return;
	            }
	        }
	    }
	}
	public void selectTwoProducts() {

	    selectProduct("Laptop");

	    selectProduct("Smartwatch");
	}
    
	// Tabs Section
	@FindBy(id = "Wikipedia1_wikipedia-search-input")
	WebElement wikipediaSearchBox;

	@FindBy(className = "wikipedia-search-button")
	WebElement wikipediaSearchBtn;

	@FindBy(xpath = "//div[@id='Wikipedia1_wikipedia-search-results']//a")
	List<WebElement> searchResults;
	
	public void searchWikipedia(String keyword) {

	    wikipediaSearchBox.clear();

	    wikipediaSearchBox.sendKeys(keyword);

	    wikipediaSearchBtn.click();
	}
	public void clickSearchResult(String resultName) {

	    for(WebElement result : searchResults) {

	        if(result.getText()
	                .equalsIgnoreCase(resultName)) {

	            result.click();

	            break;
	        }
	    }
	}
	public void waitForSearchResults() {

	    WebDriverWait wait =
	            new WebDriverWait(driver,
	                    Duration.ofSeconds(10));

	    wait.until(
	            ExpectedConditions.visibilityOfAllElements(
	                    searchResults));
	}
	public String getParentWindow() {

	    return driver.getWindowHandle();
	}
	public void switchToChildWindow(
	        String parentWindow) {

	    Set<String> windows =
	            driver.getWindowHandles();

	    for(String window : windows) {

	        if(!window.equals(parentWindow)) {

	            driver.switchTo().window(window);

	            break;
	        }
	    }
	}
	public void closeCurrentTab() {

	    driver.close();
	}
	public void switchBackToParent(
	        String parentWindow) {

	    driver.switchTo().window(parentWindow);
	}
	
	// Dynamic Button
	@FindBy(xpath="//button[contains(@class,'start') or contains(@class,'stop')]")
	WebElement dynamicButton;
	
	public void handleDynamicButton() {

	    String currentText =
	            dynamicButton.getText();

	    System.out.println("Before Click: " + currentText);

	    dynamicButton.click();

	    System.out.println("After Click: "
	            + dynamicButton.getText());
	}
	
	// Alerts
	@FindBy(id="alertBtn")
	WebElement simpleAlertBtn;

	@FindBy(id="confirmBtn")
	WebElement confirmationAlertBtn;

	@FindBy(id="promptBtn")
	WebElement promptAlertBtn;

	@FindBy(id="demo")
	WebElement alertResultText;
	
	public String handleSimpleAlert() {

	    simpleAlertBtn.click();

	    Alert alert =
	            driver.switchTo().alert();

	    String text =
	            alert.getText();

	    alert.accept();

	    return text;
	}
	public String handleConfirmationAlertOK() {

	    confirmationAlertBtn.click();

	    Alert alert =
	            driver.switchTo().alert();

	    alert.accept();

	    return alertResultText.getText();
	}
	public String handleConfirmationAlertCancel() {

	    confirmationAlertBtn.click();

	    Alert alert =
	            driver.switchTo().alert();

	    alert.dismiss();

	    return alertResultText.getText();
	}
	public String handlePromptAlert(String name) {

	    promptAlertBtn.click();

	    Alert alert =
	            driver.switchTo().alert();

	    alert.sendKeys(name);

	    alert.accept();

	    return alertResultText.getText();
	}
	
	// New Tab
	@FindBy(xpath="//button[text()='New Tab']")
	WebElement newTabButton;
	
	public String openNewTab() {

	    String parent =
	            driver.getWindowHandle();

	    newTabButton.click();

	    Set<String> windows =
	            driver.getWindowHandles();

	    for(String window : windows) {

	        if(!window.equals(parent)) {

	            driver.switchTo().window(window);

	            break;
	        }
	    }

	    return parent;
	}
	
	// Pop Window
	@FindBy(id="PopUp")
	WebElement popupWindowButton;
	
	public String openPopupWindows() {

	    String parent =
	            driver.getWindowHandle();

	    popupWindowButton.click();

	    return parent;
	}
	
	// Mouse Hover
	@FindBy(xpath="//button[text()='Point Me']")
	WebElement pointMeButton;

	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement mobilesOption;

	@FindBy(xpath="//a[text()='Laptops']")
	WebElement laptopsOption;
	
	public void hoverAndSelectOption(
	        String option) {

	    Actions actions =
	            new Actions(driver);

	    actions.moveToElement(pointMeButton)
	            .perform();

	    driver.findElement(
	            By.xpath("//a[text()='" + option + "']"))
	            .click();
	}
	
	// Double Click
	@FindBy(xpath="//button[text()='Copy Text']")
	WebElement copyTextButton;
	
	public String performDoubleClickAndGetResult() {

	    Actions actions =
	            new Actions(driver);

	    actions.doubleClick(copyTextButton)
	            .perform();

	    return driver.getPageSource();
	}
	
	// Drag & Drop
	@FindBy(id="draggable")
	WebElement draggableElement;

	@FindBy(id="droppable")
	WebElement droppableElement;
	
	@FindBy(xpath="//div[@id='droppable']/p")
	WebElement dropResult;
	
	public void performDragAndDrop() {

	    Actions actions =
	            new Actions(driver);

	    actions.clickAndHold(draggableElement)
	            .moveToElement(droppableElement)
	            .release()
	            .build()
	            .perform();
	}
	public String getDropMessage() {

	    return dropResult.getText();
	}
	
	// Slider
	@FindBy(xpath = "//div[@id='slider-range']//span[1]")
	WebElement minSlider;

	@FindBy(xpath = "//div[@id='slider-range']//span[2]")
	WebElement maxSlider;

	@FindBy(id = "amount")
	WebElement amountText;
	
	public void setSliderRange() throws InterruptedException {

	    Actions actions = new Actions(driver);

	    // Move left slider to approx 200
	    actions.dragAndDropBy(minSlider, 65, 0)
	            .perform();

	    Thread.sleep(1000);

	    // Move right slider to approx 400
	    actions.dragAndDropBy(maxSlider, 75, 0)
	            .perform();

	    System.out.println("Selected Range : "
	            + amountText.getAttribute("value"));
	}
	
	// Scrolling DropDown
	@FindBy(id = "comboBox")
	WebElement comboBox;

	@FindBy(id = "dropdown")
	WebElement dropdownContainer;

	@FindBy(xpath = "//div[@id='dropdown']//div[contains(@class,'option')]")
	List<WebElement> dropdownOptions;
	
	public void selectScrollingDropdownItem(
	        String itemName) {

	    comboBox.click();

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    while(true) {

	        try {

	            WebElement item =
	                    driver.findElement(
	                            By.xpath(
	                                    "//div[@class='option' and text()='"
	                                            + itemName +
	                                            "']"));

	            item.click();

	            break;

	        } catch(Exception e) {

	            js.executeScript(
	                    "arguments[0].scrollTop="
	                            + "arguments[0].scrollHeight",
	                    dropdownContainer);
	        }
	    }
	}
	public String getSelectedDropdownValue() {

	    return comboBox.getAttribute("value");
	}
	
	// Labels & Links
	@FindBy(id = "apple")
	WebElement appleLink;

	@FindBy(id = "lenovo")
	WebElement lenovoLink;

	@FindBy(id = "dell")
	WebElement dellLink;
	
	@FindBy(xpath="//div[@id='broken-links']//a")
	List<WebElement> brokenLinks;
	
	public void openLaptopLink(
	        String linkName) {

	    WebElement link =
	            driver.findElement(
	                    By.xpath(
	                            "//div[@id='laptops']//a[text()='"
	                                    + linkName + "']"));

	    link.click();
	}
	public String switchToNewTab() {

	    String parent =
	            driver.getWindowHandle();

	    Set<String> windows =
	            driver.getWindowHandles();

	    for(String window : windows) {

	        if(!window.equals(parent)) {

	            driver.switchTo().window(window);

	            break;
	        }
	    }

	    return parent;
	}
	public void verifyBrokenLinks() {

	    for(WebElement link : brokenLinks) {

	        try {

	            String url =
	                    link.getAttribute("href");

	            HttpURLConnection conn =
	                    (HttpURLConnection)
	                            new URL(url)
	                                    .openConnection();

	            conn.setRequestMethod("HEAD");

	            conn.connect();

	            int responseCode =
	                    conn.getResponseCode();

	            System.out.println(
	                    url +
	                    " --> " +
	                    responseCode);

	        }
	        catch(Exception e) {

	            System.out.println(
	                    "Error : "
	                    + e.getMessage());
	        }
	    }
	}
}