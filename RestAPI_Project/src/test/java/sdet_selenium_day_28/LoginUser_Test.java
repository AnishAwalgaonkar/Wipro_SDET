package sdet_selenium_day_28;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class LoginUser_Test 
{
	@Test
	public void loginUser()
	{
		String requestBody = "{\r\n"
				+ "  \"username\": \"emilys\",\r\n"
				+ "  \"password\": \"emilyspass\",\r\n"
				+ "  \"expiresInMins\": 30\r\n"
				+ "}";

		given()
			.header("Content-Type", "application/json")
			.body(requestBody)

		.when()
			.post("https://dummyjson.com/user/login")

		.then()
			.statusCode(200)
			.log().all();
	}
}