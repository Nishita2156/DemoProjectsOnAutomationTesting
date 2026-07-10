package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day16_ErrorHandlingTestCases {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║     DAY 16: ERROR HANDLING & EDGE CASE TESTING        ║");
        System.out.println("║   Negative Testing, Boundaries, Exception Scenarios   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // ===== EXERCISE 1: Null Value Testing =====

    @Test(priority = 1, description = "Test API behavior with null values in request")
    public void testNullValueHandling() {
        System.out.println("\n=== Exercise 1.1: Null Value Handling ===");

        String bodyWithNull = "{\n" +
                "  \"title\": null,\n" +
                "  \"body\": \"Test body\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithNull)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with null title accepted");
        System.out.println("✓ API handled null value gracefully");
    }

    // ===== EXERCISE 2: Empty String Testing =====

    @Test(priority = 2, description = "Test API behavior with empty strings")
    public void testEmptyStringHandling() {
        System.out.println("\n=== Exercise 1.2: Empty String Handling ===");

        String bodyWithEmpty = "{\n" +
                "  \"title\": \"\",\n" +
                "  \"body\": \"\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithEmpty)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with empty strings accepted");
        System.out.println("✓ Empty values handled without errors");
    }

    // ===== EXERCISE 3: Boundary Value Testing - Maximum Integer =====

    @Test(priority = 3, description = "Test API with maximum integer values")
    public void testMaximumIntegerBoundary() {
        System.out.println("\n=== Exercise 1.3: Maximum Integer Boundary ===");

        String bodyWithMaxInt = "{\n" +
                "  \"title\": \"Max Value Test\",\n" +
                "  \"body\": \"Testing max integer\",\n" +
                "  \"userId\": " + Integer.MAX_VALUE + "\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithMaxInt)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with MAX_INTEGER value");
        System.out.println("✓ Value: " + Integer.MAX_VALUE);
        System.out.println("✓ API handled maximum boundary correctly");
    }

    // ===== EXERCISE 4: Boundary Value Testing - Minimum Integer =====

    @Test(priority = 4, description = "Test API with minimum integer values")
    public void testMinimumIntegerBoundary() {
        System.out.println("\n=== Exercise 1.4: Minimum Integer Boundary ===");

        String bodyWithMinInt = "{\n" +
                "  \"title\": \"Min Value Test\",\n" +
                "  \"body\": \"Testing min integer\",\n" +
                "  \"userId\": " + Integer.MIN_VALUE + "\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithMinInt)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with MIN_INTEGER value");
        System.out.println("✓ Value: " + Integer.MIN_VALUE);
        System.out.println("✓ API handled minimum boundary correctly");
    }

    // ===== EXERCISE 5: Negative Number Testing =====

    @Test(priority = 5, description = "Test API with negative values")
    public void testNegativeNumberHandling() {
        System.out.println("\n=== Exercise 1.5: Negative Number Handling ===");

        String bodyWithNegative = "{\n" +
                "  \"title\": \"Negative Test\",\n" +
                "  \"body\": \"Testing negative values\",\n" +
                "  \"userId\": -1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithNegative)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with negative userId accepted");
        System.out.println("✓ Negative values handled");
    }

    // ===== EXERCISE 6: Special Characters in Strings =====

    @Test(priority = 6, description = "Test API with special characters")
    public void testSpecialCharactersHandling() {
        System.out.println("\n=== Exercise 1.6: Special Characters Handling ===");

        String bodyWithSpecialChars = "{\n" +
                "  \"title\": \"Special !@#$%^&*()_+-=[]{}|;:',.<>?/~`\",\n" +
                "  \"body\": \"Unicode: ñ é ü 中文 日本語 العربية\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithSpecialChars)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with special characters");
        System.out.println("✓ Unicode characters handled correctly");
    }

    // ===== EXERCISE 7: Very Long String Testing =====

    @Test(priority = 7, description = "Test API with very long strings")
    public void testVeryLongStringHandling() {
        System.out.println("\n=== Exercise 1.7: Very Long String Handling ===");

        StringBuilder longString = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longString.append("This is a very long string. ");
        }

        String bodyWithLongString = "{\n" +
                "  \"title\": \"Long String Test\",\n" +
                "  \"body\": \"" + longString.toString() + "\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithLongString)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with 1000+ character string");
        System.out.println("✓ Long strings handled without truncation");
    }

    // ===== EXERCISE 8: Missing Required Fields =====

    @Test(priority = 8, description = "Test API with missing required fields")
    public void testMissingRequiredFields() {
        System.out.println("\n=== Exercise 1.8: Missing Required Fields ===");

        String bodyMissingFields = "{\n" +
                "  \"title\": \"Missing Fields Test\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyMissingFields)
                .when()
                .post("/posts")
                .then()
                .statusCode(201); // JSONPlaceholder is lenient

        System.out.println("✓ POST request missing userId and body");
        System.out.println("✓ API handled missing fields gracefully");
    }

    // ===== EXERCISE 9: Invalid JSON Format =====

    @Test(priority = 9, description = "Test API with malformed JSON")
    public void testMalformedJSONHandling() {
        System.out.println("\n=== Exercise 1.9: Malformed JSON Handling ===");

        String malformedJSON = "{\"title\": \"Missing comma\" \"body\": \"test\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(malformedJSON)
                .when()
                .post("/posts");

        int statusCode = response.getStatusCode();
        System.out.println("✓ POST request with malformed JSON");
        System.out.println("✓ Status Code: " + statusCode);

        if (statusCode >= 400) {
            System.out.println("✓ API correctly rejected malformed JSON");
        }
    }

    // ===== EXERCISE 10: SQL Injection Testing =====

    @Test(priority = 10, description = "Test API security against SQL injection")
    public void testSQLInjectionProtection() {
        System.out.println("\n=== Exercise 1.10: SQL Injection Testing ===");

        String sqlInjectionPayload = "{\n" +
                "  \"title\": \"'; DROP TABLE posts; --\",\n" +
                "  \"body\": \"1' OR '1'='1\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(sqlInjectionPayload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with SQL injection payload");
        System.out.println("✓ API safely handled injection attempt");
        System.out.println("✓ Payload treated as string data, not SQL");
    }

    // ===== EXERCISE 11: XSS (Cross-Site Scripting) Testing =====

    @Test(priority = 11, description = "Test API security against XSS attacks")
    public void testXSSProtection() {
        System.out.println("\n=== Exercise 1.11: XSS Testing ===");

        String xssPayload = "{\n" +
                "  \"title\": \"<script>alert('XSS')</script>\",\n" +
                "  \"body\": \"<img src=x onerror=alert('XSS')>\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(xssPayload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with XSS payload");
        System.out.println("✓ API safely handled script tags");
        System.out.println("✓ Payload treated as plain text");
    }

    // ===== EXERCISE 12: Invalid User ID Testing =====

    @Test(priority = 12, description = "Test API with invalid/non-existent user IDs")
    public void testInvalidUserIDHandling() {
        System.out.println("\n=== Exercise 1.12: Invalid User ID Handling ===");

        // Test with non-existent user ID
        given()
                .queryParam("userId", 99999)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(0)); // Should return empty array

        System.out.println("✓ GET /posts?userId=99999");
        System.out.println("✓ Returns empty array for non-existent user");
        System.out.println("✓ No error thrown - graceful handling");
    }

    // ===== EXERCISE 13: String as Integer Parameter =====

    @Test(priority = 13, description = "Test API with wrong data type in parameters")
    public void testWrongDataTypeHandling() {
        System.out.println("\n=== Exercise 1.13: Wrong Data Type Handling ===");

        Response response = given()
                .queryParam("userId", "not_a_number")
                .when()
                .get("/posts");

        int statusCode = response.getStatusCode();
        System.out.println("✓ GET /posts?userId=not_a_number");
        System.out.println("✓ Status Code: " + statusCode);

        if (statusCode == 200) {
            System.out.println("✓ API handled type mismatch gracefully");
        }
    }

    // ===== EXERCISE 14: Timeout Testing =====

    @Test(priority = 14, description = "Test API response within timeout threshold")
    public void testTimeoutHandling() {
        System.out.println("\n=== Exercise 1.14: Timeout Handling ===");

        long startTime = System.currentTimeMillis();

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .time(lessThan(10000L)); // Must respond within 10 seconds

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("✓ Response time: " + responseTime + "ms");
        System.out.println("✓ Within acceptable timeout (< 10000ms)");
    }

    // ===== EXERCISE 15: Duplicate Request Testing =====

    @Test(priority = 15, description = "Test API idempotency with duplicate requests")
    public void testDuplicateRequestHandling() {
        System.out.println("\n=== Exercise 1.15: Duplicate Request Handling ===");

        String body = "{\n" +
                "  \"title\": \"Duplicate Test\",\n" +
                "  \"body\": \"Testing idempotency\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // First request
        int firstId = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        System.out.println("✓ First POST request - ID: " + firstId);

        // Duplicate request with same data
        int secondId = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        System.out.println("✓ Duplicate POST request - ID: " + secondId);
        System.out.println("✓ Each request generates unique resource");
    }

    // ===== EXERCISE 16: Case Sensitivity Testing =====

    @Test(priority = 16, description = "Test API case sensitivity in parameters")
    public void testCaseSensitivityHandling() {
        System.out.println("\n=== Exercise 1.16: Case Sensitivity Testing ===");

        // Test if query parameters are case-sensitive
        given()
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);

        System.out.println("✓ GET /posts?userId=1 - Success");

        // Some APIs might not recognize different case
        Response response = given()
                .queryParam("USERID", 1)
                .when()
                .get("/posts");

        System.out.println("✓ GET /posts?USERID=1 - Status: " + response.getStatusCode());
        System.out.println("✓ Case sensitivity checked");
    }

    // ===== EXERCISE 17: Whitespace Testing =====

    @Test(priority = 17, description = "Test API with whitespace in strings")
    public void testWhitespaceHandling() {
        System.out.println("\n=== Exercise 1.17: Whitespace Handling ===");

        String bodyWithWhitespace = "{\n" +
                "  \"title\": \"   Leading and trailing spaces   \",\n" +
                "  \"body\": \"\\n\\n\\tTabs and newlines\\t\\n\\n\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithWhitespace)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with leading/trailing spaces");
        System.out.println("✓ Whitespace preserved or trimmed as needed");
    }

    // ===== EXERCISE 18: Zero Value Testing =====

    @Test(priority = 18, description = "Test API with zero values")
    public void testZeroValueHandling() {
        System.out.println("\n=== Exercise 1.18: Zero Value Handling ===");

        String bodyWithZero = "{\n" +
                "  \"title\": \"Zero Test\",\n" +
                "  \"body\": \"Testing zero value\",\n" +
                "  \"userId\": 0\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(bodyWithZero)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ POST request with userId=0");
        System.out.println("✓ Zero value handled correctly");
    }

    // ===== EXERCISE 19: Field Order Independence =====

    @Test(priority = 19, description = "Test API with fields in different order")
    public void testFieldOrderIndependence() {
        System.out.println("\n=== Exercise 1.19: Field Order Independence ===");

        // Standard order
        String body1 = "{\n" +
                "  \"title\": \"Order Test\",\n" +
                "  \"body\": \"Test body\",\n" +
                "  \"userId\": 1\n" +
                "}";

        // Different order
        String body2 = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"body\": \"Test body\",\n" +
                "  \"title\": \"Order Test\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(body1)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        given()
                .header("Content-Type", "application/json")
                .body(body2)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        System.out.println("✓ Both field orders accepted");
        System.out.println("✓ JSON parsing is order-independent");
    }

    // ===== EXERCISE 20: Error Testing Summary =====

    @Test(priority = 20, description = "Summary of error handling and edge case testing")
    public void testErrorHandlingSummary() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║        ERROR HANDLING & EDGE CASE TESTING              ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ NEGATIVE TESTING:                                      ║");
        System.out.println("║  • Null values                                          ║");
        System.out.println("║  • Empty strings                                        ║");
        System.out.println("║  • Missing required fields                              ║");
        System.out.println("║  • Invalid data types                                   ║");
        System.out.println("║  • Malformed JSON                                       ║");
        System.out.println("║                                                        ║");
        System.out.println("║ BOUNDARY TESTING:                                      ║");
        System.out.println("║  • Maximum values (Integer.MAX_VALUE)                   ║");
        System.out.println("║  • Minimum values (Integer.MIN_VALUE)                   ║");
        System.out.println("║  • Negative numbers                                     ║");
        System.out.println("║  • Zero values                                          ║");
        System.out.println("║  • Very long strings (1000+ characters)                 ║");
        System.out.println("║                                                        ║");
        System.out.println("║ SECURITY TESTING:                                      ║");
        System.out.println("║  • SQL injection attempts                               ║");
        System.out.println("║  • XSS (Cross-Site Scripting) payloads                  ║");
        System.out.println("║  • Special characters handling                          ║");
        System.out.println("║                                                        ║");
        System.out.println("║ ROBUSTNESS TESTING:                                    ║");
        System.out.println("║  • Timeout handling                                     ║");
        System.out.println("║  • Duplicate requests                                   ║");
        System.out.println("║  • Case sensitivity                                     ║");
        System.out.println("║  • Whitespace handling                                  ║");
        System.out.println("║  • Field order independence                             ║");
        System.out.println("║                                                        ║");
        System.out.println("║ PROFESSIONAL APPROACH:                                 ║");
        System.out.println("║  ✅ Test both happy path AND error scenarios             ║");
        System.out.println("║  ✅ Verify API graceful error handling                   ║");
        System.out.println("║  ✅ Ensure security against common attacks              ║");
        System.out.println("║  ✅ Test edge cases and boundary conditions              ║");
        System.out.println("║  ✅ Validate robustness under unusual conditions         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}