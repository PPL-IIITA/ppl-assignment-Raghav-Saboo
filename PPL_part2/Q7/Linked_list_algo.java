/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import Dating_club.Couple;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *Class for storing data in a Linked list
 * @author RAGHAV SABOO
 */
public class Linked_list_algo extends Algo_par{
    LinkedList<Couple> lt=new LinkedList<Couple>();
    @Override
    public void store_data(ArrayList<Couple> couple_arr) {
        int i;
        for(i=0;i<couple_arr.size();i++)
        {
            lt.add(couple_arr.get(i));
        }
    }
    
}
