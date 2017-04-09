/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q9;

import Dating_club.Girl;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Girls
 * <p>
 * Attractiveness is the comparison criteria
 * @author RAGHAV SABOO
 */
public class Cmpgirl implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
     Girl g1=(Girl)o1;
     Girl g2=(Girl)o2;
     if(g1.get_attractiveness()>g2.get_attractiveness())
     {
         return -1;
     }
     else if(g1.get_attractiveness()<g2.get_attractiveness())
     {
         return 1;
     }
     else
     {
         return 0;
     }
    }
   
    
}
