/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.util.ArrayList;

/**
 *Abstract class for storing attributes of boy
 * @author RAGHAV SABOO
 */
public abstract class Boy {

    private String boy_id;
    private int attractiveness;
    private int intelligence;
    private boolean comm_or_not;
    private int budget;
    private double happiness;
    /**
     * Constructor for initializing attributes of Boy
     * @param s Name of Boy
     * @param a Attractiveness of Boy
     * @param i Intelligence of Boy
     * @param b Budget of Boy
     */
    public Boy(String s, int a, int i, int b) {
        this.boy_id = s;
        this.attractiveness = a;
        this.intelligence = i;
        this.budget = b;
        this.comm_or_not = false;
        this.happiness = 0;
    }
    /**
     * For returning id of boy
     * @return String It returns name of boy
     */
    public String get_boy_id() {
        return boy_id;
    }
       /**
     * For returning attractiveness of boy
     * @return Integer It returns attractiveness of boy
     */
    public int get_attractiveness() {
        return attractiveness;
    }
    /**
     * For returning intelligence of boy
     * @return Integer It returns intelligence of boy
     */
    public int get_intelligence() {
        return intelligence;
    }
    /**
     * To tell whether boy is committed or not
     * @return Boolean It returns true if boy is committed else it returns false
     */
    public boolean get_comm_or_not() {
        return comm_or_not;
    }
    /**
     * For returning budget of boy
     * @return Integer It returns budget of boy
     */
    public int get_budget() {
        return budget;
    }
       /**
     * For changing boy's commitment attribute
     */
    public void set_comm_or_not(Boolean b) {
        comm_or_not = b;
    }
       /**
     * For returning happiness of boy
     * @return Double It returns happiness of boy
     */
    public double get_happiness() {
        return happiness;
    }
       /**
     * For setting happiness of boy
     */
    public void set_happiness(double x) {
        happiness = x;
    }
/**
 * For calculating happiness of boy
 * @return Double It returns happiness of boy
 */       
    public abstract double calc_happiness(ArrayList<Gift> guft_arr,double hapg,int intl);
}
