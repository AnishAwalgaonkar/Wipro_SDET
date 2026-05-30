package sdet_selenium_day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemo_UseCase {

    public static void main(String[] args) throws InterruptedException {

    	ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--guest");

        options.addArguments("user-data-dir=/tmp/chrome-test-profile");

        options.setExperimentalOption("excludeSwitches",
                new String[]{"enable-automation"});

        options.setExperimentalOption("prefs",
                new java.util.HashMap<String, Object>() {{
                    put("credentials_enable_service", false);
                    put("profile.password_manager_enabled", false);
                    put("profile.password_manager_leak_detection", false);
                }});

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("first-name")).sendKeys("John");
        Thread.sleep(3000);
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        Thread.sleep(3000);
        driver.findElement(By.id("postal-code")).sendKeys("411001");
        Thread.sleep(3000);

        driver.findElement(By.id("continue")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("finish")).click();
        Thread.sleep(3000);

        String message = driver.findElement(By.className("complete-header")).getText();

        if(message.equals("Thank you for your order!")) {
            System.out.println("Order completed successfully");
        }

        Thread.sleep(3000);

        driver.quit();
    }
}