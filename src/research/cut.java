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
public class cut {
    
    public String cutt(String sentiWord){
        int i;
        
        i=sentiWord.indexOf("_");
        sentiWord=sentiWord.substring(0,i);
        return sentiWord;
        
    }
    public static void main(String args[]) throws FileNotFoundException{
        cut c=new cut();
        Scanner w;
    File file=new File("C:\\Users\\Barkha\\Desktop\\results\\op_adverb_pruned.txt");
    w= new Scanner(file);
    String t;
    while(w.hasNextLine()){
        t=w.nextLine();
        System.out.println(c.cutt(t));
    }
    
    }
    
}
