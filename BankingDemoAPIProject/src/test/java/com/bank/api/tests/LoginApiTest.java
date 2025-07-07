package com.bank.api.tests;

import com.bank.api.core.BaseApiTest;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest extends BaseApiTest {

    @Test(description = "Verify login endpoint returns success")
    @Description("Tests valid login API")
    public void testValidLogin() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"username\": \"demoUser\", \"password\": \"s3cret123!\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .body("status", equalTo("success"));
    }
}