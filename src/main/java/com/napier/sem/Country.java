package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Country {
    String code;
    String name;
    String continent;
    String region;
    String population;
    String capital;
    ConnectionProvider a = ConnectionProvider.getInstance();

       public ArrayList<Country> reportAllCountriesByArea(String area, String areaName){
                try {
                    Statement stmt = a.con.createStatement();
                    String select = "SELECT Code, Name, Continent, Region, Population, Capital " +
                            "FROM country " +
                            "WHERE " + area + " = " + "'" + areaName + "' " +
                            "ORDER BY Population DESC ";
                    ResultSet rset = stmt.executeQuery(select);

                    ArrayList<Country> countries = new ArrayList<Country>();
                    while (rset.next()) {
                        Country country = new Country();
                        country.code = rset.getString("country.Code");
                        country.name = rset.getString("country.Name");
                        country.continent = rset.getString("country.Continent");
                        country.region = rset.getString("country.Region");
                        country.population = rset.getString("country.Population");
                        country.capital = rset.getString("country.capital");
                        countries.add(country);
                    }
                    return countries;
                }

                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to get country details");
                    return null;
                }
        }

    public ArrayList<Country> reportAllCountriesByWorld(){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC ";
            ResultSet rset = stmt.executeQuery(select);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getString("country.Population");
                country.capital = rset.getString("country.capital");
                countries.add(country);
            }
            return countries;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


        public ArrayList<Country> reportNCountriesByArea(String area, String areaName, int N){

            try {
                Statement stmt = a.con.createStatement();
                String select = "SELECT Code, Name, Continent, Region, Population, Capital " +
                        "FROM country " +
                        "WHERE " + area + " = '" + areaName + "' " +
                        "ORDER BY Population DESC LIMIT " + N;

                ResultSet rset = stmt.executeQuery(select);

                ArrayList<Country> countries = new ArrayList<Country>();
                while (rset.next()) {
                    Country country = new Country();
                    country.code = rset.getString("Code");
                    country.name = rset.getString("Name");
                    country.continent = rset.getString("Continent");
                    country.region = rset.getString("Region");
                    country.population = rset.getString("Population");
                    country.capital = rset.getString("country.capital");
                    countries.add(country);
                }
                return countries;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get country details");
                return null;
            }
        }

    public ArrayList<Country> reportNCountriesByWorld(int N){

        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC LIMIT " + N;

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getString("Population");
                country.capital = rset.getString("country.capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    public ArrayList<Country> reportSingleCountry(String countryName){
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select a single country by its name
            String select = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE country.Name = '" + countryName + "'";

            ResultSet rset = stmt.executeQuery(select);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getString("Population");
                country.capital = rset.getString("country.capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

}

