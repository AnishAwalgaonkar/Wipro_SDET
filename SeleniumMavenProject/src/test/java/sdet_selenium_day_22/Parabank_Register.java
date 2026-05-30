package sdet_selenium_day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parabank_Register {
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
		
		driver.findElement(By.id("customer.username")).sendKeys("JohnDoe");
		Thread.sleep(1000);	
		
		driver.findElement(By.id("customer.password")).sendKeys("john@1234");
		Thread.sleep(1000);	

		driver.findElement(By.id("repeatedPassword")).sendKeys("john@1234");
		Thread.sleep(1000);	

		driver.findElement(By.cssSelector("input[value='Register']")).click();
		Thread.sleep(1000);	

		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(1000);	

		System.out.println(driver.getTitle());

	}

}
