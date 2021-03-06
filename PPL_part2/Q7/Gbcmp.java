/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import Dating_club.Couple;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Boys
 * <p>
 * Boy id is the comparison criteria
 * @author RAGHAV SABOO
 */
public class Gbcmp implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Couple c1=(Couple)o1;
        Couple c2=(Couple)o2;
        if(c1.get_boy().get_boy_id().compareTo(c2.get_boy().get_boy_id())<0)
        {
            return -1;
        }
        else if(c1.get_boy().get_boy_id().compareTo(c2.get_boy().get_boy_id())>0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
}
