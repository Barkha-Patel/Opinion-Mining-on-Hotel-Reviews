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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Barkha
 */
public class aspect {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner w;
    File file=new File("C:\\Users\\Barkha\\Desktop\\results\\hotel results\\positiveop.txt");
    w= new Scanner(file);
        String[] op_w=new String[500];
        int i=0;
    while(w.hasNext())
    {
      // System.out.println(w.next());
        op_w[i]=w.next();
       // System.out.println(posw[i]);
        i++;
    }
    
                String op_wo = op_w[0];
                
                //String str="If you are considering a vacation travel to Kauai Island, Hawaii, you might go to a search engine, say Google, and search reviews of other visitors for it. However, in this case, Google would report about many matched pages for you. It would be useful to know what fraction of these matches recommend Kauai Island as a good travel destination. With an algorithm for automatically classifying a review as positive or negative, it would be possible for a search engine to report such summary statistics.hello how are you. It is called sentiment classification.  Sentiment classification aims to mining the text of written reviews of customers for a certain product by classifying the reviews into positive or negative opinion.hello how are you.";

                for (int k = 1; k < op_w.length; k++)
                    op_wo += "|" + op_w[k];
                op_wo ="[^.]*\\b(" + op_wo + ")\\b[^.]*[.]";
               // System.out.println(op_wo);
                Pattern re = Pattern.compile(op_wo, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                
                
        //rev_extract s=new rev_extract();
                ReadInts s=new ReadInts();
        /*parse p=new parse();*/
       /* parse p=new parse();*/
                prunparse p=new prunparse();
       String[] features=new String[1000];
       int arraygrowth=1000;
       
       /* String[] temp=new String[200];*/
        String temp;
        
        int f,te;
        f=0;
         File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\50 reviews\\");
        File[] listOfFiles = folder.listFiles();

        for (File file1 : listOfFiles) {
            if (file1.isFile()) {
                
                String t=new String();
        try {
            t=s.data(file1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adop.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        /*File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\50 reviews\\hotel_72572_parsed.txt");
        
              /*  String t=" ";
                String key;
                Scanner z=new Scanner(folder);
                while(z.hasNext())
                 {
                     key=z.next();
                      t=t+" "+key;
                }*/
                /* String t=s.data(folder);*/
        
           
                
                
                
                
                Matcher match = re.matcher(t);
                String sentenceString="";
               while (match .find()) {
                sentenceString = match.group(0);
               /* temp=p.parsing(sentenceString);*/
                    temp=p.prunParsing(sentenceString,op_w,t);
                    System.out.println(temp);
                    if(features.length==f){
                        String[] temporary = new String[features.length + arraygrowth];
                        System.arraycopy(features, 0, temporary, 0, features.length);
                        features = temporary;
                       // System.out.println("yayy");
                     /*    for(int b=0;b<features.length;b++){
                    System.out.println(features[b]);
                    }
                       */ 
                    }
                    features[f]=temp;
                    f++;
             /*   for(int j=0;temp[j]!=null;j++){
                    features[f]=temp[j];
                      f++;
                       System.out.println(temp[j]);
                }*/
                }
               
               
            }
                
            }
                
                
               int b;
               BufferedWriter out = null;
               FileWriter fstream = new FileWriter("C:\\Users\\Barkha\\Desktop\\results\\hotel results\\aspects.txt", true); //true tells to append data.
                    out = new BufferedWriter(fstream);
                    for(b=0;b<features.length;b++){
                    out.write(features[b]+"\n");
                    }
                    out.close();
               
               
    }
}
    

    

    
