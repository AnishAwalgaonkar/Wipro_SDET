package sdet_selenium_day_28;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FilterUser_Test {
	@Test
	public void getAllUsers()
	{
		given()
		
		.when()
			.get("https://dummyjson.com/users/filter?key=hair.color&value=Brown")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
