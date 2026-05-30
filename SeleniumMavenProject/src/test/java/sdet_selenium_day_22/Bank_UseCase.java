package sdet_selenium_day_22;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bank_UseCase {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm");

		driver.manage().window().maximize();
		
		driver.findElement(By.id("customer.firstName")).sendKeys("John");
		Thread.sleep(1000);		
		
		driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.address.street")).sendKeys("Shivaji Nagar");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.address.city")).sendKeys("Sambhajinagar");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.address.state")).sendKeys("Maharashtra");
		Thread.sleep(1000);	

		driver.findElement(By.id("customer.address.zipCode")).sendKeys("431001");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("7852416599");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.username")).sendKeys("JohnDoee12");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.password")).sendKeys("john@123");
		Thread.sleep(1000);	

		driver.findElement(By.id("repeatedPassword")).sendKeys("john@123");
		Thread.sleep(1000);	

		driver.findElement(By.cssSelector("input[value='Register']")).click();
		Thread.sleep(1000);	
		System.out.println("Registeration Successful");
		
//		driver.findElement(By.name("username")).sendKeys("JohnDoe");
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.name("password")).sendKeys("john@1234");
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//input[@value='LOG IN']")).click();
//
//		Thread.sleep(3000);
//
//		System.out.println("Login Successful");
		
//		Navigate to Fund Transfer
		
		 driver.findElement(By.linkText("Transfer Funds")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("amount")).sendKeys("50000");
		 Thread.sleep(2000);
		 
		 WebElement fromAccount = driver.findElement(By.id("fromAccountId"));
		 fromAccount.click();
		 
		 Thread.sleep(2000);


		WebElement toAccount = driver.findElement(By.id("toAccountId"));
		toAccount.click();

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Transfer']")).click();
		Thread.sleep(3000);
		
		 System.out.println("Fund Transfer Successfully");	
		 
		 
		 
		 String message = driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]")).getText();

		 System.out.println("Success Message : " + message);
			
		driver.findElement(By.linkText("Log Out")).click();

		Thread.sleep(2000);

		System.out.println("Logout Successful");

		 driver.quit();
		
	}

	

}
