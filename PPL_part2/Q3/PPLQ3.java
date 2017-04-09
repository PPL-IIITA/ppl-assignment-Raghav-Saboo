/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

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
import java.sql.Timestamp;
import java.util.*;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *For reading data and making couples and assigning gifts
 * @author RAGHAV SABOO
 */
public class PPLQ3 {

    private ArrayList<Boy> boy_arr = new ArrayList<>();
    private ArrayList<Girl> girl_arr = new ArrayList<>();
    private ArrayList<Couple> couple_arr = new ArrayList<>();
    private ArrayList<Gift> gift_arr = new ArrayList<>();
    int nb,ng;
    /**
     * Method for generating random data
     * @throws java.io.FileNotFoundException 
     */
    public void generate_data() throws IOException
    {
                Ran_gen obj=new Ran_gen();
        obj.generate_data_boys_girls();
        obj.make_gifts();
    }
 /**
  * Method for reading data from file
  * @throws FileNotFoundException on error in file generation
  * @throws IOException 
  */
    public void read_file() throws IOException {
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
        Boolean b = f.createNewFile();
        //System.out.println(b);
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Answer2.txt");
        rw = new BufferedWriter(fw);
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
        rw.close();
        fw.close();
    }
}
