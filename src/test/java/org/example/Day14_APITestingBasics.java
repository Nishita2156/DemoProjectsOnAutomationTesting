package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day14_APITestingBasics {

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║        DAY 14: API TESTING WITH REST-ASSURED          ║");
        System.out.println("║   Learn REST API automation using JSONPlaceholder     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Set base URI for all requests
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // ===== EXERCISE 1: Simple GET Request =====

    @Test(priority = 1, description = "Simple GET request to retrieve a post")
    public void testSimpleGetRequest() {
        System.out.println("\n=== Exercise 1.1: Simple GET Request ===");

        // GET /posts/1
        Response response = get("/posts/1");

        // Print response
        System.out.println("✓ Request sent to: GET /posts/1");
        System.out.println("✓ Status Code: " + response.getStatusCode());
        System.out.println("✓ Response Time: " + response.getTime() + "ms");

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        System.out.println("✓ Status code verified: 200 OK");
    }

    // ===== EXERCISE 2: Validate Response Body =====

    @Test(priority = 2, description = "Validate response body contains expected data")
    public void testValidateResponseBody() {
        System.out.println("\n=== Exercise 1.2: Validate Response Body ===");

        // GET /posts/1 and validate response
        given()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .body("body", notNullValue());

        System.out.println("✓ Response body validated successfully");
        System.out.println("✓ Post ID is 1");
        System.out.println("✓ Title and body are present");
    }

    // ===== EXERCISE 3: Extract Response Data =====

    @Test(priority = 3, description = "Extract specific data from response")
    public void testExtractResponseData() {
        System.out.println("\n=== Exercise 1.3: Extract Response Data ===");

        // GET /posts/1 and extract data
        String title = given()
                .get("/posts/1")
                .then()
                .extract()
                .path("title");

        String body = given()
                .get("/posts/1")
                .then()
                .extract()
                .path("body");

        int userId = given()
                .get("/posts/1")
                .then()
                .extract()
                .path("userId");

        System.out.println("✓ Extracted data from response:");
        System.out.println("  Title: " + title);
        System.out.println("  Body: " + body.substring(0, 50) + "...");
        System.out.println("  User ID: " + userId);

        Assert.assertNotNull(title, "Title should not be null");
        Assert.assertNotNull(body, "Body should not be null");
        Assert.assertTrue(userId > 0, "User ID should be positive");
    }

    // ===== EXERCISE 4: GET Request with Query Parameters =====

    @Test(priority = 4, description = "GET request with query parameters")
    public void testGetWithQueryParameters() {
        System.out.println("\n=== Exercise 1.4: GET with Query Parameters ===");

        // GET /posts?userId=1&_limit=3
        given()
                .queryParam("userId", 1)
                .queryParam("_limit", 3)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", equalTo(3));

        System.out.println("✓ GET request with query parameters sent");
        System.out.println("✓ Parameters: userId=1, _limit=3");
        System.out.println("✓ Response contains 3 posts");
    }

    // ===== EXERCISE 5: POST Request =====

    @Test(priority = 5, description = "POST request to create a new resource")
    public void testPostRequest() {
        System.out.println("\n=== Exercise 1.5: POST Request ===");

        String requestBody = "{\n" +
                "  \"title\": \"Test Post\",\n" +
                "  \"body\": \"This is a test post created via API automation\",\n" +
                "  \"userId\": 1\n" +
                "}";

        int postId = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        System.out.println("✓ POST request sent");
        System.out.println("✓ Request body: " + requestBody);
        System.out.println("✓ Status Code: 201 (Created)");
        System.out.println("✓ New Post ID: " + postId);

        Assert.assertTrue(postId > 0, "Post ID should be assigned");
    }

    // ===== EXERCISE 6: PUT Request =====

    @Test(priority = 6, description = "PUT request to update an existing resource")
    public void testPutRequest() {
        System.out.println("\n=== Exercise 1.6: PUT Request (Update) ===");

        String updateBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"Updated Post Title\",\n" +
                "  \"body\": \"This post has been updated\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(updateBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Post Title"));

        System.out.println("✓ PUT request sent to update post 1");
        System.out.println("✓ Status Code: 200 (OK)");
        System.out.println("✓ Post updated successfully");
    }

    // ===== EXERCISE 7: DELETE Request =====

    @Test(priority = 7, description = "DELETE request to remove a resource")
    public void testDeleteRequest() {
        System.out.println("\n=== Exercise 1.7: DELETE Request ===");

        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);

        System.out.println("✓ DELETE request sent for post 1");
        System.out.println("✓ Status Code: 200 (OK)");
        System.out.println("✓ Post deleted successfully");
    }

    // ===== EXERCISE 8: Validate Response Headers =====

    @Test(priority = 8, description = "Validate response headers")
    public void testValidateResponseHeaders() {
        System.out.println("\n=== Exercise 1.8: Validate Response Headers ===");

        given()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"))
                .header("Server", notNullValue());

        System.out.println("✓ Response headers validated");
        System.out.println("✓ Content-Type: application/json");
        System.out.println("✓ Server header is present");
    }

    // ===== EXERCISE 9: Response Time Validation =====

    @Test(priority = 9, description = "Validate response time performance")
    public void testResponseTimeValidation() {
        System.out.println("\n=== Exercise 1.9: Response Time Validation ===");

        long responseTime = given()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getTime();

        System.out.println("✓ Response time: " + responseTime + "ms");
        Assert.assertTrue(responseTime < 5000, "Response should be within 5 seconds");
        System.out.println("✓ Response time is acceptable (< 5000ms)");
    }

    // ===== EXERCISE 10: Complex JSON Response Validation =====

    @Test(priority = 10, description = "Validate complex JSON response structure")
    public void testComplexJsonValidation() {
        System.out.println("\n=== Exercise 1.10: Complex JSON Validation ===");

        given()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", instanceOf(Integer.class))
                .body("userId", instanceOf(Integer.class))
                .body("title", instanceOf(String.class))
                .body("body", instanceOf(String.class));

        System.out.println("✓ JSON response structure validated");
        System.out.println("✓ All fields have correct data types");
    }

    // ===== EXERCISE 11: GET Multiple Resources =====

    @Test(priority = 11, description = "GET multiple resources and validate collection")
    public void testGetMultipleResources() {
        System.out.println("\n=== Exercise 1.11: GET Multiple Resources ===");

        given()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("id", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()));

        System.out.println("✓ Multiple resources retrieved");
        System.out.println("✓ Collection size is greater than 0");
        System.out.println("✓ All items have id and title");
    }

    // ===== EXERCISE 12: API Response Logging =====

    @Test(priority = 12, description = "Log API request and response for debugging")
    public void testApiResponseLogging() {
        System.out.println("\n=== Exercise 1.12: API Response Logging ===");

        Response response = given()
                .log().all() // Log request
                .when()
                .get("/posts/1")
                .then()
                .log().all() // Log response
                .statusCode(200)
                .extract()
                .response();

        System.out.println("✓ Request and response logged");
        System.out.println("✓ Useful for debugging API issues");
    }

    // ===== EXERCISE 13: API Testing Best Practices =====

    @Test(priority = 13, description = "Summary of API testing best practices")
    public void testAPIBestPractices() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║         API TESTING BEST PRACTICES                    ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Always validate status codes                        ║");
        System.out.println("║ 2. Validate response headers (Content-Type, etc)       ║");
        System.out.println("║ 3. Validate response body structure and data types     ║");
        System.out.println("║ 4. Extract and assert on specific fields               ║");
        System.out.println("║ 5. Test with various query parameters                  ║");
        System.out.println("║ 6. Test CRUD operations (Create, Read, Update, Delete) ║");
        System.out.println("║ 7. Validate response times for performance             ║");
        System.out.println("║ 8. Test error scenarios (400, 404, 500, etc)           ║");
        System.out.println("║ 9. Log requests and responses for debugging             ║");
        System.out.println("║ 10. Use data-driven testing with multiple datasets      ║");
        System.out.println("║ 11. Test authentication and authorization              ║");
        System.out.println("║ 12. Validate JSON schema and security headers           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
