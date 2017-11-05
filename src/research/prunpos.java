/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Barkha
 */
public class prunpos {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner w;
    File file=new File("C:\\Users\\Barkha\\Desktop\\results\\hotel results\\positiveop.txt");
    w= new Scanner(file);
    cut c= new cut();
        String[] ft=new String[1000];
        int i=0;
        String tagged ;
         MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
    while(w.hasNextLine())
    {
      // System.out.println(w.next());
        ft[i]=w.nextLine();
        ft[i]=ft[i].toLowerCase().trim();
        //System.out.println(ft[i]);
        tagged= tagger.tagString(ft[i]);
       //System.out.println(tagged);
       //System.out.println(tagged.substring(tagged.length()-3));
       if(tagged.endsWith("JJ ") || tagged.endsWith("JJS ")||tagged.endsWith("JJR ")){
            System.out.println(tagged.substring(0, tagged.lastIndexOf("_")));
        }
       // System.out.println(posw[i]);
        i++;
    }
   
    
        
    }
    
}
