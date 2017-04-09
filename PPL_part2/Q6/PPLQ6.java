/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import Dating_club.Assign_gifts;
import Dating_club.Boy;
import Dating_club.Choosy;
import Dating_club.Cmp;
import Dating_club.Cmpp;
import Dating_club.Compare;
import Dating_club.Couple;
import Dating_club.Desperate;
import Dating_club.Essential;
import Dating_club.Geek;
import Dating_club.Generous;
import Dating_club.Gift;
import Dating_club.Girl;
import Dating_club.Luxury;
import Dating_club.Make_couples;
import Dating_club.Miser;
import Dating_club.Normal;
import Dating_club.Ran_gen;
import Dating_club.Read_data;
import Dating_club.Utility;
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
public class PPLQ6 {

    ArrayList<Boy> boy_arr = new ArrayList<>();
    ArrayList<Girl> girl_arr = new ArrayList<>();
    ArrayList<Couple> couple_arr = new ArrayList<>();
    ArrayList<Gift> gift_arr = new ArrayList<>();
    int nb,ng,flag=0;
    Map <String,Integer> mp=new HashMap<>();
/**
 *Method for generating random data
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
     * @throws IOException on error in file writing
     */
        public void make_couples() throws IOException {
            Make_couples ob=new Make_couples();
            ob.make_couples(boy_arr, girl_arr, couple_arr, ng, nb);
    }
    /**
     * Method for assigning gifts to the couples formed
     * @throws IOException on error in file writing
     */
      public void give_gifts() throws IOException {
            Assign_gifts ob=new Assign_gifts();
            ob.give_gifts(couple_arr,gift_arr);
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
     * Method for breaking couples t days in month whose happiness is less than t
     * @throws IOException on error in file I/O
     */
    public void break_make_couples() throws IOException
    {
        Ran_gen ob=new Ran_gen();
        int t=5;
        for(int cnt=1;cnt<=t;cnt++)
        {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            FileWriter fw;
            BufferedWriter rw;
            fw = new FileWriter("Eventlog2.txt",true);
            rw = new BufferedWriter(fw);
            rw.newLine();
            rw.newLine();
            rw.write("Breaking couple on day "+" "+cnt);
            rw.newLine();
            rw.write("Event               "+"Couple_id     "+"Boy_id     "+"Girl_id     "+"Timestamp");
            rw.newLine();
            Collections.sort(couple_arr, new Cmp());

           // System.out.println(k);
            int i;
            for(i=0;i<couple_arr.size();i++)
            {
                if(couple_arr.get(i).get_happiness()>t)
                {
                    break;
                }
                int x=Integer.parseInt(couple_arr.get(i).get_boy().get_boy_id().substring(4));
              //  System.out.println("Breaking couple   "+couple_arr.get(i).get_couple_id());
                mp.put(couple_arr.get(i).get_girl().get_girl_id(),x);
                couple_arr.get(i).get_boy().set_comm_or_not(Boolean.FALSE);
                couple_arr.get(i).get_girl().set_comm_or_not(Boolean.FALSE);
                couple_arr.get(i).get_boy().set_happiness(0.0);
                couple_arr.get(i).get_girl().set_happiness(0.0);
                                                   timestamp = new Timestamp(System.currentTimeMillis());
                        rw.write("Breaking couple   "+couple_arr.get(i).get_couple_id()+"   "+couple_arr.get(i).get_boy().get_boy_id()+"     "+couple_arr.get(i).get_girl().get_girl_id()+"    "+timestamp);
                        rw.newLine();
            }
                    rw.close();
            fw.close();
            for(int j=0;j<i;j++)
            {
                couple_arr.remove(0);
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
               // System.out.println(mp.containsKey("girl_24"));
                if(mp.containsKey(girl_arr.get(j).get_girl_id())==true)
                {
                    i=mp.get(girl_arr.get(j).get_girl_id());
                   // System.out.println(i);
                     for (; i < nb; i++) {
                        if (boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false) {
                            girl_arr.get(j).set_comm_or_not(true);
                            boy_arr.get(i).set_comm_or_not(true);
                            Couple cp = new Couple(boy_arr.get(i), girl_arr.get(j));
                            couple_arr.add(cp);
                            timestamp = new Timestamp(System.currentTimeMillis());
                          //  System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
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
            gift_arr.clear();
            FileReader fr = new FileReader("gift.txt");
            BufferedReader rr = new BufferedReader(fr);
            String  ty, gid,s;
            StringTokenizer st;
            int   cs, vl,ngg;
            s=rr.readLine();
            st = new StringTokenizer(s, " ");
            s=st.nextToken();
            s=st.nextToken();
            ngg = Integer.parseInt(s);
            s=rr.readLine();
            for (i = 1; i <= ngg; i++) {
                s = rr.readLine();
               st = new StringTokenizer(s, ",");
                gid = st.nextToken();
                cs = Integer.parseInt(st.nextToken());
                vl = Integer.parseInt(st.nextToken());
                ty = st.nextToken();
                Gift gf;
                if(ty.compareTo("Luxury")==0)
                {
                    int lv=Integer.parseInt(st.nextToken());
                    Luxury obb=new Luxury(lv,cs, vl, gid);
                    gf=obb;
                }
                else if(ty.compareTo("Utility")==0)
                {
                    int uv=Integer.parseInt(st.nextToken());
                    String uc=st.nextToken();
                    Utility obb=new Utility(uv,uc,cs, vl, gid);
                    gf=obb;
                }
                else
                {
                    Essential obb=new Essential(cs, vl, gid);
                    gf=obb;
                }
                gift_arr.add(gf);
            }
        Collections.sort(gift_arr, new Compare());
            ob.make_gifts();
            give_gifts();
            cal_happiness_comaptablility();
            disp_data();
        }
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
        if(flag!=0)
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
            flag=1;
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

