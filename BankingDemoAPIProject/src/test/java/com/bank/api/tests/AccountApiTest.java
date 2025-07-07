package com.bank.api.tests;

import com.bank.api.core.AuthUtils;
import com.bank.api.core.BaseApiTest;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AccountApiTest extends BaseApiTest {

    private String token;

    @BeforeClass
    public void generateToken() {
        token = AuthUtils.getAuthToken("demoUser", "s3cret123!");
    }

    @Test(description = "Get account details with auth token")
    @Description("Validates authenticated account retrieval")
    public void testGetAccounts() {
        given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/accounts")
        .then()
            .statusCode(200)
            .body("accounts", is(not(empty())));
    }
}
