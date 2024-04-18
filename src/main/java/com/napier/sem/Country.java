package com.napier.sem;
//this class has similar functionality to the city class with the main obvious difference being that it handles country related report queries
//as with the last class a lot of things will be repeated within these functions, with the main differences being present in the sql
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
    //instantiates singleton instance to facility connectivity to the database
    ConnectionProvider a = ConnectionProvider.getInstance();
       //report generation function for all countries by user specified area
       public ArrayList<Country> reportAllCountriesByArea(String area, String areaName){
                try {
                    Statement stmt = a.con.createStatement();
                    //sql statement that injects user input from main in order to specify results
                    String select = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as CapitalName " +
                            "FROM country " +
                            "INNER JOIN city ON country.Capital = city.ID " +
                            "WHERE " + "country." + area + " = " + "'" + areaName + "' " +
                            "ORDER BY country.Population DESC ";
                    ResultSet rset = stmt.executeQuery(select);
                    //creates country objects and populates countries arraylist
                    ArrayList<Country> countries = new ArrayList<Country>();
                    while (rset.next()) {
                        Country country = new Country();
                        country.code = rset.getString("country.Code");
                        country.name = rset.getString("country.Name");
                        country.continent = rset.getString("country.Continent");
                        country.region = rset.getString("country.Region");
                        country.population = rset.getString("country.Population");
                        country.capital = rset.getString("CapitalName");
                        countries.add(country);
                    }//returns arraylist to factory class
                    return countries;
                }

                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to get country details");
                    return null;
                }
        }
    //function reponsible for the all countries by world special case
    public ArrayList<Country> reportAllCountriesByWorld(){
        try {
            Statement stmt = a.con.createStatement();
            //trimmed down version of all countries by area statement
            String select = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS CapitalName " +
                    "FROM country " +
                    "INNER JOIN city ON country.Capital = city.ID " +
                    "ORDER BY country.Population DESC ";
            ResultSet rset = stmt.executeQuery(select);
            //creates countries, populates arraylist
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("country.Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("country.Continent");
                country.region = rset.getString("country.Region");
                country.population = rset.getString("country.Population");
                country.capital = rset.getString("CapitalName");
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

        //function responsible for generating reports of user specified length and user specified area
        public ArrayList<Country> reportNCountriesByArea(String area, String areaName, int N){

            try {
                Statement stmt = a.con.createStatement();
                //sql with user input injection
                String select = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS capitalName " +
                        "FROM country " +
                        "INNER JOIN city ON country.Capital = city.ID " +
                        "WHERE " + "country." + area + " = " + "'" + areaName + "' " +
                        "ORDER BY country.Population DESC LIMIT " + N;

                ResultSet rset = stmt.executeQuery(select);
                //make countries, fill array
                ArrayList<Country> countries = new ArrayList<Country>();
                while (rset.next()) {
                    Country country = new Country();
                    country.code = rset.getString("Code");
                    country.name = rset.getString("Name");
                    country.continent = rset.getString("Continent");
                    country.region = rset.getString("Region");
                    country.population = rset.getString("Population");
                    country.capital = rset.getString("capitalName");
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
    //another special case for the world area option in the user specified length type
    public ArrayList<Country> reportNCountriesByWorld(int N){

        try {
            Statement stmt = a.con.createStatement();
            //trimmed down version of report n countries by area statment
            String select = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as CapitalName " +
                    "FROM country " +
                    "INNER JOIN city ON country.Capital = city.ID " +
                    "ORDER BY Population DESC LIMIT " + N;

            ResultSet rset = stmt.executeQuery(select);
            //countries,array
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getString("Population");
                country.capital = rset.getString("CapitalName");
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
    //special case for reporting only a single country
    public ArrayList<Country> reportSingleCountry(String countryName){
        try {
            Statement stmt = a.con.createStatement();
            // SQL query to select a single country by its name
            String select = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as CapitalName " +
                    "FROM country " +
                    "INNER JOIN city ON country.Capital = city.ID " +
                    "WHERE country.Name = '" + countryName + "'";

            ResultSet rset = stmt.executeQuery(select);
            //c,a
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getString("Population");
                country.capital = rset.getString("CapitalName");
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

