package base;

import factory.DriverFactory;
import utils.ConfigReader;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void setup()
    {
        DriverFactory.initDriver();

        DriverFactory.getDriver()
                .manage()
                .window()
                .maximize();

        DriverFactory.getDriver()
                .get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }
}