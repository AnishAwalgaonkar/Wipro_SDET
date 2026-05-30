package sdet_selenium_day_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SupersetLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        driver.navigate().to("https://joinsuperset.com");
        driver.manage().window().maximize();
        Thread.sleep(2000); 
        
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(2000); 
        
        driver.findElement(By.name("email")).sendKeys("awalgaonkaranish@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Krishna#0080");
        Thread.sleep(1000);
        
        System.out.println(driver.getTitle());
        
        driver.findElement(By.xpath("//input[@value='Login']")).click();
//       //*[@id="login-cloak"]/div/div[2]/div[3]/form[1]/input

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"demo_step_5\"]")).click();
        driver.findElement(By.className("MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-15tyxqi"));
//        /html/body/div[3]/div[3]/ul/li[3]
        
      
        
        System.out.println(driver.getTitle());
    }
}
