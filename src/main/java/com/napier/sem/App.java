package com.napier.sem;
import java.util.Scanner;
import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public static void main(String[] args)
    {
        App app = new App();

        // Connect to database
        app.connect();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Select an option:");
            System.out.println("1 - Generate country report");
            System.out.println("2 - Generate city report");
            System.out.println("3 - Generate capital city report");
            System.out.println("0 - Exit");

            System.out.print("Enter your choice: ");
            // Adding nextLine() to consume the rest of the line after the nextInt()
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Implement the logic or call a method to generate and display a country report
                    app.generateCountryReport();
                    break;
                case 2:
                    // Implement the logic or call a method to generate and display a city report
                    app.generateCityReport();
                    break;
                case 3:
                    // Implement the logic or call a method to generate and display a capital city report
                    app.generateCapitalCityReport();
                    break;
                // Add more cases for additional reports
                case 0:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
        // Disconnect from database
        app.disconnect();
    }

    // Placeholder methods for the report generation functionalities
    private void generateCountryReport() {
        // Logic to generate and display country report
        System.out.println("Country report generated.");
    }

    private void generateCityReport() {
        // Logic to generate and display city report
        System.out.println("City report generated.");
    }

    private void generateCapitalCityReport() {
        // Logic to generate and display capital city report
        System.out.println("Capital city report generated.");
    }
}





