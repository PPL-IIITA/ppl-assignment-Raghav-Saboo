/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

/**
 *For storing attributes of Girl
 * @author RAGHAV SABOO
 */
public class Girl {

    private String girl_id;
    private int attractiveness;
    private int intelligence;
    private boolean comm_or_not;
    private int maintenance_cost;
    private String type;
    private double happiness;
/**
 * Constructor for initializing attributes of Gift
 */
    public Girl(String s, int a, int i, int b, String t) {
        this.girl_id = s;
        this.attractiveness = a;
        this.intelligence = i;
        this.maintenance_cost = b;
        this.type = t;
        this.happiness = 0;
        this.comm_or_not = false;
    }
/**
 * For returning id of girl
 * 
 */
    public String get_girl_id() {
        return girl_id;
    }
/**
 * For returning attractiveness of girl
 * 
 */
    public int get_attractiveness() {
        return attractiveness;
    }
/**
 * For returning intelligence of girl
 * 
 */
    public int get_intelligence() {
        return intelligence;
    }
/**
 * For returning happiness of girl
 * 
 */
    public double get_happiness() {
        return happiness;
    }
/**
 * For returning whether girl is committed or not 
 * 
 */
    public boolean get_comm_or_not() {
        return comm_or_not;
    }
/**
 * For returning maintenance_cost of girl
 *
 */
    public int get_maintenance_cost() {
        return maintenance_cost;
    }
/**
 * For returning type of girl
 * 
 */
    public String get_type() {
        return type;
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
}
