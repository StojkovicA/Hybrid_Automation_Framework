package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest {

    @Test
    public void simpleApiTest(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
    }
}
