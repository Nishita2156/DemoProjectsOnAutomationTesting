package org.example;

import java.sql.*;

public class DatabaseHelper {

    private static final String DB_URL = "jdbc:sqlite:testdb.db";
    private Connection connection;

    // Constructor - Connect to database
    public DatabaseHelper() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("✓ Connected to SQLite database");
        } catch (Exception e) {
            System.err.println("✗ Database connection failed: " + e.getMessage());
        }
    }

    // Execute SELECT query
    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    // Execute INSERT/UPDATE/DELETE query
    public int executeUpdate(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

    // Get single value from database
    public String getValue(String sql) throws SQLException {
        ResultSet resultSet = executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    // Get row count
    public int getRowCount(String tableName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        ResultSet resultSet = executeQuery(sql);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    // Check if record exists
    public boolean recordExists(String sql) throws SQLException {
        ResultSet resultSet = executeQuery(sql);
        return resultSet.next();
    }

    // Create test table
    public void createTable(String sql) throws SQLException {
        executeUpdate(sql);
        System.out.println("✓ Table created");
    }

    // Clear table
    public void clearTable(String tableName) throws SQLException {
        executeUpdate("DELETE FROM " + tableName);
        System.out.println("✓ Table " + tableName + " cleared");
    }

    // Close connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("✓ Database connection closed");
            }
        } catch (SQLException e) {
            System.err.println("✗ Error closing connection: " + e.getMessage());
        }
    }

    // Get connection
    public Connection getConnection() {
        return connection;
    }
}
