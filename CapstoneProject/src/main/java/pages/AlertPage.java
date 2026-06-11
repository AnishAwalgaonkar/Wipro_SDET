package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class AlertPage {

    WebDriver driver;

    public AlertPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="alertBtn")
    WebElement alertButton;

    public void handleAlert()
    {
        alertButton.click();

        Alert alert=
                driver.switchTo().alert();

        alert.accept();
    }
}