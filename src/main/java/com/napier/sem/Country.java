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
    ConnectionProvider a = new ConnectionProvider();



       public ArrayList<Country> reportAllCountriesByArea(String area){
                try {
                    Statement stmt = a.con.createStatement();
                    String select = "";
                    ResultSet rset = stmt.executeQuery(select);

                    ArrayList<Country> countries = new ArrayList<Country>();
                    while (rset.next()) {
                        Country country = new Country();
                        country.code = rset.getString("country.Code");
                        country.name = rset.getString("country.Name");
                        country.continent = rset.getString("country.Continent");
                        country.region = rset.getString("country.Region");
                        country.population = rset.getString("city.Population");
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


        public ArrayList<Country> reportNCountriesByArea(String area, int N){

            try {
                Statement stmt = a.con.createStatement();
                String select = "";
                ResultSet rset = stmt.executeQuery(select);

                ArrayList<Country> countries = new ArrayList<Country>();
                while (rset.next()) {
                    Country country = new Country();
                    country.code = rset.getString("country.Code");
                    country.name = rset.getString("country.Name");
                    country.continent = rset.getString("country.Continent");
                    country.region = rset.getString("country.Region");
                    country.population = rset.getString("city.Population");
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

}

