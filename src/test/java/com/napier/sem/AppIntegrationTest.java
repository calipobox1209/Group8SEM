package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static City city;
    static Country country;
    static ReportFactory report;
    static ShowReports show;
    static ConnectionProvider a = ConnectionProvider.getInstance();
    @BeforeAll
    static void init()
    {
        app = new App();
        city = new City();
        country = new Country();
        report = new ReportFactory();
        show = new ShowReports();
        a.connect("localhost:33060", 30000);
    }

    @Test
    void testGetCountry()
    {
        ArrayList<Country> country1 = country.reportSingleCountry("United Arab Emirates");
        assertEquals(country1.get(0).name, "United Arab Emirates");
        assertEquals(country1.get(0).code, "ARE");
        assertEquals(country1.get(0).continent, "Asia");
        assertEquals(country1.get(0).region, "Middle East");
        assertEquals(parseInt(country1.get(0).population), 2441000);
        assertEquals(parseInt(country1.get(0).capital), 65);
    }

    @Test
    void testCountryList()
    {
        ArrayList<Country> country2 = country.reportNCountriesByWorld(50);
        assertTrue(parseInt(country2.get(0).population) > parseInt(country2.get(49).population));
    }
    @Test
    void testGetCity()
    {
        ArrayList<City> city1 = city.reportSingleCity("Houston");
        assertEquals(city1.get(0).name, "Houston");
        assertEquals(city1.get(0).district, "Texas");
        assertEquals(parseInt(city1.get(0).population), 1953631);
        assertEquals(city1.get(0).country, "United States");
        assertFalse(city1.isEmpty());
        assertNotNull(city1);
    }

    @Test
    void testGetCityList()
    {
        ArrayList<City> city2 = city.reportNCitiesByWorld(50);
        assertTrue(parseInt(city2.get(0).population) > parseInt(city2.get(49).population));
        assertFalse(city2.isEmpty());
        assertNotNull(city2);
    }

    @Test
    void testcountryReportMaker()
    {
        ArrayList<Country> country3 = report.countryReportMaker(2,30, "Continent", "Asia");
        assertEquals(30, country3.size());
        assertNotNull(country3);
        assertEquals("Asia", country3.get(16).continent);
    }

/*    @Test
    void testCityReportMaker()
    {
        ArrayList<City> city = report.cityReportMaker(2, 25, "Continent", "Europe");
        assertEquals(25, city.size());
        assertNotNull(city);
        assertEquals("Europe", city.get(12).country);
    }
*/


}