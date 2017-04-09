/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dating_club;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *Class for reading data from file
 * @author RAGHAV SABOO
 */
public class Read_data {
/**
 * 
 * @param boy_arr  Array list for storing data of boys
 * @param girl_arr Array list for storing data of girls
 * @param gift_arr Array list for storing data of gifts
 * @throws FileNotFoundException
 * @throws IOException on error in file reading 
 */       
    public void read_file(ArrayList<Boy> boy_arr,ArrayList<Girl> girl_arr,ArrayList<Gift> gift_arr) throws FileNotFoundException, IOException {
        // TODO code application logic here
        FileReader fw;
        BufferedReader rw;
            fw = new FileReader("dat.txt");
            rw = new BufferedReader(fw);
            
            String s;
            Boy b;
            int  i, at, intl, bud,ng,nb;
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
        Collections.sort(gift_arr, new Compare());
}
}
