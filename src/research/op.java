/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.StringTokenizer;

/**
 *
 * @author Barkha
 */
public class op {
    
    public void oplist(String s) throws IOException
    {
        StringTokenizer st=new StringTokenizer(s," ");
        String pre,key,post;
        
        post=null;
        cut ct=new cut();
        BufferedWriter out = null;
        pre=st.nextToken().trim();
        key=st.nextToken().trim();
        while(st.hasMoreTokens())
        {
            post=st.nextToken().trim();
            if(key.indexOf("_")==-1)
            {
                if(pre.endsWith("_JJ") || pre.endsWith("_JJR") || pre.endsWith("_JJS"))
                {
                   FileWriter fstream = new FileWriter("C:\\Users\\Barkha\\Desktop\\results\\op_adverb1.txt", true); //true tells to append data.
                    out = new BufferedWriter(fstream);
                    out.write("\n"+ct.cutt(pre)); 
                    out.close();
                }
                
                else if(post.endsWith("_JJ") ||post.endsWith("_JJR") || post.endsWith("_JJS"))
                {
                   FileWriter fstream = new FileWriter("C:\\Users\\Barkha\\Desktop\\results\\op_adverb1.txt", true); //true tells to append data.
                    out = new BufferedWriter(fstream);
                    out.write("\n"+ct.cutt(post)); 
                    out.close();
                }
            
                    
            }
            pre=key;
            key=post;
        }
        
    }
}
