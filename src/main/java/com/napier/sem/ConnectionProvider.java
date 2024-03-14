package com.napier.sem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    // Step 2: Create a private static instance of the class
    private static ConnectionProvider instance;

    // Connection to MySQL database
    public Connection con = null;

    // Step 1: Make the constructor private
    private ConnectionProvider() {}

    // Step 3: Provide a public static method to get the instance
    public static ConnectionProvider getInstance() {
        if (instance == null) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.con; // return the connection object
    }

    // Connect to the MySQL database
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    // Disconnect from the MySQL database
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
