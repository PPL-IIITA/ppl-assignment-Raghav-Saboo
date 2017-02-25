/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * For reading data and making couples
 *
 * @author RAGHAV SABOO
 *
 */
public class PPL {

    int nb, ng;
    /**
     * To store list of boys
     */
    public ArrayList<Boy> boy_arr = new ArrayList<>();
    /**
     * To store list of girls
     */
    public ArrayList<Girl> girl_arr = new ArrayList<>();
    /**
     * To store list of couples
     */
    public ArrayList<Couple> couple_arr = new ArrayList<>();

    /**
     * For reading data from file
     */
    public void read_data() throws IOException {
        // TODO code application logic here
        FileReader fw;
        BufferedReader rw;
        fw = new FileReader("dat.txt");
        rw = new BufferedReader(fw);
        String s;
        Boy b;
        int i, at, intl, bud;
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
    }

    /**
     * For assigning couples and storing timestamp
     */
    public void make_couples() throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File f = new File("Eventlog1.txt");
        Boolean b = f.createNewFile();
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Eventlog1.txt");
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

    /**
     * For writing data to output file
     */
    public void write_data() throws IOException {
        FileWriter fw;
        BufferedWriter rw;
        fw = new FileWriter("Answer1.txt");
        rw = new BufferedWriter(fw);
        int i;
        rw.write("Couples Formed are:");
        rw.newLine();
        for (i = 0; i < couple_arr.size(); i++) {
            // System.out.println(couple_arr.get(i).get_couple_id() + " " + couple_arr.get(i).get_boy().get_boy_id() + " " + couple_arr.get(i).get_girl().get_girl_id());
            rw.write("Couple id: ");
            rw.write(couple_arr.get(i).get_couple_id());
            rw.write(" Formed between " + couple_arr.get(i).get_boy().get_boy_id() + " and " + couple_arr.get(i).get_girl().get_girl_id());
            rw.newLine();
        }
        rw.close();
        fw.close();
    }

}
