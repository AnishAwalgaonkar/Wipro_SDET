package sdet_selenium_day_24;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 
public class Demoqa_select_menu {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
        driver.findElement(By.id("react-select-2-input")).sendKeys("Group 1, option 1");
		Thread.sleep(5000);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
 
        driver.findElement(By.id("react-select-3-input")).sendKeys("Dr.");
		Thread.sleep(5000);
		driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
		
		WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(dropdown);		
		select.selectByVisibleText("Purple");
		Thread.sleep(5000);
		
		driver.findElement(By.id("react-select-4-input")).sendKeys("Black");
		driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("react-select-4-input")).sendKeys("Red");
		Thread.sleep(5000);
		driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("cars")).sendKeys("Audi");
		Thread.sleep(5000);
		
		driver.quit();	
	}
}
