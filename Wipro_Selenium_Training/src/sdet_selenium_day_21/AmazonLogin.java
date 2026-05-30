package sdet_selenium_day_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonLogin {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		
		
		driver.findElement(By.id("ap_email_login")).sendKeys("awalgaonkaranish@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);

		
		driver.findElement(By.id("ap_password")).sendKeys("Anish@1603");
		Thread.sleep(1000);

		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(1000);
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Boat Rockerz ");
        searchBox.submit();
        Thread.sleep(3000);
        
        String originalWindow = driver.getWindowHandle();
        
        driver.findElement(By.partialLinkText("Rockerz")).click();
        Thread.sleep(3000); 
        
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(3000);
        
        System.out.println("After Login Title: " + driver.getTitle()); 

        org.openqa.selenium.WebElement account = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();
        Thread.sleep(2000); 

        driver.findElement(By.xpath("//*[@id='nav-item-signout']/span")).click();
        System.out.println("After Sign Out Title: " + driver.getTitle());
		System.out.println(driver.getTitle());
		
		
	}
}
