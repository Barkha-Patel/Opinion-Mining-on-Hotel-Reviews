/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.util.StringTokenizer;

/**
 *
 * @author Barkha
 */
public class ad {
    
    

       
   public String adOut(String s)
    {
        String key=new String();
        StringTokenizer st=new StringTokenizer(s," ");
        cut c=new cut();
        String add=null;
        while(st.hasMoreTokens())
        {
            key=st.nextToken();
            key=key.trim();
            if( /*key.equals("very_RB") || key.equals("very_RBR") || key.equals("very_RBS")*/key.endsWith("_RB") ||key.endsWith("_RBR") || key.endsWith("_RBS"))
            {
                key=c.cutt(key);
                
            }
            add=add+" "+key;
        }
        return add;
}
}
