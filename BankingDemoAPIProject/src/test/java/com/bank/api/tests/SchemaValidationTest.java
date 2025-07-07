package com.bank.api.tests;

import com.bank.api.core.BaseApiTest;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class SchemaValidationTest extends BaseApiTest {

    @Test(description = "Validate login response matches schema")
    @Description("JSON schema validation for /auth/login")
    public void testLoginSchemaValidation() {
        String user = "testuser";  // or get from config/properties
        String pass = "testpass";  // or get from config/properties
        
        given()
            .contentType(ContentType.JSON)
            .body("{\"username\":\"" + user + "\",\"password\":\"" + pass + "\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("login-schema.json"));
    }
}
