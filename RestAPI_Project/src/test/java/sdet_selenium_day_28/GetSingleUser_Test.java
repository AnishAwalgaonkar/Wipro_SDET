package sdet_selenium_day_28;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleUser_Test 
{
	@Test
	public void getAllUsers()
	{
		given()
		
		.when()
			.get("https://dummyjson.com/users/1")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}

