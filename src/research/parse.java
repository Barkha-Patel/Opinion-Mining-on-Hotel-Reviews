/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Barkha
 */
public class parse {
    
    public String[]  parsing(String s/*,String[] t*/){
        
        test3 t3=new test3();
        String[] feat=new String[100];
        int f=0;
        String data;
        String p,d;
        int i;
        String parserModel = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
        LexicalizedParser lp = LexicalizedParser.loadModel(parserModel);
        data=t3.demoAPI(lp,s);
        i=data.lastIndexOf("$$");
        d=data.substring(i+3);
        p=data.substring(1,i);
        
        StringTokenizer st1=new StringTokenizer(p,",");
        
        //System.out.println(p);
       //System.out.println(d);
        


        // for p
        String ps;
         String[] noun=new String[100];
        String[] adj=new String[100];
        int k=0,j=0;
        
        while(st1.hasMoreTokens())
        {
            ps=st1.nextToken().trim();
            //System.out.println(ps);
            if(ps.endsWith("/NN")|| ps.endsWith("/NNS"))
            {
                noun[k]=ps.substring(0,ps.indexOf("/"));
                k++;
            }//change
            if( ps.endsWith("/JJ") || ps.endsWith("/JJR") || ps.endsWith("JJS"))
            {
                adj[j]=ps.substring(0,ps.indexOf("/"));
                j++;
            }
        }
      /*  for(int l=0;l<noun.length;l++){
            System.out.println(noun[l]);
        }*/
       /* for(int l=0;l<noun.length;l++){
            System.out.println(noun[l]);
        }*/
        
        
        
        
        // for d
        StringTokenizer st2=new StringTokenizer(d,")");
        String ds;
        String temp1,temp2;
        while(st2.hasMoreTokens())
        {
            ds=st2.nextToken();
            
            if(ds.contains("nsubj"))
            {
                //System.out.println(ds);
                temp1=ds.substring(ds.indexOf("(")+1,ds.indexOf("-")).trim();
                temp2=ds.substring(ds.lastIndexOf(",")+1,ds.lastIndexOf("-")).trim();
                //System.out.println(temp1);
                //System.out.println(temp2);
                if( Arrays.asList(noun).contains(temp2) && Arrays.asList(/*t*/adj).contains(temp1)/* || Arrays.asList(noun).contains(temp2) && Arrays.asList(noun).contains(temp1) */)
                {
                    if(!(Arrays.asList(feat).contains(temp2)))
                    {
                    feat[f]=temp2;
                  //  System.out.println(feat[f]);
                    f++;
                    }
                }
            }
             if(ds.contains("amod"))
            {
                //System.out.println(ds);
                temp1=ds.substring(ds.indexOf("(")+1,ds.indexOf("-")).trim();
                temp2=ds.substring(ds.lastIndexOf(",")+1,ds.lastIndexOf("-")).trim();
                //System.out.println(temp1);
                //System.out.println(temp2);
                if( Arrays.asList(noun).contains(temp1) && Arrays.asList(adj/*t*/).contains(temp2))
                {
                    if(!(Arrays.asList(feat).contains(temp1)))
                    {
                    feat[f]=temp1;
                  //  System.out.println(feat[f]);
                    f++;
                    }
                }
            }
            if(ds.contains("nn"))
             {
               temp1=ds.substring(ds.indexOf("(")+1,ds.indexOf("-")).trim();
               temp2=ds.substring(ds.lastIndexOf(",")+1,ds.lastIndexOf("-")).trim(); 
               if(!(Arrays.asList(feat).contains(temp2+" "+temp1)))
                    {
                    feat[f]=temp2+" "+temp1;
                     f++;
                    }
               
             }
         }
        /*int l=0;
        while(feat[l]!=null){
            //System.out.println(feat[l]);
            l++;
        }*/
        
    return feat;
    }
    
    
    
    
    
    
    public static void main(String args[]){
        parse p=new parse();
        String[] hey=null;
      // hey=p.parsing("t 's which does not work along several long stretches on that same route ");
      for(int l=0;l<hey.length;l++){
            System.out.println(hey[l]);
        }
    }
}
            
    

