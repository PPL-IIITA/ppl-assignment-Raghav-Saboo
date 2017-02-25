/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

import java.util.Comparator;

/**
 *For sorting Gifts according to their cost
 * @author RAGHAV SABOO
 */
public class Compare implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Gift g1, g2;
        g1 = (Gift) o1;
        g2 = (Gift) o2;
        if (g1.get_cost() > g2.get_cost()) {
            return 1;
        } else if (g1.get_cost() < g2.get_cost()) {
            return -1;
        } else if (g1.get_value() < g2.get_value()) {
            return 1;
        } else if (g1.get_value() > g2.get_value()) {
            return -1;
        } else {
            return 0;
        }
    }
}
