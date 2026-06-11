package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    public void scrollDown()
    {
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");
    }

    public void scrollToBottom()
    {
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToTop()
    {
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,0)");
    }
}