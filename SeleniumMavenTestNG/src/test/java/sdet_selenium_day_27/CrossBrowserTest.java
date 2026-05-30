package sdet_selenium_day_27;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        if(browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
        else if(browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        // Add EdgeDriver handling here
    }

    @Test
    public void verifyLogin() {
        driver.get("https://saucedemo.com");
        // Add test steps
    }

    @AfterTest
    public void teardown() { if (driver != null) driver.quit(); }
}
