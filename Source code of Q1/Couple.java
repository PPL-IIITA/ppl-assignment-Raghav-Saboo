/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

/**
 *Class for storing attributes of Couple
 * @author RAGHAV SABOO
 */
public class Couple {

    private String couple_id;
    private Boy bob;
    private Girl gob;
    /**
     * Constructor for initializing attribute
     */
    public Couple(Boy b, Girl g) {
        couple_id = b.get_boy_id() + "_" + g.get_girl_id();
        bob = b;
        gob = g;
    }
    /**
     * To return id of couple
     */
    public String get_couple_id() {
        return couple_id;
    }
    /**
     * To return id of boy
     */
    public Boy get_boy() {
        return bob;
    }
    /**
     * To return id of girl
     */
    public Girl get_girl() {
        return gob;
    }
}
