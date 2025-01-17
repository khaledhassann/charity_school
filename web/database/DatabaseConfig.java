package com.rungroup.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig implements AutoCloseable{
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // Singleton instance of the connection
    private static DatabaseConfig instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConfig() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    // Public method to access the Singleton instance
    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    // Method to retrieve the connection
    public Connection getConnection() {
        return connection;
    }
    // Destructor-like method for cleanup
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to close the database connection.");
            }
        }
    }
}

