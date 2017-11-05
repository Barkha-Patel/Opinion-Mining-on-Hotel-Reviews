/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Barkha
 */
public class fix {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        File folder = new File("C:\\Users\\Barkha\\Desktop\\data.txt");
                String t=" ";
                String key;
                Scanner z=new Scanner(folder);
                while(z.hasNext())
                 {
                     key=z.next();
                      t=t+" "+key;
                      //System.out.println(key);
                      if(key.contains(".")){
                         // System.out.println(key);
                          t=t+"\n";
                          
                      }
                }

           //    System.out.println(t);
                BufferedWriter out = null;
               FileWriter fstream = new FileWriter("C:\\Users\\Barkha\\Desktop\\data2.txt", true); //true tells to append data.
                    out = new BufferedWriter(fstream);
                    
                    out.write(t);
                   
                    out.close();
                 
    }
    
}
