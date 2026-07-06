package com.bank.api.core;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigManager.env().baseUrl();
    }
}
