/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *Class containing main,for performing all tasks
 * @author RAGHAV SABOO
 */
public class Q7 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException on error in file I/O
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        PPLQ7 ob = new PPLQ7();
        ob.generate_data();
        ob.read_file();
        ob.make_couples();
        ob.give_gifts();
        ob.cal_happiness_comaptablility();
        ob.disp_data();
        ob.find_girlfriends();
    }
}
