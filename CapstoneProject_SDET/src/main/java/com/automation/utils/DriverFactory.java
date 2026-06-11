package com.automation.utils;

import com.automation.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * DriverFactory – ThreadLocal WebDriver management.
 *
 * Call DriverFactory.init()  to create a driver.
 * Call DriverFactory.get()   to retrieve the current thread's driver.
 * Call DriverFactory.quit()  to quit and remove the driver.
 */
public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() { }

    /** Initialises a browser based on config.properties [browser] key. */
    public static void init() {
        boolean headless = ConfigReader.headless();
        WebDriver driver;

        switch (ConfigReader.browser()) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions opts = new FirefoxOptions();
                if (headless) opts.addArguments("--headless");
                driver = new FirefoxDriver(opts);
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                EdgeOptions opts = new EdgeOptions();
                if (headless) opts.addArguments("--headless");
                driver = new EdgeDriver(opts);
                break;
            }
            default: {                                         // chrome
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                if (headless) {
                    opts.addArguments("--headless=new");
                    opts.addArguments("--disable-gpu");
                }
                opts.addArguments("--start-maximized",
                                  "--disable-notifications",
                                  "--no-sandbox",
                                  "--disable-dev-shm-usage");
                driver = new ChromeDriver(opts);
            }
        }

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(ConfigReader.implicitWait()))
              .pageLoadTimeout(Duration.ofSeconds(ConfigReader.pageLoadTimeout()));
        driver.manage().window().maximize();

        DRIVER.set(driver);
    }

    /** Returns the WebDriver for the current thread. */
    public static WebDriver get() {
        if (DRIVER.get() == null)
            throw new IllegalStateException("WebDriver not initialised – call DriverFactory.init() first.");
        return DRIVER.get();
    }

    /** Quits the driver and removes it from the thread-local. */
    public static void quit() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}