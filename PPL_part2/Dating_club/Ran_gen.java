/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.io.*;
import java.util.*;

/**
 * Class for generating random data and storing in files
 *
 * @author RAGHAV SABOO
 */
public class Ran_gen {

    /**
     *
     * @throws IOException
     */
    public void generate_data_boys_girls() throws IOException {
        File f;
        BufferedWriter bw;
        FileWriter fw;
        BufferedReader rbw;
        FileReader rfw;
        Boolean b;
        int i, at, intl, bud, ty, cs, x, vl;
        f = new File("dat.txt");
        b = f.createNewFile();
        fw = new FileWriter("dat.txt");
        bw = new BufferedWriter(fw);
        Random rand = new Random();
        int nb, ng;
        ng = 5 + rand.nextInt(26);
        nb = ng + rand.nextInt(101);
        bw.write("No_of_boys:- ");
        bw.write(Integer.toString(nb));
        bw.newLine();
        bw.write("Boy_id Attractiveness Intelligence Budget Type");
        bw.newLine();
        for (i = 1; i <= nb; i++) {
            String s;
            s = "boy_" + Integer.toString(i);
            at = 10 + rand.nextInt(91);
            intl = 10 + rand.nextInt(91);
            bud = 500 + rand.nextInt(1501);
            ty = rand.nextInt(3);
            bw.write(s);
            bw.write(",");
            bw.write(Integer.toString(at));
            bw.write(",");
            bw.write(Integer.toString(intl));
            bw.write(",");
            bw.write(Integer.toString(bud));
            bw.write(",");
            if (ty == 0) {
                bw.write("Miser");
            } else if (ty == 1) {
                bw.write("Generous");
            } else {
                bw.write("Geek");
            }
            bw.newLine();
            //System.out.println(at+" "+intl+" "+bud);
        }
        bw.write("No_of_girls:- ");
        bw.write(Integer.toString(ng));
        bw.newLine();
        bw.write("Girl_id Attractiveness Intelligence Maintenance_cost Type");
        bw.newLine();
        for (i = 1; i <= ng; i++) {
            String s;
            s = "girl_" + Integer.toString(i);
            at = 10 + rand.nextInt(91);
            intl = 10 + rand.nextInt(91);
            bud = 500 + rand.nextInt(1501);
            ty = rand.nextInt(3);
            bw.write(s);
            bw.write(",");
            bw.write(Integer.toString(at));
            bw.write(",");
            bw.write(Integer.toString(intl));
            bw.write(",");
            bw.write(Integer.toString(bud));
            bw.write(",");
            if (ty == 0) {
                bw.write("Choosy");
            } else if (ty == 1) {
                bw.write("Normal");
            } else {
                bw.write("Desperate");
            }
            bw.newLine();
            //System.out.println(at+" "+intl+" "+bud);
        }
        bw.close();
        fw.close();
    }

    /**
     *
     * @throws IOException
     */
    public static void make_gifts() throws IOException {
        File f;
        BufferedWriter bw;
        FileWriter fw;
        BufferedReader rbw;
        FileReader rfw;
        Boolean b;
        Random rand = new Random();
        f = new File("gift.txt");
        b = f.createNewFile();
        fw = new FileWriter("gift.txt");
        bw = new BufferedWriter(fw);
        bw.write("No_of_gifts:- ");
        int ng = 500 + rand.nextInt(501);
        int i,x,vl,cs,ty;
        bw.write(Integer.toString(ng));
        bw.newLine();
        bw.write("Gift id Cost Value Type");
        bw.newLine();
        for (i = 1; i <= ng; i++) {
            String s = "gift_id_" + Integer.toString(i);
            bw.write(s);
            bw.write(",");
            cs = 50 + rand.nextInt(250);
            bw.write(Integer.toString(cs));
            bw.write(",");
            x = rand.nextInt(2);
            if (x == 0) {
                vl = cs + rand.nextInt(100);
            } else {
                vl = cs - rand.nextInt(50);
            }
            bw.write(Integer.toString(vl));
            bw.write(",");
            ty = rand.nextInt(3);
            if (ty == 0) {
                bw.write("Essential");
            } else if (ty == 1) {
                bw.write("Luxury");
                bw.write(",");
                int lr = 10 + rand.nextInt(90);
                bw.write(Integer.toString(lr));
            } else {
                bw.write("Utility");
                bw.write(",");
                int uv = 10 + rand.nextInt(90);
                bw.write(Integer.toString(uv));
                bw.write(",");
                String uc = "Gift";
                bw.write(uc);
            }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
