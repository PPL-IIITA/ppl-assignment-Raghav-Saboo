/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

/**
 *For storing attributes of gift
 * @author RAGHAV SABOO
 */
public abstract class Gift {
    private int cost;
    private int value;
    private String gift_id;
/**
 * 
 * @param c Cost
 * @param v Value
 * @param gi Gift id
 */
    public Gift(int c, int v, String gi) {
        this.cost = c;
        this.value = v;
        this.gift_id = gi;
    }
/**
 * For returning cost of gift
     * @return Integer Returns cost of gift
 */
    public int get_cost() {
        return cost;
    }
/**
 * For returning value of gift
     * @return Integer Returns value of gift
 */
    public int get_value() {
        return value;
    }
/**
 * For returning id of gift
     * @return String Returns gift id
 */
    public String get_gift_id() {
        return gift_id;
    }
}
