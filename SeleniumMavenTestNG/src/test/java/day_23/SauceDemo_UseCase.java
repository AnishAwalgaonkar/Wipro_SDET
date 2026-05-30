package day_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemo_UseCase {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Swag Labs");
		System.out.println("Title Validation Passed");
	}

	@Test(priority = 2)
	public void loginTest() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		String currentURL = driver.getCurrentUrl();

		Assert.assertTrue(currentURL.contains("inventory"));

		System.out.println("Login Test Passed");

	}

	@Test(priority = 3)
	public void verifyProductPage() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		String productText = driver.findElement(By.className("title")).getText();

		Assert.assertEquals(productText, ("Products"));

		System.out.println("Product Page Validation Passed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
