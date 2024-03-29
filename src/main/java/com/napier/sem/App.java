package com.napier.sem;

import java.util.ArrayList;
import java.util.Scanner;

///^^^^ Package and import stuff

//this is the main app for the population database

public class App {
    //instantiates country,city,and factory objects that will be used in the class
    static ReportFactory factory = new ReportFactory();
    Country country = new Country();
    City city = new City();


    //main class, facilitates user data collection via rudimentary UI
    public static void main(String[] args) {
        //showreport object for display of reports to console
        ShowReports show = new ShowReports();


        // Instantiates singleton instance
        ConnectionProvider a = ConnectionProvider.getInstance();

        //user input variables for the query conditions
        String area;
        int query;
        int n;

        //arraylists to store country and city objects
        ArrayList<Country> Countries = new ArrayList<>();
        ArrayList<City> Cities = new ArrayList<>();

        // Connect to database and create scanners
        a.connect();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        //booleans to govern the while loops
        boolean app = true;
        boolean running = true;
        //the app loop ends when the user decides to abort the program, at which time it disconnects from the database and disconnects the scanners
        while (app) {
            //running loop ends when the user decides to abort the program
            while (running) {

                Countries.clear();
                //main menu
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

                        int choice1;
                        System.out.println("Select an option:");
                        System.out.println("1 - Generate a list of N countries report");
                        System.out.println("2 - Generate all countries report");
                        System.out.println("3 - Generate single country report");

                        choice1 = scanner.nextInt();
                        // This switch is responsible for handling which kind of country report to generate
                        switch (choice1) {
                            // case for top N populated countries in an area report (N is input after the choice)
                            case 1:
                                int choice2;
                                System.out.println("Please enter the area you wish to generate a report for: ");
                                System.out.println("1 - Region");
                                System.out.println("2 - Continent");
                                System.out.println("3 - World");

                                choice2 = scanner.nextInt();

                                switch (choice2) {

                                    //top n populated countries in region report
                                    case 1:
                                        System.out.println("Please enter the name of the region");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of countries in the report: ");
                                        n = scanner1.nextInt();
                                        Countries = factory.countryReportMaker(2, n, "Region", area);
                                        show.showCountries(Countries);
                                        running = false;

                                        break;

                                    //top n populated countries in continent report
                                    case 2:
                                        System.out.println("Please enter the name of the Continent");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of countries in the report: ");
                                        n = scanner1.nextInt();
                                        Countries = factory.countryReportMaker(2, n, "Continent", area);
                                        show.showCountries(Countries);
                                        running = false;

                                        break;

                                    //top n populated countries in world report
                                    case 3:
                                        System.out.println("Please enter the number of countries in the report: ");
                                        n = scanner1.nextInt();
                                        Countries = factory.countryReportMaker(2, n, "World", "Placeholder");
                                        show.showCountries(Countries);
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
                                switch (choice3) {
                                    // Gets user input as to the name of the requested region and sends it alongside 'Region' to the factory
                                    case 1:
                                        System.out.println("Please enter the name of the region");
                                        area = scanner1.nextLine();
                                        Countries = factory.countryReportMaker(1, 0, "Region", area);
                                        show.showCountries(Countries);
                                        running = false;

                                        break;

                                    case 2:
                                        // Gets user input as to the name of the requested continent and sends it alongside 'Continent' to the factory
                                        System.out.println("Please enter the name of the continent");
                                        area = scanner1.nextLine();
                                        Countries = factory.countryReportMaker(1, 0, "Continent", area);
                                        show.showCountries(Countries);
                                        running = false;
                                        break;

                                    case 3:
                                        // Sends "World" as input to the factory class to print ALL countries of the world
                                        Countries = factory.countryReportMaker(1, 0, "World", "placeholder");
                                        show.showCountries(Countries);
                                        running = false;
                                        break;
                                }
                                break;
                            // Case for single country
                            case 3:
                                System.out.println("Please enter the country you wish to generate a report for: ");
                                area = scanner1.nextLine();
                                Countries = factory.countryReportMaker(3, 0, "Placeholder", area);
                                show.showCountries(Countries);
                                running = false;

                                break;


                            //if the user enters an invalid input they get asked to retry
                            default:
                                System.out.println("Invalid option, please try again.");

                        }
                        break;

                    //City reports menu
                    case 2:
                        int choice4;
                        System.out.println("Select an option:");
                        System.out.println("1 - Generate a list of N cities report");
                        System.out.println("2 - Generate all cities report");
                        System.out.println("3 - Generate single city report");
                        choice4 = scanner.nextInt();

                        //this switch handles what kind of city report the user wants
                        switch (choice4){

                            //top N populated cities in an area report
                            case 1:
                                int choice5;
                                System.out.println("Please enter the area you wish to generate a report for: ");
                                System.out.println("1 - Region");
                                System.out.println("2 - Continent");
                                System.out.println("3 - World");
                                System.out.println("4 - Country");
                                System.out.println("5 - District");
                                choice5 = scanner.nextInt();

                                switch (choice5){

                                    //top N populated cities in a region report
                                    case 1:
                                        System.out.println("Please enter the name of the region");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        Cities = factory.cityReportMaker(2, n, "country.Region", area);
                                        show.showCities(Cities);

                                        running = false;


                                        break;

                                    //top N populated cities in a continent report
                                    case 2:
                                        System.out.println("Please enter the name of the Continent");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        Cities = factory.cityReportMaker(2, n, "country.Continent", area);
                                        show.showCities(Cities);

                                        running = false;

                                        break;

                                    //top N populated cities in the world report
                                    case 3:
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        Cities = factory.cityReportMaker(2, n, "World", "World");
                                        show.showCities(Cities);

                                        running = false;

                                        break;

                                    //top N populated cities in a country report
                                    case 4:
                                        System.out.println("Please enter the name of the Country");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        Cities = factory.cityReportMaker(2, n, "country.Name", area);
                                        show.showCities(Cities);

                                        running = false;

                                        break;


                                    //top N populated cities in a district report
                                    case 5:
                                        System.out.println("Please enter the name of the District");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        Cities = factory.cityReportMaker(2, n, "District", area);
                                        show.showCities(Cities);

                                        running = false;

                                        break;

                                }
                            break;

                            //generate ALL cities in an area report
                            case 2:
                                int choice6;
                                System.out.println("Please enter the area you wish to generate a report for: ");
                                System.out.println("1 - Region");
                                System.out.println("2 - Continent");
                                System.out.println("3 - World");
                                System.out.println("4 - Country");
                                System.out.println("5 - District");
                                choice6 = scanner.nextInt();
                                    //this switch handles which area the user wants to see all the cities from
                                    switch(choice6){

                                        //all cities in a region report
                                        case 1:
                                            System.out.println("Please enter the name of the region");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Region", area);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a continent report
                                        case 2:
                                            System.out.println("Please enter the name of the continent");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Continent", area);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in the world report
                                        case 3:
                                            Cities = factory.cityReportMaker(1, 0, "World", "World");
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a country report
                                        case 4:
                                            System.out.println("Please enter the name of the country");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Name", area);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a district report
                                        case 5:
                                            System.out.println("Please enter the name of the district");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "District", area);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                    }
                                break;

                            //generate a specific city report
                            case 3:
                                System.out.println("Please enter the city you wish to generate a report for: ");
                                area = scanner1.nextLine();
                                Cities = factory.cityReportMaker(3, 0, "Placeholder", area);
                                show.showCities(Cities);
                                running = false;

                                break;


                            //if the user enters an invalid input they get asked to retry
                            default:
                                System.out.println("Invalid option, please try again.");


                        }

                        break;
                    case 3:
                        // Implement the logic or call a method to generate and display a capital city report

                        break;
                    // Add more cases for additional reports

                    //this case exits the program
                    case 0:
                        running = false;
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    //if the user enters an invalid input they get asked to retry
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }


            //the user is asked if they want to generate another report
            //if they do they get sent back to the main menu
            //if they don't the program ends
            int decision;
            System.out.println("Would you like to generate another report? 1/2");
            decision = scanner.nextInt();
            if(decision == 2){
                    app = false;
                    System.out.println("Goodbye!");
            }else {
                running = true;
            }

        }
        //disconnect from database and close scanner
        scanner.close();
        scanner1.close();
        a.disconnect();
    }
}





