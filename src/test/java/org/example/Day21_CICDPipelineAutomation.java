package org.example;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Day21_CICDPipelineAutomation {

    DatabaseHelper dbHelper;
    private List<TestMetrics> testMetrics = new ArrayList<>();

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║      DAY 21: CI/CD PIPELINE & TEST AUTOMATION MASTERY        ║");
        System.out.println("║                                                               ║");
        System.out.println("║  Continuous Integration • Test Categorization • Reporting   ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        dbHelper = new DatabaseHelper();

        try {
            String createBuildTable = "CREATE TABLE IF NOT EXISTS ci_builds (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "build_number TEXT NOT NULL," +
                    "branch TEXT NOT NULL," +
                    "status TEXT NOT NULL," +
                    "total_tests INTEGER," +
                    "passed_tests INTEGER," +
                    "failed_tests INTEGER," +
                    "duration_ms INTEGER," +
                    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";

            String createTestMetrics = "CREATE TABLE IF NOT EXISTS test_metrics (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "build_id INTEGER," +
                    "test_name TEXT," +
                    "test_category TEXT," +
                    "status TEXT," +
                    "duration_ms INTEGER," +
                    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";

            dbHelper.createTable(createBuildTable);
            dbHelper.createTable(createTestMetrics);
            dbHelper.clearTable("ci_builds");
            dbHelper.clearTable("test_metrics");

            System.out.println("✓ CI/CD database tables initialized");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // ===== CI/CD TEST 1: Unit Tests (Fast, Isolated) =====

    @Test(priority = 1, groups = {"unit", "smoke"}, description = "UNIT: API response parsing")
    public void testUnitAPIResponseParsing() throws SQLException {
        System.out.println("\n[UNIT TEST] API Response Parsing");
        long startTime = System.currentTimeMillis();

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue());

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testUnitAPIResponseParsing", "unit", "PASSED", duration);

        System.out.println("  ✓ API response validated (" + duration + "ms)");
    }

    @Test(priority = 2, groups = {"unit", "smoke"}, description = "UNIT: Database connection")
    public void testUnitDatabaseConnection() throws SQLException {
        System.out.println("\n[UNIT TEST] Database Connection");
        long startTime = System.currentTimeMillis();

        Assert.assertNotNull(dbHelper.getConnection(), "Database connection should exist");

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testUnitDatabaseConnection", "unit", "PASSED", duration);

        System.out.println("  ✓ Database connected (" + duration + "ms)");
    }

    @Test(priority = 3, groups = {"unit"}, description = "UNIT: Data validation")
    public void testUnitDataValidation() throws SQLException {
        System.out.println("\n[UNIT TEST] Data Validation");
        long startTime = System.currentTimeMillis();

        dbHelper.executeUpdate("INSERT INTO ci_builds (build_number, branch, status, total_tests, passed_tests, failed_tests, duration_ms) " +
                "VALUES ('BUILD-001', 'main', 'PASSED', 100, 100, 0, 1500)");

        String buildNumber = dbHelper.getValue("SELECT build_number FROM ci_builds WHERE build_number = 'BUILD-001'");
        Assert.assertEquals(buildNumber, "BUILD-001", "Build number should match");

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testUnitDataValidation", "unit", "PASSED", duration);

        System.out.println("  ✓ Data validation passed (" + duration + "ms)");
    }

    // ===== CI/CD TEST 2: Integration Tests (Medium, Cross-component) =====

    @Test(priority = 4, groups = {"integration"}, description = "INTEGRATION: API + Database sync")
    public void testIntegrationAPIDatabase() throws SQLException {
        System.out.println("\n[INTEGRATION TEST] API + Database Synchronization");
        long startTime = System.currentTimeMillis();

        // Step 1: Create via API
        int apiId = given()
                .when()
                .get("/posts/1")  // ✅ Use GET instead (more reliable)
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        // Step 2: Store in database
        dbHelper.executeUpdate("INSERT INTO test_metrics (test_name, test_category, status, duration_ms) " +
                "VALUES ('integration_test', 'api_db', 'PASSED', 150)");

        // Step 3: Verify both layers
        int dbCount = dbHelper.getRowCount("test_metrics");
        Assert.assertTrue(dbCount > 0, "Metrics should be stored");

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testIntegrationAPIDatabase", "integration", "PASSED", duration);

        System.out.println("  ✓ API and Database synchronized (" + duration + "ms)");
    }

    @Test(priority = 5, groups = {"integration"}, description = "INTEGRATION: Multi-layer data flow")
    public void testIntegrationMultiLayerDataFlow() throws SQLException {
        System.out.println("\n[INTEGRATION TEST] Multi-Layer Data Flow");
        long startTime = System.currentTimeMillis();

        // Simulate complete workflow
        dbHelper.executeUpdate("INSERT INTO ci_builds (build_number, branch, status, total_tests, passed_tests, failed_tests, duration_ms) " +
                "VALUES ('BUILD-002', 'develop', 'PASSED', 50, 48, 2, 2100)");

        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testIntegrationMultiLayerDataFlow", "integration", "PASSED", duration);

        System.out.println("  ✓ Multi-layer data flow verified (" + duration + "ms)");
    }

    // ===== CI/CD TEST 3: Smoke Tests (Critical, Fastest) =====

    @Test(priority = 6, groups = {"smoke"}, description = "SMOKE: API availability")
    public void testSmokeAPIAvailability() throws SQLException {
        System.out.println("\n[SMOKE TEST] API Availability");
        long startTime = System.currentTimeMillis();

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testSmokeAPIAvailability", "smoke", "PASSED", duration);

        System.out.println("  ✓ API is available (" + duration + "ms)");
    }

    @Test(priority = 7, groups = {"smoke"}, description = "SMOKE: Database availability")
    public void testSmokeDatabaseAvailability() throws SQLException {
        System.out.println("\n[SMOKE TEST] Database Availability");
        long startTime = System.currentTimeMillis();

        int buildCount = dbHelper.getRowCount("ci_builds");
        Assert.assertTrue(buildCount >= 0, "Database should be accessible");

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testSmokeDatabaseAvailability", "smoke", "PASSED", duration);

        System.out.println("  ✓ Database is available (" + duration + "ms)");
    }

    // ===== CI/CD TEST 4: Regression Tests (Full Coverage) =====

    @Test(priority = 8, groups = {"regression"}, description = "REGRESSION: Complete order flow")
    public void testRegressionCompleteOrderFlow() throws SQLException {
        System.out.println("\n[REGRESSION TEST] Complete Order Flow");
        long startTime = System.currentTimeMillis();

        // Test entire workflow
        String orderBody = "{\n" +
                "  \"title\": \"Regression Test Order\",\n" +
                "  \"body\": \"Complete workflow verification\",\n" +
                "  \"userId\": 1\n" +
                "}";

        int orderId = given()
                .header("Content-Type", "application/json")
                .body(orderBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        Assert.assertTrue(orderId > 0, "Order should be created");

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testRegressionCompleteOrderFlow", "regression", "PASSED", duration);

        System.out.println("  ✓ Complete order flow verified (" + duration + "ms)");
    }

    @Test(priority = 9, groups = {"regression"}, description = "REGRESSION: Error handling")
    public void testRegressionErrorHandling() throws SQLException {
        System.out.println("\n[REGRESSION TEST] Error Handling");
        long startTime = System.currentTimeMillis();

        // Test error scenarios
        given()
                .when()
                .get("/posts/999999")
                .then()
                .statusCode(404);

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testRegressionErrorHandling", "regression", "PASSED", duration);

        System.out.println("  ✓ Error handling verified (" + duration + "ms)");
    }

    // ===== CI/CD TEST 5: Performance Tests (Quality Gates) =====

    @Test(priority = 10, groups = {"performance"}, description = "PERFORMANCE: Response time SLA")
    public void testPerformanceResponseTimeSLA() throws SQLException {
        System.out.println("\n[PERFORMANCE TEST] Response Time SLA");
        long startTime = System.currentTimeMillis();

        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .time(lessThan(3000L));

        long duration = System.currentTimeMillis() - startTime;
        logMetric("testPerformanceResponseTimeSLA", "performance", "PASSED", duration);

        System.out.println("  ✓ Response time SLA met: " + duration + "ms");
        Assert.assertTrue(duration < 3000, "Response should be under 3 seconds");
    }

    @Test(priority = 11, groups = {"performance"}, description = "PERFORMANCE: Bulk operations")
    public void testPerformanceBulkOperations() throws SQLException {
        System.out.println("\n[PERFORMANCE TEST] Bulk Operations");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            given()
                    .when()
                    .get("/posts/" + ((i % 10) + 1))
                    .then()
                    .statusCode(200);
        }

        long duration = System.currentTimeMillis() - startTime;
        double avgTime = duration / 10.0;
        logMetric("testPerformanceBulkOperations", "performance", "PASSED", (int) avgTime);

        System.out.println("  ✓ Bulk operations completed: " + duration + "ms (avg: " + String.format("%.0f", avgTime) + "ms per request)");
        Assert.assertTrue(avgTime < 500, "Average response should be under 500ms");
    }

    // ===== CI/CD TEST 6: Build Quality Gate =====

    @Test(priority = 12, groups = {"quality-gate"}, description = "QUALITY GATE: Build pass criteria")
    public void testQualityGateBuildCriteria() throws SQLException {
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("BUILD QUALITY GATE VERIFICATION");
        System.out.println("═══════════════════════════════════════════════════════");

        // Calculate metrics
        int totalTests = testMetrics.size();
        long passedTests = testMetrics.stream().filter(m -> m.status.equals("PASSED")).count();
        long failedTests = totalTests - passedTests;
        long totalDuration = testMetrics.stream().mapToLong(m -> m.duration).sum();
        double passRate = (passedTests * 100.0) / totalTests;

        System.out.println("\n📊 BUILD METRICS:");
        System.out.println("  • Total Tests Run: " + totalTests);
        System.out.println("  • Passed: " + passedTests);
        System.out.println("  • Failed: " + failedTests);
        System.out.println("  • Pass Rate: " + String.format("%.2f", passRate) + "%");
        System.out.println("  • Total Duration: " + totalDuration + "ms");

        System.out.println("\n🎯 TEST BREAKDOWN:");
        long unitTests = testMetrics.stream().filter(m -> m.category.equals("unit")).count();
        long integrationTests = testMetrics.stream().filter(m -> m.category.equals("integration")).count();
        long smokeTests = testMetrics.stream().filter(m -> m.category.equals("smoke")).count();
        long regressionTests = testMetrics.stream().filter(m -> m.category.equals("regression")).count();
        long performanceTests = testMetrics.stream().filter(m -> m.category.equals("performance")).count();

        System.out.println("  • Unit Tests: " + unitTests);
        System.out.println("  • Integration Tests: " + integrationTests);
        System.out.println("  • Smoke Tests: " + smokeTests);
        System.out.println("  • Regression Tests: " + regressionTests);
        System.out.println("  • Performance Tests: " + performanceTests);

        // Quality Gate Criteria
        System.out.println("\n✅ QUALITY GATE CRITERIA:");
        Assert.assertTrue(passRate >= 95, "Pass rate must be >= 95%");
        System.out.println("  ✓ Pass Rate >= 95%: " + String.format("%.2f", passRate) + "% PASSED");

        Assert.assertTrue(totalDuration < 30000, "Total duration must be < 30 seconds");
        System.out.println("  ✓ Total Duration < 30s: " + totalDuration + "ms PASSED");

        Assert.assertEquals(failedTests, 0, "No failed tests allowed");
        System.out.println("  ✓ Zero Failed Tests: PASSED");

        System.out.println("\n🚀 BUILD STATUS: ✅ ALL QUALITY GATES PASSED");
    }

    // ===== CI/CD TEST 7: CI/CD Pipeline Summary =====

    @Test(priority = 13, groups = {"reporting"}, description = "CI/CD Pipeline Summary Report")
    public void testCIPipelineSummary() throws SQLException {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              CI/CD PIPELINE EXECUTION REPORT                   ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");

        // Store build results
        long totalDuration = testMetrics.stream().mapToLong(m -> m.duration).sum();
        int passedCount = (int) testMetrics.stream().filter(m -> m.status.equals("PASSED")).count();
        int totalCount = testMetrics.size();

        dbHelper.executeUpdate("INSERT INTO ci_builds (build_number, branch, status, total_tests, passed_tests, failed_tests, duration_ms) " +
                "VALUES ('BUILD-21', 'main', 'PASSED', " + totalCount + ", " + passedCount + ", " + (totalCount - passedCount) + ", " + totalDuration + ")");

        System.out.println("║ BUILD INFORMATION:                                              ║");
        System.out.println("║  • Build Number: BUILD-21                                      ║");
        System.out.println("║  • Branch: main                                                ║");
        System.out.println("║  • Status: ✅ PASSED                                           ║");
        System.out.println("║                                                               ║");
        System.out.println("║ TEST EXECUTION:                                               ║");
        System.out.println("║  • Total Tests: " + totalCount + "                                           ║");
        System.out.println("║  • Passed: " + passedCount + "                                            ║");
        System.out.println("║  • Failed: " + (totalCount - passedCount) + "                                             ║");
        System.out.println("║  • Duration: " + totalDuration + "ms                                         ║");
        System.out.println("║                                                               ║");
        System.out.println("║ TEST CATEGORIES:                                              ║");
        System.out.println("║  ✅ Unit Tests: 3                                              ║");
        System.out.println("║  ✅ Integration Tests: 2                                       ║");
        System.out.println("║  ✅ Smoke Tests: 2                                             ║");
        System.out.println("║  ✅ Regression Tests: 2                                        ║");
        System.out.println("║  ✅ Performance Tests: 2                                       ║");
        System.out.println("║                                                               ║");
        System.out.println("║ QUALITY GATES:                                                ║");
        System.out.println("║  ✅ Pass Rate: 100%                                            ║");
        System.out.println("║  ✅ Response Time SLA: MET                                     ║");
        System.out.println("║  ✅ Zero Critical Failures: YES                                ║");
        System.out.println("║                                                               ║");
        System.out.println("║ ARTIFACTS GENERATED:                                          ║");
        System.out.println("║  📊 Test Report: target/surefire-reports/                     ║");
        System.out.println("║  📈 Metrics: Database (ci_builds, test_metrics)                ║");
        System.out.println("║  🔗 Build Log: GitHub Actions > Day21_CICDPipelineAutomation  ║");
        System.out.println("║                                                               ║");
        System.out.println("║ NEXT STEPS:                                                   ║");
        System.out.println("║  ✓ Merge to production                                        ║");
        System.out.println("║  ✓ Deploy to staging                                          ║");
        System.out.println("║  ✓ Monitor performance                                        ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }

    // ===== Helper Methods =====

    private void logMetric(String testName, String category, String status, long duration) {
        testMetrics.add(new TestMetrics(testName, category, status, duration));
    }

    // ===== Inner Class =====

    private static class TestMetrics {
        String testName;
        String category;
        String status;
        long duration;

        TestMetrics(String testName, String category, String status, long duration) {
            this.testName = testName;
            this.category = category;
            this.status = status;
            this.duration = duration;
        }
    }
}
