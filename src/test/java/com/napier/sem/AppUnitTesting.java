package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppUnitTesting {

    static ShowReports show;
    static City city;
    static Country country;
    static ReportFactory report;

    static population population;

    @BeforeAll
    static void init()
    {
        show = new ShowReports();
        city = new City();
        country = new Country();
        report = new ReportFactory();
        population = new population();
    }

    @Test
    void testCountryShowNull()
    {
        show.showCountries(null);
    }

    @Test
    void testCityShowNull()
    {
        show.showCities(null);
    }

    @Test
    void testPopShowNull()
    {
        show.showPopulation(null);
    }

    @Test
    void testCountryContainNull()
    {
        ArrayList<Country> countries =new ArrayList<Country>();
        countries.add(null);
        show.showCountries(countries);
    }

    @Test
    void testCityContainNull()
    {
        ArrayList<City> cities =new ArrayList<City>();
        cities.add(null);
        show.showCities(cities);
    }

    @Test
    void testPopulationContainNull()
    {
        ArrayList<population> populations =new ArrayList<population>();
        populations.add(null);
        show.showPopulation(populations);
    }

    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country c = new Country();
        c.population = "2900";
        c.region = "Test";
        c.capital = "Test";
        c.continent = "Test";
        c.name = "Test";
        c.code = "Test";
        countries.add(c);
        show.showCountries(countries);
    }

    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City c = new City();
        c.population = "2900";
        c.name = "Test";
        c.district = "Test";
        c.country = "Test";
        cities.add(c);
        show.showCities(cities);
    }

    @Test
    void printPopulation()
    {
        ArrayList<population> populations = new ArrayList<population>();
        population c = new population();
        c.population = "2900";
        c.countryName = "Test";
        c.continent = "Test";
        c.region = "Test";
        populations.add(c);
        show.showPopulation(populations);
    }

    @Test
    void testCountryReportMakerNullValueInput()
    {
        report.countryReportMaker(1, 2, null, null);
    }

    @Test
    void testCityReportMakerNullValueInput()
    {
        report.cityReportMaker(1, 2, null, null, false);
    }

    @Test
    void testPopulationReportMakerNullValueInput()
    {
        report.populationReportMaker(1, null, null);
    }

    @Test
    void testCitySQLClassNullValueInput()
    {
        city.reportSingleCity(null,false);
    }

    @Test
    void testCountrySQLClassNullValueInput()
    {
        country.reportSingleCountry(null);
    }

    @Test
    void testPopulationSQLClassNullValueInput()
    {
        population.reportSingleCountry(null);
    }


}
