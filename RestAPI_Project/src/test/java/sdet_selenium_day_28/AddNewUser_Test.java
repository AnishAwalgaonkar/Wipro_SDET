package sdet_selenium_day_28;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AddNewUser_Test {

    @Test
    public void addUser() {

        String requestBody = "{\n" +
                "\"firstName\": \"Muhammad\",\n" +
                "\"lastName\": \"Ovi\",\n" +
                "\"age\": 250\n" +
                "}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)

        .when()
            .post("https://dummyjson.com/users/add")

        .then()
            .statusCode(201)
            .log().all();
    }
}
