package com.napier.sem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class population {
    String continent;
    String region;
    String countryName;

    String population;

    ConnectionProvider a = ConnectionProvider.getInstance();

    public ArrayList<population> reportPopulationByWorld() {
    try {
        Statement stmt = a.con.createStatement();
        String select = "SELECT country.Continent, country.region, country.Name,SUM(country.Population) AS worldPop " +
                "FROM country " +
                "GROUP BY country.Continent, country.Region, country.Name";
        ResultSet rset = stmt.executeQuery(select);
        ArrayList<population> populations = new ArrayList<population>();
        while (rset.next()) {
          population pop = new population();
            pop.countryName = rset.getString("country.Name");
            pop.continent = rset.getString("country.Continent");
            pop.region = rset.getString("country.Region");
            pop.population = rset.getString("worldPop");
            populations.add(pop);
        }
        System.out.println(populations.size());
        return populations;
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Failed to get population details");
        return null;

        }
        }
// areas to be passed to byArea region, continent district,
    public ArrayList<population> reportPopulationByArea(String area, String areaName) {
       return null;

    }

    public ArrayList<population> reportSingleCity(String cityName){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT city.Name, country.Name as CountryName, country.Continent as CountryCont, country.region as CountryRegion, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.Name = '" + cityName + "' ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.countryName = rset.getString("CountryName");
                pop.continent = rset.getString("CountryCont");
                pop.region = rset.getString("CountryRegion");
                pop.population = rset.getString("city.Population");
                populations.add(pop);
            }
            return populations;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;

        }
    }


    public ArrayList<population> reportSingleCountry(String countryName){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT country.Name, country.Continent, country.Region, country.Population " +
                    "FROM country " +
                    "WHERE country.Name = '" + countryName + "' ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.countryName = rset.getString("country.Name");
                pop.continent = rset.getString("country.Continent");
                pop.region = rset.getString("country.Continent");
                pop.population = rset.getString("country.Population");
                populations.add(pop);
            }
            return populations;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;

        }

    }
}
