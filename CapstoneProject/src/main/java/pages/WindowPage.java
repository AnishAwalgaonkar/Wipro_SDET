package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage {

    WebDriver driver;

    public WindowPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void openNewTab()
    {
        driver.findElement(
                By.xpath("//button[text()='New Tab']"))
                .click();
    }

    public void openNewWindow()
    {
        driver.findElement(
                By.xpath("//button[text()='Popup Windows']"))
                .click();
    }

    public void switchToNewWindow()
    {
        Set<String> windows =
                driver.getWindowHandles();

        List<String> list =
                new ArrayList<>(windows);

        driver.switchTo().window(list.get(1));
    }

    public String getWindowTitle()
    {
        return driver.getTitle();
    }

    public void closeCurrentWindow()
    {
        driver.close();
    }

    public void switchBackToParent()
    {
        Set<String> windows =
                driver.getWindowHandles();

        List<String> list =
                new ArrayList<>(windows);

        driver.switchTo().window(list.get(0));
    }
}