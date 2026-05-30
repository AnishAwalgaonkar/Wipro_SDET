package hooks;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
 
import anish.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Hooks extends BaseClass
{
 
    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
 
        driver = new ChromeDriver();
 
        driver.manage().window().maximize();
 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
        System.out.println("Browser Launched");
    }
 
    @After
    public void tearDown()
    {
        driver.quit();
 
        System.out.println("Browser Closed");
    }
}
