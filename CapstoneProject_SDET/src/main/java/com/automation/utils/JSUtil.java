package com.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * JSUtil – thin wrapper around JavascriptExecutor.
 */
public class JSUtil {

    private final JavascriptExecutor js;

    public JSUtil(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    /** Scrolls the element into the centre of the viewport. */
    public void scrollIntoView(WebElement el) {
        js.executeScript(
            "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", el);
    }

    /** Clicks the element via JS (bypasses overlap/animation issues). */
    public void click(WebElement el) {
        js.executeScript("arguments[0].click();", el);
    }

    /** Sets an input value directly (useful for date-pickers & sliders). */
    public void setValue(WebElement el, String value) {
        js.executeScript("arguments[0].value = arguments[1];", el, value);
    }

    /**
     * Sets a range-input value AND fires both 'input' and 'change' events
     * so any JS listeners (price display etc.) update.
     */
    public void setSlider(WebElement el, int value) {
        js.executeScript(
            "arguments[0].value = arguments[1];" +
            "arguments[0].dispatchEvent(new Event('input',  {bubbles:true}));" +
            "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
            el, value);
    }

    /** Highlights the element with a red border for 400 ms (debug aid). */
    public void highlight(WebElement el) {
        js.executeScript("arguments[0].style.border='3px solid red'", el);
        WaitUtil.sleep(400);
        js.executeScript("arguments[0].style.border=''", el);
    }

    public Object execute(String script, Object... args) {
        return js.executeScript(script, args);
    }
}