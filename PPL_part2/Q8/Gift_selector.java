/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import Dating_club.Couple;
import Dating_club.Gift;
import java.io.IOException;
import java.util.ArrayList;

/**
 *Abstract class for assigning gifts
 * @author RAGHAV SABOO
 */
public abstract class Gift_selector {
    public abstract void assign_gifts(ArrayList<Couple> couple_arr,ArrayList<Gift> gift_arr)throws IOException;
}
