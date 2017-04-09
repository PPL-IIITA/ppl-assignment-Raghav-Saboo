/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.util.ArrayList;

/**
 *Class for storing attributes of Couple
 * @author RAGHAV SABOO
 */
public class Couple {
    private String couple_id;
    private Boy bob;
    private int compatibility;
    private double happiness;
    private Girl gob;
    private ArrayList<Gift> gift_arr = new ArrayList<>();  
    /**
     * Constructor for initializing attribute
     * @param b Reference of boy
     * @param g Reference of girl
     */
    public Couple(Boy b, Girl g) {
        couple_id = b.get_boy_id() + "_" + g.get_girl_id();
        bob = b;
        gob = g;
        happiness = 0;
        compatibility = 0;
    }
    /**
     * For returning couple id
     * @return String It returns couple id
     */
    public String get_couple_id() {
        return couple_id;
    }
    /**
     * For returning Reference of class Boy
     * @return Boy It returns Reference of class Boy
     */
    public Boy get_boy() {
        return bob;
    }
    /**
     * For returning Reference of class Girl
     *  @return Girl It returns Reference of class Girl
     */
    public Girl get_girl() {
        return gob;
    }
    /**
     * For returning happiness of boy
     *  @return Double It returns happiness of couple
     */
    public double get_happiness() {
        return happiness;
    }
    /**
     * For returning compatability of couple
     * @return Integer It returns compatability of couple
     */
    public int get_compatibility() {
        return compatibility;
    }
    /**
     * For returning array list of gift
     * @return It returns array list of gift
     */
    public ArrayList<Gift> get_gift_arr() {
        return gift_arr;
    }
    /**
     * For returning setting happiness of couple
     * @param x For setting happiness with value in x
     */
    public void set_happiness(double x) {
        happiness = x;
    }
    /**
     * For returning setting compatability of couple
     * @param x For setting compatability with value in x
     */
    public void set_compatibility(int x) {
        compatibility = x;
    }
    /**
     * For resetting gift array
     */
    public void reset_gift_arr()
    {
        gift_arr.clear();
    }
}
