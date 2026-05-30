package sdet_selenium_day_28;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteUser_Test {

    @Test
    public void deleteUser() {

        given()

        .when()
            .delete("https://dummyjson.com/users/1")

        .then()
            .statusCode(200)
            .log().all();
    }
}