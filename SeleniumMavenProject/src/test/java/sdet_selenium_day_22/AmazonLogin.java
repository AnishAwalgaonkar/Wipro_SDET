package sdet_selenium_day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        searchBox.sendKeys("Boat Rockerz 512");
        searchBox.submit();
        Thread.sleep(3000);
        
        WebElement productLink = driver.findElement(By.xpath("//span[contains(text(), 'Rockerz 512 ANC')]"));
        System.out.println("Selecting: " + productLink.getText());
        productLink.click();
        Thread.sleep(3000); 
        
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        
        WebElement addToCartBtn = driver.findElement(By.className("a-button-input"));
        addToCartBtn.click();
        Thread.sleep(3000); 

        WebElement cartIcon = driver.findElement(By.id("nav-cart"));
        cartIcon.click();
        
//        id="freshAddToCartButton-announce"
        
        driver.getTitle();
}
}
