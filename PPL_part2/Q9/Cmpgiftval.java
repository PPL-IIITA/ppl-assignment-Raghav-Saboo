/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q9;

import Dating_club.Gift;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Gifts
 * <p>
 * Value is the comparison criteria
 * @author RAGHAV SABOO
 */
public class Cmpgiftval implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Gift g1=(Gift)o1;
        Gift g2=(Gift)o2;
        if(g1.get_value()>g2.get_value())
        {
            return -1;
        }
        else if(g1.get_value()<g2.get_value())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
}
