/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import Dating_club.Couple;
import Dating_club.Generous;
import Dating_club.Gift;
import Dating_club.Luxury;
import Dating_club.Miser;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *Abstract class for assigning gifts according to previous/default strategy
 * @author RAGHAV SABOO
 */
public class Gift_selector_c1 extends Gift_selector{

    /**
     *
     * @param couple_arr
     * @param gift_arr
     * @throws IOException
     */
    @Override
    public void assign_gifts(ArrayList<Couple> couple_arr,ArrayList<Gift> gift_arr)throws IOException{
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog2.txt",true);
        rw = new BufferedWriter(fw);
        rw.newLine();
        rw.newLine();
        rw.write("Event               "+"Couple_id     "+"Gift_id     "+"Timestamp");
        rw.newLine();
        int i, j, x, y, mc = 0;
        for (i = 0; i < couple_arr.size(); i++) {
            if (couple_arr.get(i).get_boy() instanceof Miser) {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                j = 0;
                x = 0;
                while (j < mc) {
                    j += gift_arr.get(x).get_cost();
                                 timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr.get(x));
                    x++;
                }
            } else if (couple_arr.get(i).get_boy() instanceof Generous) {
                mc = couple_arr.get(i).get_boy().get_budget();
                j = 0;
                x = 0;
                while (j < mc) {
                    j += gift_arr.get(x).get_cost();
                                  timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr.get(x));
                    x++;
                }
            } else {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                j = 0;
                x = 0;
                while (j < mc) {
                    j += gift_arr.get(x).get_cost();
                                      timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr.get(x));
                    x++;
                }
                y = couple_arr.get(i).get_boy().get_budget() - j;
                for (j = 0; j < gift_arr.size(); j++) {
                    if (couple_arr.get(i).get_gift_arr().contains(gift_arr.get(j))==false&&gift_arr.get(j) instanceof Luxury && y >= gift_arr.get(j).get_cost()) {
                                               timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(j).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                        couple_arr.get(i).get_gift_arr().add(gift_arr.get(j));
                        break;
                    }
                }
            }
        }
                rw.close();
        fw.close();
    }
    
}
