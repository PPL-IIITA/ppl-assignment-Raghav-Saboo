/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

import Dating_club.Girl;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Girls
 * <p>
 * Maintenance cost is the comparison criteria
 * @author RAGHAV SABOO
 */
public class CmpGirl implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Girl g1=(Girl)o1;
        Girl g2=(Girl)o2;
        if(g1.get_maintenance_cost()>g2.get_maintenance_cost())
        {
            return 1;
        }
        else if(g1.get_maintenance_cost()<g2.get_maintenance_cost())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
}
