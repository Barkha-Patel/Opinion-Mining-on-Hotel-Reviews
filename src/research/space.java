/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Barkha
 */
public class space {
    
    
    Scanner z;
    public String data(File filename) throws FileNotFoundException {
        z=new Scanner(filename);
       
        
        String inter;
        String end = null;
        int i;
        String s;
        while(z.hasNext())
        {
            
            String key=z.next();
            
            
            if(key.contains("##"))
            {
                //System.out.println(key);
                i=key.lastIndexOf("##");
                s=key.substring(i+2);
               // System.out.println(s);
                end=end+" "+s;
                
                inter=z.next();
                while(!(inter.contains(".")||inter.contains("!")||inter.contains("?")))
                {
                    end=end+" "+inter;
                    inter=z.next();
                }
            }
            end=end+".";
        }
        return end;
    }
       
    
     public static void main(String args[]) throws FileNotFoundException{
        
        space r=new space();
        
        File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\customer review data\\DVD.txt");
        String s=null;
       
        s=r.data(folder);
        System.out.println(s);
        
        
    }
    }

