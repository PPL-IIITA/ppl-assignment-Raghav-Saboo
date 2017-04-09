/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q10;

import Dating_club.Boy;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Boys
 * <p>
 * Attractiveness is the comparison criteria
 * @author RAGHAV SABOO
 */
public class Cmpboy implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Boy b1=(Boy)o1;
        Boy b2=(Boy)o2;
        if(b1.get_attractiveness()>b2.get_attractiveness())
        {
            return -1;
        }
        else if(b1.get_attractiveness()<b2.get_attractiveness())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
}
