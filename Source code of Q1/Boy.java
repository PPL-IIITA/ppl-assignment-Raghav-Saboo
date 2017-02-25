/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *Class for storing attributes of boy
 * @author RAGHAV SABOO
 * 
 */
public class Boy {
    private String boy_id;
    private int attractiveness;
    private int intelligence;
    private boolean comm_or_not;
    private int budget;
    private String type;
    /**
     * Constructor for initializing attribute
     */
    public Boy(String s, int a, int i, int b, String t) {
        this.boy_id = s;
        this.attractiveness = a;
        this.intelligence = i;
        this.budget = b;
        this.type = t;
        this.comm_or_not = false;
    }
    /**
     * For returning id of boy
     */
    public String get_boy_id() {
        return boy_id;
    }
       /**
     * For returning attractiveness of boy
     */
    public int get_attractiveness() {
        return attractiveness;
    }
    /**
     * For returning intelligence of boy
     */
    public int get_intelligence() {
        return intelligence;
    }
    /**
     * To tell whether boy is committed or not
     */
    public boolean get_comm_or_not() {
        return comm_or_not;
    }
    /**
     * For returning budget of boy
     */
    public int get_budget() {
        return budget;
    }
    /**
     * For returning type of boy
     */
    public String get_type() {
        return type;
    }
       /**
     * For changing boy's commitment attribute
     */
    public void set_comm_or_not(Boolean b) {
        comm_or_not = b;
    }
}
