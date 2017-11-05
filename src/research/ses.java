/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;


/**
 *
 * @author Barkha
 */
public class ses {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner w;
    File file=new File("C:\\Users\\Barkha\\Desktop\\results\\nokia\\pruned_final.txt");
    w= new Scanner(file);
        String[] ft=new String[500];
        int i=0;
    while(w.hasNextLine())
    {
      // System.out.println(w.next());
        ft[i]=w.nextLine();
        ft[i]=ft[i].toLowerCase().trim();
       // System.out.println(posw[i]);
        i++;
    }
    
    
  /*  for(int k=0;k<ft.length;k++){
        System.out.println(ft[k]);
        
    }*/
   // System.out.println("%%%%");
    String temp;
    String s,p;
    for(int j=0;ft[j]!=null;j++){
        temp=ft[j];
       // System.out.println("temp:"+temp);
        if(temp.endsWith("s"))
        {
            s=temp.substring(0,temp.length()-1);
           // System.out.println("sss"+s);
            if(Arrays.asList(ft).contains(s))
            {
                System.out.println("rem: "+temp);
                ft=ArrayUtils.removeElement(ft,temp);
            }
            
        }
        if(temp.contains(" ")){
            p=temp.substring(0,temp.indexOf(" "))+temp.substring(temp.indexOf(" ")+1);
            // System.out.println(p);
            if(Arrays.asList(ft).contains(p))
            {  System.out.println("rem: "+p);
                ft=ArrayUtils.removeElement(ft,p);
            }
        }
        
    }
    
    for(int k=0;k<ft.length;k++){
        System.out.println(ft[k]);
        
    }
    
    
}}
