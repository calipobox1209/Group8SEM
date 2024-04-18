package com.napier.sem;
//class is essentially the nervous system of the program, connects user input with database to fulfill user needs

import java.util.ArrayList;

public class ReportFactory {
    //creating country and city objects to send user input to
    Country countryReport = new Country();
    City cityReport = new City();

    population populationReport = new population();
    //array lists to contain the output of lower level database query outputs
    ArrayList<Country> countries = new ArrayList<>();
    ArrayList<City> cities = new ArrayList<>();

    ArrayList<population> populations = new ArrayList<>();



    //managrd creating country reports based on user input, takes in a query int to decide what types of report are created, an int n that is used for
    //functions that specify list length, a string "a" denoting the area type for area sensitive functions, and finally a string b for area name
    public ArrayList<Country> countryReportMaker(int query, int n, String a, String b)
    {
        switch (query) {

            case 1:
                //since one of the options for area is the entire world, we call our special case if user input is flagged as requesting that
                if (a == "World")
                {
                    countries = countryReport.reportAllCountriesByWorld();
                }else {
                    countries = countryReport.reportAllCountriesByArea(a, b);
                }
                break;
            case 2:
                //exact sane thinking here as the above if statement
                if (a == "World")
                {
                    countries = countryReport.reportNCountriesByWorld(n);
                }else {
                    countries = countryReport.reportNCountriesByArea(a, b, n);
                }
                break;
            case 3:
                //special case for single country
                countries = countryReport.reportSingleCountry(b);
                break;
        }
        //we pass the retrieved array back to main
        return countries;

    }
    //this is the function that handles city related reports, same intake and ideas associated as above function
    public ArrayList<City> cityReportMaker(int query, int n, String a, String b, boolean capital)
    {
        switch (query) {
            case 1:
                //world special case
                if (a == "World")
                {
                    cities = cityReport.reportAllCitiesByWorld(capital);
                }else {
                    cities = cityReport.reportAllCitiesByArea(a, b, capital);
                }
                break;
            case 2:
                //world special case
                if (a == "World")
                {
                    cities = cityReport.reportNCitiesByWorld(n, capital);
                }else {
                    cities = cityReport.reportNCitiesByArea(a, b, n, capital);
                }
                break;
            case 3:
                //single city special case
                cities = cityReport.reportSingleCity(b, capital);
                break;
        }
        //passes retrieved cities array up to the main function
        return cities;
    }

    public ArrayList<population> populationReportMaker(int query, String a, String b)
    {
        switch (query) {

            case 1:
                //since one of the options for area is the entire world, we call our special case if user input is flagged as requesting that
                if (a == "World")
                {
                    populations = populationReport.reportPopulationByWorld();
                }else {
                    //populations = populationReport.reportPopulationByArea(a, b);
                    return null;
                }
                break;
            case 2:
                //exact sane thinking here as the above if statement

                break;
            case 3:
                //special case for single country
                countries = countryReport.reportSingleCountry(b);
                break;
        }
        //we pass the retrieved array back to main
        return populations;

    }

}

