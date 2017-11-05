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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Barkha
 */
public class psup {
    
  /*  public static void main (String args[]) throws FileNotFoundException{
      Scanner w;
       File file=new File("C:\\Users\\Barkha\\Desktop\\results\\nokia\\ftr.txt");
        w= new Scanner(file);
        String[] ftr=new String[1000];
        int i=0;
    while(w.hasNext())
    {
      // System.out.println(w.next());
       ftr[i]=w.next();
       ftr[i]=ftr[i].trim();
       // System.out.println(posw[i]);
        i++;
    }
    File folder = new File("C:\\Users\\Barkha\\Desktop\\data2.txt");
        HashMap<String,Integer> m=new HashMap<String,Integer>();
        
        for(int b=0;b<ftr.length;b++){
                   
        int wordCount = 0;
        Scanner s = new Scanner(folder);
        String tempo;
        while (s.hasNextLine()) {
            tempo=s.nextLine();
           // System.out.println();
        if(tempo.contains(ftr[b])){
           // System.out.println("#");
            wordCount++;
            
        }}
            
        
        m.put(ftr[b],wordCount);
        }
    
        // correct scores 
        String temp;
        String pre;
        String post;
        int sub;
        int calc;
         for(int j=0;j<ftr.length;j++){
             if(ftr[i].contains(" "))
             {
                 temp=ftr[i];
                 pre=temp.substring(0,temp.indexOf(" ")-1).trim();
                 post=temp.substring(temp.indexOf(" ")+1).trim();
                 
                   sub=m.get(temp);
                  if(m.containsKey(pre))
                  {
                      calc=m.get(pre)-sub;
                      m.put(pre, calc);
                  }
                  if(m.containsKey(post))
                  {
                      calc=m.get(post)-sub;
                      m.put(post, calc);
                  }
             }
     }

         Set<Map.Entry<String, Integer>> set = m.entrySet();
         for(Map.Entry<String, Integer> me: set){
             if(me.getValue()>=3){
                 System.out.println(me.getKey());
             }
         }
         
         
    
}
}
*/
//StringUtils.countMatches(string, searchedFor)
 

public static void main (String args[]) throws FileNotFoundException, IOException{
  /*  remdup r=new remdup();
    r.stripDuplicates("C:\\Users\\Barkha\\Desktop\\results\\nokia\\ftr.txt");*/
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
       File file=new File("C:\\Users\\Barkha\\Desktop\\results\\nokia\\ftr_new.txt");
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
      // System.out.println(w.next());
       ftr[i]=w.nextLine();
     // ftr[i]=ftr[i].trim();
    //  System.out.println(ftr[i]);
       if(ftr[i].contains(" ")){
           
                 te=ftr[i];
                 p=te.substring(0,te.indexOf(" ")).trim();
                 s=te.substring(te.indexOf(" ")+1).trim();
                 fp ="[^.]*\\b(" + p + "[-\\s]"+ s+")\\b[^.]*[.]";
               // System.out.println(op_wo);
               
       
       }
       // System.out.println(posw[i]);
        
       else{// System.out.println(ftr[i]);
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
     String temp;
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
     }

      
                   
                 
         Set<Map.Entry<String, Integer>> set = m.entrySet();
         for(Map.Entry<String, Integer> me: set){
             
             if(me.getKey().contains(" "))
             {
             if(me.getValue()>=2){
                
                // System.out.println("@@");
               System.out.println(me.getKey());
              // System.out.println("//");
                // System.out.println(me.getKey());
             }
             } 
            
         }
         /*
    rev_extract re=new rev_extract();
    String q=new String();
    String temp=new String();
         File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\customer review data");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                
                temp=re.datar(file);
                q=q+temp;
                
                
            }
                
        
        }
               // System.out.println("1");
    HashMap<String,Integer> m=new HashMap<String,Integer>();
    Scanner w;
       File file=new File("C:\\Users\\Barkha\\Desktop\\results\\op_adverb.txt");
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
      // System.out.println(w.next());
       ftr[i]=w.nextLine();
     // ftr[i]=ftr[i].trim();
    //  System.out.println(ftr[i]);
    /*   if(ftr[i].contains(" ")){
           
                 te=ftr[i];
                 p=te.substring(0,te.indexOf(" ")).trim();
                 s=te.substring(te.indexOf(" ")+1).trim();
                 fp ="[^.]*\\b(" + p + "[-\\s]"+ s+")\\b[^.]*[.]";
               // System.out.println(op_wo);
               
       
       }*/
       // System.out.println(posw[i]);
        
       // System.out.println(ftr[i]);
    /*    fp ="[^.]*\\b(" + ftr[i] + ")\\b[^.]*[.]";
               // System.out.println(op_wo);
                
                 Pattern r = Pattern.compile(fp, 
                Pattern.MULTILINE | Pattern.COMMENTS | 
                Pattern.CASE_INSENSITIVE);
                Matcher match = r.matcher(q.trim());
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

      
                   
       /*          
         Set<Map.Entry<String, Integer>> set =m.entrySet();
         for(Map.Entry<String, Integer> me: set){
             if(me.getValue()>=5){
                
                // System.out.println("@@");
               System.out.println(me.getKey());
                // System.out.println(me.getKey());
             }
              
         }
    
}*/
}}
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    