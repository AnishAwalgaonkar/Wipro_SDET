package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ActionsPage {

    WebDriver driver;

    public ActionsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void dragAndDrop()
    {
        WebElement source =
                driver.findElement(By.id("draggable"));

        WebElement target =
                driver.findElement(By.id("droppable"));

        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true)",
                        source);

        Actions actions =
                new Actions(driver);

        actions.dragAndDrop(source,target)
                .build()
                .perform();
    }

    @FindBy(xpath = "//div[@id='slider-range']//span[1]")
    WebElement leftSlider;

    @FindBy(xpath = "//div[@id='slider-range']//span[2]")
    WebElement rightSlider;

    public void adjustSliderRange()
    {
        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        leftSlider);

        Actions actions =
                new Actions(driver);

        actions.clickAndHold(leftSlider)
                .moveByOffset(40,0)
                .release()
                .perform();

        actions.clickAndHold(rightSlider)
                .moveByOffset(-40,0)
                .release()
                .perform();
    }
}