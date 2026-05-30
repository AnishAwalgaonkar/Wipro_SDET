package stepdefinition;

import org.openqa.selenium.By;

import anish.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class LoginSteps extends BaseClass
{
 
    @Given("user launches browser")
    public void user_launches_browser()
    {
        System.out.println("Browser launched successfully");
    }
 
    @Given("user opens login page")
    public void user_opens_login_page()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
 
    // VALID LOGIN
 
    @When("user enter username {string}")
    public void user_enter_username(String username) throws InterruptedException
    {
        Thread.sleep(2000);
 
        driver.findElement(By.name("username")).sendKeys(username);
    }
 
    @When("user enter password {string}")
    public void user_enter_password(String password)
    {
        driver.findElement(By.name("password")).sendKeys(password);
    }
 
    // INVALID LOGIN
 
    @When("user enters username {string}")
    public void user_enters_username(String username) throws InterruptedException
    {
        Thread.sleep(2000);
 
        driver.findElement(By.name("username")).sendKeys(username);
    }
 
    @When("user enters password {string}")
    public void user_enters_password(String password)
    {
        driver.findElement(By.name("password")).sendKeys(password);
    }
 
    // COMMON LOGIN BUTTON
 
    @When("clicks on login button")
    public void enter_login()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
 
    // VALIDATION
 
    @Then("user should navigate to dashboard")
    public void user_should_navigate_to_dashboard()
    {
        System.out.println("Login Successful");
    }
 
    @Then("error message should display")
    public void error_message()
    {
        System.out.println("Invalid Login");
    }
}
