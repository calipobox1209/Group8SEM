package com.napier.sem;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class City {
    String name;
    String country;
    String district;
    String population;

    ConnectionProvider a = ConnectionProvider.getInstance();

     public ArrayList<City> reportAllCitiesByArea(String area){
        try {
            Statement stmt = a.con.createStatement();
            String select = "";
            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("city.District");
                city.population = rset.getString("city.Population");
                cities.add(city);
            }
            return cities;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }


    }

    public ArrayList<City> reportNCitiesByArea(String area, int N){
        try {
            Statement stmt = a.con.createStatement();
            String select = "";
            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> topNcities = new ArrayList<City>();
            while (rset.next()) {
                City Ncity = new City();
                Ncity.name = rset.getString("city.Name");
                Ncity.district = rset.getString("city.District");
                Ncity.population = rset.getString("city.Population");
                topNcities.add(Ncity);
            }
            return topNcities;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }
}
