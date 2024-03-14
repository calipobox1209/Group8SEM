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

    public ArrayList<City> reportAllCitiesByArea(String name, String countryName) {
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select all cities in a specific country
            String select = "SELECT city.Name, city.District, city.Population, city.Country " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE " + name + " = " + "'" + countryName + "' " +
                    "ORDER BY city.Population DESC";

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("Country");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    public ArrayList<City> reportNCitiesByArea(String area, String areaName, int N) {
        try {
            Statement stmt = a.con.createStatement();
            // Construct SQL query to select top N cities in a specific area ordered by population
            String select = "SELECT city.Name, city.District, city.Population, " +
                    "FROM city " +
                    "WHERE " + area + " = '" + areaName + "' " +
                    "ORDER BY Population DESC LIMIT " + N;

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> topNcities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                topNcities.add(city);
            }
            return topNcities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> reportSingleCity(String cityName) {
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select a single city by name
            String select = "SELECT city.Name, city.District, city.Population, c FROM city WHERE Name = '" + cityName + "'";

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

}
