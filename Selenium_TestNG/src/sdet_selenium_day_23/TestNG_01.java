package sdet_selenium_day_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNG_01
{
 
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("Launching Browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}
	@Test
	public void loginTest()
	{
		System.out.println("Executing Login Test");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		System.out.println("Login Successful");
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Closing Browser");
		driver.quit();
		
	}
	
}
 
