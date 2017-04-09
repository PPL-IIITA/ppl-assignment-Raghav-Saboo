/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q9;

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
import static java.lang.Math.min;
import java.sql.Timestamp;
import java.util.*;

/**
 *For reading data and making couples and assigning gifts
 * @author RAGHAV SABOO
 */
public class PPLQ9 {


    Template_best_k<Boy> boy_arr = new Template_best_k<>();
    Template_best_k<Girl> girl_arr = new Template_best_k<>();
    Template_best_k<Couple> couple_arr = new Template_best_k<>();
    Template_best_k<Gift> gift_arr = new Template_best_k<>();
    int nb,ng;
 /**
  * Method for generating random data
  * @throws IOException on error in file I/O
  */
    public void generate_data() throws IOException
    {
                Ran_gen obj=new Ran_gen();
        obj.generate_data_boys_girls();
        obj.make_gifts();
    }
    /**
     * Method for reading data from file
     * @throws FileNotFoundException on error in file I/O
     * @throws IOException on error in file I/O
     */
    public void read_file() throws FileNotFoundException, IOException {
        // TODO code application logic here
                Ran_gen obj=new Ran_gen();
        obj.generate_data_boys_girls();
        obj.make_gifts();
        FileReader fw;
        BufferedReader rw;
            fw = new FileReader("dat.txt");
            rw = new BufferedReader(fw);

          String s;
            Boy b;
            int  i, at, intl, bud;
            s=rw.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            s=st.nextToken();
            s=st.nextToken();
            nb = Integer.parseInt(s);
            s=rw.readLine();
            for (i = 1; i <= nb; i++) {
                s = rw.readLine();
                st = new StringTokenizer(s, ",");
                String name = st.nextToken();
                at = Integer.parseInt(st.nextToken());
                intl = Integer.parseInt(st.nextToken());
                bud = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                if(type.compareTo("Geek")==0)
                {
                    Geek ob=new Geek(name,at,intl,bud);
                    b=ob;
                }
                else if(type.compareTo("Miser")==0)
                {
                    Miser ob=new Miser(name,at,intl,bud);
                    b=ob;
                }
                else
                {
                    Generous ob=new Generous(name,at,intl,bud);
                    b=ob;                    
                }
                boy_arr.add(b);
            }
            s=rw.readLine();
            st = new StringTokenizer(s, " ");
            s=st.nextToken();
            s=st.nextToken();
            ng = Integer.parseInt(s);
            s=rw.readLine();
            Girl g;
            for (i = 1; i <= ng; i++) {
                s = rw.readLine();
                st = new StringTokenizer(s, ",");
                String name = st.nextToken();
                at = Integer.parseInt(st.nextToken());
                intl = Integer.parseInt(st.nextToken());
                bud = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                if(type.compareTo("Choosy")==0)
                {
                    Choosy ob=new Choosy(name,at,intl,bud);
                    g=ob;
                }
                else if(type.compareTo("Normal")==0)
                {
                    Normal ob=new Normal(name,at,intl,bud);
                    g=ob;
                }
                else
                {
                    Desperate ob=new Desperate(name,at,intl,bud);
                    g=ob;                    
                }
                girl_arr.add(g);
            }
            fw = new FileReader("gift.txt");
            rw = new BufferedReader(fw);
            String  ty, gid;
            int   cs, vl,ngg;
            s=rw.readLine();
            st = new StringTokenizer(s, " ");
            s=st.nextToken();
            s=st.nextToken();
            ngg = Integer.parseInt(s);
            s=rw.readLine();
            for (i = 1; i <= ngg; i++) {
                s = rw.readLine();
                st = new StringTokenizer(s, ",");
                gid = st.nextToken();
                cs = Integer.parseInt(st.nextToken());
                vl = Integer.parseInt(st.nextToken());
                ty = st.nextToken();
                Gift gf;
                if(ty.compareTo("Luxury")==0)
                {
                    int lv=Integer.parseInt(st.nextToken());
                    Luxury ob=new Luxury(lv,cs, vl, gid);
                    gf=ob;
                }
                else if(ty.compareTo("Utility")==0)
                {
                    int uv=Integer.parseInt(st.nextToken());
                    String uc=st.nextToken();
                    Utility ob=new Utility(uv,uc,cs, vl, gid);
                    gf=ob;
                }
                else
                {
                    Essential ob=new Essential(cs, vl, gid);
                    gf=ob;
                }
                gift_arr.add(gf);
            }
}
        /**
     * Method for making couples
     * @throws IOException on error in file I/O
     */
        public void make_couples() throws IOException {
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
        int kb=ng;
        Template_best_k<Boy> boy_arr_k=boy_arr.best_k(new Cmpboy(),kb);
        int kg=min(10,kb);
        Template_best_k<Girl> girl_arr_k=girl_arr.best_k(new Cmpgirl(),kg);
        int j,i,flag=0,cnt=0;
        while(cnt<ng)
        {
          if(flag==0)
          {
        for (j = 0; j < ng; j++) {
            int p=-1,mx=0;
            if(girl_arr.get(j).get_comm_or_not()==false)
            {
                flag=0;
                for (i = 0; i < kb; i++) {
                    if (mx<boy_arr.get(i).get_budget()&&boy_arr.get(i).get_budget() >= girl_arr.get(j).get_maintenance_cost() && boy_arr.get(i).get_comm_or_not() == false) {
                        p=i;
                        mx=boy_arr.get(i).get_budget();
                    }
                }
                if(p!=-1)
                {
                            girl_arr.get(j).set_comm_or_not(true);
                            boy_arr.get(p).set_comm_or_not(true);
                            Couple cp = new Couple(boy_arr.get(p), girl_arr.get(j));
                            couple_arr.add(cp);
                            timestamp = new Timestamp(System.currentTimeMillis());
                           // System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_girl_id()+" at timestamp: "+timestamp);
                            rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                            rw.newLine();
                }
            }
            if(p!=-1)
            {
                break;
            }
        }
          flag=1;
            cnt++;
          }
            else if(flag==1)
            {
                for(i=0;i<nb;i++)
                {
                     int mn=10000,p=-1;
                    if(boy_arr.get(i).get_comm_or_not()==false)
                    {
                        for(j=0;j<kg;j++)
                        {
                            if(mn>girl_arr.get(j).get_maintenance_cost()&&girl_arr.get(j).get_comm_or_not()==false&&boy_arr.get(i).get_budget()>=girl_arr.get(j).get_maintenance_cost())
                            {
                                p=j;
                                mn=girl_arr.get(j).get_maintenance_cost();
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
                            //System.out.println(cp.get_couple_id()+" is formed between "+boy_arr.get(i).get_boy_id()+" and "+girl_arr.get(j).get_maintenance_cost());
                            rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                            rw.newLine();
                        }
                   }
                    if(p!=-1)
                    {
                        break;
                    }
                }
                flag=0;
            }
        }
                rw.close();
        fw.close();

    }
/**
 * Method for assigning gifts
 * @throws IOException on error in file I/O
 */
    public void give_gifts() throws IOException {
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
        int kg=min(300,gift_arr.size());
        Template_best_k<Gift> gift_arr_k_t=gift_arr.best_k(new Cmpgift(),kg);
        Template_best_k<Gift> gift_arr_k=gift_arr_k_t.best_k(new Cmpgiftval(),kg);
        for (i = 0; i < couple_arr.size(); i++) {
            if (couple_arr.get(i).get_boy() instanceof Miser) {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                j = 0;
                x = 0;
                while (j < mc&&x<kg) {
                    j += gift_arr.get(x).get_cost();
                                 timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr_k.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr_k.get(x));
                    x++;
                }
            } else if (couple_arr.get(i).get_boy() instanceof Generous) {
                mc = couple_arr.get(i).get_boy().get_budget();
                j = 0;
                x = 0;
                while (j < mc&&x<kg) {
                    j += gift_arr_k.get(x).get_cost();
                                  timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr_k.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr_k.get(x));
                    x++;
                }
            } else {
                mc = couple_arr.get(i).get_girl().get_maintenance_cost();
                j = 0;
                x = 0;
                while (j < mc&&x<kg) {
                    j += gift_arr_k.get(x).get_cost();
                                      timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr_k.get(x).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                    couple_arr.get(i).get_gift_arr().add(gift_arr_k.get(x));
                    x++;
                }
               // System.out.println(couple_arr.get(i).get_couple_id()+"   "+j+" "+mc);
                y = couple_arr.get(i).get_boy().get_budget() - j;
                for (j = 0; j < gift_arr_k.size(); j++) {
                    if (gift_arr_k.get(j) instanceof Luxury && y >= gift_arr_k.get(j).get_cost()) {
                                               timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr_k.get(j).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                        couple_arr.get(i).get_gift_arr().add(gift_arr_k.get(j));
                    }
                }
            }
        }
                rw.close();
        fw.close();
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
 * Method for writing data to file
 * @throws IOException on error in file I/O
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
        couple_arr.sort(new Cmp());
        rw.write("Best couples according to happiness:");
        rw.newLine();
        for (i = 0; i < couple_arr.size(); i++) {
            rw.write("Couple id : " + couple_arr.get(i).get_couple_id() + " happiness : " + couple_arr.get(i).get_happiness());
            rw.newLine();
        }
        couple_arr.sort(new Cmpp());
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
