package sdet_selenium_day_22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight_UseCase2 {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://blazedemo.com/");

		driver.manage().window().maximize();

		Thread.sleep(3000);

		// Select Departure City
		WebElement fromCity = driver.findElement(By.xpath("//select[@name='fromPort']"));

		fromCity.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[@value='Boston']")).click();

		System.out.println("Departure City Selected");

		Thread.sleep(2000);

		// Select Destination City
		WebElement toCity = driver.findElement(By.xpath("//select[@name='toPort']"));

		toCity.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[@value='London']")).click();

		System.out.println("Destination City Selected");

		Thread.sleep(2000);

		// Click Find Flights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		System.out.println("Flights Searched");

		Thread.sleep(3000);

		// Choose Flight
		driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[1]")).click();

		System.out.println("Flight Selected");

		Thread.sleep(3000);

		// Passenger Details
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Anish");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Sambhajinagar");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Sambhajinagar");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("431006");

		Thread.sleep(2000);

		// Card Details
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456789");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();

		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();

		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2028");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Anish");

		Thread.sleep(2000);

		// Click Purchase Flight
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		System.out.println("Flight Ticket Booked Successfully");

		Thread.sleep(3000);

		// Validate Booking ID
		String bookingID = driver.findElement(
				By.xpath("//td[contains(text(),'Id')]//following-sibling::td"))
				.getText();

		System.out.println("Booking ID : " + bookingID);

		Thread.sleep(5000);

		driver.quit();
	}

}
