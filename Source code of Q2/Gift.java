/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

/**
 *For storing attributes of gift
 * @author RAGHAV SABOO
 */
public class Gift {

    private String type;
    private int cost;
    private int value;
    private String gift_id;
/**
 * Constructor for initializing attributes of Gift
 */
    public Gift(String t, int c, int v, String gi) {
        this.type = t;
        this.cost = c;
        this.value = v;
        this.gift_id = gi;
    }
/**
 * For returning type of gift
     * @return 
 */
    public String get_type() {
        return type;
    }
/**
 * For returning cost of gift
     * @return 
 */
    public int get_cost() {
        return cost;
    }
/**
 * For returning value of gift
     * @return 
 */
    public int get_value() {
        return value;
    }
/**
 * For returning id of gift
     * @return 
 */
    public String get_gift_id() {
        return gift_id;
    }
}
