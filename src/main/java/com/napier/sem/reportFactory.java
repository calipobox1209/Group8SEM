package com.napier.sem;
//this class contains function calls and objects that have not been built yet instances of this have been commented out

public class reportFactory {

    //Country countryReport = new Country;
    //City cityReport = new City;

    //these functions will eventually have the return type of ArrayList(country/city)
    public void countryReportMaker(int query, int n, String a)
    {
        switch (query) {

            case 1:
                //return countryReport.reportAllCountryByArea(a)
                break;
            case 2:
                //return countryReport.reportNCountryByArea(n,a)
                break;
            case 3:
                //return countryReport.singleCountryPop(a)
                break;
        }
    }

    public void cityReportMaker(int query, int n, String a)
    {
        switch (query) {
            case 1:
                //return cityReport.reportAllCitiesByArea(a)
                break;
            case 2:
                //return cityReport.reportNCitiesByArea(a,n)
                break;
            case 3:
                //return cityReport.singleCityPop(a)
                break;
        }
    }

}

