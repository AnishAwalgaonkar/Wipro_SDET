package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class UploadPage {

    WebDriver driver;

    public UploadPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="singleFileInput")
    WebElement upload;

    public void uploadFile()
    {
        upload.sendKeys(
        System.getProperty("user.dir")
        +"\\src\\main\\resources\\testdata\\sample.txt");
    }
}