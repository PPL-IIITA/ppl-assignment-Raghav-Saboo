/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import Dating_club.Couple;
import java.util.Comparator;

/**
 *Class that provides comparison logic for comparing two Couples
 * <p>
 * Compatability is the comparison criteria
 * @author RAGHAV SABOO
 */
public class Cmpp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Couple g1, g2;
        g1 = (Couple) o1;
        g2 = (Couple) o2;
        if (g1.get_compatibility() > g2.get_compatibility()) {
            return 1;
        } else if (g1.get_compatibility() < g2.get_compatibility()) {
            return -1;
        } else {
            return 0;
        }
    }
}
