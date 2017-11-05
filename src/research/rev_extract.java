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
public class rev_extract {
    

    
    Scanner z;
    public String datar(File filename) throws FileNotFoundException {
        z=new Scanner(filename);
       
        cuttt c=new cuttt();
        String inter;
        String end = null;
        while(z.hasNext())
        {
            
            String key=z.next();
            
            if(key.contains("##"))
            {
                key=c.cutt_t(key);
                end=end+" "+key;
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
        
        rev_extract r=new rev_extract();
        
        File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\customer review data\\Nokia 6610.txt");
        String s=null;
       
       // s=r.data(folder);
        System.out.println(s);
        
        
    }

}
    
