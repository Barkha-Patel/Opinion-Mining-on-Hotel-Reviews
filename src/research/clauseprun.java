/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Barkha
 */
public class clauseprun {
    
    public static void main(String args[]) throws FileNotFoundException{
        
        File folder = new File("C:\\Users\\Barkha\\Desktop\\data2.txt");
                String t=" ";
                String key;
                Scanner z=new Scanner(folder);
                while(z.hasNext())
                 {
                     key=z.next();
                      t=t+" "+key;
                }  
               // System.out.println("1");
    HashMap<String,Integer> m=new HashMap<String,Integer>();
    Scanner w;
       File file=new File("C:\\Users\\Barkha\\Desktop\\results\\nokia\\pruned_final.txt");
        w= new Scanner(file);
        String[] ftr=new String[1000];
        int i=0;
       // System.out.println("2");
        //System.out.println(t);
        String p,s,te;
        String fp;
    while(w.hasNextLine())
    {
      System.out.println("@@");
     // System.out.println(w.nextLine());
      // System.out.println("@@");
       ftr[i]=w.nextLine();
      // System.out.println("@@");
     ftr[i]=ftr[i].trim();
     //System.out.println("@@");
     System.out.println(ftr[i]);
       if(ftr[i].contains(" ")){
          // System.out.println("pppp");
                 te=ftr[i];
                 p=te.substring(0,te.indexOf(" ")).trim();
                 s=te.substring(te.indexOf(" ")+1).trim();
                 fp ="[^.]*\\b(" + p + "[-\\s]"+ s+")\\b[^.]*[.]";
               // System.out.println(op_wo);
               
       
       }
       // System.out.println(posw[i]);
        
       else{//System.out.println(ftr[i]);
        fp ="[^.]*\\b(" + ftr[i] + ")\\b[^.]*[.]";
               // System.out.println(op_wo);
                }
                 Pattern re = Pattern.compile(fp, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                Matcher match = re.matcher(t.trim());
                int count=0;
               while (match .find()) {
                   
               count++;
            //  System.out.println(count);
               }
              // System.out.println(count);
               m.put(ftr[i],count);
               i++;
    }

 //  System.out.println("6");
   //System.out.println(ftr[2]);
  // System.out.println(m.get(ftr[2]));
   /*  String temp;
        String pre;
        String post;
        int sub;
        int calc;
         for(int j=0;ftr[j]!=null;j++){
            //  System.out.println("##");
              //System.out.println(ftr[j]);
             if(ftr[j].contains(" "))
             {
                 temp=ftr[j];
                 pre=temp.substring(0,temp.indexOf(" ")).trim();
                 post=temp.substring(temp.indexOf(" ")+1).trim();
                 
                   sub=m.get(temp);
                  if(m.containsKey(pre))
                  {
                      calc=m.get(pre)-sub;
                      m.put(pre, calc);
                     // if(calc>=3){
                         // System.out.println(pre);
                     // }
                    //  System.out.println(m.get(pre));
                  }
                  if(m.containsKey(post))
                  {
                      calc=m.get(post)-sub;
                      m.put(post, calc);
                     // if(calc>=3){
                        //  System.out.println(post);
                      //}
                  }
             }
     }*/

      
                   
                 
      /*   Set<Map.Entry<String, Integer>> set = m.entrySet();
         for(Map.Entry<String, Integer> me: set){
             if(me.getValue()>=2){
                
                // System.out.println("@@");
               System.out.println(me.getKey()+" "+me.getValue());
           } } */
            File filee=new File("C:\\Users\\Barkha\\Desktop\\results\\op_adverb_pruned.txt");
    w= new Scanner(filee);
        String[] op_w=new String[330];
        int o=0;
    while(w.hasNext())
    {
      // System.out.println(w.next());
        op_w[o]=w.next();
       // System.out.println(posw[i]);
        o++;
    } 
             
            // parse p=new parse();
        String[] features=new String[1000];
        String temp;
        int r;
        int f=0;
        prunparse pp=new prunparse();
        for(int h=0;ftr[h]!=null;h++){
            
            System.out.println(ftr[h]);
            if(ftr[h].contains(" ")){
           
                 te=ftr[h];
                 p=te.substring(0,te.indexOf(" ")).trim();
                 s=te.substring(te.indexOf(" ")+1).trim();
                 fp ="[^.]*\\b(" + p + "[-\\s]"+ s+")\\b[^.]*[.]";
               // System.out.println(op_wo);
               
       
       }
       // System.out.println(posw[i]);
        
       else{// System.out.println(ftr[i]);
        fp ="[^.]*\\b(" + ftr[h] + ")\\b[^.]*[.]";
               // System.out.println(op_wo);
                }
                 Pattern re = Pattern.compile(fp, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                Matcher match = re.matcher(t.trim());
                int count=0;
                String sentenceString;
               while (match .find()) {
                   sentenceString = match.group(0);
                temp=pp.prunParsing(sentenceString,op_w,m);
                if(!Arrays.asList(features).contains(temp))
                { features[f]=temp;
                System.out.println("F:"+features[f]);
                }
                f++;
                t.replace(sentenceString,". .");
                
               }     
        }
        
        for(f=0;f<features.length;f++){
            System.out.println(features[f]);
        }
    }
}