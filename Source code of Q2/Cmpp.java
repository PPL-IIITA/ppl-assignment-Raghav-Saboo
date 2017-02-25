/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

import java.util.Comparator;

/**
 *For sorting couples according to their compatability
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
