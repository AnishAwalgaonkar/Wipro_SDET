package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class FormSectionPage {

    WebDriver driver;

    public FormSectionPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
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
    WebElement monday;

    @FindBy(id="country")
    WebElement country;

    public void fillForm()
    {
        txtName.sendKeys("Anish");
        txtEmail.sendKeys("anish@gmail.com");
        txtPhone.sendKeys("9876543210");
        txtAddress.sendKeys("Pune");

        maleRadio.click();

        monday.click();
    }
}