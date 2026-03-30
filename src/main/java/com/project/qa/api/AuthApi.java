package com.project.qa.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthApi {

    // This method returns the cookies after a successful login
    public static Map<String, String> getLoginCookies(String username, String password) {
        Response response = given()
                .baseUri("https://the-internet.herokuapp.com")
                .contentType(ContentType.URLENC) // Form data
                .formParam("username", username)
                .formParam("password", password)
                .when()
                .post("/authenticate")
                .then()
                .log().all()
                .statusCode(200) // HerokuApp redirects on success
                .extract()
                .response();

        return response.getCookies();
    }
}