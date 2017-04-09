/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

/**
 *Class for storing attributes of Luxury gift
 * @author RAGHAV SABOO
 */
public class Luxury extends Gift{
    public int luxury_rating;
    /**
     * 
     * @param lr Luxury rating
     * @param c Cost
     * @param v Value
     * @param gi  Gift id
     */
    public Luxury(int lr,int c, int v, String gi) {
        super(c, v, gi);
        luxury_rating=lr;
    }
    
}
