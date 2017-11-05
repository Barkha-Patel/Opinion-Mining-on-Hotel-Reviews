/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research;

/**
 *
 * @author Barkha
 */
public class cuttt {
    
    public String cutt_t(String sentiWord){
        int i;
        
        i=sentiWord.indexOf("##");
        sentiWord=sentiWord.substring(i+2);
        return sentiWord;
        
    }
    
}
