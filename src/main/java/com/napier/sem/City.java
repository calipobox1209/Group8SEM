package com.napier.sem;
//This class contains functions used to send sql statements to the database in order to obtain report information specifically pertaining to cities
//many of these functions are very similar with the main noticable differences residing in the SQL query
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class City {
    String name;
    String country;
    String district;
    String population;
    //Getting instance of connection provider
    ConnectionProvider a = ConnectionProvider.getInstance();
    //this function is for the report all cities by user inputted area functionality
    public ArrayList<City> reportAllCitiesByArea(String name, String countryName) {
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select all cities in a specific country
            String select = "SELECT city.Name, country.Name as CountryName, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE " + name + " = " + "'" + countryName + "' " +
                    "ORDER BY city.Population DESC ";

            ResultSet rset = stmt.executeQuery(select);
            //takes the outputs from the query and creates city objects with the obtained data
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("CountryName");
                cities.add(city);
            }
            //returns the ArrayList cities
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    //this function is for the special case of reporting on all cities in the world
    public ArrayList<City> reportAllCitiesByWorld(boolean capital) {
        try {

            if (capital == false){
                Statement stmt = a.con.createStatement();
            // SQL query to select all cities in the World
            String select = "SELECT city.Name, country.Name as CountryName, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC ";

            ResultSet rset = stmt.executeQuery(select);
            //creates city objects and populates cities arraylist
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("CountryName");
                cities.add(city);
            }
            return cities;
        } else {
                Statement stmt = a.con.createStatement();
                // SQL query to select all cities in the World
                String select = "SELECT city.Name, country.Name as CountryName, city.Population " +
                        "FROM city  JOIN country ON city.ID = country.Capital " +
                        "ORDER BY city.Population DESC ";

                ResultSet rset = stmt.executeQuery(select);
                //creates city objects and populates cities arraylist
                ArrayList<City> cities = new ArrayList<City>();
                while (rset.next()) {
                    City city = new City();
                    city.name = rset.getString("Name");
                    city.district = "";
                    city.population = rset.getString("Population");
                    city.country = rset.getString("CountryName");
                    cities.add(city);
                }
                return cities;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }


    public ArrayList<City> reportNCitiesByArea(String area, String areaName, int N) {
        try {
            Statement stmt = a.con.createStatement();
            // Construct SQL query to select top N cities in a specific area ordered by population
            String select = "SELECT city.Name, country.Name as CountryName, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE " + area + " = '" + areaName + "' " +
                    "ORDER BY Population DESC LIMIT " + N;

            ResultSet rset = stmt.executeQuery(select);
            //this function creates city objects and populates an array list of cities
            ArrayList<City> topNcities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("CountryName");
                topNcities.add(city);
            }
            return topNcities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> reportNCitiesByWorld(int N) {
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select top N cities in the world ordered by population
            String select = "SELECT city.Name, country.Name as CountryName, city.District, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY Population DESC LIMIT " + N;

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> topNcities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("CountryName");
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
            String select = "SELECT city.Name, country.Name as CountryName, city.District, city.Population " +
                            "FROM city JOIN country ON city.CountryCode = country.Code " +
                            "WHERE city.Name = '" + cityName + "' ";

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.district = rset.getString("District");
                city.population = rset.getString("Population");
                city.country = rset.getString("CountryName");
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
