/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

import java.io.*;
import static java.lang.Math.exp;
import java.sql.Timestamp;
import java.util.*;
import static jdk.nashorn.internal.objects.Global.Infinity;

/**
 *For reading data and making couples and assigning gifts
 * @author RAGHAV SABOO
 */
public class PPLQ2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    ArrayList<Boy> boy_arr = new ArrayList<>();
    ArrayList<Girl> girl_arr = new ArrayList<>();
    ArrayList<Couple> couple_arr = new ArrayList<>();
    ArrayList<Gift> gift_arr = new ArrayList<>();
    int nb,ng;
    public void read_file() throws FileNotFoundException, IOException {
        // TODO code application logic here
        FileReader fw;
        BufferedReader rw;
            fw = new FileReader("dat.txt");
            rw = new BufferedReader(fw);

            String s;
            Boy b;
            int  i, at, intl, bud;
            nb = Integer.parseInt(rw.readLine());
            for (i = 1; i <= nb; i++) {
                s = rw.readLine();
                StringTokenizer st = new StringTokenizer(s, ",");
                String name = st.nextToken();
                at = Integer.parseInt(st.nextToken());
                intl = Integer.parseInt(st.nextToken());
                bud = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                b = new Boy(name, at, intl, bud, type);
                boy_arr.add(b);
            }
            ng = Integer.parseInt(rw.readLine());
            Girl g;
            for (i = 1; i <= ng; i++) {
                s = rw.readLine();
                StringTokenizer st = new StringTokenizer(s, ",");
                String name = st.nextToken();
                at = Integer.parseInt(st.nextToken());
                intl = Integer.parseInt(st.nextToken());
                bud = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                g = new Girl(name, at, intl, bud, type);
                girl_arr.add(g);
            }
            fw = new FileReader("gift.txt");
            rw = new BufferedReader(fw);
            String  ty, gid;
            int   cs, vl,ngg;
            ngg = Integer.parseInt(rw.readLine());
            for (i = 1; i <= ngg; i++) {
                s = rw.readLine();
                StringTokenizer st = new StringTokenizer(s, ",");
                gid = st.nextToken();
                cs = Integer.parseInt(st.nextToken());
                vl = Integer.parseInt(st.nextToken());
                ty = st.nextToken();
                Gift gf = new Gift(ty, cs, vl, gid);
                gift_arr.add(gf);
            }
        Collections.sort(gift_arr, new Compare());
}
        public void make_couples() throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f = new File("Eventlog2.txt");
        Boolean b = f.createNewFile();
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog2.txt");
        rw = new BufferedWriter(fw);
        rw.write("Event               "+"Couple_id     "+"Timestamp");
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
                    rw.write("Couple formation   "+cp.get_couple_id()+"   "+timestamp);
                    rw.newLine();
                    break;
                }
            }
        }
                rw.close();
        fw.close();
    }

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
        for (i = 0; i < couple_arr.size(); i++) {
            if (couple_arr.get(i).get_boy().get_type().equals("Miser")) {
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
            } else if (couple_arr.get(i).get_boy().get_type().equals("Generous")) {
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
                    if (gift_arr.get(j).get_type().equals("Luxury") && y >= gift_arr.get(j).get_cost()) {
                                               timestamp = new Timestamp(System.currentTimeMillis());
                    rw.write("Gift Distribution   "+couple_arr.get(i).get_couple_id()+"   "+gift_arr.get(j).get_gift_id()+"    "+timestamp);
                    rw.newLine();
                        couple_arr.get(i).get_gift_arr().add(gift_arr.get(j));
                    }
                }
            }
        }
                rw.close();
        fw.close();
    }

    public void cal_happiness_comaptablility() {
        int i, j, x, y, mc = 0;
        for (i = 0; i < couple_arr.size(); i++) {
            x = 0;
            y = 0;
            double hapg = 0, hapb = 0;
            for (j = 0; j < couple_arr.get(i).get_gift_arr().size(); j++) {
                x += couple_arr.get(i).get_gift_arr().get(j).get_cost();
                y += couple_arr.get(i).get_gift_arr().get(j).get_value();
            }
            mc = couple_arr.get(i).get_girl().get_maintenance_cost();
            if (couple_arr.get(i).get_girl().get_type().equals("Choosy")) {
                hapg += Math.abs(Math.log10(x - mc + 2 * y));
            } else if (couple_arr.get(i).get_girl().get_type().equals("Desperate")) {
                int r=x-mc;
                while(exp(r)==Infinity)
                {
                    r-=500;
                }
                hapg += Math.abs(Math.exp(r));
                //System.out.println(x-mc+" "+hapg+" "+couple_arr.get(i).couple_id);
            } else {
                hapg += x - mc + y;
                //System.out.println(x-mc+y+" "+hapg+" "+couple_arr.get(i).couple_id);
            }
            if (couple_arr.get(i).get_boy().get_type().equals("Miser")) {
                hapb += Math.abs(couple_arr.get(i).get_boy().get_budget() - x);
            } else if (couple_arr.get(i).get_boy().get_type().equals("Generous")) {
                hapb = hapg;
            } else {
                hapb = couple_arr.get(i).get_girl().get_intelligence();
            }
            //System.out.println(hapb+" "+hapg+" "+couple_arr.get(i).couple_id);
            couple_arr.get(i).get_boy().set_happiness(hapb);
            couple_arr.get(i).get_girl().set_happiness(hapg);
            couple_arr.get(i).set_happiness(hapb + hapg);
            couple_arr.get(i).set_compatibility(couple_arr.get(i).get_boy().get_budget() - mc + Math.abs(couple_arr.get(i).get_girl().get_attractiveness() - couple_arr.get(i).get_boy().get_attractiveness()) + Math.abs(couple_arr.get(i).get_girl().get_intelligence() - couple_arr.get(i).get_boy().get_intelligence()));
        }
    }

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
