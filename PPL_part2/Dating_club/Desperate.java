/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import static java.lang.Math.exp;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *Class for Desperate girl
 * <p>
 *It is a child class of Girl class
 * @author RAGHAV SABOO
 */
public class Desperate extends Girl{
/**
 * Constructor for initializing attributes of Choosy girl
 * @param s Name of girl
 * @param a Attractiveness of girl
 * @param i Intelligence of girl
 * @param b Maintenance cost of girl
 */
    public Desperate(String s, int a, int i, int b) {
        super(s, a, i, b);
    }

    @Override
    /**
     * Function for calculating happiness of girl
     * @param gift_arr Array list for storing gifts of various types
     *  @return Double Returns happiness of Girl of type Desperate
     */
    public double calc_happiness(ArrayList<Gift> gift_arr) {
                    int j,x=0,y=0;
            for (j = 0; j < gift_arr.size(); j++) {
                x += gift_arr.get(j).get_cost();
                y += gift_arr.get(j).get_value();
            }    
        double hapg=0;
                int r=x-get_maintenance_cost();
                while(exp(r)==Infinity)
                {
                    r-=500;
                }
                hapg += Math.abs(Math.exp(r));        
        return hapg;
    }
    
}