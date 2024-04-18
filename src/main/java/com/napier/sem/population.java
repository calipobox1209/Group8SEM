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
        return populations;
    }
    catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("Failed to get population details");
        return null;

        }
        }

    /*public ArrayList<population> reportPopulationByArea(String area, String areaName) {
        return
    }*/
}
