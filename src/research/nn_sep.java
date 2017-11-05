/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Barkha
 */
public class nn_sep {
    
    public static void main(String args[]) throws IOException{
        File folder = new File("C:\\Users\\Barkha\\Desktop\\results\\features-nokia.txt");
       
        Scanner z=new Scanner(folder);
        String inter;
        String re=" ";
        while(z.hasNext()){
            inter=z.next();
            //System.out.println(inter);
            if(!(inter.startsWith("nn")))
            {
               re=re+"\n"+inter; 
               
            }
        }
       // System.out.println(re);
        
              BufferedWriter out = null;
               FileWriter fstream = new FileWriter("C:\\Users\\Barkha\\Desktop\\results\\features-nokia-only.txt", true); //true tells to append data.
                    out = new BufferedWriter(fstream);
                    
                    out.write(re);
                    
                    out.close();
                 
    }
    
}
