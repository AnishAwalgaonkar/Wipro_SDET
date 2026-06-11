package pages;

import org.openqa.selenium.*;
import java.util.*;

public class TablePage {

    WebDriver driver;

    public TablePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int getRowCount()
    {
        List<WebElement> rows=
                driver.findElements(
                        By.xpath("//table//tr"));

        return rows.size();
    }
}