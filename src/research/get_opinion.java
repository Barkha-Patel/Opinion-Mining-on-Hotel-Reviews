/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barkha
 */
public class get_opinion {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public static void main(String args[]) throws IOException{
        
        remdup rd=new remdup();
       
        pre p=new pre();
        space re=new space();
        pos ps=new pos();
        ad AD=new ad();
        op OP=new op();
        
        
        File folder = new File("C:\\Users\\Barkha\\Desktop\\research\\customer review data");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                
                String s=new String();
        try {
            s=re.data(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adop.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(s);
        
        List<String> lemmas = new LinkedList<String>();
        lemmas=p.lemmatize(s);
        //System.out.println(lemmas);
        String s1=new String();
        
        s1=ps.mpos(lemmas);
        s1=AD.adOut(s1);
       // System.out.println(s1);
        OP.oplist(s1);
        //rd.stripDuplicates("C:\\Users\\Barkha\\Desktop\\results\\opinion.txt");
        }
  }
        rd.stripDuplicates("C:\\Users\\Barkha\\Desktop\\results\\op_adverb1.txt");
    }
}


