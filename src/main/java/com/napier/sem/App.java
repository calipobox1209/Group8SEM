package com.napier.sem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

import static java.lang.Math.random;

///^^^^ Package and import stuff

//this is the main app for the population database

public class App {

    //main class, facilitates user data collection via rudimentary UI
    public static void main(String[] args) {
        //instantiates country,city,and factory objects that will be used in the class
        ReportFactory factory = new ReportFactory();
        Country country = new Country();
        City city = new City();
        population population = new population();
        ExecutorService ex = Executors.newSingleThreadExecutor();

        //showreport object for display of reports to console
        ShowReports show = new ShowReports();


        // Instantiates singleton instance
        ConnectionProvider a = ConnectionProvider.getInstance();

        //user input variables for the query conditions
        String area;
        int query;
        int n;
        Random rand = new Random();
        boolean capital = false;

        //arraylists to store country and city objects
        ArrayList<Country> Countries = new ArrayList<>();
        ArrayList<City> Cities = new ArrayList<>();
        ArrayList<population> Populace = new ArrayList<>();

        // Connect to database and create scanners
        if (args.length < 1) {
            a.connect("localhost:33060", 10000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

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
                System.out.println("3 - Generate populations report");
                System.out.println("0 - Exit");

                System.out.print("Enter your choice: ");

                // Adding nextLine() to consume the rest of the line after the nextInt()|
                Future<Integer> future = (Future<Integer>) ex.submit(() -> {
                    int choice = scanner.nextInt();
                });

                try {
                    int choice = future.get(10, TimeUnit.SECONDS);




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
                        scanner.nextLine();
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
                                scanner.nextLine();

                                switch (choice2) {

                                    //top n populated countries in region report
                                    case 1:
                                        System.out.println("Please enter the name of the region");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of countries in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
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
                                        scanner1.nextLine();
                                        Countries = factory.countryReportMaker(2, n, "Continent", area);
                                        show.showCountries(Countries);
                                        running = false;

                                        break;

                                    //top n populated countries in world report
                                    case 3:
                                        System.out.println("Please enter the number of countries in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
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
                                scanner.nextLine();
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
                        int choice4a;
                        System.out.println("Select an option:");
                        System.out.println("1 - Generate a capital cities report");
                        System.out.println("2 - Generate an all cities report");


                        choice4a = scanner.nextInt();
                        scanner.nextLine();

                        switch(choice4a){
                            case 1:
                                capital = true;
                                System.out.println(capital);
                                break;

                            case 2:
                                capital = false;
                                System.out.println(capital);
                                break;

                        }

                        int choice4b;
                        System.out.println("Select an option:");
                        System.out.println("1 - Generate a list of N cities report");
                        System.out.println("2 - Generate all cities report");
                        System.out.println("3 - Generate single city report");
                        choice4b = scanner.nextInt();
                        scanner.nextLine();

                        //this switch handles what kind of city report the user wants
                        switch (choice4b){

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
                                scanner.nextLine();

                                switch (choice5){

                                    //top N populated cities in a region report
                                    case 1:

                                        System.out.println("Please enter the name of the region ");

                                        area = scanner1.nextLine();
                                        System.out.println(area);
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
                                        Cities = factory.cityReportMaker(2, n, "country.Region", area, capital);
                                        show.showCities(Cities);

                                        running = false;


                                        break;

                                    //top N populated cities in a continent report
                                    case 2:
                                        System.out.println("Please enter the name of the Continent");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
                                        Cities = factory.cityReportMaker(2, n, "country.Continent", area, capital);
                                        show.showCities(Cities);

                                        running = false;

                                        break;

                                    //top N populated cities in the world report
                                    case 3:
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
                                        Cities = factory.cityReportMaker(2, n, "World", "World", capital);
                                        show.showCities(Cities);

                                        running = false;

                                        break;

                                    //top N populated cities in a country report
                                    case 4:
                                        System.out.println("Please enter the name of the Country");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
                                        Cities = factory.cityReportMaker(2, n, "country.Name", area, capital);
                                        show.showCities(Cities);

                                        running = false;

                                        break;


                                    //top N populated cities in a district report
                                    case 5:
                                        System.out.println("Please enter the name of the District");
                                        area = scanner1.nextLine();
                                        System.out.println("Please enter the number of cities in the report: ");
                                        n = scanner1.nextInt();
                                        scanner1.nextLine();
                                        Cities = factory.cityReportMaker(2, n, "District", area, capital);
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
                                scanner.nextLine();
                                    //this switch handles which area the user wants to see all the cities from
                                    switch(choice6){

                                        //all cities in a region report
                                        case 1:
                                            System.out.println("Please enter the name of the region");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Region", area, capital);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a continent report
                                        case 2:
                                            System.out.println("Please enter the name of the continent");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Continent", area, capital);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in the world report
                                        case 3:
                                            Cities = factory.cityReportMaker(1, 0, "World", "World", capital);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a country report
                                        case 4:
                                            System.out.println("Please enter the name of the country");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "country.Name", area, capital);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                        //all cities in a district report
                                        case 5:
                                            System.out.println("Please enter the name of the district");
                                            area = scanner1.nextLine();
                                            Cities = factory.cityReportMaker(1, 0, "District", area, capital);
                                            show.showCities(Cities);

                                            running = false;

                                            break;

                                    }
                                break;

                            //generate a specific city report
                            case 3:
                                System.out.println("Please enter the city you wish to generate a report for: ");
                                area = scanner1.nextLine();
                                Cities = factory.cityReportMaker(3, 0, "Placeholder", area, capital);
                                show.showCities(Cities);
                                running = false;

                                break;


                            //if the user enters an invalid input they get asked to retry
                            default:
                                System.out.println("Invalid option, please try again.");


                        }

                        break;

                    // Add more cases for additional reports
                    // Language report case?
                    case 3:
                        int choicepop;
                        System.out.println("Please enter the type of report you wish to generate a population report for: ");
                        System.out.println("1 - Population of the world");
                        System.out.println("2 - Population of a country");
                        System.out.println("3 - Population of a city");
                        System.out.println("4 - Population of an encompassing area");
                        choicepop = scanner.nextInt();
                        scanner.nextLine();

                        switch (choicepop) {

                            // Generates population of the world report
                            case 1:

                                Populace = factory.populationReportMaker(1,"World", "placeholder");
                                show.showPopulation(Populace);
                                running = false;
                                break;
                                // generates single country population report
                            case 2:
                                System.out.println("Please enter the country you wish to generate a report for: ");
                                area = scanner1.nextLine();
                                Populace = factory.populationReportMaker(3, "placeholder", area);
                                show.showPopulation(Populace);
                                running = false;
                                break;
                                // generates single city population report
                            case 3:
                                System.out.println("Please enter the city you wish to generate a report for: ");
                                area = scanner1.nextLine();
                                Populace = factory.populationReportMaker(2, "placeholder", area);
                                show.showPopulation(Populace);
                                running = false;
                                break;
                            case 4:
                                int choicepop2;
                                System.out.println("Please enter the area you wish to generate a report for ");
                                System.out.println("1 - Population of a continent");
                                System.out.println("2 - Population of a region");
                                System.out.println("3 - Population of a district");
                                choicepop2 = scanner.nextInt();
                                scanner.nextLine();

                                switch(choicepop2){
                                    case 1:
                                        System.out.println("Please enter the name of the continent you wish to generate a report for: ");
                                        area = scanner1.nextLine();
                                        Populace = factory.populationReportMaker(1,"Continent", area);
                                        show.showPopulation(Populace);
                                        running = false;
                                        break;
                                    case 2:
                                        System.out.println("Please enter the name of the region you wish to generate a report for: ");
                                        area = scanner1.nextLine();
                                        Populace = factory.populationReportMaker(1,"Region", area);
                                        show.showPopulation(Populace);
                                        running = false;
                                        break;
                                    case 3:
                                        System.out.println("Please enter the name of the district you wish to generate a report for: ");
                                        area = scanner1.nextLine();
                                        Populace = factory.populationReportMaker(1, "placeholder", area);
                                        show.showPopulation(Populace);
                                        running = false;
                                        break;

                                    default:
                                        System.out.println("Invalid option, please try again.");
                                        break;

                                }
                            default:
                                System.out.println("Invalid option, please try again.");
                                break;


                        }
                        break;
                    // Population report case?

                    //this case exits the program
                    case 0:
                        running = false;
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    //if the user enters an invalid input they get asked to retry
                    default:
                        System.out.println("Invalid option, please try again.");
                }
                } catch (TimeoutException | InterruptedException | ExecutionException e) {
                    System.out.println("Bye");
                    System.exit(0);
                }
            }


            //the user is asked if they want to generate another report
            //if they do they get sent back to the main menu
            //if they don't the program ends
            int decision;
            System.out.println("Would you like to generate another report? 1/2");
            decision = scanner.nextInt();
            scanner.nextLine();
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





