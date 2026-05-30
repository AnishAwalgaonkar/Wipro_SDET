package sdet_selenium_day_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Flight_UseCase {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://blazedemo.com/");

        System.out.println("Flight Booking Website Opened");

        // SELECT SOURCE CITY

        WebElement fromCity = driver.findElement(
                By.name("fromPort"));

        fromCity.sendKeys("Boston");
        
        // SELECT DESTINATION CITY
        
      WebElement toCity = driver.findElement(
                By.name("toPort"));

        toCity.sendKeys("London");

        // SEARCH FLIGHTS

        driver.findElement(
                By.cssSelector("input[type='submit']"))
                .click();

        System.out.println("Searching Flights...");

        // FLUENT WAIT
        // Wait until flight table appears

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);

        WebElement flightTable = wait.until(driver1 -> {

            WebElement table = driver1.findElement(
                    By.xpath("//table[@class='table']"));

            if (table.isDisplayed()) {

                return table;
            }

            return null;
        });

        // VALIDATION

        if (flightTable.isDisplayed()) {

            System.out.println(
                    "Flight Search Results Displayed Successfully");
        }

        // PRINT FIRST FLIGHT DETAILS

        String firstFlight = driver.findElement(
                By.xpath("//table[@class='table']/tbody/tr[1]"))
                .getText();

        System.out.println(
                "First Flight Details : ");

        System.out.println(firstFlight);

        // CLOSE BROWSER

        driver.quit();

        System.out.println("Browser Closed");
    }
}