/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.util.ArrayList;

/**
 *Class for storing attributes of boy of type Miser
 * @author RAGHAV SABOO
 */
public class Miser extends Boy{
    /**
     * Constructor for initializing attributes of Boy of type Geek
     * @param s Name of Boy
     * @param a Attractiveness of Boy
     * @param i Intelligence of Boy
     * @param b Budget of Boy
     */
    public Miser(String s, int a, int i, int b) {
        super(s, a, i, b);
    }

    @Override
/**
 * For calculating happiness of boy
 * @param gift_arr Array list for storing list of gifts
 * @param hapg For storing happiness of girl
 * @param intl For storing intelligence of girl
 *  @return Double Returns happiness of Boy of type Geek 
 */  
    public double calc_happiness(ArrayList<Gift> gift_arr,double hapg,int intl) {
                    int j,x=0;
            for (j = 0; j <gift_arr.size(); j++) {
                x += gift_arr.get(j).get_cost();
            }
        double hapb=0;
        hapb += Math.abs(get_budget() - x);
        set_happiness(hapb);
        //System.out.print("Miser  ");
        return hapb;
    }
    
}
