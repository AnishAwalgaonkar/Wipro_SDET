package sdet_selenium_day_21;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();		
		
		System.out.println(driver.getTitle());
		
		
	}
}
