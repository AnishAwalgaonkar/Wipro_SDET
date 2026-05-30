package day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT_02 {

    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://127.0.0.1:3306/testing"; 
        String dbUser = "root"; 
        String dbPassword = "root@123"; 
        String query = "SELECT username, password FROM Credentials";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("Connected to Database successfully.");

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String Username = resultSet.getString("username");
                String Password = resultSet.getString("password");

                WebDriver driver = new ChromeDriver();

                driver.get("https://saucedemo.com");
                driver.manage().window().maximize();
                System.out.println("Website Opened");

                driver.findElement(By.id("user-name")).sendKeys(Username);
                System.out.println("Username Entered : " + Username);

                driver.findElement(By.id("password")).sendKeys(Password);
                System.out.println("Password Entered");

                driver.findElement(By.id("login-button")).click();
                System.out.println("Login Button Clicked");

                System.out.println("Login Test Completed Successfully");

                driver.quit();
                System.out.println("Browser Closed");

                System.out.println("----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Database connection or query execution failed!");
            e.printStackTrace();
        } finally {
        	
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Database resources closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All SQL DDT Test Cases Executed Successfully");
    }
}
