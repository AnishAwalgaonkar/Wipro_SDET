package sdet_selenium_day_22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeManagement_UseCase {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // OPEN WEBSITE

        driver.get("https://demoqa.com/webtables");

        System.out.println("DemoQA Website Opened");

        System.out.println("Admin Login Successful");

        // ADD EMPLOYEE
       WebElement addButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("addNewRecordButton")));

        js.executeScript("arguments[0].click();", addButton);

        System.out.println("Add Employee Form Opened");

        // FIRST NAME

        driver.findElement(By.id("firstName"))
                .sendKeys("Anish");

        // LAST NAME

        driver.findElement(By.id("lastName"))
                .sendKeys("Awalgaonkar");

        // EMAIL

        driver.findElement(By.id("userEmail"))
                .sendKeys("anish@gmail.com");

        // AGE

        driver.findElement(By.id("age"))
                .sendKeys("24");

        // SALARY

        driver.findElement(By.id("salary"))
                .sendKeys("50000");

        // DEPARTMENT

        driver.findElement(By.id("department"))
                .sendKeys("QA");

        // SUBMIT

        WebElement submitBtn = driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click();", submitBtn);

        System.out.println("Employee Added Successfully");

        Thread.sleep(3000);

        // SEARCH EMPLOYEE

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("searchBox")));

        searchBox.sendKeys("Anish");

        System.out.println("Employee Search Successful");

        Thread.sleep(3000);

        // UPDATE EMPLOYEE DETAILS
        WebElement editButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("edit-record-4")));

        js.executeScript("arguments[0].click();", editButton);

        System.out.println("Edit Employee Form Opened");

        // UPDATE SALARY

        WebElement salaryField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("salary")));

        salaryField.clear();

        salaryField.sendKeys("75000");

        // UPDATE DEPARTMENT

        WebElement deptField = driver.findElement(By.id("department"));

        deptField.clear();

        deptField.sendKeys("Automation Testing");

        // SAVE UPDATED DETAILS

        WebElement updateBtn = driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click();", updateBtn);

        System.out.println("Employee Details Updated");

        Thread.sleep(3000);

        // DELETE EMPLOYEE

        WebElement deleteButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("delete-record-4")));

        js.executeScript("arguments[0].click();", deleteButton);

        System.out.println("Employee Deleted Successfully");

        Thread.sleep(3000);

        // CLOSE BROWSER

        driver.quit();

        System.out.println("Browser Closed");
    }
}