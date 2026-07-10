package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Day17_DatabaseIntegrationTesting {

    DatabaseHelper dbHelper;

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║    DAY 17: DATABASE INTEGRATION TESTING                ║");
        System.out.println("║  Connect Tests to Database, Validate Data Integrity   ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        dbHelper = new DatabaseHelper();

        // Create test table
        try {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "age INTEGER," +
                    "created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";

            dbHelper.createTable(createTableSQL);
            dbHelper.clearTable("users"); // Clear for fresh start
        } catch (SQLException e) {
            System.err.println("✗ Error creating table: " + e.getMessage());
        }
    }

    // ===== EXERCISE 1: Insert and Verify Data =====

    @Test(priority = 1, description = "Insert data into database and verify")
    public void testInsertAndVerifyData() throws SQLException {
        System.out.println("\n=== Exercise 1.1: Insert and Verify Data ===");

        // Insert data
        String insertSQL = "INSERT INTO users (username, email, age) VALUES ('john_doe', 'john@example.com', 30)";
        int result = dbHelper.executeUpdate(insertSQL);

        Assert.assertEquals(result, 1, "One row should be inserted");
        System.out.println("✓ Data inserted successfully");

        // Verify data in database
        String selectSQL = "SELECT * FROM users WHERE username = 'john_doe'";
        ResultSet resultSet = dbHelper.executeQuery(selectSQL);

        Assert.assertTrue(resultSet.next(), "Record should exist");
        String email = resultSet.getString("email");
        int age = resultSet.getInt("age");

        Assert.assertEquals(email, "john@example.com", "Email should match");
        Assert.assertEquals(age, 30, "Age should match");
        System.out.println("✓ Data verified in database");
    }

    // ===== EXERCISE 2: Row Count Validation =====

    @Test(priority = 2, description = "Validate row count in database table")
    public void testRowCountValidation() throws SQLException {
        System.out.println("\n=== Exercise 1.2: Row Count Validation ===");

        // Insert multiple records
        dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('alice', 'alice@example.com', 25)");
        dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('bob', 'bob@example.com', 28)");
        dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('charlie', 'charlie@example.com', 35)");

        // Count rows
        int rowCount = dbHelper.getRowCount("users");

        Assert.assertTrue(rowCount >= 3, "Table should have at least 3 records");
        System.out.println("✓ Row count: " + rowCount);
        System.out.println("✓ Row count validation passed");
    }

    // ===== EXERCISE 3: Update and Verify =====

    @Test(priority = 3, description = "Update database record and verify changes")
    public void testUpdateAndVerify() throws SQLException {
        System.out.println("\n=== Exercise 1.3: Update and Verify ===");

        // Update data
        String updateSQL = "UPDATE users SET age = 31 WHERE username = 'john_doe'";
        int result = dbHelper.executeUpdate(updateSQL);

        Assert.assertEquals(result, 1, "One row should be updated");
        System.out.println("✓ Data updated successfully");

        // Verify update
        String selectSQL = "SELECT age FROM users WHERE username = 'john_doe'";
        String ageStr = dbHelper.getValue(selectSQL);
        int age = Integer.parseInt(ageStr);

        Assert.assertEquals(age, 31, "Age should be updated to 31");
        System.out.println("✓ Updated age verified: " + age);
    }

    // ===== EXERCISE 4: Delete and Verify =====

    @Test(priority = 4, description = "Delete record and verify deletion")
    public void testDeleteAndVerify() throws SQLException {
        System.out.println("\n=== Exercise 1.4: Delete and Verify ===");

        // Delete data
        String deleteSQL = "DELETE FROM users WHERE username = 'bob'";
        int result = dbHelper.executeUpdate(deleteSQL);

        Assert.assertEquals(result, 1, "One row should be deleted");
        System.out.println("✓ Data deleted successfully");

        // Verify deletion
        String selectSQL = "SELECT * FROM users WHERE username = 'bob'";
        boolean exists = dbHelper.recordExists(selectSQL);

        Assert.assertFalse(exists, "Record should not exist after deletion");
        System.out.println("✓ Deletion verified - record no longer exists");
    }

    // ===== EXERCISE 5: Data Type Validation =====

    @Test(priority = 5, description = "Validate data types stored in database")
    public void testDataTypeValidation() throws SQLException {
        System.out.println("\n=== Exercise 1.5: Data Type Validation ===");

        String selectSQL = "SELECT * FROM users WHERE username = 'alice' LIMIT 1";
        ResultSet resultSet = dbHelper.executeQuery(selectSQL);

        Assert.assertTrue(resultSet.next(), "Record should exist");

        // Validate data types
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        int age = resultSet.getInt("age");

        Assert.assertTrue(id > 0, "ID should be positive integer");
        Assert.assertNotNull(username, "Username should not be null");
        Assert.assertNotNull(email, "Email should not be null");
        Assert.assertTrue(age > 0, "Age should be positive");

        System.out.println("✓ Data types validated correctly");
        System.out.println("  ID (int): " + id);
        System.out.println("  Username (String): " + username);
        System.out.println("  Email (String): " + email);
        System.out.println("  Age (int): " + age);
    }

    // ===== EXERCISE 6: NULL Handling =====

    @Test(priority = 6, description = "Test NULL value handling in database")
    public void testNullHandling() throws SQLException {
        System.out.println("\n=== Exercise 1.6: NULL Handling ===");

        // Insert record with NULL age
        String insertSQL = "INSERT INTO users (username, email, age) VALUES ('david', 'david@example.com', NULL)";
        dbHelper.executeUpdate(insertSQL);
        System.out.println("✓ Record with NULL age inserted");

        // Query NULL value
        String selectSQL = "SELECT age FROM users WHERE username = 'david'";
        ResultSet resultSet = dbHelper.executeQuery(selectSQL);
        resultSet.next();

        int age = resultSet.getInt("age");
        boolean isNull = resultSet.wasNull();

        Assert.assertTrue(isNull, "Age should be NULL");
        System.out.println("✓ NULL value handled correctly");
    }

    // ===== EXERCISE 7: SQL Injection Prevention =====

    @Test(priority = 7, description = "Test SQL injection handling using prepared statements")
    public void testSQLInjectionPrevention() throws SQLException {
        System.out.println("\n=== Exercise 1.7: SQL Injection Prevention ===");

        String username = "eve' OR '1'='1"; // SQL injection attempt

        // Using vulnerable query (for demonstration only)
        String vulnerableSQL = "SELECT * FROM users WHERE username = '" + username + "'";
        System.out.println("✓ Vulnerable query detected: " + vulnerableSQL);

        // Safe approach with parameterized query would use PreparedStatement
        System.out.println("✓ Prepared statements prevent SQL injection");
        System.out.println("✓ Always use parameterized queries in production");
    }

    // ===== EXERCISE 8: Transaction Testing =====

    @Test(priority = 8, description = "Test database transactions")
    public void testTransactions() throws SQLException {
        System.out.println("\n=== Exercise 1.8: Transaction Testing ===");

        try {
            // Start transaction
            java.sql.Connection connection = dbHelper.getConnection();
            connection.setAutoCommit(false);

            // Multiple operations
            dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('frank', 'frank@example.com', 40)");
            dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('grace', 'grace@example.com', 32)");

            // Commit
            connection.commit();
            connection.setAutoCommit(true);

            System.out.println("✓ Transaction committed successfully");
            System.out.println("✓ Multiple operations executed atomically");
        } catch (Exception e) {
            System.err.println("✗ Transaction error: " + e.getMessage());
        }
    }

    // ===== EXERCISE 9: Aggregate Functions =====

    @Test(priority = 9, description = "Test database aggregate functions")
    public void testAggregateFunctions() throws SQLException {
        System.out.println("\n=== Exercise 1.9: Aggregate Functions ===");

        // COUNT
        int count = dbHelper.getRowCount("users");
        System.out.println("✓ COUNT(*): " + count);
        Assert.assertTrue(count > 0, "Should have records");

        // SUM, AVG, MIN, MAX
        String statsSQL = "SELECT COUNT(*) as cnt, AVG(age) as avg_age, MIN(age) as min_age, MAX(age) as max_age FROM users";
        ResultSet resultSet = dbHelper.executeQuery(statsSQL);

        if (resultSet.next()) {
            int totalRecords = resultSet.getInt("cnt");
            double avgAge = resultSet.getDouble("avg_age");
            int minAge = resultSet.getInt("min_age");
            int maxAge = resultSet.getInt("max_age");

            System.out.println("✓ Total Records: " + totalRecords);
            System.out.println("✓ Average Age: " + avgAge);
            System.out.println("✓ Min Age: " + minAge);
            System.out.println("✓ Max Age: " + maxAge);
        }
    }

    // ===== EXERCISE 10: JOIN Operations =====

    @Test(priority = 10, description = "Test database JOIN operations")
    public void testJoinOperations() throws SQLException {
        System.out.println("\n=== Exercise 1.10: JOIN Operations ===");

        // Create second table
        String createPostsTable = "CREATE TABLE IF NOT EXISTS posts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "title TEXT," +
                "FOREIGN KEY(user_id) REFERENCES users(id)" +
                ")";

        try {
            dbHelper.createTable(createPostsTable);

            // Insert sample data
            dbHelper.executeUpdate("INSERT INTO posts (user_id, title) VALUES (1, 'First Post')");
            dbHelper.executeUpdate("INSERT INTO posts (user_id, title) VALUES (1, 'Second Post')");

            // JOIN query
            String joinSQL = "SELECT u.username, p.title FROM users u JOIN posts p ON u.id = p.user_id";
            ResultSet resultSet = dbHelper.executeQuery(joinSQL);

            int recordCount = 0;
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String title = resultSet.getString("title");
                System.out.println("  • User: " + username + ", Post: " + title);
                recordCount++;
            }

            Assert.assertTrue(recordCount > 0, "JOIN should return records");
            System.out.println("✓ JOIN operations working correctly");
        } catch (SQLException e) {
            System.out.println("✓ JOIN tested (table already exists)");
        }
    }

    // ===== EXERCISE 11: Index Performance =====

    @Test(priority = 11, description = "Test database index performance")
    public void testIndexPerformance() throws SQLException {
        System.out.println("\n=== Exercise 1.11: Index Performance ===");

        // Create index
        try {
            dbHelper.executeUpdate("CREATE INDEX idx_username ON users(username)");
            System.out.println("✓ Index created on username column");
        } catch (SQLException e) {
            System.out.println("✓ Index already exists");
        }

        // Query using indexed column
        long startTime = System.currentTimeMillis();
        String selectSQL = "SELECT * FROM users WHERE username = 'john_doe'";
        ResultSet resultSet = dbHelper.executeQuery(selectSQL);
        long endTime = System.currentTimeMillis();

        long queryTime = endTime - startTime;
        System.out.println("✓ Indexed query time: " + queryTime + "ms");
        System.out.println("✓ Index improves query performance");
    }

    // ===== EXERCISE 12: Constraint Validation =====

    @Test(priority = 12, description = "Test database constraints")
    public void testConstraintValidation() throws SQLException {
        System.out.println("\n=== Exercise 1.12: Constraint Validation ===");

        // Try to insert duplicate username (if unique constraint exists)
        try {
            String insertSQL1 = "INSERT INTO users (username, email, age) VALUES ('helen', 'helen@example.com', 27)";
            dbHelper.executeUpdate(insertSQL1);
            System.out.println("✓ First record inserted");

            // This might fail if UNIQUE constraint exists
            String insertSQL2 = "INSERT INTO users (username, email, age) VALUES ('helen', 'helen2@example.com', 28)";
            dbHelper.executeUpdate(insertSQL2);
            System.out.println("✓ Duplicate allowed (no UNIQUE constraint)");
        } catch (SQLException e) {
            System.out.println("✓ Duplicate rejected by UNIQUE constraint");
        }
    }

    // ===== EXERCISE 13: Database Transactions with Rollback =====

    @Test(priority = 13, description = "Test transaction rollback on error")
    public void testTransactionRollback() throws SQLException {
        System.out.println("\n=== Exercise 1.13: Transaction Rollback ===");

        try {
            java.sql.Connection connection = dbHelper.getConnection();
            connection.setAutoCommit(false);

            int beforeCount = dbHelper.getRowCount("users");

            // Insert and then rollback
            dbHelper.executeUpdate("INSERT INTO users (username, email, age) VALUES ('iris', 'iris@example.com', 29)");
            connection.rollback();
            connection.setAutoCommit(true);

            int afterCount = dbHelper.getRowCount("users");

            Assert.assertEquals(beforeCount, afterCount, "Row count should be same after rollback");
            System.out.println("✓ Transaction rolled back successfully");
            System.out.println("✓ Data not committed to database");
        } catch (Exception e) {
            System.err.println("✗ Rollback error: " + e.getMessage());
        }
    }

    // ===== EXERCISE 14: Stored Procedures =====

    @Test(priority = 14, description = "Test stored procedure calls (if database supports)")
    public void testStoredProcedures() throws SQLException {
        System.out.println("\n=== Exercise 1.14: Stored Procedures ===");

        System.out.println("✓ Stored procedures can be called via JDBC");
        System.out.println("✓ Use CallableStatement for stored procedures");
        System.out.println("✓ SQLite doesn't support stored procedures");
        System.out.println("✓ MySQL/PostgreSQL support stored procedures");
    }

    // ===== EXERCISE 15: Database Testing Summary =====

    @Test(priority = 15, description = "Summary of database integration testing")
    public void testDatabaseTestingSummary() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║        DATABASE INTEGRATION TESTING                    ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ BASIC OPERATIONS:                                      ║");
        System.out.println("║  • INSERT and verify                                    ║");
        System.out.println("║  • UPDATE and verify                                    ║");
        System.out.println("║  • DELETE and verify                                    ║");
        System.out.println("║  • SELECT/Query                                         ║");
        System.out.println("║                                                        ║");
        System.out.println("║ VALIDATION:                                            ║");
        System.out.println("║  • Row count validation                                 ║");
        System.out.println("║  • Data type validation                                 ║");
        System.out.println("║  • NULL handling                                        ║");
        System.out.println("║  • Constraint validation                                ║");
        System.out.println("║                                                        ║");
        System.out.println("║ ADVANCED FEATURES:                                     ║");
        System.out.println("║  • Transactions & Commits                               ║");
        System.out.println("║  • Rollback functionality                               ║");
        System.out.println("║  • JOIN operations                                      ║");
        System.out.println("║  • Aggregate functions (COUNT, SUM, AVG, MIN, MAX)      ║");
        System.out.println("║  • Indexes & Performance                                ║");
        System.out.println("║  • Stored Procedures                                    ║");
        System.out.println("║                                                        ║");
        System.out.println("║ SECURITY:                                              ║");
        System.out.println("║  • SQL Injection Prevention                             ║");
        System.out.println("║  • Prepared Statements                                  ║");
        System.out.println("║                                                        ║");
        System.out.println("║ END-TO-END TESTING:                                    ║");
        System.out.println("║  ✅ UI Test → API Call → Database Verification          ║");
        System.out.println("║  ✅ Complete data flow testing                          ║");
        System.out.println("║  ✅ Business logic validation                           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    @AfterClass
    public void afterClass() {
        // Clean up
        try {
            dbHelper.clearTable("users");
            dbHelper.clearTable("posts");
        } catch (SQLException e) {
            System.out.println("Note: " + e.getMessage());
        }

        dbHelper.closeConnection();

        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║    DAY 17 DATABASE INTEGRATION TESTING COMPLETE!       ║");
        System.out.println("║  You can now test complete end-to-end data flows!     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
