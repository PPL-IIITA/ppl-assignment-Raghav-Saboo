/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Class for making couples
 *
 * @author RAGHAV SABOO
 */
public class Make_couples {

    /**
     *
     * @param boy_arr Array list of boys
     * @param girl_arr Array list for storing data of girls
     * @param couple_arr Array list for storing data of couples
     * @param ng No of girls
     * @param nb No of boys
     * @throws IOException on error in file reading or writing
     */
    public void make_couples(ArrayList<Boy> boy_arr, ArrayList<Girl> girl_arr, ArrayList<Couple> couple_arr, int ng, int nb) throws IOException {
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
