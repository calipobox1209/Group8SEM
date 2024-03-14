package com.napier.sem;
//class contains function calls and objects that have not been built yet instances of this have been commented out

public class reportFactory {

    //Country countryReport = new Country;
    //City cityReport = new City;

    //these functions will eventually have the return type of ArrayList(country/city)
    public void countryReportMaker(int query, int n, String a, String b)
    {
        switch (query) {

            case 1:

                //return countryReport.reportAllCountryByArea(a,b)
                break;
            case 2:
                //return countryReport.reportNCountryByArea(n,a,b)
                break;
            case 3:
                //return countryReport.singleCountryPop(b)
                break;
        }
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

