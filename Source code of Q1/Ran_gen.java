    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.*;
import java.util.*;

/**
 *Class for generating random data and storing in files
 * @author RAGHAV SABOO
 */
public class Ran_gen {

    public static void main(String args[]) throws IOException {
        File f;
        BufferedWriter bw;
        FileWriter fw;
        BufferedReader rbw;
        FileReader rfw;
        Boolean b;
        f = new File("dat.txt");
        b = f.createNewFile();
        fw = new FileWriter("dat.txt");
        bw = new BufferedWriter(fw);
        Random rand = new Random();
        int nb, ng;
        ng = 5 + rand.nextInt(25);
        nb = ng + rand.nextInt(100);
        bw.write(Integer.toString(nb));
        bw.newLine();
        int i, at, intl, bud, ty;
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
        }
        bw.write(Integer.toString(ng));
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
}
