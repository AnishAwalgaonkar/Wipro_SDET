package sdet_selenium_day_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECommerce_UseCase {

    public static void main(String[] args) {
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

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        System.out.println("E-Commerce Website Opened");

        // LOGIN

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        // OPEN PRODUCT
        
        driver.findElement(
                By.linkText("Sauce Labs Backpack"))
                .click();

        System.out.println("Product Page Opened");

        // EXPLICIT WAIT


        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart")));

        // CLICK ADD TO CART

        addToCartBtn.click();

        System.out.println(
                "Product Added To Cart Successfully");

        // VALIDATION

        String cartText = driver.findElement(
                By.className("shopping_cart_badge"))
                .getText();

        System.out.println(
                "Items In Cart : " + cartText);

        // CLOSE BROWSER

        driver.quit();

        System.out.println("Browser Closed");
    }
}
