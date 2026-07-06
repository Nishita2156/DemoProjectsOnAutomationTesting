package com.bank.api.core;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthUtils {

    public static String getAuthToken(String user, String pass) {
        Response res = given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"" + user + "\",\"password\":\"" + pass + "\"}")
            .when()
                .post("/auth/login");

        return res.then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}