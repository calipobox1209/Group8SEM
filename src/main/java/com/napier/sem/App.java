package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static reportFactory factory =  new reportFactory();
    Country country = new Country();
    City city = new City();

    /**
     * Connection to MySQL database.
     */
    public Connection con = null;

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
            catch (SQLException e)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(e.getMessage());
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
        // Create new Application
        App a = new App();

        String area;
        // Connect to database
        a.connect();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

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
            // This switch is reponsible for determining which type of report to create i.e Country or City
            switch (choice) {
                // This case is for Countries
                case 1:
                    // Implement the logic or call a method to generate and display a country report
                    int choice1;
                    System.out.println("Select an option:");
                    System.out.println("1 - Generate a list of N countries report");
                    System.out.println("2 - Generate all countries report");
                    System.out.println("3 - Generate single country report");

                    choice1 = scanner.nextInt();
                    // This switch is responsible for handling which kind of country report to generate
                    switch(choice1) {
                        // case for N countries
                        case 1:
                            System.out.println("Please enter the area you wish to generate a report for:");
                            System.out.println("1 - Region");
                            System.out.println("2 - Continent");
                            System.out.println("3 - World");
                            break;
                        // case for ALL countries
                        case 2:
                            int choice3;
                            System.out.println("Please enter the area you wish to generate a report for:");
                            System.out.println("1 - Region");
                            System.out.println("2 - Continent");
                            System.out.println("3 - World");

                            choice3 = scanner.nextInt();
                            // This switch then determines which information to send to the factory class alongside
                            switch(choice3){
                                // Gets user input as to the name of the requested region and sends it alongside 'Region' to the factory
                                case 1:
                                    System.out.println("Please enter the name of the region");
                                    area = scanner1.nextLine();
                                    factory.countryReportMaker(1, 0, "Region");

                                break;

                                case 2:
                                    // Gets user input as to the name of the requested continent and sends it alongside 'Continent' to the factory
                                    System.out.println("Please enter the name of the continent");
                                    area = scanner1.nextLine();
                                    factory.countryReportMaker(1, 0, "Continent");
                                break;

                                case 3:
                                    // Sends "World" as input to the factory class to print ALL countries of the world
                                    factory.countryReportMaker(1, 0, "World");
                                break;
                            }
                        break;
                        // Case for single country
                        case 3:
                            System.out.println("Please enter the area you wish to generate a report for:");
                            System.out.println("1 - Region");
                            System.out.println("2 - Continent");
                            System.out.println("3 - World");
                            break;


                        default:
                            System.out.println("Invalid option, please try again.");

                    }
                    break;


                case 2:
                    // Implement the logic or call a method to generate and display a city report

                    break;
                case 3:
                    // Implement the logic or call a method to generate and display a capital city report

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



    // Placeholder methods for the report generation functionalities

        //
        //add main program stuff here
        //

        // Disconnect from database
        a.disconnect();
    }
}
