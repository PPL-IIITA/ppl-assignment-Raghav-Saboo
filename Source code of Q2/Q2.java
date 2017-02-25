/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq2;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *Class containing main,for performing all tasks
 * @author RAGHAV SABOO
 */
public class Q2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        PPLQ2 ob = new PPLQ2();
        ob.read_file();
        ob.make_couples();
        ob.give_gifts();
        ob.cal_happiness_comaptablility();
        ob.disp_data();
    }
}
