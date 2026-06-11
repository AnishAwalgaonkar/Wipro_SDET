package com.automation.tests;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC10 – Drag and Drop
 * Primary: Actions.dragAndDrop().
 * Fallback: JS simulation if the element doesn't register as dropped.
 */
public class TC10_DragAndDropTest extends BaseTest {

    @Test(priority = 1, description = "Drag 'draggable' element to 'droppable' target using Actions")
    public void testDragAndDropActions() {
        homePage.performDragAndDrop();
        String text = homePage.getDroppableText();
        log().info("Droppable text after drop: '" + text + "'");

        Assert.assertTrue(
            text.toLowerCase().contains("dropped") || !text.equals("Drop here"),
            "Drop target text should change after drop. Got: " + text);
        log().pass("Drag & Drop via Actions succeeded. Target text: '" + text + "' ✔");
    }

    @Test(priority = 2, description = "Drag and Drop via JavaScript simulation (fallback)")
    public void testDragAndDropJS() {
        resetPage();

        WebElement src = driver.findElement(By.id("draggable"));
        WebElement tgt = driver.findElement(By.id("droppable"));

        ((JavascriptExecutor) driver).executeScript(
            "function dnd(s,d){" +
            "  var e=new DragEvent('dragstart',{bubbles:true,cancelable:true,dataTransfer:new DataTransfer()});" +
            "  s.dispatchEvent(e);" +
            "  d.dispatchEvent(new DragEvent('dragover',{bubbles:true,cancelable:true}));" +
            "  d.dispatchEvent(new DragEvent('drop',{bubbles:true,cancelable:true,dataTransfer:e.dataTransfer}));" +
            "  s.dispatchEvent(new DragEvent('dragend',{bubbles:true,cancelable:true}));" +
            "}  dnd(arguments[0],arguments[1]);", src, tgt);

        WaitUtil.sleep(600);
        log().info("JS drag-and-drop fired");
        log().pass("Drag & Drop via JS simulation completed ✔");
    }

    @Test(priority = 3, description = "Verify draggable element is present on page")
    public void testDraggablePresent() {
        resetPage();
        WebElement el = driver.findElement(By.id("draggable"));
        Assert.assertTrue(el.isDisplayed(), "Draggable element should be visible");
        log().pass("Draggable element is visible ✔");
    }

    @Test(priority = 4, description = "Verify droppable target is present on page")
    public void testDroppablePresent() {
        WebElement el = driver.findElement(By.id("droppable"));
        Assert.assertTrue(el.isDisplayed(), "Droppable target should be visible");
        log().pass("Droppable target is visible ✔");
    }
}