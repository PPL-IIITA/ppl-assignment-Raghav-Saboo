/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

/**
 *Class for storing attributes of Utility gift
 * @author RAGHAV SABOO
 */
public class Utility extends Gift{
    public int utility_value;
    String utility_class;
  /**
   * 
   * @param uv Utility value
   * @param uc Utility class
   * @param c Cost
   * @param v Value
   * @param gi  Gift id
   */
    public Utility(int uv,String uc,int c, int v, String gi) {
        super(c, v, gi);
        utility_value=uv;
        utility_class=uc;
    }
    
}
