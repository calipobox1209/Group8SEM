package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;
//class for integration tests
public class AppIntegrationTest
{
    static App app;
    static City city;
    static Country country;
    static ReportFactory report;

    static population pop;
    static ShowReports show;
    static ConnectionProvider a = ConnectionProvider.getInstance();
    //initializes our objects before running any tests
    @BeforeAll
    static void init()
    {
        app = new App();
        city = new City();
        country = new Country();
        pop = new population();
        report = new ReportFactory();
        show = new ShowReports();
        a.connect("localhost:33060", 30000);
    }

    //tests to see if the single country report works
    @Test
    void testGetCountry()
    {
        ArrayList<Country> country1 = country.reportSingleCountry("United Arab Emirates");
        assertEquals(country1.get(0).name, "United Arab Emirates");
        assertEquals(country1.get(0).code, "ARE");
        assertEquals(country1.get(0).continent, "Asia");
        assertEquals(country1.get(0).region, "Middle East");
        assertEquals(parseInt(country1.get(0).population), 2441000);
        assertEquals(country1.get(0).capital, "Abu Dhabi");
    }

    //tests to see if list of country is sorting from highest to lowest population in length and not null
    @Test
    void testCountryList()
    {
        ArrayList<Country> country2 = country.reportNCountriesByWorld(50);
        assertTrue(parseInt(country2.get(0).population) > parseInt(country2.get(49).population));
        assertNotNull(country2);
    }
    //tests the single city report maker by verifying its values and checking it isnt empty/null
    @Test
    void testGetCity()
    {
        ArrayList<City> city1 = city.reportSingleCity("Houston", false);
        assertEquals(city1.get(0).name, "Houston");
        assertEquals(city1.get(0).district, "Texas");
        assertEquals(parseInt(city1.get(0).population), 1953631);
        assertEquals(city1.get(0).country, "United States");
        assertFalse(city1.isEmpty());
        assertNotNull(city1);
    }
    //tests n cities list is sorted properly, not null or empty
    @Test
    void testGetCityList()
    {
        ArrayList<City> city2 = city.reportNCitiesByWorld(50, false);
        assertTrue(parseInt(city2.get(0).population) > parseInt(city2.get(49).population));
        assertFalse(city2.isEmpty());
        assertNotNull(city2);
    }

    //verifies list is correct size, isnt null, and checks random index to verify correct continent
    @Test
    void testcountryReportMaker()
    {
        ArrayList<Country> country3 = report.countryReportMaker(2,30, "Continent", "Asia");
        assertEquals(30, country3.size());
        assertNotNull(country3);
        assertEquals("Asia", country3.get(16).continent);
    }

    //tests city report maker
    @Test
    void testCityReportMaker()
    {
        ArrayList<City> city = report.cityReportMaker(2, 25, "Continent", "Europe", false);
        assertEquals(25, city.size());
        assertNotNull(city);
        assertEquals("Poland", city.get(12).country);
    }

    //tests that produced list is correct size, contains no null values, and is correct country
    @Test
    void testPopulationReportMaker()
    {
        ArrayList<population> population = report.populationReportMaker(2, "placeholder", "Albania");
        assertEquals(1, population.size());
        assertNotNull(population);
        assertEquals("Albania", population.get(0).name);
    }
    //same test as before but for world report maker
    @Test
    void testPopulationWorldReportMaker()
    {
        ArrayList<population> population = report.populationReportMaker(1, "World", "Placeholder");
        assertEquals(1, population.size());
        assertNotNull(population.get(0).population);
    }

    //tests population report maker again with different query
    @Test
    void testPopulationCityReportMaker()
    {
        ArrayList<population> population = report.populationReportMaker(3, "placeholder", "Glasgow");
        assertEquals(1, population.size());
        assertNotNull(population);
        assertEquals("Glasgow", population.get(0).name);
    }

    //tests capital city function produces correct list
    @Test
    void capitalCitytester() {

    ArrayList<City> city2 = city.reportNCitiesByWorld(50, true);
    assertTrue(parseInt(city2.get(0).population) > parseInt(city2.get(49).population));
    assertFalse(city2.isEmpty());
    assertNotNull(city2);
    }

/*    @Test
    void areaPercentagePopTest(){
        ArrayList<population> population = pop.reportPercentagePop("Continent", "Asia");
        assertNotNull(population.get(0).population);
    }
*/
    //tests district population report by verifying data and checking for null
    @Test
    void populationSingleDistrict(){
        ArrayList<population> population = pop.reportSingleDistrict("Texas");
        assertEquals(9208281, Integer.parseInt(population.get(0).population));
        assertFalse(population.isEmpty());
        assertNotNull(population.get(0));
        assertEquals("Texas", population.get(0).name);
    }
    //tests single city population report in same way
    @Test
    void populationSingleRegion(){
        ArrayList<population> population = pop.reportSingleRegion("Eastern Europe");
        assertFalse(population.isEmpty());
        assertNotNull(population.get(0));
        assertEquals("Eastern Europe", population.get(0).name);

    }
    //checks continent test in same way
    @Test
    void populationSingleContinent(){
        ArrayList<population> population = pop.reportSingleContinent("Africa");
        assertEquals(784475000, Integer.parseInt(population.get(0).population));
        assertFalse(population.isEmpty());
        assertNotNull(population.get(0));
        assertEquals("Africa", population.get(0).name);
    }
}