package sdet_selenium_day_28;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class SearchUser_Test {
	@Test
	public void getAllUsers()
	{
		given()
		
		.when()
			.get("https://dummyjson.com/users/search?q=John")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
