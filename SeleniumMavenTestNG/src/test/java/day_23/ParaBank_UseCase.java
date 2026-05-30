package day_23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParaBank_UseCase {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        System.out.println("Browser Launched");
    }

    @Test(priority = 1)
    public void registerUser() throws InterruptedException {

        driver.findElement(By.id("customer.firstName"))
                .sendKeys("John");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.lastName"))
                .sendKeys("Doe");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.street"))
                .sendKeys("Shivaji Nagar");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.city"))
                .sendKeys("Sambhajinagar");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.state"))
                .sendKeys("Maharashtra");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.address.zipCode"))
                .sendKeys("431001");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.phoneNumber"))
                .sendKeys("7852416599");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.ssn"))
                .sendKeys("123456789");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.username"))
                .sendKeys("JohnDoe1234");

        Thread.sleep(1000);

        driver.findElement(By.id("customer.password"))
                .sendKeys("john@1234");

        Thread.sleep(1000);

        driver.findElement(By.id("repeatedPassword"))
                .sendKeys("john@1234");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[value='Register']"))
                .click();

        Thread.sleep(2000);

        String title = driver.getTitle();

        System.out.println("Page Title : " + title);

        Assert.assertEquals(title,
                "ParaBank | Customer Created");

        System.out.println("Registration Successful");
    }

    @Test(priority = 2)
    public void fundTransfer() throws InterruptedException {

        // CLICK TRANSFER FUNDS

        driver.findElement(By.linkText("Transfer Funds"))
                .click();

        Thread.sleep(2000);

        // ENTER AMOUNT

        driver.findElement(By.id("amount"))
                .sendKeys("50000");

        Thread.sleep(2000);

        // FROM ACCOUNT

        WebElement fromAccount = driver.findElement(By.id("fromAccountId"));

        fromAccount.click();

        Thread.sleep(2000);

        // TO ACCOUNT

        WebElement toAccount = driver.findElement(By.id("toAccountId"));

        toAccount.click();

        Thread.sleep(2000);

        // TRANSFER BUTTON

        driver.findElement(By.xpath("//input[@value='Transfer']"))
                .click();

        Thread.sleep(3000);

        System.out.println("Fund Transfer Successfully");

        // SUCCESS MESSAGE

        String message = driver.findElement(
                By.xpath("//h1[contains(text(),'Transfer Complete!')]"))
                .getText();

        System.out.println("Success Message : " + message);

        Assert.assertEquals(message,
                "Transfer Complete!");

        System.out.println("Transaction Validation Successful");
    }

    @Test(priority = 3)
    public void logout() throws InterruptedException {

        driver.findElement(By.linkText("Log Out"))
                .click();

        Thread.sleep(2000);

        System.out.println("Logout Successful");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}