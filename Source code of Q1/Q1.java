/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Class containing main,for performing all tasks
 * @author RAGHAV SABOO
 */
public class Q1 {

    public static void main(String args[]) throws IOException {
        PPL ob = new PPL();
        ob.read_data();
        ob.make_couples();
        ob.write_data();
    }

}
