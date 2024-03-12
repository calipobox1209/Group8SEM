package com.napier.sem;

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
                //return countryReport.SingleCountryPop(a)
                break;
        }
    }

    public void cityReportMaker(int query, int n, String a)
    {
        switch (query) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

}

