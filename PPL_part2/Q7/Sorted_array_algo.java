/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import Dating_club.Couple;
import java.util.ArrayList;
import java.util.Collections;

/**
 *Class for storing data in an array in sorted order
 * @author RAGHAV SABOO
 */
public class Sorted_array_algo extends Algo_par{
    ArrayList<Couple> cr=new ArrayList<>();
    @Override
    public void store_data(ArrayList<Couple> couple_arr) {
        int i;
        for(i=0;i<couple_arr.size();i++)
        {
            cr.add(couple_arr.get(i));
        }
        Collections.sort(cr,new Gbcmp());
    }
    
}
