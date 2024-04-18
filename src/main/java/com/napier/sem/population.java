package com.napier.sem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//class for making population reports
public class population {
    String name;

    String population;

    String cityPop;

    String ruralPop;

    String cityPercent;

    String ruralPercent;

    ConnectionProvider a = ConnectionProvider.getInstance();
    //same as most of the report generation functions, it sends an sql statement and puts the output into an arraylist of populations
    public ArrayList<population> reportPopulationByWorld() {
    try {
        Statement stmt = a.con.createStatement();
        String select = "SELECT SUM(country.Population) AS worldPop " +
                "FROM country ";
        ResultSet rset = stmt.executeQuery(select);
        ArrayList<population> populations = new ArrayList<population>();
        while (rset.next()) {
          population pop = new population();
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

    public ArrayList<population> reportSingleCityPop(String cityName){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT city.Name, city.Population " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.Name = '" + cityName + "' ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();;
                pop.name = rset.getString("city.Name");
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


    public ArrayList<population> reportSingleCountry(String countryName) {
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT country.Name, country.Population, SUM(city.Population) as CityPop, country.Population - SUM(city.Population) as NonCityPop " +
                    "FROM country JOIN city on city.CountryCode = country.Code " +
                    "WHERE country.Name = '" + countryName + "' " +
                    "GROUP BY country.Name, country.Population "  ;

            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.name = rset.getString("country.Name");
                pop.population = rset.getString("country.Population");
                pop.cityPop = rset.getString("CityPop");
                pop.ruralPop = rset.getString("NonCityPop");
                pop.cityPercent = Integer.toString((Integer.parseInt(pop.cityPop) / Integer.parseInt(pop.population)) * 100);
                pop.ruralPercent = Integer.toString((Integer.parseInt(pop.ruralPop) / Integer.parseInt(pop.population)) * 100);
                populations.add(pop);
            }

            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;

        }
    }
    public ArrayList<population> reportSingleRegion(String regionName){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT country.Region, SUM(country.Population) as RegionPop " +
                    "FROM country JOIN city on city.CountryCode = country.Code " +
                    "WHERE country.Region = '" + regionName + "' " +
                    "GROUP BY country.Region ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.name = rset.getString("country.Region");
                pop.population = rset.getString("RegionPop");
                populations.add(pop);
            }

            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;

        }


    }

    public ArrayList<population> reportSingleContinent(String continentName) {
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT country.Continent, SUM(country.Population) as ContinentPop " +
                    "FROM country " +
                    "WHERE country.Continent = '" + continentName + "' " +
                    "GROUP BY country.Continent ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.name = rset.getString("country.Continent");
                pop.population = rset.getString("ContinentPop");
                populations.add(pop);
            }

            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;

        }
    }

    public ArrayList<population> reportSingleDistrict(String districtName){
        try {
            Statement stmt = a.con.createStatement();
            String select = "SELECT city.District , SUM(city.Population) as DistrictPop " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = '" + districtName + "' " +
                    "GROUP BY city.District ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();;
                pop.name = rset.getString("city.District");
                pop.population = rset.getString("DistrictPop");
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

    public ArrayList<population> reportPercentagePop(String area, String areaName){
        try{
            Statement stmt = a.con.createStatement();
            String select = "SELECT country." + area + " as AreaType, SUM(country.Population) as AreaPop, SUM(city.Population) as CityPop, SUM(country.Population) - SUM(city.Population) as RuralPop " +
                    "FROM country JOIN city ON country.Code = city.CountryCode " +
                    "WHERE country." + area + " = '" + areaName + "' " +
                    "GROUP BY AreaType ";
            ResultSet rset = stmt.executeQuery(select);
            ArrayList<population> populations = new ArrayList<population>();
            while (rset.next()) {
                population pop = new population();
                pop.name = rset.getString("AreaType");
                pop.population = rset.getString("AreaPop");
                pop.cityPop = rset.getString("CityPop");
                pop.ruralPop = rset.getString("RuralPop");
                pop.cityPercent = Integer.toString((Integer.parseInt(pop.cityPop) / Integer.parseInt(pop.population)) * 100);
                pop.ruralPercent = Integer.toString((Integer.parseInt(pop.ruralPop) / Integer.parseInt(pop.population)) * 100);
                populations.add(pop);
            }
            return populations;

        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }



}
