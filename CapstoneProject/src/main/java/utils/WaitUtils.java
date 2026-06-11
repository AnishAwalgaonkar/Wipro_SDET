package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement waitForVisibility(WebElement element)
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                        .visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element)
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(element));
    }

    public void waitForTitle(String title)
    {
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.titleContains(title));
    }
}