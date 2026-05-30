package sdet_selenium_day_25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initializes ChromeDriver (Ensure WebDriverManager or path is set)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "admin", "admin123" },
            { "user", "user123" },
            { "test", "test123" }
        };
    }

    @Test(dataProvider = "loginData")
    public void testMultipleLogins(String username, String password) {
        // Locate elements and input data
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // SauceDemo throws an error message for these invalid credentials
        boolean isErrorDisplayed = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        
        // Assert that the error message appears for bad credentials
        Assert.assertTrue(isErrorDisplayed, "Error message was not displayed for credentials: " + username);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

