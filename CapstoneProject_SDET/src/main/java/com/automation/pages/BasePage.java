package com.automation.pages;

import com.automation.utils.JSUtil;
import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * BasePage – every Page Object extends this.
 * Provides driver, wait helper and JS helper; initialises @FindBy fields.
 */
public abstract class BasePage {

    protected final WebDriver driver;
    protected final WaitUtil  wait;
    protected final JSUtil    js;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WaitUtil(driver);
        this.js     = new JSUtil(driver);
        PageFactory.initElements(driver, this);
    }
}