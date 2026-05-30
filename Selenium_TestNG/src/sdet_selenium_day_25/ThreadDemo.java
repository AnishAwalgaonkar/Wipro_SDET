package sdet_selenium_day_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ThreadDemo {
 
	public static void main(String[] args) {
 
        WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
        
        FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
        	.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
        
        
        WebElement button = wait.until(driver1 -> driver1.findElement(By.id("visibleAfter")));
 
        button.click();
        System.out.println("Button clicked successfully");
		driver.quit();
		}
}
