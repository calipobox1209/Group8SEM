package com.napier.sem;
//this class makes it possible to output the contents of our arrays to the console in the correct format for our reports
import java.util.ArrayList;

public class ShowReports {
    //we differentiate between countries and cities because different object types and different report format
    public void showCountries(ArrayList<Country> c){
        //goes through entire arraylist and outputs code,name,continent,region,population,and capital
        if (c == null)
        {
            System.out.println("No countries");
            return;
        }
        for(int i = 0; i < c.size(); i++ )
        {
            if (c.get(i) == null)
                continue;
            System.out.println(
                    c.get(i).code + " "
                            + c.get(i).name + " "
                            + c.get(i).continent + " "
                            + c.get(i).region + " "
                            + c.get(i).population + " "
                            + c.get(i).capital );
        }
    }
    public void showCities(ArrayList<City> ci){
        if (ci == null)
        {
            System.out.println("No cities");
            return;
        }
        //goes through entire arraylist and outputs name,country,district,and population
        for(int i = 0; i < ci.size(); i++ )
        {
            if (ci.get(i) == null)
                continue;
            System.out.println(
                    ci.get(i).name + " "
                            + ci.get(i).country + " "
                            + ci.get(i).district + " "
                            + ci.get(i).population);
        }

    }

    public void showPopulation(ArrayList<population> cii){
        if (cii == null)
        {
            System.out.println("No population reports");
            return;
        }
        //goes through entire arraylist and outputs name,country,district,and population
        for(int i = 0; i < cii.size(); i++ )
        {
            if (cii.get(i) == null)
                continue;
            System.out.println(
                    cii.get(i).name + " "
                            + cii.get(i).population + " "
                            + cii.get(i).cityPop + " "
                            + cii.get(i).ruralPop + " "
                            + cii.get(i).cityPercent + " "
                            + cii.get(i).ruralPercent);
        }

    }
}
