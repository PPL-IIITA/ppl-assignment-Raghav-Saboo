/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.util.ArrayList;

/**
 *For storing attributes of Girl
 * @author RAGHAV SABOO
 */
public abstract class Girl {
/**
  * @param girl_id Name of girl
 * @param attractiveness Attractiveness of girl
 * @param intelligence Intelligence of girl
 * @param maintenance_cost Maintenance cost of girl
 */
    private String girl_id;
    private int attractiveness;
    private int intelligence;
    private boolean comm_or_not;
    private int maintenance_cost;
    private double happiness;
/**
 * Constructor for initializing attributes of Choosy girl
 * @param s Name of girl
 * @param a Attractiveness of girl
 * @param i Intelligence of girl
 * @param b Maintenance cost of girl
 */
    public Girl(String s, int a, int i, int b) {
        this.girl_id = s;
        this.attractiveness = a;
        this.intelligence = i;
        this.maintenance_cost = b;
        this.happiness = 0;
        this.comm_or_not = false;
    }
/**
 * For returning id of girl
 *  @return String It returns name of girl
 */
    public String get_girl_id() {
        return girl_id;
    }
/**
 * For returning attractiveness of girl
 *@return Integer It returns attractiveness of girl
 */
    public int get_attractiveness() {
        return attractiveness;
    }
/**
 * For returning intelligence of girl
 * @return Integer It returns intelligence of girl
 */
    public int get_intelligence() {
        return intelligence;
    }
/**
 * For returning happiness of girl
 * @return Double It returns happiness of girl
 */
    public double get_happiness() {
        return happiness;
    }
/**
 * For returning whether girl is committed or not 
 *  @return Boolean It returns true if girl is committed else it returns false
 */
    public boolean get_comm_or_not() {
        return comm_or_not;
    }
/**
 * For returning maintenance_cost of girl
 *@return Integer It returns budget of Girl
 */
    public int get_maintenance_cost() {
        return maintenance_cost;
    }
/**
 * For setting the commitment of girl
 * 
 */
    public void set_comm_or_not(Boolean b) {
        comm_or_not = b;
    }
/**
 * For setting happiness of girl
 * 
 */
    public void set_happiness(double x) {
        happiness = x;
    }
/**
 * For calculating happiness of girl
 * @return Double It returns happiness of Girl
 */    
    public abstract double calc_happiness(ArrayList<Gift> gift_arr);
}
