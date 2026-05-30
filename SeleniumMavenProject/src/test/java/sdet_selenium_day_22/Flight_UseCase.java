package sdet_selenium_day_22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flight_UseCase {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://phptravels.net/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Close Popup
        WebElement popupBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'I Understand & Continue')]")));

        popupBtn.click();

        System.out.println("Popup Closed");

        // Flights Tab
        WebElement flightsTab = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//a[contains(text(),'Flights')])[1]")));

        js.executeScript("arguments[0].click();", flightsTab);

        System.out.println("Flights Tab Clicked");

        Thread.sleep(4000);

        // FROM CITY
        WebElement from = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//input[contains(@class,'autocomplete-input')])[1]")));

        js.executeScript("arguments[0].scrollIntoView(true);", from);

        js.executeScript("arguments[0].click();", from);

        from.sendKeys("Mumbai");

        Thread.sleep(3000);

        WebElement fromSelect = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class,'autocomplete-result')])[1]")));

        js.executeScript("arguments[0].click();", fromSelect);

        System.out.println("Source Selected");

        // TO CITY
        WebElement to = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//input[contains(@class,'autocomplete-input')])[2]")));

        js.executeScript("arguments[0].click();", to);

        to.sendKeys("Delhi");

        Thread.sleep(3000);

        WebElement toSelect = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class,'autocomplete-result')])[1]")));

        js.executeScript("arguments[0].click();", toSelect);

        System.out.println("Destination Selected");

        // DATE
        WebElement date = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("departure")));

        js.executeScript("arguments[0].value='25-05-2026';", date);

        System.out.println("Date Selected");

        // PASSENGERS
        WebElement adults = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("fadults")));

        adults.clear();

        adults.sendKeys("2");

        System.out.println("Passengers Selected");

        // SEARCH BUTTON
        WebElement searchBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("flights-search")));

        js.executeScript("arguments[0].click();", searchBtn);

        System.out.println("Flight Search Successful");

    }
}