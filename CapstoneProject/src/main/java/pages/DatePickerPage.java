package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DatePickerPage {

    WebDriver driver;

    public DatePickerPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="datepicker")
    WebElement datePicker;

    public void selectDate()
    {
        datePicker.sendKeys("06/10/2026");
    }
}