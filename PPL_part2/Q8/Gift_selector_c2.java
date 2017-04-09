/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import Dating_club.Couple;
import Dating_club.Essential;
import Dating_club.Generous;
import Dating_club.Gift;
import Dating_club.Luxury;
import Dating_club.Miser;
import Dating_club.Utility;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *Abstract class for assigning gifts according to new strategy
 * @author RAGHAV SABOO
 */
public class Gift_selector_c2 extends Gift_selector{

    @Override
    public void assign_gifts(ArrayList<Couple> couple_arr,ArrayList<Gift> gift_arr)throws IOException {
        int mcl,mcu,mce;
        mcl=400;
        mcu=400;
        mce=400;
        int pl=0,pu=0,pe=0;
        for(int i=0;i<gift_arr.size();i++)
        {
            if(gift_arr.get(i) instanceof Luxury&&mcl>gift_arr.get(i).get_cost())
            {
                pl=i;
                mcl=gift_arr.get(i).get_cost();
            }
            else if(gift_arr.get(i) instanceof Essential&&mce>gift_arr.get(i).get_cost())
            {
                pe=i;
                mce=gift_arr.get(i).get_cost();
            }
            else if(gift_arr.get(i) instanceof Utility&&mcu>gift_arr.get(i).get_cost())
            {
                pu=i;
                mcu=gift_arr.get(i).get_cost();
            }
        }        
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
           j=mcl+mcu+mce;
           timestamp = new Timestamp(System.currentTimeMillis());
            rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(pl).get_gift_id()+"    "+timestamp);
            rw.newLine();
            couple_arr.get(i).get_gift_arr().add(gift_arr.get(pl));
           timestamp = new Timestamp(System.currentTimeMillis());
            rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(pe).get_gift_id()+"    "+timestamp);
            rw.newLine();
            couple_arr.get(i).get_gift_arr().add(gift_arr.get(pe));
           timestamp = new Timestamp(System.currentTimeMillis());
            rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(pu).get_gift_id()+"    "+timestamp);
            rw.newLine();
            couple_arr.get(i).get_gift_arr().add(gift_arr.get(pu));
            if (couple_arr.get(i).get_boy() instanceof Miser) {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                x=0;
                while (j < mc) {
                    if(x==pl||x==pe||x==pu)
                    {
                        x++;
                        continue;
                    }
                    j += gift_arr.get(x).get_cost();
                                 timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr.get(x));
                    x++;
                }
            } else if (couple_arr.get(i).get_boy() instanceof Generous) {
                mc = couple_arr.get(i).get_boy().get_budget();
                x = 0;
                while (j < mc) {
                                        if(x==pl||x==pe||x==pu)
                    {
                        x++;
                        continue;
                    }
                    j += gift_arr.get(x).get_cost();
                                  timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr.get(x));
                    x++;
                }
            } else {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                x = 0;
                while (j < mc) {
                                        if(x==pl||x==pe||x==pu)
                    {
                        x++;
                        continue;
                    }
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
    
