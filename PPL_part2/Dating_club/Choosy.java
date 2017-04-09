/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.util.ArrayList;

/**
 *Class for Choosy girl
 * <p>
 *It is a child class of Girl class
 * @author RAGHAV SABOO
 */
public class Choosy extends Girl{
/**
 * Constructor for initializing attributes of Choosy girl
 * @param s Name of girl
 * @param a Attractiveness of girl
 * @param i Intelligence of girl
 * @param b Maintenance cost of girl
 */
    public Choosy(String s, int a, int i, int b) {
        super(s, a, i, b);
    }

    @Override
    /**
     * Function for calculating happiness of girl
     * @param gift_arr Array list for storing gifts of various types
     * @return Double It returns happiness of girl of type Choosy
     */
    public double calc_happiness(ArrayList<Gift> gift_arr) {
            int j,x=0,y=0;
            for (j = 0; j < gift_arr.size(); j++) {
                x += gift_arr.get(j).get_cost();
                y += gift_arr.get(j).get_value();
            }      
        double hapg=0;
        hapg += Math.abs(Math.log10(x -get_maintenance_cost() + 2 * y));
        set_happiness(hapg);
        return hapg;
    }
    
}
