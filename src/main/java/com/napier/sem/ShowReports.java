package com.napier.sem;

import java.util.ArrayList;

public class ShowReports {
    public void showCountries(ArrayList<Country> c){

        for(int i = 0; i < c.size(); i++ )
        {
            System.out.println(
                    c.get(i).code + " "
                            + c.get(i).name + " "
                            + c.get(i).continent + " "
                            + c.get(i).region + " "
                            + c.get(i).population + " "
                            + c.get(i).capital );
        }
    }
}
