/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *Class for storing attributes of Girl
 * @author RAGHAV SABOO
 */
public class Girl {

    private String girl_id;
    private int attractiveness;
    private int intelligence;
    private boolean comm_or_not;
    private int maintenance_cost;
    private String type;
    /**
     * Constructor for initializing attribute
     */
    public Girl(String s, int a, int i, int b, String t) {
        this.girl_id = s;
        this.attractiveness = a;
        this.intelligence = i;
        this.maintenance_cost = b;
        this.type = t;
        this.comm_or_not = false;
    }
    /**
     * To return id of girl
     */
    public String get_girl_id() {
        return girl_id;
    }
    /**
     * For returning attractiveness of girl
     */
    public int get_attractiveness() {
        return attractiveness;
    }
    /**
     *For returning intelligence of girl
     */
    public int get_intelligence() {
        return intelligence;
    }
   /**
     *For returning whether girl is committed or not 
     */
    public boolean get_comm_or_not() {
        return comm_or_not;
    }
   /**
     *For returning maintenance cost of girl
     */
    public int get_maintenance_cost() {
        return maintenance_cost;
    }
   /**
     *For returning type of girl
     */
    public String get_type() {
        return type;
    }
   /**
     *For setting the commitment of girl
     */
    public void set_comm_or_not(Boolean b) {
        comm_or_not = b;
    }
}
