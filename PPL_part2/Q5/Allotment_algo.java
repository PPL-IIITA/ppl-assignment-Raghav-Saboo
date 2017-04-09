/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

import Dating_club.Boy;
import Dating_club.Couple;
import Dating_club.Girl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author RAGHAV SABOO
 */
public class Allotment_algo {
    /**
     * Make couples according to algo in q1
     * @param boy_arr Array list of boys
     * @param girl_arr Array list of girls
     * @param couple_arr Array list of couples
     * @throws IOException on error in file writing
     */
    public void make_couple_1(ArrayList<Boy> boy_arr,ArrayList<Girl> girl_arr,ArrayList<Couple> couple_arr) throws IOException
    {
        int ng,nb;
        ng=girl_arr.size();
        nb=boy_arr.size();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f = new File("Eventlog2.txt");
        Boolean b = f.createNewFile();
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog2.txt");
        rw = new BufferedWriter(fw);
        rw.write("Event               "+"Couple_id     "+"Timestamp");
        rw.newLine();
        Collections.sort(girl_arr,new CmpGirl());
        Collections.sort(boy_arr,new CmpBoy());
        int j,i,flag=0,cnt=0;
        while(cnt<ng)
        {
          if(flag==0)
          {
        for (j = 0; j < ng; j++) {
            if(girl_arr.get(j).get_comm_or_not()==false)
            {
                for (i = 0; i < nb; i++) {
                    if (boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false) {
                        girl_arr.get(j).set_comm_or_not(true);
                        boy_arr.get(i).set_comm_or_not(true);
                        Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                        couple_arr.add(cp);
                        timestamp = new Timestamp(System.currentTimeMillis());
                      //  System.out.println(i + " "+cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                        rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                        rw.newLine();
                        flag=1;
                        break;
                    }
                }
                cnt++;
                break;
            }
        }
        flag=1;
          }
            else if(flag==1)
            {
                for(i=0;i<nb;i++)
                {
                    int mx=0,p=-1;
                    if(boy_arr.get(i).get_comm_or_not()==false)
                    {
                        for(j=0;j<ng;j++)
                        {
                            if(mx<girl_arr.get(j).get_attractiveness()&&girl_arr.get(j).get_comm_or_not()==false&&boy_arr.get(i).get_budget()>=girl_arr.get(j).get_maintenance_cost())
                            {
                                p=j;
                                mx=girl_arr.get(j).get_attractiveness();
                            }
                        }
                        j=p;
                        if(j!=-1)
                        {
                            girl_arr.get(j).set_comm_or_not(true);
                            boy_arr.get(i).set_comm_or_not(true);
                            Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                            couple_arr.add(cp);
                            timestamp = new Timestamp(System.currentTimeMillis());
                           // System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                            rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                            rw.newLine();
                            cnt++;
                            break;
                        }
                    }
                          if(p!=-1)
                        {
                            break;
                        }
                }
            }
          flag=0;
        }
                rw.close();
        fw.close();
    }
    /**
     * Make couples according to algo in q4
     * @param boy_arr Array list of boys
     * @param girl_arr Array list of girls
     * @param couple_arr Array list of couples
     * @throws IOException on error in file writing
     */
    public void make_couple_2(ArrayList<Boy> boy_arr,ArrayList<Girl> girl_arr,ArrayList<Couple> couple_arr) throws IOException
    {
        int ng,nb;
        ng=girl_arr.size();
        nb=boy_arr.size();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f = new File("Eventlog2.txt");
        Boolean b = f.createNewFile();
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog2.txt");
        rw = new BufferedWriter(fw);
        rw.write("Event               " + "Couple_id     " + "Timestamp");
        rw.newLine();
        int j, i;
        for (j = 0; j < ng; j++) {
            for (i = 0; i < nb; i++) {
                if (boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false) {
                    girl_arr.get(j).set_comm_or_not(true);
                    boy_arr.get(i).set_comm_or_not(true);
                    Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                    couple_arr.add(cp);
                    timestamp = new Timestamp(System.currentTimeMillis());
                    // System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                    rw.write("Couple formation   " + cp.get_couple_id() + "   " + timestamp);
                    rw.newLine();
                    break;
                }
            }
        }
        rw.close();
        fw.close();
    }
}
