package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static reportFactory factory =  new reportFactory();
    Country country = new Country();
    City city = new City();

    public void showCountries(ArrayList<Country> c){

        for(int i = 1; i < c.size() + 1; i++ )
        {
            System.out.println(
                    c.get(i).code + " "
                    + c.get(i).name + " "
                    + c.get(i).continent + " "
                    + c.get(i).region + " "
                    + c.get(i).population + " "
                    + c.get(i).capital + "\n" );
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        ConnectionProvider a = ConnectionProvider.getInstance();

        String area;
        int query;
        int n;
        ArrayList<Country> Countries = new ArrayList<>();

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
            // This switch is responsible for determining which type of report to create i.e Country or City
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
                            int choice2;
                            System.out.println("Please enter the area you wish to generate a report for: ");
                            System.out.println("1 - Region");
                            System.out.println("2 - Continent");
                            System.out.println("3 - World");

                            choice2 = scanner.nextInt();

                            switch(choice2){
                                case 1:
                                    System.out.println("Please enter the name of the region");
                                    area = scanner1.nextLine();
                                    System.out.println("Please enter the number of countries in the report: ");
                                    n = scanner1.nextInt();
                                    Countries = factory.countryReportMaker(2, n, "Region", area);
                                    running = false;

                                break;

                                case 2:
                                    System.out.println("Please enter the name of the Continent");
                                    area = scanner1.nextLine();
                                    System.out.println("Please enter the number of countries in the report: ");
                                    n = scanner1.nextInt();
                                    Countries = factory.countryReportMaker(2, n, "Continent", area);
                                    running = false;

                                break;

                                case 3:
                                    System.out.println("Please enter the number of countries in the report: ");
                                    n = scanner1.nextInt();
                                    Countries = factory.countryReportMaker(2, n, "World", "Placeholder");
                                    running = false;

                                break;

                            }
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
                                    factory.countryReportMaker(1, 0, "Region", area);
                                    running = false;

                                break;

                                case 2:
                                    // Gets user input as to the name of the requested continent and sends it alongside 'Continent' to the factory
                                    System.out.println("Please enter the name of the continent");
                                    area = scanner1.nextLine();
                                    factory.countryReportMaker(1, 0, "Continent",area);
                                    running = false;
                                break;

                                case 3:
                                    // Sends "World" as input to the factory class to print ALL countries of the world
                                    factory.countryReportMaker(1, 0, "World","placeholder");
                                    running = false;
                                break;
                            }
                        break;
                        // Case for single country
                        case 3:
                            System.out.println("Please enter the country you wish to generate a report for: ");
                            area = scanner1.nextLine();
                            factory.countryReportMaker(3, 0, "Placeholder", area);
                            running = false;

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

        App show = new App();
        show.showCountries(Countries);

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
