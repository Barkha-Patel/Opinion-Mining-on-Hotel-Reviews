/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Barkha
 */
public class parser {
    
    public static void main(String args[]) throws FileNotFoundException{
        Scanner w;
    File file=new File("C:\\Users\\Barkha\\Desktop\\results\\positiveop.txt");
    w= new Scanner(file);
        String[] posw=new String[500];
        String[] negw=new String[500];
        int i=0;
    while(w.hasNext())
    {
      // System.out.println(w.next());
        posw[i]=w.next();
       // System.out.println(posw[i]);
        i++;
    }
    Scanner z;
    File filee=new File("C:\\Users\\Barkha\\Desktop\\results\\negativeop.txt");
    z= new Scanner(filee);
    int j=0;
     while(z.hasNext())
    {
        
       // System.out.println(z.next());
        negw[j]=z.next();
        //System.out.println(negw[j]);
        j++;
    }
                 String poswo = posw[0];   
                //String str="If you are considering a vacation travel to Kauai Island, Hawaii, you might go to a search engine, say Google, and search reviews of other visitors for it. However, in this case, Google would report about many matched pages for you. It would be useful to know what fraction of these matches recommend Kauai Island as a good travel destination. With an algorithm for automatically classifying a review as positive or negative, it would be possible for a search engine to report such summary statistics.hello how are you. It is called sentiment classification.  Sentiment classification aims to mining the text of written reviews of customers for a certain product by classifying the reviews into positive or negative opinion.hello how are you.";

                 for (int k = 1; k < posw.length; k++)
                    poswo += "|" + posw[i];
                poswo = "[^.]*\\b(" + poswo + ")\\b[^.]*[.]";
                Pattern re = Pattern.compile(poswo, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                
                String negwo = negw[0];  
                for (int l = 1; l <negw.length; l++)
                    negwo += "|" + negw[i];
                negwo = "[^.]*\\b(" + negwo + ")\\b[^.]*[.]";
                Pattern ren = Pattern.compile(negwo, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                
        ReadInts ri=new ReadInts();
        File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\50 reviews\\");
        File[] listOfFiles = folder.listFiles();

        for (File files : listOfFiles) {
            if (files.isFile()) {
                
                String s=new String();
                s=ri.data(file);
                Matcher match = re.matcher(s);
                String sentenceString="";
                while (match .find()) {
                sentenceString = match.group(0);
                System.out.println(sentenceString);// instead this feed the line into parser and extract feature and the work ahead
            }
                
        
     
     
     
     
    }
    
}
    }
}
    
