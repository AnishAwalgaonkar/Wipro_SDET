package sdet_selenium_day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Demoqa_date_picker {
	public static void main(String[]args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/date-picker");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		
		driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.BACK_SPACE);
		
		driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("08/16/2025");
		driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("dateAndTimePickerInput")).click();
		
		driver.findElement(By.id("dateAndTimePickerInput")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("dateAndTimePickerInput")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("dateAndTimePickerInput")).sendKeys("August 16, 2026 10:30 AM");
		driver.findElement(By.id("dateAndTimePickerInput")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(3000);
		
		driver.quit();		
		}
 
}
 
