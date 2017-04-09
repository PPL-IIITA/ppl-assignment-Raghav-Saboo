/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import Dating_club.Assign_gifts;
import Dating_club.Boy;
import Dating_club.Cmp;
import Dating_club.Cmpp;
import Dating_club.Compare;
import Dating_club.Couple;
import Dating_club.Gift;
import Dating_club.Girl;
import Dating_club.Make_couples;
import Dating_club.Ran_gen;
import Dating_club.Read_data;
import java.io.*;
import static java.lang.Math.exp;
import static java.lang.Math.min;
import java.sql.Timestamp;
import java.util.*;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *For reading data and making couples and assigning gifts
 * @author RAGHAV SABOO
 */
public class PPLQ4 {

    private ArrayList<Boy> boy_arr = new ArrayList<>();
    private ArrayList<Girl> girl_arr = new ArrayList<>();
    private ArrayList<Couple> couple_arr = new ArrayList<>();
    private ArrayList<Gift> gift_arr = new ArrayList<>();
    int nb,ng,flag=0;
/**
 * 
 * @throws IOException on error in file generation
 */
    public void generate_data() throws IOException
    {
                Ran_gen obj=new Ran_gen();
        obj.generate_data_boys_girls();
        obj.make_gifts();
    }
     /**
  * Method for reading data from file
  * @throws FileNotFoundException
  * @throws IOException on error in file reading
  */
    public void read_file() throws FileNotFoundException, IOException {
        Read_data ob=new Read_data();
        ob.read_file(boy_arr, girl_arr, gift_arr);
        ng=girl_arr.size();
        nb=boy_arr.size();
        Collections.sort(gift_arr, new Compare());
}
        /**
     * Method for making couples
     * @throws IOException on error in file reading
     */
        public void make_couples() throws IOException {
            Make_couples ob=new Make_couples();
            ob.make_couples(boy_arr, girl_arr, couple_arr, ng, nb);
    }
       /**
      * Method for calculating happiness and compatability
      */
    public void cal_happiness_comaptablility() {
        int i;
        for (i = 0; i < couple_arr.size(); i++) {
            double hapg = 0, hapb = 0;
            hapg=couple_arr.get(i).get_girl().calc_happiness(couple_arr.get(i).get_gift_arr());
            hapb = couple_arr.get(i).get_boy().calc_happiness(couple_arr.get(i).get_gift_arr(),hapg,couple_arr.get(i).get_girl().get_intelligence());
           // System.out.println(couple_arr.get(i).get_boy().get_boy_id());
            couple_arr.get(i).set_happiness(hapb + hapg);
            couple_arr.get(i).set_compatibility(couple_arr.get(i).get_boy().get_budget() - couple_arr.get(i).get_girl().get_maintenance_cost()+ Math.abs(couple_arr.get(i).get_girl().get_attractiveness() - couple_arr.get(i).get_boy().get_attractiveness()) + Math.abs(couple_arr.get(i).get_girl().get_intelligence() - couple_arr.get(i).get_boy().get_intelligence()));
        }
    }
        /**
     * Method for Breaking least k happy couples
     * @throws IOException on error in file reading
     */
    public void break_make_couples() throws IOException
    {
        flag=1;
        Map<String,String> mp=new HashMap<>();
              Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog2.txt",true);
        rw = new BufferedWriter(fw);
        rw.newLine();
        rw.newLine();
        rw.write("Event                          "+"Couple_id        "+"   Boy_id     "+"   Girl_id     "+"Timestamp");
        rw.newLine();
        Collections.sort(couple_arr, new Cmp());
        Random rand=new Random();
        int k=min(10,couple_arr.size());
       // System.out.println(k);
        int i;
        for(i=0;i<k;i++)
        {
            mp.put(couple_arr.get(i).get_girl().get_girl_id(),couple_arr.get(i).get_boy().get_boy_id());
            couple_arr.get(i).get_boy().set_comm_or_not(Boolean.FALSE);
            couple_arr.get(i).get_girl().set_comm_or_not(Boolean.FALSE);
            couple_arr.get(i).get_boy().set_happiness(0.0);
            couple_arr.get(i).get_girl().set_happiness(0.0);
           // System.out.println("Breaked  "+couple_arr.get(i).get_couple_id());
                                               timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Breaking least "+k+" happy couple   "+couple_arr.get(i).get_couple_id()+"      "+couple_arr.get(i).get_boy().get_boy_id()+"        "+couple_arr.get(i).get_girl().get_girl_id()+"       "+timestamp);
                    rw.newLine();
        }
                rw.close();
        fw.close();
        Set st=mp.entrySet();
        Iterator it=st.iterator();
        while(it.hasNext())
        {
            Map.Entry mpe=(Map.Entry)it.next();
            for(i=0;i<couple_arr.size();i++)
            {
                if(couple_arr.get(i).get_boy().get_boy_id().compareTo((String) mpe.getValue())==0&&couple_arr.get(i).get_girl().get_girl_id().compareTo((String) mpe.getKey())==0)
                {
                    couple_arr.remove(i);
                    break;
                }
            }
        }
        File f = new File("Eventlog2.txt");
        fw = new FileWriter("Eventlog2.txt",true);
        rw = new BufferedWriter(fw);
        rw.newLine();
        rw.newLine();
        rw.write("Event               "+"Couple_id     "+"Timestamp");
        rw.newLine();
        int j;
        for (j = 0; j < ng; j++) {
            for (i = 0; i < nb; i++) {
                if(mp.containsKey(girl_arr.get(j).get_girl_id())==true)
                {
                if (boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false && mp.containsKey(girl_arr.get(j).get_girl_id()) == false) {
                    girl_arr.get(j).set_comm_or_not(true);
                    boy_arr.get(i).set_comm_or_not(true);
                    Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                    cp.set_happiness(0.0);
                    cp.set_compatibility(0);
                    cp.reset_gift_arr();
                    couple_arr.add(cp);
                    timestamp = new Timestamp(System.currentTimeMillis());
                   // System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                    rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                    rw.newLine();
                    break;
                }
                else if(((boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false) && mp.containsKey(girl_arr.get(j).get_girl_id()) == true)&&mp.get(girl_arr.get(j).get_girl_id()).compareTo(boy_arr.get(i).get_boy_id())!=0)
                {
                    girl_arr.get(j).set_comm_or_not(true);
                    boy_arr.get(i).set_comm_or_not(true);
                    Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                    couple_arr.add(cp);
                    timestamp = new Timestamp(System.currentTimeMillis());
                    // System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                    rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                    rw.newLine();
                    break;
                }
                }
            }
        }
                rw.close();
        fw.close();
        mp.clear();
    }

    /**
     * Method for assigning gifts to the couples formed
     * @throws IOException on error in file reading
     */

    public void give_gifts() throws IOException {
            Assign_gifts ob=new Assign_gifts();
            ob.give_gifts(couple_arr,gift_arr);
    }
/**
 * Method for writing data to file
 * @throws IOException on error in file writing
 */
    
    public void disp_data() throws IOException {
        File f = new File("Answer2.txt");
        //System.out.println(b);
        FileWriter fw;
        BufferedWriter rw;
        if(flag==1)
        {
            fw = new FileWriter("Answer2.txt",true);
            rw = new BufferedWriter(fw);
            rw.write("After breaking couples");
            rw.newLine();
        }
        else
        {
            f.createNewFile();
            fw = new FileWriter("Answer2.txt");
            rw = new BufferedWriter(fw);
        }
        int i;
        Collections.sort(couple_arr, new Cmp());
        rw.write("Best couples according to happiness:");
        rw.newLine();
        for (i = 0; i < couple_arr.size(); i++) {
            rw.write("Couple id : " + couple_arr.get(i).get_couple_id() + " happiness : " + couple_arr.get(i).get_happiness());
            rw.newLine();
        }
        Collections.sort(couple_arr, new Cmpp());
        rw.newLine();
        rw.write("Best couples according to compatability:");
        rw.newLine();
        //System.out.println();
        for (i = 0; i < couple_arr.size(); i++) {
            rw.write("Couple id : " + couple_arr.get(i).get_couple_id() + " compatability : " + couple_arr.get(i).get_compatibility());
            rw.newLine();
        }
        rw.newLine();
        rw.newLine();
        rw.close();
        fw.close();
    }
}
