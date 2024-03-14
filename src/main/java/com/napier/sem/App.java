package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static Country country = new Country();
    City city = new City();
  /*  private static String CountryAreaChecker(int choice) {

        Scanner scanner = new Scanner(System.in);
        String area;
        switch (choice) {
            case 1:
                System.out.println("Please enter your desired region");
                area = scanner.nextLine();
                country.reportAllCountriesByArea(area);
                break;

            case 2:
                System.out.println("Please enter your desired continent");
                area = scanner.nextLine();
                country.reportAllCountriesByArea(area);
                break;

            default:
                System.out.println("Invalid option, please try again.");

        }
    }

    private static ArrayList<Country> NareaChecker(int choice, int N) {
        Scanner scannerN = new Scanner(System.in);
        String area;
        switch (choice) {
            case 1:
                System.out.println("Please enter your desired region");
                area = scannerN.nextLine();
                countries = country.reportNCountriesByArea(area, N);
                break;

            case 2:
                System.out.println("Please enter your desired continent");
                area = scannerN.nextLine();
                countries = country.reportNCountriesByArea(area, N);
                break;

            default:
                System.out.println("Invalid option, please try again.");

        }
        return countries;
    }
*/
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
                    int choice1;
                    System.out.println("Select an option:");
                    System.out.println("1 - Generate a list of N countries report");
                    System.out.println("2 - Generate all countries report");
                    System.out.println("3 - Generate single country report");

                    choice1 = scanner.nextInt();

                    switch(choice1) {

                        case 1:
                        break;

                        case 2:
                            int choice3;
                            System.out.println("Please enter the area you wish to generate a report for:");
                            System.out.println("Invalid option, please try again.");
                            System.out.println("1 - Region");
                            System.out.println("2 - Continent");
                            System.out.println("3 - World");

                            choice3 = scanner.nextInt();
                            switch(choice3){

                                case 1:
                                break;

                                case 2:
                                break;

                                case 3:
                                break;
                            }




                        break;

                        case 3:
                        break;

                        default:
                            System.out.println("Invalid option, please try again.");

                    }


                    break;


                case 2:
                    // Implement the logic or call a method to generate and display a city report
                    a.generateCityReport();
                    break;
                case 3:
                    // Implement the logic or call a method to generate and display a capital city report
                    a.generateCapitalCityReport();
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
