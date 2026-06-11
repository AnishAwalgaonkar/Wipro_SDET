package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.CSVDataProvider;

import java.time.Duration;

public class LoginTest_csv {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "loginData",
          dataProviderClass = CSVDataProvider.class)
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.name("username"))
                .sendKeys(username);

        driver.findElement(By.name("password"))
                .sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        if ("SUCCESS".equals(expectedResult)) {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("dashboard"),
                    "Login should be successful");

            // Logout
            driver.findElement(By.cssSelector(".oxd-userdropdown-tab"))
                    .click();

            driver.findElement(By.linkText("Logout"))
                    .click();

        } else if ("Invalid credentials".equals(expectedResult)) {

            String actualMessage =
                    driver.findElement(By.cssSelector(".oxd-alert-content-text"))
                            .getText();

            Assert.assertTrue(
                    actualMessage.contains("Invalid credentials"));

        } else if ("Required".equals(expectedResult)) {

            String validationMessage =
                    driver.findElement(
                            By.xpath("//span[contains(@class,'oxd-input-field-error-message')]"))
                            .getText();

            Assert.assertEquals(validationMessage, "Required");
        }
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}