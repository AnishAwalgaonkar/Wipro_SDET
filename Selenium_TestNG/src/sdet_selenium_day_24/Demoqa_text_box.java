package sdet_selenium_day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoqa_text_box {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userName")).sendKeys("Anish");
		
		Thread.sleep(2000);
		driver.findElement(By.id("userEmail")).sendKeys("aa@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("currentAddress")).sendKeys("Pune");
		Thread.sleep(2000);
		driver.findElement(By.id("permanentAddress")).sendKeys("Pune");
		Thread.sleep(2000);
		
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("userName")).clear();
 
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("currentAddress")).clear();
		driver.findElement(By.id("permanentAddress")).clear();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}
 
}
