/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import Dating_club.Couple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *Class for storing data in a Hash table
 * @author RAGHAV SABOO
 */
public class Hash_table_algo extends Algo_par{
    Map<String,String> mp=new HashMap<>();
    @Override
    public void store_data(ArrayList<Couple> couple_arr) {
        int i;
        for(i=0;i<couple_arr.size();i++)
        {
            mp.put(couple_arr.get(i).get_boy().get_boy_id(),couple_arr.get(i).get_girl().get_girl_id());
        }
    }
    
}
