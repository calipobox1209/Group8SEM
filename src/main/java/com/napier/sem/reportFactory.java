package com.napier.sem;
//class contains function calls and objects that have not been built yet instances of this have been commented out

import java.util.ArrayList;

public class reportFactory {

    Country countryReport = new Country();
    City cityReport = new City();

    ArrayList<Country> countries = new ArrayList<>();


    public ArrayList<Country> countryReportMaker(int query, int n, String a, String b)
    {
        switch (query) {

            case 1:

                countries = countryReport.reportAllCountriesByArea(a,b);
                break;
            case 2:
                countries = countryReport.reportNCountriesByArea(a,b,n);
                break;
            case 3:
                countries = countryReport.reportSingleCountry(b);
                break;
        }

        return countries;

    }

    public void cityReportMaker(int query, int n, String a, String b)
    {
        switch (query) {
            case 1:
                //return cityReport.reportAllCitiesByArea(a,b)
                break;
            case 2:
                //return cityReport.reportNCitiesByArea(n,a,b)
                break;
            case 3:
                //return cityReport.singleCityPop(b)
                break;
        }
    }

}

