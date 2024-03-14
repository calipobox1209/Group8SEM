package com.napier.sem;
//class contains function calls and objects that have not been built yet instances of this have been commented out

import java.lang.reflect.Array;
import java.util.ArrayList;

public class reportFactory {

    Country countryReport = new Country();
    City cityReport = new City();

    ArrayList<Country> countries = new ArrayList<>();
    ArrayList<City> cities = new ArrayList<>();


    public ArrayList<Country> countryReportMaker(int query, int n, String a, String b)
    {
        switch (query) {

            case 1:
                if (a == "World")
                {
                    countries = countryReport.reportAllCountriesByWorld();
                }else {
                    countries = countryReport.reportAllCountriesByArea(a, b);
                }
                break;
            case 2:
                if (a == "World")
                {
                    countries = countryReport.reportNCountriesByWorld(n);
                }else {
                    countries = countryReport.reportNCountriesByArea(a, b, n);
                }
                break;
            case 3:
                countries = countryReport.reportSingleCountry(b);
                break;
        }

        return countries;

    }

    public ArrayList<City> cityReportMaker(int query, int n, String a, String b)
    {
        switch (query) {
            case 1:
                cities = cityReport.reportAllCitiesByArea(a,b);
                break;
            case 2:
                cities = cityReport.reportNCitiesByArea(a,b,n);
                break;
            case 3:
                cities = cityReport.reportSingleCity(b);
                break;
        }

        return cities;
    }

}

