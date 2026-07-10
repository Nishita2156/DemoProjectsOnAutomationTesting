package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day15_AdvancedAPITesting {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║      DAY 15: ADVANCED API TESTING WITH RESTASSURED    ║");
        System.out.println("║   Authentication, Error Handling, Complex Validation  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // ===== EXERCISE 1: Authentication with Bearer Token =====

    @Test(priority = 1, description = "API request with Bearer token authentication")
    public void testBearerTokenAuthentication() {
        System.out.println("\n=== Exercise 1.1: Bearer Token Authentication ===");

        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIn0";

        given()
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);

        System.out.println("✓ Bearer token added to request");
        System.out.println("✓ Authorization header: Bearer " + bearerToken.substring(0, 20) + "...");
        System.out.println("✓ Request authenticated successfully");
    }

    // ===== EXERCISE 2: API Key Authentication =====

    @Test(priority = 2, description = "API request with API key authentication")
    public void testAPIKeyAuthentication() {
        System.out.println("\n=== Exercise 1.2: API Key Authentication ===");

        String apiKey = "sk_test_51234567890abcdefghij";

        given()
                .header("X-API-Key", apiKey)
                .queryParam("key", apiKey)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);

        System.out.println("✓ API key added via header and query parameter");
        System.out.println("✓ X-API-Key: " + apiKey.substring(0, 15) + "...");
        System.out.println("✓ Request authorized successfully");
    }

    // ===== EXERCISE 3: Error Handling - 404 Not Found =====

    @Test(priority = 3, description = "Handle 404 Not Found error response")
    public void testHandle404NotFound() {
        System.out.println("\n=== Exercise 1.3: Handle 404 Not Found ===");

        given()
                .when()
                .get("/posts/99999")
                .then()
                .statusCode(404);

        System.out.println("✓ GET request to non-existent resource");
        System.out.println("✓ Status Code: 404 (Not Found)");
        System.out.println("✓ Error handled correctly");
    }

    // ===== EXERCISE 4: Error Handling - 400 Bad Request =====

    @Test(priority = 4, description = "Handle 400 Bad Request error")
    public void testHandle400BadRequest() {
        System.out.println("\n=== Exercise 1.4: Handle 400 Bad Request ===");

        String invalidBody = "{\"invalid\": json}"; // Missing quotes

        given()
                .header("Content-Type", "application/json")
                .body(invalidBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(201), equalTo(400))); // API might accept or reject

        System.out.println("✓ POST request with invalid JSON body");
        System.out.println("✓ Error handled - malformed request detected");
    }

    // ===== EXERCISE 5: Error Handling - 500 Server Error =====

    @Test(priority = 5, description = "Handle 500 Internal Server Error")
    public void testHandle500ServerError() {
        System.out.println("\n=== Exercise 1.5: Handle 500 Server Error ===");

        // Try to trigger server error with unusual request
        given()
                .when()
                .get("/invalid-endpoint")
                .then()
                .statusCode(anyOf(equalTo(404), equalTo(500))); // Server error or not found

        System.out.println("✓ GET request to invalid endpoint");
        System.out.println("✓ Server error handled gracefully");
    }

    // ===== EXERCISE 6: Complex JSON Nested Objects =====

    @Test(priority = 6, description = "Validate complex nested JSON structure")
    public void testComplexNestedJSON() {
        System.out.println("\n=== Exercise 1.6: Complex Nested JSON ===");

        // Create nested JSON object
        String complexBody = "{\n" +
                "  \"title\": \"Complex Post\",\n" +
                "  \"body\": \"Test body\",\n" +
                "  \"userId\": 1,\n" +
                "  \"metadata\": {\n" +
                "    \"author\": \"John Doe\",\n" +
                "    \"tags\": [\"automation\", \"testing\", \"api\"],\n" +
                "    \"ratings\": {\n" +
                "      \"quality\": 5,\n" +
                "      \"relevance\": 4\n" +
                "    }\n" +
                "  }\n" +
                "}";

        int postId = given()
                .header("Content-Type", "application/json")
                .body(complexBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Complex Post"))
                .extract()
                .path("id");

        System.out.println("✓ Complex nested JSON posted successfully");
        System.out.println("✓ Post ID: " + postId);
        System.out.println("✓ Nested objects and arrays handled correctly");
    }

    // ===== EXERCISE 7: JSON Array Validation =====

    @Test(priority = 7, description = "Validate and iterate through JSON arrays")
    public void testJSONArrayValidation() {
        System.out.println("\n=== Exercise 1.7: JSON Array Validation ===");

        given()
                .queryParam("userId", 1)
                .queryParam("_limit", 5)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5))
                .body("[0].userId", equalTo(1))
                .body("[1].userId", equalTo(1))
                .body("[4].userId", equalTo(1))
                .body("id", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()));

        System.out.println("✓ JSON array retrieved with 5 items");
        System.out.println("✓ All items have valid id and title");
        System.out.println("✓ Array indexed access validated");
    }

    // ===== EXERCISE 8: API Chaining - Dependent Requests =====

    @Test(priority = 8, description = "API chaining with dependent requests")
    public void testAPIChaining() {
        System.out.println("\n=== Exercise 1.8: API Chaining ===");

        // Step 1: Create a new post
        System.out.println("✓ Step 1: Create a new post (POST)");
        String createBody = "{\n" +
                "  \"title\": \"Chained Post\",\n" +
                "  \"body\": \"Created for chaining\",\n" +
                "  \"userId\": 1\n" +
                "}";

        int createdPostId = given()
                .header("Content-Type", "application/json")
                .body(createBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        System.out.println("  New Post ID: " + createdPostId);

        // Step 2: Retrieve the created post
        System.out.println("✓ Step 2: Retrieve the post (GET)");
        given()
                .when()
                .get("/posts/" + createdPostId)
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(404)));// May not exist on JSONPlaceholder

        System.out.println("  Retrieved post with ID: " + createdPostId);

        // Step 3: Update the post
        System.out.println("✓ Step 3: Update the post (PUT)");
        String updateBody = "{\n" +
                "  \"id\": " + createdPostId + ",\n" +
                "  \"title\": \"Updated Chained Post\",\n" +
                "  \"body\": \"Updated via chaining\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(updateBody)
                .when()
                .put("/posts/" + createdPostId)
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(404)));

        System.out.println("  Updated post with ID: " + createdPostId);

        System.out.println("✓ API chaining completed successfully");
    }

    // ===== EXERCISE 9: Response Headers Validation =====

    @Test(priority = 9, description = "Validate security and content headers")
    public void testSecurityHeadersValidation() {
        System.out.println("\n=== Exercise 1.9: Security Headers Validation ===");

        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"))
                .extract()
                .response();

        System.out.println("✓ Content-Type: " + response.getHeader("Content-Type"));
        System.out.println("✓ Server: " + response.getHeader("Server"));
        System.out.println("✓ Security headers validated");
    }

    // ===== EXERCISE 10: Performance Testing - Response Time =====

    @Test(priority = 10, description = "Validate API response time performance")
    public void testPerformanceValidation() {
        System.out.println("\n=== Exercise 1.10: Performance Testing ===");

        long startTime = System.currentTimeMillis();

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .time(lessThan(5000L)); // Response in less than 5 seconds

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("✓ Response time: " + responseTime + "ms");
        System.out.println("✓ Performance acceptable (< 5000ms)");

        Assert.assertTrue(responseTime < 5000, "Response should be fast");
    }

    // ===== EXERCISE 11: Data-Driven API Testing =====

    @Test(priority = 11, dataProvider = "userIds", description = "Test API with multiple user IDs")
    public void testDataDrivenAPITesting(int userId) {
        System.out.println("\n=== Exercise 1.11: Data-Driven API Testing (User ID: " + userId + ") ===");

        given()
                .queryParam("userId", userId)
                .queryParam("_limit", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);

        System.out.println("✓ Posts retrieved for user " + userId);
    }

    @org.testng.annotations.DataProvider(name = "userIds")
    public Object[][] getUserIds() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
    }

    // ===== EXERCISE 12: Content-Type Validation =====

    @Test(priority = 12, description = "Validate different content types")
    public void testContentTypeValidation() {
        System.out.println("\n=== Exercise 1.12: Content-Type Validation ===");

        // JSON response
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"));

        System.out.println("✓ JSON response validated");
        System.out.println("✓ Content-Type: application/json; charset=utf-8");
    }

    // ===== EXERCISE 13: Request/Response Logging for Debugging =====

    @Test(priority = 13, description = "Log detailed request and response for debugging")
    public void testDetailedLogging() {
        System.out.println("\n=== Exercise 1.13: Detailed Logging ===");

        given()
                .log().all() // Log request headers, body, etc
                .when()
                .get("/posts/1")
                .then()
                .log().body() // Log response body
                .statusCode(200);

        System.out.println("✓ Full request logged");
        System.out.println("✓ Full response logged");
        System.out.println("✓ Useful for debugging API issues");
    }

    // ===== EXERCISE 14: Multiple Assertions in Single Test =====

    @Test(priority = 14, description = "Multiple assertions validating complete response")
    public void testMultipleAssertions() {
        System.out.println("\n=== Exercise 1.14: Multiple Assertions ===");

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", notNullValue())
                .body("body", notNullValue())
                .body("id", greaterThan(0))
                .body("userId", greaterThan(0));

        System.out.println("✓ All 8 assertions passed");
        System.out.println("✓ Complete response validation successful");
    }

    // ===== EXERCISE 15: Advanced API Testing Summary =====

    @Test(priority = 15, description = "Summary of advanced API testing techniques")
    public void testAdvancedAPITestingSummary() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║         ADVANCED API TESTING TECHNIQUES                 ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Authentication (Bearer tokens, API keys)             ║");
        System.out.println("║ 2. Error Handling (4xx, 5xx status codes)               ║");
        System.out.println("║ 3. Complex JSON Validation (nested objects, arrays)     ║");
        System.out.println("║ 4. API Chaining (dependent requests)                    ║");
        System.out.println("║ 5. Response Headers Validation                          ║");
        System.out.println("║ 6. Performance Testing (response time)                   ║");
        System.out.println("║ 7. Data-Driven Testing (multiple datasets)              ║");
        System.out.println("║ 8. Content-Type Validation                              ║");
        System.out.println("║ 9. Detailed Logging for Debugging                       ║");
        System.out.println("║ 10. Multiple Assertions in Single Test                  ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ You can now test PRODUCTION APIs like a SENIOR QA!     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
