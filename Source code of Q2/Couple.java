/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

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
     */
    public String get_couple_id() {
        return couple_id;
    }
    /**
     * For returning boy object
     */
    public Boy get_boy() {
        return bob;
    }
    /**
     * For returning girl object
     */
    public Girl get_girl() {
        return gob;
    }
    /**
     * For returning happiness of boy
     */
    public double get_happiness() {
        return happiness;
    }
    /**
     * For returning compatability of couple
     */
    public int get_compatibility() {
        return compatibility;
    }

    public ArrayList<Gift> get_gift_arr() {
        return gift_arr;
    }
    /**
     * For returning setting happiness of couple
     */
    public void set_happiness(double x) {
        happiness = x;
    }
    /**
     * For returning setting compatability of couple
     */
    public void set_compatibility(int x) {
        compatibility = x;
    }
}
